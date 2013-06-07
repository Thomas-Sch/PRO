/* ============================================================================
 * Nom du fichier   : AcCreateOnTheFlyBudget.java
 * ============================================================================
 * Date de création : 10 mai 2013
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
import gui.alert.BadDate;
import gui.alert.InconsistencyDate;
import gui.exception.BadDateException;
import gui.utils.Positions;
import gui.utils.Positions.ScreenPosition;
import gui.views.JCreateOnTheFlyBudget;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import settings.Language.Text;
import core.Core;
import core.components.BudgetOnTheFly;
import core.exceptions.InconsistencyDateException;

/**
 * Action de création d'un budget à la volée.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcCreateOnTheFlyBudget extends UserAction {

   private BudgetOnTheFly budget;
   private JCreateOnTheFlyBudget view;
   private Controller controller;
   
   /**
    * @param core Objet core qui va être utilisé pour faires des appels à la
    *             BDD.
    * @param controller Contrôleur ayant appelé cette action.
    */
   public AcCreateOnTheFlyBudget(Core core, Controller controller) {
      super(core);
      this.controller = controller;
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(final Core core, ActionEvent event, Object[] dependencies) {     
      budget = core.createBudgetOnTheFly();
      
      view = new JCreateOnTheFlyBudget(controller, budget);
      view.setTitle(Text.APP_TITLE.toString() + " - " + Text.BUDGET_FLY_CREATION_TITLE);
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);   
      
      initListeners(core);
      
      budget.addObserver(view);
      
      // ATTENTION  : le réglage de la modalité doit être fait après la paramétrisation de la fenêtre !
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }
   
   /**
    * Initialise les écouteurs de l'action.
    * @param core Permet de sauvegarder l'objet créer.
    */
   public void initListeners(Core core) {
      view.addValidateListener(new UserAction(core) {
         @Override
         protected void execute(Core core, ActionEvent event, Object[] dependencies) {            
            try {
               budget.setStartDate(view.getStartDate());
               budget.setEndDate(view.getEndDate());
               core.saveBudgetOnTheFly(budget);
               view.dispose();
            }
            catch (InconsistencyDateException e) {
               new InconsistencyDate(e);
            } 
            catch (BadDateException e) {
               new BadDate(e);
            }
         }
      });
      
      view.addCancelListener(new ActionListener() {  
         @Override
         public void actionPerformed(ActionEvent e) {
            view.dispose();
         }
      });
   }
   
   /**
    * Récupère le budget à la volée produit par cette action.
    * @return Le budget crée.
    */
   public BudgetOnTheFly getCreatedBudget() {
      return budget;
   }

}
