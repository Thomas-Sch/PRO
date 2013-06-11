/* ============================================================================
 * Nom du fichier   : JWarningPanel.java
 * ============================================================================
 * Date de création : 8 juin 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component;

import gui.controller.listbox.WarningListBox;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import settings.Language.Text;
import core.Core;

/**
 * Panneau contenant les alertes concernants les budgets en retard.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JWarningPanel extends JPanel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 5322488419806964881L;

   private JLabel lblDescription;
   private WarningListBox warnings;

   public JWarningPanel(Core core) {
      initContent(core);
      buildContent();
   }

   /**
    * Initialise les composants du panneau.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   private void initContent(Core core) {
      lblDescription = new JLabel(Text.WARNING_LABEL.toString());
      warnings = new WarningListBox(core);
   }

   /**
    * Construit le contenu et place les composants.
    */
   private void buildContent() {
      setLayout(new BorderLayout());

      add(lblDescription, BorderLayout.NORTH);
      add(new JScrollPaneDefault(warnings.getGraphicalComponent()),
            BorderLayout.CENTER);
   }

}
