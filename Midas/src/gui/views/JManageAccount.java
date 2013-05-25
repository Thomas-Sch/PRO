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
import gui.JManageFrame;
import gui.component.infoedition.JAccountIE;
import gui.controller.AccountListBox;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import settings.Language.Text;
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
public class JManageAccount extends JManageFrame {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 6474851721091887221L;
   
   private JLabel lblListDescription;
   
   private AccountListBox accounts;

   private JAccountIE aieInfos;
   
   /**
    * Contructeur.
    * @param controller Contrôleur de cet objet.
    */
   public JManageAccount(Controller controller) {  
      super(controller);
   }
   
   /**
    * Initialise les composants graphiques.
    */
   protected void initContent() {
      super.initContent();
      lblListDescription = new JLabel(Text.ACCOUNT_LIST_LABEL.toString());
      accounts = new AccountListBox(controller.getCore());
      aieInfos = new JAccountIE();
   }
   
   /**
    * Initialise les listeners internes au composant graphique.
    */
   protected void initListeners() {
      super.initListeners();
      accounts.addSelectionChangedListener(new ListSelectionListener() {
         
         @Override
         public void valueChanged(ListSelectionEvent e) {
            if(accounts.getSelectedAccount() != null) {
               setEnabledAccountDependantButtons(true);

               switch (state) {
                  case EDITION:
                     aieInfos = new JAccountIE(JManageAccount.this, pnlInfosActions, aieInfos, accounts.getSelectedAccount());
                     break;
                  case VIEW:
                     aieInfos = new JAccountIE(JManageAccount.this, pnlInfosActions, aieInfos, accounts.getSelectedAccount());
                     break;
               }
            }
            else {
               setEnabledAccountDependantButtons(false);
            }
         }
      });
   }
   
   /**
    * Construction des éléments de la vue.
    * @return Le panel contenant les éléments graphiques.
    */
   protected JPanel buildContent() {
      JPanel pnlContent = new JPanel(new BorderLayout(5,5));
      
      pnlContent.add(lblListDescription, BorderLayout.NORTH);
      pnlContent.add(accounts.getGraphicalComponent(),BorderLayout.WEST);
      
      pnlContent.add(pnlInfosActions, BorderLayout.CENTER);
      pnlInfosActions.setLayout(new BorderLayout());
      
      pnlInfosActions.add(aedActions, BorderLayout.SOUTH);
      pnlInfosActions.add(aieInfos, BorderLayout.CENTER);
      return pnlContent;
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

   /* (non-Javadoc)
    * @see gui.JManageFrame#setEnabledOnEdition(boolean)
    */
   @Override
   protected void setEnabledOnEdition(boolean b) {
      aieInfos.setEditable(b);      
   }

   /* (non-Javadoc)
    * @see gui.JManageFrame#setEnabledOnView(boolean)
    */
   @Override
   protected void setEnabledOnView(boolean b) {
      accounts.getGraphicalComponent().setEnabled(b);
   }
}
