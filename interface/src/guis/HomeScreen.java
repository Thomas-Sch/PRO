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
package guis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

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
      JComboBox<String> cmbBudgets = new JComboBox<>();
      
      ComboBoxModel<String> cbmBudgetsData = new DefaultComboBoxModel<String>(
            new String[] { "Selectionner un budget", "Maison", "Tourisme", "Cadeaux", "Nouveau budget..." });
      
      cmbBudgets.setModel(cbmBudgetsData);
      pnlQuickExpense.add(cmbBudgets, gblConstraints);
      
      // Ajout de la zone de saisie d'un montant.
      gblConstraints.gridx = 1;
      gblConstraints.weightx = 0.0;
      gblConstraints.anchor = GridBagConstraints.CENTER;
      pnlQuickExpense.add(new JLabel("Montant:"), gblConstraints);
      
      gblConstraints.gridx = 2;
      gblConstraints.weightx = 0.5;
      gblConstraints.anchor = GridBagConstraints.NORTH;
      pnlQuickExpense.add(new JTextField("..."), gblConstraints);
      
      gblConstraints.gridx = 3;
      JDateChooser dchTime = new JDateChooser();
      
      pnlQuickExpense.add(dchTime, gblConstraints);
      
      return pnlQuickExpense;
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
      lstLastMoneyMoves.setSelectionBackground(Color.WHITE);
      lstLastMoneyMoves.setSelectionForeground(Color.BLACK);
      
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

}
