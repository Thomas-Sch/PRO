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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;

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
      
      GridBagConstraints gbl = new GridBagConstraints(); 
      // Options globales de contrainte.
      gbl.fill = GridBagConstraints.BOTH;
      
      gbl.insets = new Insets(5, 5, 5, 5);
      gbl.weighty = 0.5;
      
      // Paramétrage des contraintes et ajout du panel d'alerte.
      gbl.weightx = 0.5;
      gbl.gridx = 0;
      gbl.gridy = 0;      
      add(getWarningPanel(),gbl);
      
      // Paramétrage des contraintes et ajout du panel des derniers mouvements d'argent.
      gbl.weightx = 0.5;
      gbl.gridx = 1;
      gbl.gridy = 0;
      add(getLastMoneyMovesPanel(),gbl);
      
      // Désormais, les composants suivants prennent toute la largeur verticale.
      gbl.gridwidth = 2;
      
      // Ajout du premier séparateur.
      gbl.gridx = 0;
      gbl.gridy = 1;
      gbl.weighty = 0.0;
      JSeparator sepOne = new JSeparator();
      add(sepOne, gbl);
      
      // Paramétrage des contraintes et ajout de la zone d'ajout de dépense rapide.
      gbl.weighty = 0.5;
      gbl.anchor = GridBagConstraints.NORTH;
      gbl.gridx = 0;
      gbl.gridy = 2;
      add(getQuickExpensePanel(),gbl);
   }   
   
   
   /**
    * Créer le panel de dépense rapide.
    * @return le panel d'ajout de dépense rapide.
    */
   private JPanel getQuickExpensePanel() {
      JPanel pnlQuickExpense = new JPanel();
      pnlQuickExpense.setBackground(Color.CYAN);
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
