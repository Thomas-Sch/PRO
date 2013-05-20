/* ============================================================================
 * Nom du fichier   : JManageAccount.java
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
package gui.views;

import gui.Controller;
import gui.component.JAddEditDelete;
import gui.controller.AccountListBox;
import gui.frameContent.JEditionAccount;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import core.components.Account;

/**
 * Fenêtre de gestion de comptes.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JManageAccount extends JDialog {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 6474851721091887221L;
   
   // Etat de l'interface (contrôlé internement).
   private enum State { EDITION, VIEW };
   private State state;
   
   private Controller controller;
   
   private JLabel lblDescription;
   
   private AccountListBox accounts;
   private JInfoAccount ifaAccount;
   private JEditionAccount edaAccount;
   private JAddEditDelete aedActions;
   
   private JPanel pnlInfosActions;
   
   /**
    * Contructeur.
    * @param controller Contrôleur de cet objet.
    */
   public JManageAccount(Controller controller) {  
      this.controller = controller;
      state = State.VIEW;
      initContent();
      initListeners();
      setContentPane(buildContent());
      pack();
   }
   
   /**
    * Initialise les composants graphiques.
    */
   public void initContent() {
      lblDescription = new JLabel("Liste des comptes");
      accounts = new AccountListBox(controller.getCore());
      ifaAccount = new JInfoAccount();
      edaAccount = new JEditionAccount();
      aedActions = new JAddEditDelete();
      
      // On désactive les boutons qui utilise un compte car aucun n'est
      // séléctionné de base lorsque l'on lance l'interface.
      setEnabledAccountDependantButtons(false);
      pnlInfosActions = new JPanel();
   }
   
   /**
    * Active ou désactive les boutons qui dépendent d'un compte cible.
    * @param b Nouvel état d'activation des bouttons.
    */
   private void setEnabledAccountDependantButtons(boolean b) {
      aedActions.setButtonDeleteEnabled(b);
      aedActions.setButtonModifyEnabled(b);
   }
   
   /**
    * Initialise les listeners internes au composant graphique.
    */
   public void initListeners() {
      accounts.addSelectionChangedListener(new ListSelectionListener() {
         
         @Override
         public void valueChanged(ListSelectionEvent e) {
            if(accounts.getSelectedAccount() != null) {
               setEnabledAccountDependantButtons(true);

               updateFields(accounts.getSelectedAccount());
            }
            else {
               setEnabledAccountDependantButtons(false);
               edaAccount.setVisible(false);
               ifaAccount.setVisible(false);
            }
         }
      });
   }
   
   /**
    * Construction des éléments de la vue.
    * @return Le panel contenant les éléments graphiques.
    */
   private JPanel buildContent() {
      JPanel pnlContent = new JPanel(new BorderLayout(10,10));
      pnlContent.add(lblDescription, BorderLayout.NORTH);
      
      pnlContent.add(accounts.getGraphicalComponent(),BorderLayout.WEST);
      
      
      pnlContent.add(pnlInfosActions, BorderLayout.CENTER);
      pnlInfosActions.setLayout(new BorderLayout());
      
      pnlInfosActions.add(ifaAccount, BorderLayout.CENTER);
      pnlInfosActions.add(aedActions, BorderLayout.SOUTH);
      return pnlContent;
   }
   
   /**
    * Ajout de l'action à effectuer lors du clique sur le bouton d'ajout.
    * @param listener Action à effectuer.
    */
   public void addButtonAddListener(ActionListener listener) {
      aedActions.addAddActionListener(listener);
   }
   
   /**
    * Ajout de l'action à effectuer lors du clique sur le bouton de 
    * modification.
    * @param listener Action à effectuer.
    */
   public void addButtonModifyListener(ActionListener listener) {
      aedActions.addModifyActionListener(listener);
   }
   
   /**
    * Ajout de l'action à effectuer lors du clique sur le bouton de suppression
    * @param listener Action à effectuer.
    */
   public void addButtonDeleteListener(ActionListener listener) {
      aedActions.addDeleteActionListener(listener);
   }
   

   /**
    * Change l'état de l'interface et s'occupe de faire les changements
    * graphiques nécéssaires.
    */
   public void swapMode() {
      
      switch (state) {
         case VIEW:
            state = State.EDITION;
            pnlInfosActions.remove(ifaAccount);
            pnlInfosActions.add(edaAccount, BorderLayout.CENTER);
            break;
            
         case EDITION:
            state = State.VIEW;
            pnlInfosActions.remove(edaAccount);
            pnlInfosActions.add(ifaAccount, BorderLayout.CENTER);
            break;
      }
      pack();
   }
   
   /**
    * Récupère le compte seléctionné dans l'interface.
    * @return le compte seléctionné.
    */
   public Account getSelectedAccount() {
      return accounts.getSelectedAccount();
   }
   
   /**
    * Force la mise à jour la liste des comptes.
    */
   public void updateModel() {
      accounts.updateModel();
      pack();
   }
   
   /**
    * Met à jour les champs que peut voir l'utlisateur en fonction du compte
    * qu'il sélectionne.
    * @param account Compte dont on veut afficher ou éditer les informations.
    */
   public void updateFields(Account account) {
      ifaAccount.updateFields(account);
      edaAccount.updateFields(account);
   }
   
   /**
    * Renvoie true si l'interface est en mode d'édition de données.
    * @return true si l'interface est en mode édition.
    */
   public boolean isModifyingAccount() {
      return state == State.EDITION;
   }
}
