/* ============================================================================
 * Nom du fichier   : Language.java
 * ============================================================================
 * Date de création : 10 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package settings;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import utils.xml.HasXMLName;
import utils.xml.XMLGetters;
import core.MidasLogs;

/**
 * Contient les outils permettant de gérer l'affichage des textes selon leur
 * langue au sein du programme.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class Language {

   private static final String xmlRootName = "language";

   /**
    * Énumération des champs de textes de l'application. Il s'agit des champs
    * courts, comme les textes des menus, boutons etc...
    * 
    * @author Biolzi Sébastien
    * @author Brito Carvalho Bruno
    * @author Decorvet Grégoire
    * @author Schweizer Thomas
    * @author Sinniger Marcel
    * 
    */
   public enum Text implements HasXMLName {
      
      /* ----------------------------------------------------------------------
       * Début des déclarations - ajouter au besoin
       * ----------------------------------------------------------------------
       */
      APP_TITLE,
     
      // Titres des menus principaux.
      FILE_MENU,
      EDIT_MENU,
      VIEW_MENU,
      INTERROGATION_MENU,
      
      // Sous menus de FILE_MENU.
      ACTION_QUIT,
      
      // Sous menus de EDIT_MENU.
      ACTION_MANAGE_ACCOUNT,
      ACTION_MANAGE_BUDGET,
      ACTION_CREATE_ONTHEFLY_BUDGET,
      ACTION_MANAGE_CATEGORY,
      ACTION_MANAGE_USER,
      ACTION_NEW_EXPENSE,
      ACTION_NEW_TRANSACTION,
      
      // Sous menus de VIEW_MENU.
      ACTION_LIST,
      ACTION_GRAPH,
      
      ACTION_LIST_LAST20,
      ACTION_LIST_TRANSACTION,
      
      // Sous menus de INTERROGATION_MENU.
      ACTION_HELP,
      ACTION_ABOUT,
      
      // Titres des fenêtres.
      ACCOUNT_CREATION_TITLE,
      ACCOUNT_MANAGEMENT_TITLE,
      CATEGORY_CREATION_TITLE,
      CATEGORY_MANAGEMENT_TITLE,
      SUBCATEGORY_CREATION_TITLE,
      USER_CREATION_TITLE,
      USER_MANAGEMENT_TITLE,
      BUDGET_CREATION_TITLE,
      BUDGET_FLY_CREATION_TITLE,
      BUDGET_MANAGEMENT_TITLE,
      EXPENSE_CREATION_TITLE,
      TRANSACTION_CREATION_TITLE,
      
      // Texte des boutons.
      VALIDATE_BUTTON,
      CANCEL_BUTTON,
      RESET_BUTTON,
      ADD_BUTTON,
      MODIFY_BUTTON,
      DELETE_BUTTON,
      
      // Décrivent une zone de l'application.
      ACCOUNT_LIST_LABEL,
      BUDGET_LIST_LABEL,
      USER_LIST_LABEL,
      CATEGORY_LIST_LABEL,
      QUICK_EXPENSE_LABEL,
      LAST_MONEY_MOVE_LABEL,
      
      // Descripteurs.
      USER_NAME_LABEL,
      HOME_SCREEN_NAME,
      REASON_LABEL,
      AMOUNT_LABEL,
      DATE_LABEL,
      BEGIN_DATE_LABEL,
      END_DATE_LABEL,
      RECURRENCE_LABEL,
      TIME_SLICE_SETTINGS,
      BUDGET_LABEL,
      
      // Champs du budget.
      BUDGET_DESCRIPTION_LABEL,
      BUDGET_NAME_LABEL,
      BUDGET_BINDED_ACCOUNT_NAME_LABEL,
      BUDGET_BALANCE_LABEL,
      BUDGET_LIMIT_LABEL,
      BUDGET_IS_OK_LABEL, // Budget tenu ou pas.
      BUDGET_POSITIVE_LABEL,
      BUDGET_NEGATIVE_LABEL,
      BUDGET_AMOUNT_LEFT,
      
      // Champs du compte.
      ACCOUNT_THRESHOLD_LABEL,
      ACCOUNT_INITIAL_AMOUNT_LABEL,
      ACCOUNT_NUMBER_LABEL,
      ACCOUNT_DESCRIPTION_LABEL,
      ACCOUNT_NAME_LABEL,
      ACCOUNT_BANK_NAME_LABEL,
      ACCOUNT_BALANCE_LABEL,
      
      // Invites des catégories.
      CATEGORY_NAME_LABEL,
      CATEGORY_PARENT_LABEL,
      SELECT_CATEGORY_LABEL,
      NEW_CATEGORY_LABEL,
      SELECT_SUBCATEGORY_LABEL,
      NEW_SUBCATEGORY_LABEL,
      
      // Nom des intervalles de temps.
      DAILY_LABEL,
      WEEKLY_LABEL,
      MONTHLY_LABEL,
      ANNUAL_LABEL, 
      
      // Messages d'alerte.
      ACCOUNT_BANKRUPTCY_MESSAGE,
      BAD_DATE_MESSAGE,
      INCONSISTENCY_DATE_MESSAGE,
      BAD_TIME_SLICE_MESSAGE,
      NEGATIVE_BUDGET_MESSAGE,
      
      // Acronymes des monnaies.
      SWISS_FRANC_ACRONYM;
      
      /*
       * ----------------------------------------------------------------------
       * Fin des déclarations, ne pas modifier ci-dessous
       * ----------------------------------------------------------------------
       */
      private String text;

      @Override
      public String toString() {
         if (text == null) {
            return "Missing String";
         }
         else {
            return text;
         }
      }

      @Override
      public String getXMLName() {
         return super.toString().toLowerCase();
      }

      /**
       * Définit le texte à partir de la chaîne de caractères donnée.
       * 
       * @param text
       *           - le texte associé à l'attribut.
       */
      private void setValue(String text) {
         this.text = text;
      }

   }
   
   /**
    * Charge les textes à partir du fichier xml donné.
    * 
    * @param languageFile
    *           - le fichier de langue au format xml.
    */
   public static void loadFromFile(File languageFile) {

      MidasLogs.messages.push("Language", "Start loading texts from "
            + languageFile.getAbsolutePath());

      if (languageFile.exists()) {
         Document document = null;
         SAXBuilder saxBuilder = new SAXBuilder();

         Element root;

         try {
            document = saxBuilder.build(languageFile);
         }
         catch (Exception e) {
            MidasLogs.errors.push("Language", "Unable to load the file \""
                  + languageFile.getName() + "\".");
         }

         // Reconfiguration du type enum en lisant le fichier de langue
         String readValue;
         if (document != null) {
            root = document.getRootElement();

            for (Text text : Text.values()) {
               readValue = XMLGetters.getStringChild(root, text.getXMLName());

               // Ne modifie que si le texte contient au moins un caractère
               if (!readValue.isEmpty()) {
                  text.setValue(readValue);
               }

            }
         }
      }
      else {
         MidasLogs.errors.push("Language", "File \"" + languageFile.getName()
               + "\" does not exist.");
      }
   }

   /**
    * Crée un fichier de langue contenant tous les noeuds et en remplissant les
    * noeud déjà associés à un texte, laissant les autres à remplir
    * 
    * @param languageFile
    *           - le fichier de langue.
    */
   public static void createUpdatedLanguageFile(File languageFile) {
      createLanguageFile(languageFile, true);
   }

   /**
    * Crée un fichier de langue contenant tous les noeuds en laissant les champs
    * libres pour n'avoir que le canevas.
    * 
    * @param languageFile
    *           - le fichier de langue.
    */
   public static void createTemplateLanguageFile(File languageFile) {
      createLanguageFile(languageFile, false);
   }

   /**
    * Crée un fichier de langue selon le fichier donné. Remplit ou non les
    * champs des nouveaux noeuds.
    * 
    * @param languageFile
    *           - le fichier de langue.
    * @param createUpdate
    *           - Vrai remplira les champs par le texte actuel s'il existe,
    *           alors que Faux créera un canevas de la langue en laissant le
    *           texte du noeud vide.
    */
   private static void createLanguageFile(File languageFile,
         boolean createUpdate) {
      try {
         if (!languageFile.getParentFile().exists()) {
            languageFile.getParentFile().mkdirs();
         }
      }
      catch (Exception e) {
         MidasLogs.errors.push("Settings", "Unable to create language folder.");
      }

      Element root = new Element(xmlRootName);
      Document document = new Document(root);

      Element textElement;
      for (Text text : Text.values()) {
         textElement = new Element(text.getXMLName());

         if (createUpdate) {
            textElement.setText(text.toString());
         }
         else {
            textElement.setText("TODO");
         }

         root.addContent(textElement);
      }

      /* Creation du fichier à l'emplacement voulu
       * ----------------------------------------------------------------------
       */
      FileOutputStream fileOutputStream = null;
      try {
         fileOutputStream = new FileOutputStream(languageFile);

         XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());

         outputter.output(document, fileOutputStream);
      }
      catch (IOException ex) {
         MidasLogs.errors.push("Language",
               "Unable to create template file for language.");
      }
      finally {
         if (fileOutputStream != null) {
            try {
               fileOutputStream.close();
            }
            catch (IOException ex) {
               MidasLogs.errors.push("Language",
                     "Error while closing the output stream.");
            }
         }
      }

   }

}
