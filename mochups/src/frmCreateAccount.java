import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class frmCreateAccount extends javax.swing.JFrame {
	
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JButton btnvalidate;
	private JButton btnValidateAndAdd;
	private JTextField txtAccountName;
	private JTextField txtThreshold;
	private JTextPane txpAccountDescription;
	private JLabel lblAccountDescription;
	private JTextField txtAccountNumber;
	private JLabel lblAccountNumber;
	private JLabel lblthreshold;
	private JLabel lblAccountName;
	private JButton btnInit;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frmCreateAccount inst = new frmCreateAccount();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public frmCreateAccount() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GridBagLayout thisLayout = new GridBagLayout();
			thisLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1};
			thisLayout.rowHeights = new int[] {41, 43, 45, 79, 20};
			thisLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.1, 0.0};
			thisLayout.columnWidths = new int[] {7, 97, 104, 7, 7};
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				btnvalidate = new JButton();
				getContentPane().add(btnvalidate, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				btnvalidate.setText("Valider");
			}
			{
				btnInit = new JButton();
				getContentPane().add(btnInit, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				btnInit.setText("Initialiser");
			}
			{
				btnValidateAndAdd = new JButton();
				getContentPane().add(btnValidateAndAdd, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				btnValidateAndAdd.setText("Valider et ajouter un autre compte");
			}
			{
				lblAccountName = new JLabel();
				getContentPane().add(lblAccountName, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				lblAccountName.setText("Nom du compte");
			}
			{
				txtAccountName = new JTextField();
				getContentPane().add(txtAccountName, new GridBagConstraints(2, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				lblthreshold = new JLabel();
				getContentPane().add(lblthreshold, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				lblthreshold.setText("Seuil");
			}
			{
				txtThreshold = new JTextField();
				getContentPane().add(txtThreshold, new GridBagConstraints(2, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				txtThreshold.setText("0");
			}
			{
				lblAccountNumber = new JLabel();
				getContentPane().add(lblAccountNumber, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				lblAccountNumber.setText("Num�ro de compte");
			}
			{
				txtAccountNumber = new JTextField();
				getContentPane().add(txtAccountNumber, new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				lblAccountDescription = new JLabel();
				getContentPane().add(lblAccountDescription, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				lblAccountDescription.setText("Description");
			}
			{
				txpAccountDescription = new JTextPane();
				getContentPane().add(txpAccountDescription, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				txpAccountDescription.setText("Blablabla...");
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
