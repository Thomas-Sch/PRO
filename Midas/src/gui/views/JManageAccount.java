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
import gui.frameContent.JAccountList;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
   
   private JLabel lblDescription;
   
   private JAccountList altAccount;
   private JInfoAccount ifaAccount;
   private JAddEditDelete aedActions;
   
   /**
    * Contructeur.
    * @param controller Contrôleur de cet objet.
    */
   public JManageAccount(Controller controller) {      
      setContentPane(buildContent());
      pack();
   }
   
   /**
    * Construction des éléments de la vue.
    * @return Le panel contenant les éléments graphiques.
    */
   private JPanel buildContent() {
      JPanel pnlContent = new JPanel(new GridBagLayout());
      
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.fill = GridBagConstraints.BOTH;
      constraints.anchor = GridBagConstraints.CENTER;
      
      constraints.weightx = 0.5;
      constraints.insets = new Insets(5, 5, 5, 5);
      
      
     
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.gridwidth = 2;
      constraints.weighty = 0.1;
      lblDescription = new JLabel("Liste des comptes");
      pnlContent.add(lblDescription, constraints);
      
      constraints.gridy = 1;
      constraints.gridwidth = 1;
      constraints.gridheight = 2;
      constraints.weighty = 0.5;
      constraints.weightx = 0.7;
      altAccount = new JAccountList();
      pnlContent.add(altAccount,constraints);
      
      constraints.gridheight = 1;
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.gridx = 1;
      constraints.weightx = 0.4;
      
      ifaAccount = new JInfoAccount();
      pnlContent.add(ifaAccount, constraints);
      
      constraints.gridy = 2;
      aedActions = new JAddEditDelete();
      pnlContent.add(aedActions, constraints);
      return pnlContent;
   }
}
