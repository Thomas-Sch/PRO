/* ============================================================================
 * Nom du fichier   : EditMenu.java
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

import gui.actions.AcManageAccount;
import gui.actions.AcManageAuthor;
import gui.actions.AcManageCategory;
import gui.menu.JEditMenu;

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
public class EditMenu extends Controller {
   JEditMenu view;

   /**
    * @param core
    */
   public EditMenu(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      view = new JEditMenu();

   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initListeners()
    */
   @Override
   protected void initListeners() {
      view.addManageAuthorListener(new AcManageAuthor(getCore(), null));
      view.addManageCategoryListener(new AcManageCategory(getCore(), null));
      view.addManageAccountListener(new AcManageAccount(getCore()));
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#getGraphicalComponent()
    */
   @Override
   public Component getGraphicalComponent() {
      return view;
   }

}
