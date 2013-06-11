/* ============================================================================
 * Nom du fichier   : JAlertList.java
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
package gui.component.list;

import gui.View;

import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

import core.components.Alert;
import core.components.AlertList;

/**
 * Composant graphique pour une liste d'alertes.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JAlertList extends JList<Alert> implements View {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 6312860386159673605L;

   private AlertList alerts;

   /**
    * Crée la vue sur la liste d'alertes.
    * 
    * @param alerts
    *           - la liste des alertes.
    */
   public JAlertList(AlertList alerts) {
      this.alerts = alerts;
      update(alerts, null);
   }

   @Override
   public void update(Observable arg0, Object arg1) {
      LinkedList<Alert> list = alerts.getList();

      Alert[] temp = new Alert[0];
      setModel(new DefaultComboBoxModel<Alert>(list.toArray(temp)));
   }
}
