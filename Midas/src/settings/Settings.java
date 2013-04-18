/* ============================================================================
 * Nom du fichier   : Settings.java
 * ============================================================================
 * Date de cr�ation : 7 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi S�bastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Gr�goire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package settings;

import core.MidasLogs;
import gui.utils.Positions.ScreenPosition;
import settings.elements.FrameSettings;
import utils.XMLGetters;

import java.io.File;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class Settings {
   
   private static final String CONFIG_FOLDER_PATH = "config";
   private static final String CONFIG_FILE_NAME = "config";
   private static final String CONFIG_FILE_EXTENSION = "xml";
   
   private static final String LANGUAGES_FOLDER_PATH = "languages";
   private static final String LANGUAGE_FILE_EXTENSION = "xml";
   
   
   public static String languageCode; 
   
   public static FrameSettings mainFrame;
   
   {
      mainFrame = new FrameSettings("mainFrame");
   }
   
   public Settings() {
      
   }
   
   public void loadSettings() {
      
      MidasLogs.messages.push("Settings", "Start loading settings");
      
      File file = new File(CONFIG_FOLDER_PATH + File.separator +
                           CONFIG_FILE_NAME + "." + CONFIG_FILE_EXTENSION);
      
      if (file.exists()) {
         
         Document document = null;
         SAXBuilder saxBuilder = new SAXBuilder();
         
         Element root;
         
         try {
            document = saxBuilder.build(file);
         }
         catch(Exception e) {
            MidasLogs.errors.push("Settings", "Unable to load the file \""
                                  + file.getName() + "\".");
         }
         
         Element currentElement;
         if (document != null) {
            root = document.getRootElement();
            
            /* Load properties
             * ----------------------------------------------------------------
             */
            currentElement = root.getChild("properties");
            
            languageCode = XMLGetters.getStringChild(currentElement,
                                                     "language", "fr");
            
            /* Load frames
             * ----------------------------------------------------------------
             */
            currentElement = root.getChild("frames");
            
            Settings.mainFrame.setFromXML(
               currentElement.getChild(mainFrame.getName()));
            
         }

         
         
         
         
         
      }
      else {
         
         MidasLogs.messages.push("Settings",
                                 "Settings file is missing, load defaults");
         
         loadDefaults();
         
         MidasLogs.messages.push("Settings", "Creating new settings file.");
         
         saveSettings();
         
      }
      
      Language.loadFromFile(new File(LANGUAGES_FOLDER_PATH + File.separator +
                            languageCode + "." + LANGUAGE_FILE_EXTENSION));
   }
   
   public void saveSettings() {
      File file = new File(CONFIG_FOLDER_PATH + File.separator +
                           CONFIG_FILE_NAME + "." + CONFIG_FILE_EXTENSION);
      
      try {
         if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
         }
         file.createNewFile();
      }
      catch(Exception e) {
         MidasLogs.errors.push("Settings", "Unable to create config file.");
      }
      
      
      
      
   }
   
   public static void createTemplateForLanguage(String languageCode) {
      
      File file = new File(LANGUAGES_FOLDER_PATH+ File.separator +
            languageCode + "." + LANGUAGE_FILE_EXTENSION);
      
      if (!file.exists()) {
         Language.createTemplateLanguageFile(file);
      }
      else {
         MidasLogs.messages.push("Settings", "Specified language already exist, template not created.");
      }
      
      
      
   }
   
   private void loadDefaults() {
      
      languageCode = "fr";
      
      mainFrame.positionX = 0;
      mainFrame.positionY = 0;
      mainFrame.anchor = ScreenPosition.CENTER;
      mainFrame.width = 600;
      mainFrame.height = 300;
      
      
   }
   

   
}
