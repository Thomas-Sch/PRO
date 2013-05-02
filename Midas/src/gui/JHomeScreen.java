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

import gui.controller.Controller;
import gui.controller.QuickExpense;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
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
public class JHomeScreen extends JPanel {
   
   Controller controller;
   
   QuickExpense quickExpense;
   /**
    * Constructeur par défaut.
    */
   public JHomeScreen(Controller controller) {
      this.controller = controller;
      
      quickExpense = new QuickExpense(controller.getCore());
      
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
      add(quickExpense.getJComponent(),gblConstraints);
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
}
