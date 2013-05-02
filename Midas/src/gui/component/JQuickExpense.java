/* ============================================================================
 * Nom du fichier   : QuickExpense.java
 * ============================================================================
 * Date de création : 28 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component;

import gui.controller.ComboBoxAuthor;
import gui.controller.Controller;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import settings.Language.Text;

/**
 * Panel permettant l'ajout d'une dépense rapide.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JQuickExpense extends JPanel {
   Controller controller;
   
   GridBagLayout layout;
   
   //Composants graphiques.
   JButton btnValidate;
   
   /**
    * ID de série.
    */
   private static final long serialVersionUID = -3027141438435669187L;

   /**
    * 
    */
   public JQuickExpense(Controller controller) {
      this.controller = controller;
      
      GridBagLayout layout = new GridBagLayout();
      setLayout(layout);
      
      GridBagConstraints constraints = new GridBagConstraints();
      initConstraints(constraints);
     
      
      setTitle(constraints);
      setAuthorList(constraints);
      setAmountInput(constraints);
      setDateInput(constraints);
      setBudgetList(constraints);   
      setCategoryLists(constraints);
      setReasonInput(constraints);
      setValidateButton(constraints);
   }
   
   public JButton getValidateButton() {
      return  btnValidate;
   }
   
   /**
    * Configure l'emplacement et ajoute de bouton de validation.
    * @param constraints Contraintes.
    */
   private void setValidateButton(GridBagConstraints constraints) {
      constraints.gridx = 2;
      constraints.gridy = 4;
      constraints.gridwidth = 1;
      btnValidate = new JButton("Valider la dépense");
      add(btnValidate, constraints);
   }

   /**
    * Configure l'emplacement et ajoute les champs de saisie du motif de 
    * la dépense.
    * @param constraints Contraintes.
    */
   private void setReasonInput(GridBagConstraints constraints) {
      constraints.gridx = 0;
      constraints.gridy = 3;
      constraints.gridwidth = 3;
      add(new JReasonInput(), constraints);
   }

   /**
    * Configure l'emplacement et ajoute les listes de sélection des catégories 
    * et sous catégories correspondantes.
    * @param constraints Contraintes.
    */
   private void setCategoryLists(GridBagConstraints constraints) {
      constraints.gridx = 1;
      add(new JComboBoxCategory(), constraints);
      
      constraints.gridx = 2;
      add(new JComboBoxCategory(), constraints);
   }

   /**
    * Configure l'emplacement et ajoute la liste des budgets.
    * @param constraints Contraintes.
    */
   private void setBudgetList(GridBagConstraints constraints) {
      constraints.gridx = 0;
      constraints.gridy = 2;
      JComboBox<String> cmbBudgets = new JComboBox<>();
      
      ComboBoxModel<String> cbmBudgetsData = new DefaultComboBoxModel<String>(
            new String[] { "Selectionner un budget", "Maison", "Tourisme", "Cadeaux", "Nouveau budget..." });
      
      cmbBudgets.setModel(cbmBudgetsData);
      add(cmbBudgets, constraints);
   }

   /**
    * Configure l'emplacement et ajoute les champs de saisie de date.
    * @param constraints Contrainte.
    */
   private void setDateInput(GridBagConstraints constraints) {
      constraints.gridx = 2;
      add(new JDateInput(), constraints);
   }

   /**
    * Configure l'emplacement et ajoute la zone de saisie d'un montant.
    * @param constraints Contraintes.
    */
   private void setAmountInput(GridBagConstraints constraints) {
      constraints.gridx = 1;
      add(new JAmountInput(), constraints);
   }

   /**
    * Configure l'emplacement et ajoute la liste déroulante d'auteurs.
    * @param constraints Contraintes.
    */
   private void setAuthorList(GridBagConstraints constraints) {
      ComboBoxAuthor authors = new ComboBoxAuthor(controller.getCore());
      constraints.gridx = 0;
      constraints.gridy = 1;
      add(authors.getGraphicalComponent(), constraints);
   }

   /**
    * Initialisation des contraintes initiales d'affichage.
    * @param constraints Contraintes à initialiser.
    */
   private void initConstraints(GridBagConstraints constraints) {
      constraints.fill = GridBagConstraints.HORIZONTAL;
      
      constraints.insets = new Insets(5, 5, 5, 5);
      constraints.weighty = 0.0;
   }
   
   /**
    * Placement du titre dans le panel.
    * @param constraints Contraintes.
    */
   private void setTitle(GridBagConstraints constraints) {
      // Paramétrage des contraintes et ajout du panel d'alerte.
      constraints.weightx = 0.1;
      constraints.gridx = 0;
      constraints.gridy = 0;     
      constraints.anchor = GridBagConstraints.NORTH;
      add(new JLabel(Text.QUICK_EXPENSE_LABEL.toString()), constraints);
   }
}
