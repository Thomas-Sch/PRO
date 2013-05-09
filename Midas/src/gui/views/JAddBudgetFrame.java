/* ============================================================================
 * Nom du fichier   : JAddBudgetFrame.java
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
package gui.views;

import gui.Controller;
import gui.View;
import gui.component.JLabelMoneyPanel;
import gui.component.JLabelTextPanel;
import gui.controller.ComboBoxAccount;
import gui.utils.StandardInsets;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;

import javax.swing.JDialog;
import javax.swing.JPanel;

import settings.Language.Text;

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
public class JAddBudgetFrame extends JDialog implements View{

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -2619002208500615656L;
   
   private JLabelTextPanel ltpName;
   private JLabelMoneyPanel ltpAmount;
   
   private ComboBoxAccount accounts;
   
   private Controller controller;
   
   public JAddBudgetFrame(Component parent, Controller controller, Budget budget) {
      this.controller = controller;
      
      setTitle(Text.APP_TITLE.toString());
      setContentPane(buildContent());
      setLocationRelativeTo(parent);
      setResizable(false);
      pack();
      update(null, null);
   }
   
   private JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      pnlContent.setLayout(new GridBagLayout());
      
      initComponents();
      
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.anchor = GridBagConstraints.WEST;
      
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.weightx = 0.5;
      constraints.weighty = 0.5;
      constraints.insets = new StandardInsets();
      pnlContent.add(ltpName, constraints);
      
      constraints.gridy = 1;
      pnlContent.add(ltpAmount, constraints);
      
      constraints.gridy = 2;
      pnlContent.add(accounts.getGraphicalComponent(), constraints);
     
      return pnlContent;
   }
   
   private void initComponents() {
      ltpName = new JLabelTextPanel("Nom du budget");
      ltpAmount = new JLabelMoneyPanel("Somme");
      accounts = new ComboBoxAccount(controller.getCore());
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      // TODO Auto-generated method stub
      
   }
   
   

}
