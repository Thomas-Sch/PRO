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
import gui.actions.AcCreateAccount;
import gui.views.JManageAccount;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import settings.Language.Text;
import core.Core;
import database.utils.DatabaseConstraintViolation;
import database.utils.DatabaseException;

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
   private Component parent;
   
   /**
    * Constructeur principale de la classe
    * @param parent Composant qui appelle ce contrôleur.
    * @param core Coeur de l'application.
    */
   public ManageAccount(Component parent, Core core) {
      super(core);
      this.parent = parent; 
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      view = new JManageAccount(this);
      view.setTitle(Text.APP_TITLE.toString() + " - " + Text.ACCOUNT_MANAGEMENT_TITLE);
      view.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      view.setLocationRelativeTo(parent);
      view.setVisible(true);
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initListeners()
    */
   @Override
   protected void initListeners() {
      view.addButtonAddListener(new AcCreateAccount(getCore()));
      view.addButtonModifyListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            if(view.isModifyingAccount()) {
               getCore().saveAccount(view.getSelectedAccount());
            }
            view.swapMode();
         }
      });
      
      view.addButtonDeleteListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               getCore().deleteAccount(view.getSelectedAccount());
            }
            catch (DatabaseException e1) {
               e1.printStackTrace();
            }
            catch (DatabaseConstraintViolation e1) {
               e1.printStackTrace();
            }
            view.updateModel();
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
