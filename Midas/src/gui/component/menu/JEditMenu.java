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
package gui.component.menu;

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
   
   private JMenuItem mniEditNewExpense;
   private JMenuItem mniEditNewTransaction;

   /**
    * 
    */
   public JEditMenu() {
      setText("Edition");
      
      initContent();
      
      // Sous menu Edition->Comptes.
      add(mniEditAccount);
     
      // Sous menu Edition->Budgets.
      add(mniEditBudget);

      // Option Edition->Budget à la volée. 
      add(mniEditOnTheFlyBudget);

      // Séparateur Edition->Separateur1.
      JSeparator sepEditOne = new JSeparator();
      add(sepEditOne);

      // Option Edition->Gérer les catégories.
      add(mniEditManageCategory);

      // Option Edition->Gérer les auteurs.
      add(mniEditManageAuthor);
     
      // Séparateur Edition->Separateur2.
      JSeparator sepEditTwo = new JSeparator();
      add(sepEditTwo);
   
      // Option Edition->Dépenser.
      add(mniEditNewExpense);
   
      // Option Edition->Transaction.
      add(mniEditNewTransaction);
   }
   
   /**
    * Initialise les composants du menu d'édition.
    */
   public void initContent() {
      mniEditAccount = new JMenuItem("Comptes...");
      mniEditBudget = new JMenuItem("Budgets...");
      mniEditOnTheFlyBudget = new JMenuItem("Créer un budget à la volée");
      mniEditManageCategory = new JMenuItem("Gérer les catégories");
      mniEditManageAuthor = new JMenuItem("Gérer les auteurs");
      
      mniEditNewExpense = new JMenuItem("Effectuer une dépense");
      mniEditNewTransaction = new JMenuItem("Faire une transaction...");
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

   public void addCreateOnTheFlyBudgetListener(ActionListener listener) {
      mniEditOnTheFlyBudget.addActionListener(listener);
   }

   public void addNewExpenseListener(ActionListener listener) {
      mniEditNewExpense.addActionListener(listener);
   }
   
   public void addNewTransactionListener(ActionListener listener) {
      mniEditNewTransaction.addActionListener(listener);
   }
}
