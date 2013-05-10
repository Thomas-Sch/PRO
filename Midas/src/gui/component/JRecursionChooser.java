/* ============================================================================
 * Nom du fichier   : JRecursionChooser.java
 * ============================================================================
 * Date de création : 10 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component;

import gui.utils.StandardInsets;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import settings.Language.Text;

/**
 * Panel de sélection de résurrence.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JRecursionChooser extends JPanel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 2161876509341301904L;
   
   // Composants.
   private JCheckBox cbxRecurrence;
   
   private ButtonGroup radioGroup;
   private JRadioButton rbtDaily;
   private JRadioButton rbtWeekly;
   private JRadioButton rbtMonthly;
   private JRadioButton rbtAnnual;
   
   /**
    * 
    */
   public JRecursionChooser() { 
      initContent();
      buildContent();
   }
    
   private void initContent() {
      cbxRecurrence = new JCheckBox(Text.RECURRENCE_LABEL.toString());
      
      radioGroup = new ButtonGroup();
      rbtDaily = new JRadioButton(Text.DAILY_LABEL.toString());
      rbtWeekly = new JRadioButton(Text.WEEKLY_LABEL.toString());
      rbtMonthly = new JRadioButton(Text.MONTHLY_LABEL.toString());
      rbtAnnual = new JRadioButton(Text.ANNUAL_LABEL.toString());     
   }
   
   private void buildContent() {
      setLayout(new GridBagLayout());
      
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.insets = new StandardInsets();
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.weightx = 0.5;
      constraints.weighty = 0.5;
      
      constraints.gridx = 0;
      constraints.gridy = 0;
      add(cbxRecurrence, constraints);
      
      constraints.gridy = 1;
      add(buildRadioButtonGroup(), constraints);    
   }
   
   private JPanel buildRadioButtonGroup() {
      JPanel pnlContent = new JPanel();
      
      // Ajout des composants au groupe logique des boutons radio.
      radioGroup.add(rbtDaily);
      radioGroup.add(rbtWeekly);
      radioGroup.add(rbtMonthly);
      radioGroup.add(rbtAnnual);
      
      pnlContent.setLayout(new GridLayout(2, 2));
      pnlContent.setBorder(BorderFactory.createTitledBorder(Text.RECURRENCE_SETTINGS.toString()));
      
      pnlContent.add(rbtDaily);
      pnlContent.add(rbtWeekly);
      pnlContent.add(rbtMonthly);
      pnlContent.add(rbtAnnual);
      
      return pnlContent;
   }
   
   
}
