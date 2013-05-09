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
import gui.views.JManageAccount;

import java.awt.Component;
import java.awt.Dialog.ModalityType;

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
      // TODO Auto-generated constructor stub
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      view = new JManageAccount(this);
      view.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initListeners()
    */
   @Override
   protected void initListeners() {
      
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
