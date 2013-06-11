/* ============================================================================
 * Nom du fichier   : WarningListBox.java
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
package gui.controller.listbox;

import gui.Controller;
import gui.component.list.JAlertList;

import java.awt.Component;

import core.Core;
import core.components.AlertList;

/**
 * Contrôleur de la liste des alertes.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class WarningListBox extends Controller {

   private JAlertList view;
   private AlertList model;

   /**
    * Crée le contrôleur de la liste des alertes.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public WarningListBox(Core core) {
      super(core);
   }

   @Override
   protected void initComponents() {
      model = getCore().getAllAlerts();
      view = new JAlertList(model);
      model.addObserver(view);
   }

   @Override
   protected void initListeners() {
      // Aucun pour l'instant.
   }

   @Override
   public Component getGraphicalComponent() {
      return view;
   }
}
