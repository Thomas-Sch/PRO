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
import gui.views.JAddBudgetFrame;

import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;

import core.Core;
import core.components.Budget;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcCreateBudget extends UserAction {
   
   private Budget budget;
   private JAddBudgetFrame view;
   
   private Controller controller;

   public AcCreateBudget(Controller controller, Core core) {
      super(core);
      this.controller = controller;
   }

   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      
      budget = core.createBudget();
      
      view = new JAddBudgetFrame((Component)event.getSource(), controller, budget);
      
//      view.addValidateListener(new UserAction(core) {
//         @Override
//         protected void execute(Core core, ActionEvent event, Object[] dependencies) {
//            core.saveUser(user);
//            view.dispose();
//         }
//      });
//      view.addCancelListener(new ActionListener() {
//         
//         @Override
//         public void actionPerformed(ActionEvent arg0) {
//            view.dispose();
//         }
//      });
      
      budget.addObserver(view);
      
      // ATTENTION  : le réglage de la modalité doit être fait après la paramétrisation de la fenêtre !
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }
   
   public Budget getCreatedBudget() {
      return budget;
   }

}
