/* ============================================================================
 * Nom du fichier   : JEditMenu.java
 * ============================================================================
 * Date de création : 4 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 * Représente le menu d'édition de l'application.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JEditMenu extends JMenu {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -8256836741751163343L;

   /**
    * 
    */
   public JEditMenu() {
      setText("Edition");
      
      // Sous menu Edition->Comptes.
      JMenu mnuEditAccount = new JMenu("Comptes");
      add(mnuEditAccount);
      
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
      add(mnuEditBudget);

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
      add(mniEditOnTheFlyBudget);

      // Séparateur Edition->Separateur1.
      JSeparator sepEditOne = new JSeparator();
      add(sepEditOne);

      // Option Edition->Gérer les catégories.
      JMenuItem mniEditManageCategory = new JMenuItem("Gérer les catégories");
      add(mniEditManageCategory);

      // Option Edition->Gérer les auteurs.
      JMenuItem mniEditManageAuthor = new JMenuItem("Gérer les auteurs");
      add(mniEditManageAuthor);
     
      // Séparateur Edition->Separateur2.
      JSeparator sepEditTwo = new JSeparator();
      add(sepEditTwo);
   
      // Option Edition->Dépenser.
      JMenuItem mniEditDoExpense = new JMenuItem("Effectuer une dépense");
      add(mniEditDoExpense);
   
      // Option Edition->Transaction.
      JMenuItem mniEditDoTransaction = new JMenuItem("Faire une transaction...");
      add(mniEditDoTransaction);
   }
}
