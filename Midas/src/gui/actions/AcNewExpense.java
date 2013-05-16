/* ============================================================================
 * Nom du fichier   : AcNewExpense.java
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

import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import settings.Language.Text;

import core.Core;
import gui.Controller;
import gui.UserAction;
import gui.views.JNewExpense;

/**
 * Contrôleur et action de l'ajout d'une dépense.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcNewExpense extends UserAction {
   
   private Controller controller;
   private JNewExpense view;
   

   /**
    * @param core
    * @param dependencies
    */
   public AcNewExpense(Core core, Controller controller, Object[] dependencies) {
      super(core, dependencies);
      this.controller = controller;
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      view = new JNewExpense(controller);
      view.setLocationRelativeTo((Component)event.getSource());
      
      view.addValidateListener(new UserAction(core) {
         @Override
         protected void execute(Core core, ActionEvent event, Object[] dependencies) {
            view.dispose();
         }
      });
      
      view.addCancelListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent arg0) {
            view.dispose();
         }
      });
      
      view.setTitle(Text.APP_TITLE.toString() + " - " + Text.EXPENSE_CREATION_TITLE.toString());
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }

}
