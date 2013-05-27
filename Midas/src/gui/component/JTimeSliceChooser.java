/* ============================================================================
 * Nom du fichier   : JTimeSliceChooser.java
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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import settings.Language.Text;

/**
 * Panel de sélection d'intervalle de temps (Journalier, Mois, etc...).
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JTimeSliceChooser extends JPanel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 2161876509341301904L;
   
   public static enum TimeSlice { 
      DAILY(1, Text.DAILY_LABEL.toString()), 
      WEEKLY(7, Text.WEEKLY_LABEL.toString() ),
      MONTHLY(31, Text.MONTHLY_LABEL.toString()), 
      ANNUAL(365, Text.ANNUAL_LABEL.toString());
      
      int lengthIdentifier;
      String name;
      
      /**
       * Constructeur d'une intervalle de temps.
       * @param id Nombre identifiant la longueur de temps.
       * @param name Nom de l'intervalle.
       */
      private TimeSlice(int id, String name) {
         lengthIdentifier = id;
         this.name = name;
      }
      
      /**
       * @return Le nom de l'intervalle de temps.
       */
      public String getName () {
         return name;
      }
   }
   
   // Composants. 
   private ButtonGroup radioGroup;
   private LinkedList<JRadioButton> list;
   
   /**
    * 
    */
   public JTimeSliceChooser(TimeSlice ... slices) {
      initContent(slices);
      buildContent(slices);
   }
    
   private void initContent(TimeSlice ... slices) {
      radioGroup = new ButtonGroup();
      
      for(TimeSlice slice : slices) {
         list.add(new JRadioButton(slice.getName()));
         radioGroup.add(list.getLast());
      }
   }
   
   private void buildContent(TimeSlice ... slices) {
      setLayout(new GridBagLayout());
      
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.weightx = 0.5;
      constraints.weighty = 0.5;
      
      constraints.gridx = 0;
      constraints.gridy = 0;
      add(buildRadioButtonGroup(), constraints);    
   }
   
   private JPanel buildRadioButtonGroup() {
      JPanel pnlContent = new JPanel();
      
      pnlContent.setLayout(new GridLayout(2, 2));
      pnlContent.setBorder(BorderFactory.createTitledBorder(Text.TIME_SLICE_SETTINGS.toString()));
      
      for (JRadioButton button : list) {
         pnlContent.add(button);
      }
      
      return pnlContent;
   }
}
