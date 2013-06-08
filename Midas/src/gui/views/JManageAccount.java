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

import gui.JManageFrame;
import gui.View;
import gui.component.JScrollPaneDefault;
import gui.component.infoedition.JAccountIE;
import gui.controller.listbox.AccountListBox;

import java.awt.BorderLayout;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import settings.Language.Text;
import core.Core;
import core.components.Account;

/**
 * Fenêtre de gestion de comptes.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JManageAccount extends JManageFrame implements View {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 6474851721091887221L;

   private JLabel lblListDescription;

   private AccountListBox accounts;

   private JAccountIE aieInfos;

   /**
    * Crée la fenêtre de gestion des comptes.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public JManageAccount(Core core) {
      super(core);
   }

   /**
    * Initialise les composants graphiques.
    */
   protected void initContent() {
      super.initContent();
      lblListDescription = new JLabel(Text.ACCOUNT_LIST_LABEL.toString());
      accounts = new AccountListBox(core);
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
            if (accounts.getSelectedValue() != null) {
               setEnabledItemDependantButtons(true);

               switch (state) {
                  case EDITION:
                     aieInfos = new JAccountIE(JManageAccount.this,
                           pnlInfosActions, aieInfos, accounts
                                 .getSelectedValue());
                     break;
                  case VIEW:
                     aieInfos = new JAccountIE(JManageAccount.this,
                           pnlInfosActions, aieInfos, accounts
                                 .getSelectedValue());
                     break;
               }
            }
            else {
               setEnabledItemDependantButtons(false);
            }
         }
      });
   }

   /**
    * Construction des éléments de la vue.
    * 
    * @return Le panneau contenant les éléments graphiques.
    */
   protected JPanel buildContent() {
      JPanel pnlContent = new JPanel(new BorderLayout(5, 5));

      pnlContent.add(lblListDescription, BorderLayout.NORTH);
      pnlContent.add(new JScrollPaneDefault(accounts.getGraphicalComponent()),
            BorderLayout.WEST);

      pnlContent.add(pnlInfosActions, BorderLayout.CENTER);
      pnlInfosActions.setLayout(new BorderLayout());

      pnlInfosActions.add(aedActions, BorderLayout.SOUTH);
      pnlInfosActions.add(aieInfos, BorderLayout.CENTER);
      return pnlContent;
   }

   /**
    * Récupère le compte sélectionné dans l'interface.
    * 
    * @return Le compte sélectionné.
    */
   public Account getSelectedValue() {
      return accounts.getSelectedValue();
   }

   /**
    * Force la mise à jour de la liste des comptes.
    */
   public void updateModel() {
      accounts.updateModel();
      pack();
   }

   @Override
   protected void setEnabledOnEdition(boolean b) {
      aieInfos.setEditable(b);
   }

   @Override
   protected void setEnabledOnView(boolean b) {
      accounts.getGraphicalComponent().setEnabled(b);
   }

   @Override
   public void update(Observable o, Object arg) {
      // Pas d'update pour l'instant. Voir rapport.
   }
}
