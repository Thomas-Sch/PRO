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
import utils.TimeSlice;

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
      list = new LinkedList<>();
      
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
   
   /**
    * Renvoie l'identifiant de l'intervalle de temps sélectionnée dans le composant.
    * @return
    */
   public TimeSlice getTimeSlice() {
      JRadioButton selected = (JRadioButton) radioGroup.getSelection();
      
      return TimeSlice.getTimeSlice(selected.getText());
   }
}
