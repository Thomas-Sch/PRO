/* ============================================================================
 * Nom du fichier   : JHomeScreen.java
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
package gui.component;

import gui.Controller;
import gui.controller.QuickExpense;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 * Fenêtre contenant les éléments du menu d'accueil.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JHomeScreen extends JPanel {

   /**
    * Identifiant de sérialisation.
    */
   private static final long serialVersionUID = -5781131226071442325L;

   private Controller controller;
   private QuickExpense quickExpense;
   private JMoneyMove mmePanel;
   private JWarningPanel wplPanel;

   /**
    * Crée la fenêtre d'accueil.
    */
   public JHomeScreen(Controller controller) {
      this.controller = controller;

      initContent();
      buildContent();
   }

   /**
    * Initialise les composants de l'interface.
    */
   public void initContent() {
      quickExpense = new QuickExpense(controller.getCore());
      mmePanel = new JMoneyMove(controller.getCore());
      wplPanel = new JWarningPanel(controller.getCore());
   }

   /**
    * Construit et place les éléments de l'interface.
    */
   public void buildContent() {
      setLayout(new GridBagLayout());

      GridBagConstraints gblConstraints = new GridBagConstraints();
      // Options globales de contrainte.
      gblConstraints.fill = GridBagConstraints.BOTH;

      gblConstraints.insets = new Insets(5, 5, 5, 5);
      gblConstraints.weighty = 0.5;

      // Paramétrage des contraintes et ajout du panneau d'alerte.
      gblConstraints.weightx = 0.5;
      gblConstraints.gridx = 0;
      gblConstraints.gridy = 0;
      add(wplPanel, gblConstraints);

      // Paramétrage des contraintes et ajout du panneau des derniers mouvements
      // d'argent.
      gblConstraints.weightx = 0.5;
      gblConstraints.gridx = 1;
      gblConstraints.gridy = 0;
      add(mmePanel, gblConstraints);

      // Désormais, les composants suivants prennent toute la largeur verticale.
      gblConstraints.gridwidth = 2;

      // Ajout du premier séparateur.
      gblConstraints.gridx = 0;
      gblConstraints.gridy = 1;
      gblConstraints.weighty = 0.0;
      JSeparator sepOne = new JSeparator();
      add(sepOne, gblConstraints);

      // Paramétrage des contraintes et ajout de la zone d'ajout de dépense
      // rapide.
      gblConstraints.anchor = GridBagConstraints.NORTH;
      gblConstraints.weighty = 0.02;
      gblConstraints.gridx = 0;
      gblConstraints.gridy = 2;
      add(quickExpense.getGraphicalComponent(), gblConstraints);
   }
}
