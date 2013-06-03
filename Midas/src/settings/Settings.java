/* ============================================================================
 * Nom du fichier   : Settings.java
 * ============================================================================
 * Date de création : 7 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package settings;

import gui.utils.Positions.ScreenPosition;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.JDOMParseException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import settings.elements.FrameSettings;
import utils.xml.HasXMLName;
import utils.xml.XMLGetters;
import utils.xml.XMLModifiers;
import core.MidasLogs;

/**
 * Permet de charger la configuration du programme.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class Settings extends DefaultsSettings {

   private static final String CONFIG_FOLDER_PATH = "config";
   private static final String CONFIG_FILE_NAME = "config";
   private static final String CONFIG_FILE_EXTENSION = "xml";

   private static final String LANGUAGES_FOLDER_PATH = "languages";
   private static final String LANGUAGE_FILE_EXTENSION = "xml";

   /**
    * Charge les options de configurations du programme.
    */
   public void loadSettings() {

      boolean successfullyLoaded = false;

      MidasLogs.messages.push("Settings", "Start loading settings");

      File file = new File(CONFIG_FOLDER_PATH + File.separator
            + CONFIG_FILE_NAME + "." + CONFIG_FILE_EXTENSION);

      /*
       * Charge le fichier de configuration principal
       * ----------------------------------------------------------------------
       */
      Document document = null;
      SAXBuilder saxBuilder = new SAXBuilder();

      Element root;
      Element currentElement;

      try {
         document = saxBuilder.build(file);

         root = document.getRootElement();

         /*
          * Lecture de l'arborescence "properties"
          * -------------------------------------------------------------------
          */
         currentElement = root.getChild(XMLNodes.PROPERTIES.getXMLName());

         languageCode = XMLGetters.getStringChild(currentElement,
               XMLNodes.LANGUAGE_CODE.getXMLName(), languageCode);

         /*
          * Lecture de l'arborescence "frames"
          * -------------------------------------------------------------------
          */
         currentElement = root.getChild(XMLNodes.FRAMES.getXMLName());

         setFrameSettingsFromXMLFramesNodes(mainFrame, currentElement);

         successfullyLoaded = true;

      }
      catch (IOException e) {
         MidasLogs.errors.push("Settings",
               "Unable to open and read the file \"" + file.getName() + "\".");
      }
      catch (JDOMParseException e) {
         MidasLogs.errors.push("Settings", "The file \"" + file.getName()
               + "\" is corrupted.");
      }
      catch (JDOMException e) {
         MidasLogs.errors.push("Settings",
               "Unable to load the file \"" + file.getName() + "\".");
      }
      catch (NullPointerException e) {
         MidasLogs.errors.push("Settings",
               "Configuration file is corrupted, elements are " + "missing.");
      }

      /*
       * Fichier manquant ou corrompu, charge les options par défaut
       * ----------------------------------------------------------------------
       */
      if (!successfullyLoaded) {
         MidasLogs.messages.push("Settings",
               "Settings file is missing, load defaults");

         loadDefaults();

         MidasLogs.messages.push("Settings", "Creating new settings file.");

         saveSettings();
      }

      /*
       * Chargement du fichier langue
       * ----------------------------------------------------------------------
       */
      Language.loadFromFile(new File(LANGUAGES_FOLDER_PATH + File.separator
            + languageCode + "." + LANGUAGE_FILE_EXTENSION));
   }

   /**
    * Sauvegarde dans le fichier de configuration les paramètres actuels.
    */
   public void saveSettings() {
      File file = new File(CONFIG_FOLDER_PATH + File.separator
            + CONFIG_FILE_NAME + "." + CONFIG_FILE_EXTENSION);

      // Création du dossier et / ou fichier si inexistant
      try {
         if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
         }
         file.createNewFile();
      }
      catch (Exception e) {
         MidasLogs.errors.push("Settings", "Unable to create config file.");
      }

      /*
       * Création de l'arborescence xml
       * ----------------------------------------------------------------------
       */
      Element root = new Element(XMLNodes.SETTINGS.getXMLName());
      Document document = new Document(root);

      // Ajout des propriétés générales
      Element newNode = new Element(XMLNodes.PROPERTIES.getXMLName());

      XMLModifiers.addChild(newNode, XMLNodes.LANGUAGE_CODE.getXMLName(),
            languageCode);
      root.addContent(newNode);

      // Ajout des propriétés des "frames"
      newNode = new Element(XMLNodes.FRAMES.getXMLName());

      addFrameSettingsToXMLNode(newNode, mainFrame);

      root.addContent(newNode);

      /*
       * Creation du fichier à l'emplacement voulu
       * ----------------------------------------------------------------------
       */
      FileOutputStream fileOutputStream = null;
      try {
         fileOutputStream = new FileOutputStream(file);

         XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());

         outputter.output(document, fileOutputStream);
      }
      catch (IOException ex) {
         MidasLogs.errors.push("Settings", "Unable to create the config file.");
      }
      finally {
         if (fileOutputStream != null) {
            try {
               fileOutputStream.close();
            }
            catch (IOException ex) {
               MidasLogs.errors.push("Settings",
                     "Error while closing the output stream.");
            }
         }
      }
   }

   /**
    * Crée un fichier de langue contenant tous les champs à remplir.
    * 
    * @param languageCode
    *           - le code de language à utiliser comme nom de fichier.
    */
   public static void createTemplateForLanguage(String languageCode) {

      File file = new File(LANGUAGES_FOLDER_PATH + File.separator
            + languageCode + "_template." + LANGUAGE_FILE_EXTENSION);

      Language.createTemplateLanguageFile(file);

   }

   /**
    * Crée un fichier de langue contenant tous les champs. Les champs déjà
    * remplis par le premier fichier de langue chargé sont repris tels quels.
    * <p>
    * Cette méthode sert à simplifier l'ajout de nouveau champs dans le fichier
    * de langue sans avoir à écrire les balise à la main.
    * 
    * @param languageCode
    *           - le code de language à utiliser comme nom de fichier.
    */
   public static void createUpdateForLanguage(String languageCode) {

      File file = new File(LANGUAGES_FOLDER_PATH + File.separator
            + languageCode + "_update." + LANGUAGE_FILE_EXTENSION);

      Language.createUpdatedLanguageFile(file);

   }

   /**
    * Définit les paramètres d'une fenêtre à partir du noeud donné.
    * 
    * @param frame
    *           - le conteneur des paramètres de la fenêtre.
    * @param xmlNode
    *           - le noeud xml définissant la fenêtre.
    */
   private void setFrameSettingsFromXMLNode(FrameSettings frame, Element xmlNode) {
      frame.width = XMLGetters.getIntegerChild(xmlNode,
            XMLNodes.WIDTH.getXMLName(), frame.width);
      frame.height = XMLGetters.getIntegerChild(xmlNode,
            XMLNodes.HEIGHT.getXMLName(), frame.height);

      frame.positionX = XMLGetters.getIntegerChild(xmlNode,
            XMLNodes.POSITION_X.getXMLName(), frame.positionX);
      frame.positionX = XMLGetters.getIntegerChild(xmlNode,
            XMLNodes.POSITION_Y.getXMLName(), frame.positionY);

      try {
         frame.anchor = ScreenPosition.valueOf(XMLGetters.getStringChild(
               xmlNode, XMLNodes.ANCHOR.getXMLName(),
               ScreenPosition.TOP_LEFT.toString()).toUpperCase());
      }
      catch (Exception ex) {
         frame.anchor = ScreenPosition.TOP_LEFT;
      }
   }

   /**
    * Définit les paramètres de la fenêtre donnée selon ceux lui correspondant à
    * partir du noeud xml contenant les paramètres de toutes les fenêtres.
    * 
    * @param frame
    *           - le conteneur des paramètres de la fenêtre.
    * @param xmlFramesNode
    *           - le noeud xml, racine de toutes les fenêtres.
    */
   private void setFrameSettingsFromXMLFramesNodes(FrameSettings frame,
         Element xmlFramesNode) {

      Element node = xmlFramesNode.getChild(frame.getName());

      if (node != null) {

         setFrameSettingsFromXMLNode(frame, node);

      }
      else {
         MidasLogs.errors.push("Settings", "Node for frame " + frame.getName()
               + " is missing.");
      }
   }

   /**
    * Définit les paramètres du noeud xml donné à partir des paramètres de la
    * fenêtre donnée.
    * 
    * @param element
    *           - le noeud xml à définir.
    * @param frame
    *           - le conteneur des paramètres de la fenêtre.
    */
   private void setXMLNodeFromFrameSettings(Element element, FrameSettings frame) {
      XMLModifiers.addChild(element, XMLNodes.WIDTH.getXMLName(), frame.width);
      XMLModifiers
            .addChild(element, XMLNodes.HEIGHT.getXMLName(), frame.height);
      XMLModifiers.addChild(element, XMLNodes.POSITION_X.getXMLName(),
            frame.positionX);
      XMLModifiers.addChild(element, XMLNodes.POSITION_Y.getXMLName(),
            frame.positionY);
      XMLModifiers.addChild(element, XMLNodes.ANCHOR.getXMLName(),
            frame.anchor.name());
   }

   /**
    * Attaque un noeud décrivant une fenêtre, selon les paramètres donnés, en
    * tant qu'enfant au noeud principal donné contenant toutes les fenêtres.
    * 
    * @param node
    *           - le noeud principal.
    * @param frame
    *           - le conteneur des paramètres de la fenêtre.
    */
   private void addFrameSettingsToXMLNode(Element node, FrameSettings frame) {
      Element frameNode = new Element(frame.getName());
      setXMLNodeFromFrameSettings(frameNode, frame);
      node.addContent(frameNode);
   }

   /**
    * Charge les paramètres par défaut.
    */
   public void loadDefaults() {
      DefaultsSettings.setDefaults();
   }

   /**
    * Enumération des différents noeud xml lié au fichier de configuration.
    * 
    * @author Biolzi Sébastien
    * @author Brito Carvalho Bruno
    * @author Decorvet Grégoire
    * @author Schweizer Thomas
    * @author Sinniger Marcel
    * 
    */
   private enum XMLNodes implements HasXMLName {
      SETTINGS, PROPERTIES, LANGUAGE_CODE,
      FRAMES, FRAME_SETTINGS,
      WIDTH, HEIGHT, POSITION_X, POSITION_Y, ANCHOR;

      @Override
      public String getXMLName() {
         return name().toLowerCase();
      }
   }
}
