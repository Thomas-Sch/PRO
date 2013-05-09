/* ============================================================================
 * Nom du fichier   : ManageAccount.java
 * ============================================================================
 * Date de création : 8 mai 2013
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
import gui.actions.AcAddAccount;
import gui.views.JManageAccount;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import core.Core;

/**
 * Contrôleur de la fenêtre de consultation et d'édition des comptes.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class ManageAccount extends Controller {

   private JManageAccount view;
   /**
    * @param core
    */
   public ManageAccount(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      view = new JManageAccount(this);
      view.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
     //view.setModalityType(ModalityType.APPLICATION_MODAL); // Empèches les envents de se lancer.
      //view.setModal(true);
      view.setVisible(true);
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initListeners()
    */
   @Override
   protected void initListeners() {
      view.addButtonAddListener(new AcAddAccount(getCore(), view, null));
      view.addButtonModifyListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            view.swapMode();
         }
      });
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#getGraphicalComponent()
    */
   @Override
   public Component getGraphicalComponent() {
      return view;
   }

}
