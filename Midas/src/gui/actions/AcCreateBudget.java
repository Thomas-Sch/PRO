/* ============================================================================
 * Nom du fichier   : AcCreateBudget.java
 * ============================================================================
 * Date de création : 9 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.actions;

import gui.Controller;
import gui.UserAction;
import gui.utils.Positions;
import gui.utils.Positions.ScreenPosition;
import gui.views.JCreateBudgetFrame;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import settings.Language.Text;
import core.Core;
import core.components.Budget;
import core.components.Recurrence;
import database.dbComponents.DBRecurrence;

/**
 * Contrôleur et action d'ajout d'un budget.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcCreateBudget extends UserAction {
   
   private Budget budget;
   private Recurrence recurrence;
   private JCreateBudgetFrame view;
   
   private Controller controller;

   public AcCreateBudget(Core core, Controller controller) {
      super(core);
      this.controller = controller;
   }

   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      
      recurrence = core.createReccurence();
      System.out.println(recurrence.getDBRecurrence());
      budget = core.createBudget();
      
      view = new JCreateBudgetFrame(controller, budget, recurrence);
      view.setTitle(Text.APP_TITLE.toString() + " - " + Text.BUDGET_CREATION_TITLE);
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);
      
      view.addValidateListener(new UserAction(core) {
         @Override
         protected void execute(Core core, ActionEvent event, Object[] dependencies) {
            budget.setRecurrence(new Recurrence(controller.getCore(), new DBRecurrence()));
            core.saveBudget(budget);
            view.dispose();
         }
      });
      
      view.addCancelListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            view.dispose();
         }
      });
      
      budget.addObserver(view);
      
      // ATTENTION  : le réglage de la modalité doit être fait après la paramétrisation de la fenêtre !
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }
   
   public Budget getCreatedBudget() {
      return budget;
   }

}
