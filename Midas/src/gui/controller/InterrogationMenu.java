/* ============================================================================
 * Nom du fichier   : InterrogationMenu.java
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
import gui.menu.JInterrogationMenu;

import java.awt.Component;

import core.Core;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class InterrogationMenu extends Controller {
   
   JInterrogationMenu view;
   
   /**
    * @param core
    */
   public InterrogationMenu(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      view = new JInterrogationMenu();
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initListeners()
    */
   @Override
   protected void initListeners() {
      // TODO Auto-generated method stub

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
