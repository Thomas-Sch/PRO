/* ============================================================================
 * Nom du fichier   : MainMenu.java
 * ============================================================================
 * Date de création : 13 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package guis;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 * Classe contenant le menu principale de notre application
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
@SuppressWarnings("serial")
public class MainMenu extends JMenuBar {
   /**
    * Construit le menu avec ses composants.
    */
   public MainMenu() {      
      add(getFileMenu());
      add(getEditMenu());
      add(getViewMenu());
      add(getInterrogationMenu());
   }
   
   /**
    * Construit le menu "Fichier".
    * @return Le menu fichier.
    */
   private JMenu getFileMenu() {
      JMenu mnuFile = new JMenu("Fichier");
      
      // Option Fichier->Quitter.
      JMenuItem mniFileQuit = new JMenuItem("Quitter");
      mnuFile.add(mniFileQuit);
      
      return mnuFile;
   }
   
   /**
    * Construit le menu "Edition".
    * @return Le menu edition.
    */
   private JMenu getEditMenu() {
      JMenu mnuEdit = new JMenu("Edition");
      
      // Sous menu Edition->Comptes.
      JMenu mnuEditAccount = new JMenu("Comptes");
      mnuEdit.add(mnuEditAccount);
      
      // Option Edition->Comptes->Ajouter...
      JMenuItem mniEditAccountAdd = new JMenuItem("Ajouter...");
      mnuEditAccount.add(mniEditAccountAdd);

      // Option Edition->Comptes->Consulter...
      JMenuItem mniEditAccountConsult = new JMenuItem("Consulter...");
      mnuEditAccount.add(mniEditAccountConsult);

      // Option Edition->Comptes->Supprimer...
      JMenuItem mniEditAccountDelete = new JMenuItem("Supprimer...");
      mnuEditAccount.add(mniEditAccountDelete);

      // Sous menu Edition->Budgets.
      JMenu mnuEditBudget = new JMenu("Budgets");
      mnuEdit.add(mnuEditBudget);

      // Option Edition->Budgets->Ajouter...
      JMenuItem mniEditBudgetAdd = new JMenuItem("Ajouter...");
      mnuEditBudget.add(mniEditBudgetAdd);

      // Option Edition->Budgets->Consulter
      JMenuItem mniEditBudgetConsult = new JMenuItem("Consulter...");
      mnuEditBudget.add(mniEditBudgetConsult);

      // Option Edition->Budgets->Supprimer...
      JMenuItem mniEditBudgetDelete = new JMenuItem("Supprimer...");
      mnuEditBudget.add(mniEditBudgetDelete);

      // Option Edition->Budget à la volée.
      JMenuItem mniEditOnTheFlyBudget = new JMenuItem("Créer un budget à la volée");
      mnuEdit.add(mniEditOnTheFlyBudget);

      // Séparateur Edition->Separateur1.
      JSeparator sepEditOne = new JSeparator();
      mnuEdit.add(sepEditOne);

      // Option Edition->Gérer les catégories.
      JMenuItem mniEditManageCategory = new JMenuItem("Gérer les catégories");
      mnuEdit.add(mniEditManageCategory);

      // Option Edition->Gérer les auteurs.
      JMenuItem mniEditManageAuthor = new JMenuItem("Gérer les auteurs");
      mnuEdit.add(mniEditManageAuthor);
     
      // Séparateur Edition->Separateur2.
      JSeparator sepEditTwo = new JSeparator();
      mnuEdit.add(sepEditTwo);
   
      // Option Edition->Dépenser.
      JMenuItem mniEditDoExpense = new JMenuItem("Effectuer une dépense");
      mnuEdit.add(mniEditDoExpense);
   
      // Option Edition->Transaction.
      JMenuItem mniEditDoTransaction = new JMenuItem("Faire une transaction...");
      mnuEdit.add(mniEditDoTransaction);
      
      return mnuEdit;
   }

   /**
    * Construit le menu "Afficher".
    * @return le menu afficher.
    */
   private JMenu getViewMenu() {
      JMenu mnuView = new JMenu("Afficher");

      // Sous menu Afficher->Graphiques.
      JMenu mnuViewGraphic = new JMenu("Graphiques");
      mnuView.add(mnuViewGraphic);

      // Sous menu Afficher->Listes.
      JMenu mnuViewList = new JMenu("Listes");
      mnuView.add(mnuViewList);
         
      // Option Afficher->Listes->20 derniers mouvements d'argent.
      JMenuItem mniViewListLast20 = new JMenuItem("Les 20 derniers mouvements d'argent");
      mnuViewList.add(mniViewListLast20);

      // Option Afficher->Listes->Mouvements entre deux dates.
      JMenuItem mniViewListInterval = new JMenuItem("Mouvements d'argent dans un interval");
      mnuViewList.add(mniViewListInterval);
      
      return mnuView;
   }
   
   /**
    * Construit le menu "?".
    * @return le menu ?.
    */
   private JMenu getInterrogationMenu() {
      JMenu mnuInterrogation = new JMenu("?");

      // Option ?->Aide...
      JMenuItem mniInterrogationHelp = new JMenuItem("Aide...");
      mnuInterrogation.add(mniInterrogationHelp);

      // Option ?->A propos...
      JMenuItem mniInterrogationAbout = new JMenuItem("A propos...");
      mnuInterrogation.add(mniInterrogationAbout);
      
      return mnuInterrogation;
   }
}
