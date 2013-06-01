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

   public AcCreateBudget(Core core) {
      super(core);
   }

   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      // Initialisation de la récurrence du budget.
      recurrence = core.createReccurence();      
      budget = core.createBudget();
      
      view = new JCreateBudgetFrame(core, budget);
      view.setTitle(Text.APP_TITLE.toString() + " - " + Text.BUDGET_CREATION_TITLE);
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);
      
      initListeners(core);
      
      budget.addObserver(view);
      
      // ATTENTION  : le réglage de la modalité doit être fait après la paramétrisation de la fenêtre !
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }
   
   public Budget getCreatedBudget() {
      return budget;
   }
   
   private void initListeners(Core core) {
      view.addValidateListener(new UserAction(core) {
         @Override
         protected void execute(Core core, ActionEvent event, Object[] dependencies) {
            Date[] result = TimeSlice.getFirstAndLastDay(view.getTimeSlice(), view.getDate());
            
            try {
               // Ici l'intervalle de récurrence est toujours à 0 car on ne fait pas de récurrence.
               // dans cette version-ci du logiciel.
               recurrence.setIntervalRecurrence(0);
               recurrence.setStartDate(result[0]);
               recurrence.setEndDate(result[1]);

               core.saveRecurrence(recurrence);
               budget.setRecurrence(recurrence);
               core.saveBudget(budget);
            }
            catch (InconsistencyDate e) {
               MidasLogs.errors.push(e.getMessage());
            }
            view.dispose();
         }
      });
      
      view.addCancelListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            view.dispose();
         }
      });
   }

}
