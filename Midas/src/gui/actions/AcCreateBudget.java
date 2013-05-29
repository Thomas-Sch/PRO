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
import java.util.Date;

import settings.Language.Text;
import utils.TimeSlice;
import core.Core;
import core.MidasLogs;
import core.components.Budget;
import core.components.Recurrence;
import core.exceptions.InconsistencyDate;

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
   protected void execute(final Core core, ActionEvent event, Object[] dependencies) {
      
      // Initialisation de la récurrence du budget.
      recurrence = core.createReccurence();
      core.saveRecurrence(recurrence);
      
      budget = core.createBudget();
      
      view = new JCreateBudgetFrame(controller, budget);
      view.setTitle(Text.APP_TITLE.toString() + " - " + Text.BUDGET_CREATION_TITLE);
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);
      
      view.addValidateListener(new UserAction(core) {
         @Override
         protected void execute(Core core, ActionEvent event, Object[] dependencies) {
            Date[] result = TimeSlice.getFirstAndLastDay(view.getTimeSlice(), view.getDate());
            
            System.out.println(result[0] + "\n" + result[1]);
            
            try {
               recurrence.setEndtDate(result[1]);
               recurrence.setStartDate(result[0]);
            }
            catch (InconsistencyDate e) {
               MidasLogs.errors.push(e.getMessage());
            }
            // Ici l'intervalle de récurrence est toujours à 0 car on ne fait pas de récurrence.
            // dans cette version-ci du logiciel.
            recurrence.setIntervalRecurrence(0);
            
            budget.setRecurrence(recurrence);
            core.saveBudget(budget);
            view.dispose();
         }
      });
      
      view.addCancelListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // Pas besoin de garder cette récurrence.
            core.deleteRecurrence(recurrence); 
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
