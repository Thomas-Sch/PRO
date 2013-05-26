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

import gui.Controller;
import gui.actions.AcCreateBudget;
import gui.actions.AcCreateOnTheFlyBudget;
import gui.actions.AcManageAccount;
import gui.actions.AcManageUser;
import gui.actions.AcManageCategory;
import gui.actions.AcNewExpense;
import gui.actions.AcNewTransaction;
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
      view.addManageAuthorListener(new AcManageUser(getCore(),this, null));
      view.addManageCategoryListener(new AcManageCategory(getCore()));
      view.addManageAccountListener(new AcManageAccount(getCore()));
      view.addManageBudgetListener(new AcCreateBudget(getCore(), this));
      view.addCreateOnTheFlyBudgetListener(new AcCreateOnTheFlyBudget(getCore(), this));
      view.addNewExpenseListener(new AcNewExpense(getCore(), this, null));
      view.addNewTransactionListener(new AcNewTransaction(getCore(), this, null));
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#getGraphicalComponent()
    */
   @Override
   public Component getGraphicalComponent() {
      return view;
   }
}
