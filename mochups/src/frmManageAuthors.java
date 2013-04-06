import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class frmManageAuthors extends javax.swing.JFrame {
	
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JList lstAuthors;
	private JButton btnAdd;
	private JButton btnRename;
	private JButton btnDelete;
	private JLabel lblAuthors;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frmManageAuthors inst = new frmManageAuthors();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public frmManageAuthors() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GridBagLayout thisLayout = new GridBagLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			thisLayout.rowWeights = new double[] {0.0, 0.0, 0.1, 0.1, 0.1, 0.0};
			thisLayout.rowHeights = new int[] {7, 34, 7, 7, 7, 7};
			thisLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.0};
			thisLayout.columnWidths = new int[] {7, 5, 29, 7, 42, 7, 45, 7, 7};
			getContentPane().setLayout(thisLayout);
			{
				ListModel lstAuthorsModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
				lstAuthors = new JList();
				getContentPane().add(lstAuthors, new GridBagConstraints(2, 2, 6, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				lstAuthors.setModel(lstAuthorsModel);
			}
			{
				lblAuthors = new JLabel();
				getContentPane().add(lblAuthors, new GridBagConstraints(2, 1, 4, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				lblAuthors.setText("Liste des auteurs");
			}
			{
				btnAdd = new JButton();
				getContentPane().add(btnAdd, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				btnAdd.setText("+");
			}
			{
				btnDelete = new JButton();
				getContentPane().add(btnDelete, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				btnDelete.setText("-");
			}
			{
				btnRename = new JButton();
				getContentPane().add(btnRename, new GridBagConstraints(6, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				btnRename.setText("*");
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
