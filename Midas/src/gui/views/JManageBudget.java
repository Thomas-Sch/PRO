/* ============================================================================
 * Nom du fichier   : JManageBudget.java
 * ============================================================================
 * Date de création : 1 juin 2013
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
import gui.component.infoedition.JBudgetIE;
import gui.controller.listbox.BudgetListBox;

import java.awt.BorderLayout;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import settings.Language.Text;
import core.Core;
import core.components.Budget;

/**
 * Fenêtre de gestion des budgets.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JManageBudget extends JManageFrame implements View {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 6474851721091887221L;
   
   private JLabel lblListDescription;
   
   private BudgetListBox budgets;

   private JBudgetIE bieInfos;
   
   /**
    * Contructeur.
    * @param controller Contrôleur de cet objet.
    */
   public JManageBudget(Core core) {  
      super(core);
   }
   
   /**
    * Initialise les composants graphiques.
    */
   protected void initContent() {
      super.initContent();
      lblListDescription = new JLabel(Text.BUDGET_LIST_LABEL.toString());
      budgets = new BudgetListBox(core);
      bieInfos = new JBudgetIE();
   }
   
   /**
    * Initialise les listeners internes au composant graphique.
    */
   protected void initListeners() {
      super.initListeners();
      budgets.addSelectionChangedListener(new ListSelectionListener() {
         
         @Override
         public void valueChanged(ListSelectionEvent e) {
            if(budgets.getSelectedValue() != null) {
               setEnabledItemDependantButtons(true);

               switch (state) {
                  case EDITION:
                     bieInfos = new JBudgetIE(JManageBudget.this, pnlInfosActions, bieInfos, budgets.getSelectedValue());
                     break;
                  case VIEW:
                     bieInfos = new JBudgetIE(JManageBudget.this, pnlInfosActions, bieInfos, budgets.getSelectedValue());
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
    * @return Le panel contenant les éléments graphiques.
    */
   protected JPanel buildContent() {
      JPanel pnlContent = new JPanel(new BorderLayout(5,5));
      
      pnlContent.add(lblListDescription, BorderLayout.NORTH);
  
      pnlContent.add(new JScrollPaneDefault(budgets.getGraphicalComponent()),BorderLayout.WEST);
      
      pnlContent.add(pnlInfosActions, BorderLayout.CENTER);
      pnlInfosActions.setLayout(new BorderLayout());
      
      pnlInfosActions.add(aedActions, BorderLayout.SOUTH);
      pnlInfosActions.add(bieInfos, BorderLayout.CENTER);
      return pnlContent;
   }
   

   /**
    * Récupère le compte seléctionné dans l'interface.
    * @return le compte seléctionné.
    */
   public Budget getSelectedValue() {
      return budgets.getSelectedValue();
   }
   
   /**
    * Force la mise à jour la liste des comptes.
    */
   public void updateModel() {
      budgets.updateModel();
      pack();
   }

   /* (non-Javadoc)
    * @see gui.JManageFrame#setEnabledOnEdition(boolean)
    */
   @Override
   protected void setEnabledOnEdition(boolean b) {
      bieInfos.setEditable(b);      
   }

   /* (non-Javadoc)
    * @see gui.JManageFrame#setEnabledOnView(boolean)
    */
   @Override
   protected void setEnabledOnView(boolean b) {
      budgets.getGraphicalComponent().setEnabled(b);
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable o, Object arg) {
      // Pas d'update pour l'instant. Voir rapport.  
   }
}
