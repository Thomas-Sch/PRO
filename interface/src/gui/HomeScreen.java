/* ============================================================================
 * Nom du fichier   : HomeScreen.java
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
package gui;

import gui.component.ComboBoxAuthor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import data.AuthorData;

/**
 * Contient les éléments du menu d'accueil.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
@SuppressWarnings("serial")
public class HomeScreen extends JPanel {
   /**
    * Constructeur par défaut.
    */
   public HomeScreen() {
      setLayout(new GridBagLayout());
      
      GridBagConstraints gblConstraints = new GridBagConstraints(); 
      // Options globales de contrainte.
      gblConstraints.fill = GridBagConstraints.BOTH;
      
      gblConstraints.insets = new Insets(5, 5, 5, 5);
      gblConstraints.weighty = 0.5;
      
      // Paramétrage des contraintes et ajout du panel d'alerte.
      gblConstraints.weightx = 0.5;
      gblConstraints.gridx = 0;
      gblConstraints.gridy = 0;      
      add(getWarningPanel(),gblConstraints);
      
      // Paramétrage des contraintes et ajout du panel des derniers mouvements d'argent.
      gblConstraints.weightx = 0.5;
      gblConstraints.gridx = 1;
      gblConstraints.gridy = 0;
      add(getLastMoneyMovesPanel(),gblConstraints);
      
      // Désormais, les composants suivants prennent toute la largeur verticale.
      gblConstraints.gridwidth = 2;
      
      // Ajout du premier séparateur.
      gblConstraints.gridx = 0;
      gblConstraints.gridy = 1;
      gblConstraints.weighty = 0.0;
      JSeparator sepOne = new JSeparator();
      add(sepOne, gblConstraints);
      
      // Paramétrage des contraintes et ajout de la zone d'ajout de dépense rapide.
      gblConstraints.anchor = GridBagConstraints.NORTH;
      gblConstraints.gridx = 0;
      gblConstraints.gridy = 2;
      add(getQuickExpensePanel(),gblConstraints);
   }   
   
   
   /**
    * Créer le panel de dépense rapide.
    * @return le panel d'ajout de dépense rapide.
    */
   private JPanel getQuickExpensePanel() {
      JPanel pnlQuickExpense = new JPanel();
      pnlQuickExpense.setLayout(new GridBagLayout());
      
      GridBagConstraints gblConstraints = new GridBagConstraints(); 
      // Options globales de contrainte.
      gblConstraints.fill = GridBagConstraints.HORIZONTAL;
      
      gblConstraints.insets = new Insets(5, 5, 5, 5);
      gblConstraints.weighty = 0.0;
      
      // Paramétrage des contraintes et ajout du panel d'alerte.
      gblConstraints.weightx = 0.1;
      gblConstraints.gridx = 0;
      gblConstraints.gridy = 0;     
      gblConstraints.anchor = GridBagConstraints.NORTH;
      pnlQuickExpense.add(new JLabel("Effectuer une dépense rapide..."), gblConstraints);
      
      // Ajout de la liste déroulante
      gblConstraints.gridx = 0;
      gblConstraints.gridy = 1;

      pnlQuickExpense.add(new ComboBoxAuthor(), gblConstraints);
      
      // Ajout de la zone de saisie d'un montant.
      gblConstraints.gridx = 1;
      pnlQuickExpense.add(getAmountInputPanel(), gblConstraints);
      
      // Saisie de la date.
      gblConstraints.gridx = 2;
      pnlQuickExpense.add(getDateInputPanel(), gblConstraints);
      
      gblConstraints.gridx = 0;
      gblConstraints.gridy = 2;
      JComboBox<String> cmbBudgets = new JComboBox<>();
      
      ComboBoxModel<String> cbmBudgetsData = new DefaultComboBoxModel<String>(
            new String[] { "Selectionner un budget", "Maison", "Tourisme", "Cadeaux", "Nouveau budget..." });
      
      cmbBudgets.setModel(cbmBudgetsData);
      pnlQuickExpense.add(cmbBudgets, gblConstraints);
     
      
      gblConstraints.gridx = 1;
      JComboBox<String> cmbCategory = new JComboBox<>();
      
      ComboBoxModel<String> cbmCategory = new DefaultComboBoxModel<String>(
            new String[] { "Selectionner une catégorie", "Mirtille", "Poire", "Orange", "Nouvelle catégorie..." });
      
      cmbCategory.setModel(cbmCategory);
      pnlQuickExpense.add(cmbCategory, gblConstraints);
      
      gblConstraints.gridx = 2;
      JComboBox<String> cmbSubCategory = new JComboBox<>();
      
      ComboBoxModel<String> cbmSubCategory = new DefaultComboBoxModel<String>(
            new String[] { "Selectionner une sous-catégorie", "Atome", "Proton", "Quark", "Nouvelle sous-catégorie..." });
      
      cmbSubCategory.setModel(cbmSubCategory);
      pnlQuickExpense.add(cmbSubCategory, gblConstraints);
      
      gblConstraints.gridx = 0;
      gblConstraints.gridy = 3;
      gblConstraints.gridwidth = 3;
      pnlQuickExpense.add(getReasonPanel(), gblConstraints);
      
      gblConstraints.gridx = 2;
      gblConstraints.gridy = 4;
      gblConstraints.gridwidth = 1;
      pnlQuickExpense.add(new JButton("Valider la dépense"), gblConstraints);
      
      return pnlQuickExpense;
   }


   /**
    * Construit le panel contenant le motif d'une dépense.
    * @return le panel construit.
    */
   private Component getReasonPanel() {
      JPanel pnlReasons = new JPanel(new BorderLayout(5,5));
      
      pnlReasons.add(new JLabel("Motif:"), BorderLayout.WEST);
      pnlReasons.add(new JTextField("..."), BorderLayout.CENTER);
      
      return pnlReasons;
   }


   /**
    * Renvoie le panel des derniers mouvements d'argent.
    * @return le panels des dernies mouvements d'argent.
    */
   private JPanel getLastMoneyMovesPanel() {
      JPanel pnlLastMoneyMoves = new JPanel();
      
      pnlLastMoneyMoves.setLayout(new BorderLayout());
      
      // Ajout des composants au panel.
      pnlLastMoneyMoves.add(new JLabel("Derniers mouvements d'argent:"), BorderLayout.NORTH);
      
      // Définission du modèle de test.
      DefaultListModel<String> dlmLastMoneyMoves = new DefaultListModel<>();
      dlmLastMoneyMoves.addElement("P PP PPP");
      dlmLastMoneyMoves.addElement("C'est n'est pas le panel que vous recherchez.");
      
      JList<String> lstLastMoneyMoves = new JList<>(dlmLastMoneyMoves);
      // Code obtenu sur http://tutiez.com/how-to-disable-jlist-selection-in-java.html
      lstLastMoneyMoves.setCellRenderer(new DefaultListCellRenderer() {
         
         public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                 boolean isSelected, boolean cellHasFocus) {
             super.getListCellRendererComponent(list, value, index, false, false);
      
             return this;
         }
     });
      
      pnlLastMoneyMoves.add(lstLastMoneyMoves, BorderLayout.CENTER);
      return pnlLastMoneyMoves;
   }

   /**
    * Renvoie le panel d'alertes.
    * @return le panel d'alertes.
    */
   private JPanel getWarningPanel() {
      JPanel pnlWarning = new JPanel();
      
      pnlWarning.setLayout(new BorderLayout());
      
      // Ajout des composants au panel d'alertes.
      pnlWarning.add(new JLabel("Alertes:"), BorderLayout.NORTH);
      
      // Contenu de la liste
      DefaultListModel<String> dlmWarning = new DefaultListModel<>();
      dlmWarning.addElement("C'est la fin du monde");
      dlmWarning.addElement("J'aurais pas du dépenser autant :(");
      
      JList<String> lstWarning = new JList<>(dlmWarning);
      
      pnlWarning.add(lstWarning, BorderLayout.CENTER);
      
      return pnlWarning;
   }
   
   /**
    * Construit le panel de saisie du montant d'argent.
    * @return le panel construit.
    */
   private JPanel getAmountInputPanel(){
      JPanel pnlAmountInput = new JPanel();
      pnlAmountInput.setLayout(new BorderLayout(5,5));
      
      pnlAmountInput.add(new JLabel("Montant:"), BorderLayout.WEST);
      
      JTextField txtAmountInput = new JTextField("...");
      
      pnlAmountInput.add(txtAmountInput, BorderLayout.CENTER);
      
      return pnlAmountInput;
   }
   
   /**
    * Construit le panel de saisie de la date.
    * @return le panel construit.
    */
   private JPanel getDateInputPanel(){
      JPanel pnlDateInput = new JPanel();
      pnlDateInput.setLayout(new BorderLayout(5,5));
      
      pnlDateInput.add(new JLabel("Date:"), BorderLayout.WEST);      
      JDateChooser dchTime = new JDateChooser(new Date());
      pnlDateInput.add(dchTime, BorderLayout.CENTER);
      return pnlDateInput;      
   }
   

}
