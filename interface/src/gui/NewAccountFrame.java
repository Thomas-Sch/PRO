/* ============================================================================
 * Nom du fichier   : NewAccountFrame.java
 * ============================================================================
 * Date de création : 18 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

/**
 * Fenêtre d'ajout de compte.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class NewAccountFrame extends JDialog {

   /**
    * Serial id
    */
   private static final long serialVersionUID = -2273955948172856823L;
   
   /**
    * Construit une nouvelle fenêtre pour ajouter un compte.
    */
   public NewAccountFrame(Component parent) {
      setLocationRelativeTo(parent);
      setVisible(true);
      GridBagLayout thisLayout = new GridBagLayout();
      thisLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1};
      thisLayout.rowHeights = new int[] {41, 43, 45, 79, 20};
      thisLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.1, 0.0};
      thisLayout.columnWidths = new int[] {7, 97, 104, 7, 7};
      getContentPane().setLayout(thisLayout);
      setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      {
         JButton btnvalidate = new JButton();
         getContentPane().add(btnvalidate, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
         btnvalidate.setText("Valider");
      }
      {
         JButton btnInit = new JButton();
         getContentPane().add(btnInit, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
         btnInit.setText("Initialiser");
      }
      {
         JLabel lblAccountName = new JLabel();
         getContentPane().add(lblAccountName, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
         lblAccountName.setText("Nom du compte");
      }
      {
         JTextField txtAccountName = new JTextField();
         getContentPane().add(txtAccountName, new GridBagConstraints(2, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
      }
      {
         JLabel lblthreshold = new JLabel();
         getContentPane().add(lblthreshold, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
         lblthreshold.setText("Seuil");
      }
      {
         JTextField txtThreshold = new JTextField();
         getContentPane().add(txtThreshold, new GridBagConstraints(2, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
         txtThreshold.setText("0");
      }
      {
         JLabel lblAccountNumber = new JLabel();
         getContentPane().add(lblAccountNumber, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
         lblAccountNumber.setText("Num�ro de compte");
      }
      {
         JTextField txtAccountNumber = new JTextField();
         getContentPane().add(txtAccountNumber, new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
      }
      {
         JLabel lblAccountDescription = new JLabel();
         getContentPane().add(lblAccountDescription, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
         lblAccountDescription.setText("Description");
      }
      {
         JTextPane txpAccountDescription = new JTextPane();
         getContentPane().add(txpAccountDescription, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
         txpAccountDescription.setText("Blablabla...");
      }
      pack();
      setSize(400, 300);
   }

}
