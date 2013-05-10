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

import java.awt.event.ActionListener;

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
   
   private JMenuItem mniEditManageCategory;
   private JMenuItem mniEditManageAuthor;
   private JMenuItem mniEditAccount;
   private JMenuItem mniEditBudget;
   private JMenuItem mniEditOnTheFlyBudget;

   /**
    * 
    */
   public JEditMenu() {
      setText("Edition");
      
      // Sous menu Edition->Comptes.
      mniEditAccount = new JMenuItem("Comptes...");
      add(mniEditAccount);
      
//      // Option Edition->Comptes->Ajouter...
//      JMenuItem mniEditAccountAdd = new JMenuItem("Ajouter...");
//      mniEditAccount.add(mniEditAccountAdd);
//
//      // Option Edition->Comptes->Consulter...
//      JMenuItem mniEditAccountConsult = new JMenuItem("Consulter...");
//      mniEditAccount.add(mniEditAccountConsult);
//
//      // Option Edition->Comptes->Supprimer...
//      JMenuItem mniEditAccountDelete = new JMenuItem("Supprimer...");
//      mniEditAccount.add(mniEditAccountDelete);

      // Sous menu Edition->Budgets.
      mniEditBudget = new JMenuItem("Budgets...");
      add(mniEditBudget);

//      // Option Edition->Budgets->Ajouter...
//      JMenuItem mniEditBudgetAdd = new JMenuItem("Ajouter...");
//      mniEditBudget.add(mniEditBudgetAdd);
//
//      // Option Edition->Budgets->Consulter
//      JMenuItem mniEditBudgetConsult = new JMenuItem("Consulter...");
//      mniEditBudget.add(mniEditBudgetConsult);
//
//      // Option Edition->Budgets->Supprimer...
//      JMenuItem mniEditBudgetDelete = new JMenuItem("Supprimer...");
//      mniEditBudget.add(mniEditBudgetDelete);

      // Option Edition->Budget à la volée.
      mniEditOnTheFlyBudget = new JMenuItem("Créer un budget à la volée");
      add(mniEditOnTheFlyBudget);

      // Séparateur Edition->Separateur1.
      JSeparator sepEditOne = new JSeparator();
      add(sepEditOne);

      // Option Edition->Gérer les catégories.
      mniEditManageCategory = new JMenuItem("Gérer les catégories");
      add(mniEditManageCategory);

      // Option Edition->Gérer les auteurs.
      mniEditManageAuthor = new JMenuItem("Gérer les auteurs");
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
   
   public void addManageCategoryListener(ActionListener listener) {
      mniEditManageCategory.addActionListener(listener);
   }
   
   public void addManageAuthorListener(ActionListener listener) {
      mniEditManageAuthor.addActionListener(listener);
   }
   
   public void addManageAccountListener(ActionListener listener) {
      mniEditAccount.addActionListener(listener);
   }
   
   public void addManageBudgetListener(ActionListener listener) {
      mniEditBudget.addActionListener(listener);
   }

   public void addCreateOnTheFlyBudget(ActionListener listener) {
      mniEditOnTheFlyBudget.addActionListener(listener);
   }

}
