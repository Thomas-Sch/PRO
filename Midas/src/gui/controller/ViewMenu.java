/* ============================================================================
 * Nom du fichier   : ViewMenu.java
 * ============================================================================
 * Date de création : 4 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.controller;

import gui.Controller;
import gui.menu.JViewMenu;

import java.awt.Component;

import core.Core;

/**
 * Contrôleur du menu d'édition.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class ViewMenu extends Controller {
   
   JViewMenu view;

   /**
    * @param core
    */
   public ViewMenu(Core core) {
      super(core);
      // TODO Auto-generated constructor stub
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      view = new JViewMenu();
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initListeners()
    */
   @Override
   protected void initListeners() {
      // Aucun pour l'instant.

   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#getGraphicalComponent()
    */
   @Override
   public Component getGraphicalComponent() {
      // TODO Auto-generated method stub
      return view;
   }

}
