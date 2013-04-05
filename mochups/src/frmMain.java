import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;

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
public class frmMain extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private JMenuItem mniInterrogationHelp;
	private JMenu mnuInterrogation;
	private JMenuItem mniEditBudgetDelete;
	private JMenuItem mniEditBudgetConsult;
	private JMenuItem mniEditBudgetAdd;
	private JMenuItem mniEditAccountDelete;
	private JMenuItem mniEditAccountConsult;
	private JMenuItem mniEditAccountAdd;
	private JMenuItem mniShowListInterval;
	private JComboBox cmbSubCategory;
	private JLabel lblTransaction;
	private JButton jButton1;
	private JLabel jLabel4;
	private JTextField jTextField3;
	private JLabel jLabel1;
	private JTextField jTextField1;
	private JComboBox cmbTransactionMode;
	private JComboBox cmbAccount;
	private JComboBox cmbBudget;
	private JSeparator jSeparator1;
	private JSeparator sepNorthMiddle;
	private JButton btnBudgetAccept;
	private JTextField txtReason;
	private JLabel lblReason;
	private JComboBox cmbCategory;
	private JTextField txtDate;
	private JLabel lblDate;
	private JTextField txtAmount;
	private JLabel lblAmount;
	private JLabel lblAddExpense;
	private JLabel lblLastFive;
	private JLabel lblWarning;
	private JPanel pnlLastFive;
	private JPanel pnlWarnings;
	private JMenuItem mniShowListLast20;
	private JMenu mnuShowList;
	private JMenu mnuShowGraphic;
	private JMenuItem mniEditDoTransaction;
	private JMenuItem mniEditDoExpense;
	private JSeparator sepEditTwo;
	private JMenuItem mniEditManageAuthor;
	private JMenuItem mniEditManageCategory;
	private JSeparator sepEditOne;
	private JMenuItem mniEditOnTheFlyBudget;
	private JMenu mnuEditBudget;
	private JMenu mnuEditAccount;
	private JMenuItem mniInterrogationAbout;
	private JMenu mnuShow;
	private JMenu mnuEdit;
	private JMenuItem mniFileQuit;
	private JMenu mnuFile;
	private JMenuBar mnbMain;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frmMain inst = new frmMain();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public frmMain() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			{
				pnlWarnings = new JPanel();
				getContentPane().add(pnlWarnings);
				pnlWarnings.setBounds(10, 48, 266, 125);
				pnlWarnings.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				pnlLastFive = new JPanel();
				getContentPane().add(pnlLastFive);
				pnlLastFive.setBounds(319, 47, 241, 125);
				pnlLastFive.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				lblWarning = new JLabel();
				getContentPane().add(lblWarning);
				lblWarning.setText("Alertes");
				lblWarning.setBounds(10, 27, 34, 14);
			}
			{
				lblLastFive = new JLabel();
				getContentPane().add(lblLastFive);
				lblLastFive.setText("Dernières transactions");
				lblLastFive.setBounds(319, 27, 108, 14);
			}
			{
				lblAddExpense = new JLabel();
				getContentPane().add(lblAddExpense);
				lblAddExpense.setText("Ajouter une dépense");
				lblAddExpense.setBounds(10, 202, 101, 14);
			}
			{
				ComboBoxModel cmbBudgetModel = 
						new DefaultComboBoxModel(
								new String[] { "Budget", "Maison", "Tourisme", "Cadeaux", "Nouveau budget..." });
				cmbBudget = new JComboBox();
				getContentPane().add(getCmbBudget());
				cmbBudget.setModel(cmbBudgetModel);
				cmbBudget.setBounds(10, 227, 90, 20);
			}
			{
				lblAmount = new JLabel();
				getContentPane().add(lblAmount);
				lblAmount.setText("Montant:");
				lblAmount.setBounds(119, 230, 44, 14);
			}
			{
				txtAmount = new JTextField();
				getContentPane().add(txtAmount);
				txtAmount.setBounds(173, 227, 78, 20);
			}
			{
				lblDate = new JLabel();
				getContentPane().add(lblDate);
				lblDate.setText("Date:");
				lblDate.setBounds(263, 230, 27, 14);
			}
			{
				txtDate = new JTextField();
				getContentPane().add(txtDate);
				txtDate.setBounds(300, 227, 63, 20);
			}
			{
				ComboBoxModel cmbCategoryModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
				cmbCategory = new JComboBox();
				getContentPane().add(cmbCategory);
				cmbCategory.setModel(cmbCategoryModel);
				cmbCategory.setBounds(377, 227, 92, 20);
			}
			{
				ComboBoxModel cmbSubCategoryModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
				cmbSubCategory = new JComboBox();
				getContentPane().add(cmbSubCategory);
				cmbSubCategory.setModel(cmbSubCategoryModel);
				cmbSubCategory.setBounds(479, 227, 81, 20);
			}
			{
				lblReason = new JLabel();
				getContentPane().add(lblReason);
				lblReason.setText("Motif:");
				lblReason.setBounds(10, 256, 28, 14);
			}
			{
				txtReason = new JTextField();
				getContentPane().add(txtReason);
				txtReason.setText("Saisissez le motif de la dépense...");
				txtReason.setBounds(48, 258, 315, 66);
			}
			{
				btnBudgetAccept = new JButton();
				getContentPane().add(btnBudgetAccept);
				btnBudgetAccept.setText("Valider");
				btnBudgetAccept.setBounds(443, 280, 65, 23);
			}
			{
				sepNorthMiddle = new JSeparator();
				getContentPane().add(sepNorthMiddle);
				sepNorthMiddle.setBounds(10, 186, 550, 10);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(10, 333, 550, 11);
			}
			{
				lblTransaction = new JLabel();
				getContentPane().add(lblTransaction);
				lblTransaction.setText("Ajouter une transaction");
				lblTransaction.setBounds(10, 345, 121, 14);
			}
			{
				ComboBoxModel cmbAccountModel = 
						new DefaultComboBoxModel(
								new String[] { "Compte","Poste Courant", "Epargne", "Ajouter un nouveau compte..." });
				cmbAccount = new JComboBox();
				getContentPane().add(cmbAccount);
				cmbAccount.setModel(cmbAccountModel);
				cmbAccount.setBounds(10, 365, 90, 20);
			}
			{
				ComboBoxModel cmbTransactionModeModel = 
						new DefaultComboBoxModel(
								new String[] { "Débit", "Crédit" });
				cmbTransactionMode = new JComboBox();
				getContentPane().add(cmbTransactionMode);
				cmbTransactionMode.setModel(cmbTransactionModeModel);
				cmbTransactionMode.setBounds(119, 365, 77, 20);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(268, 365, 78, 20);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Montant:");
				jLabel1.setBounds(214, 368, 44, 14);
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				jTextField3.setText("Saisissez le motif de la dépense...");
				jTextField3.setBounds(48, 406, 315, 66);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Motif:");
				jLabel4.setBounds(10, 406, 28, 14);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Valider");
				jButton1.setBounds(443, 406, 65, 23);
			}
			{
				mnbMain = new JMenuBar();
				setJMenuBar(mnbMain);
				{
					mnuFile = new JMenu();
					mnbMain.add(mnuFile);
					mnuFile.setText("Fichier");
					{
						mniFileQuit = new JMenuItem();
						mnuFile.add(mniFileQuit);
						mniFileQuit.setText("Quitter");
					}
				}
				{
					mnuEdit = new JMenu();
					mnbMain.add(mnuEdit);
					mnuEdit.setText("Edition");
					{
						mnuEditAccount = new JMenu();
						mnuEdit.add(mnuEditAccount);
						mnuEditAccount.setText("Comptes");
						{
							mniEditAccountAdd = new JMenuItem();
							mnuEditAccount.add(mniEditAccountAdd);
							mniEditAccountAdd.setText("Ajouter...");
						}
						{
							mniEditAccountConsult = new JMenuItem();
							mnuEditAccount.add(mniEditAccountConsult);
							mniEditAccountConsult.setText("Consulter...");
						}
						{
							mniEditAccountDelete = new JMenuItem();
							mnuEditAccount.add(mniEditAccountDelete);
							mniEditAccountDelete.setText("Supprimer...");
						}
					}
					{
						mnuEditBudget = new JMenu();
						mnuEdit.add(mnuEditBudget);
						mnuEditBudget.setText("Budgets");
						{
							mniEditBudgetAdd = new JMenuItem();
							mnuEditBudget.add(mniEditBudgetAdd);
							mniEditBudgetAdd.setText("Ajouter...");
						}
						{
							mniEditBudgetConsult = new JMenuItem();
							mnuEditBudget.add(mniEditBudgetConsult);
							mniEditBudgetConsult.setText("Consulter...");
						}
						{
							mniEditBudgetDelete = new JMenuItem();
							mnuEditBudget.add(mniEditBudgetDelete);
							mniEditBudgetDelete.setText("Supprimer...");
						}
					}
					{
						mniEditOnTheFlyBudget = new JMenuItem();
						mnuEdit.add(mniEditOnTheFlyBudget);
						mniEditOnTheFlyBudget.setText("Créer un budget à la volée");
					}
					{
						sepEditOne = new JSeparator();
						mnuEdit.add(sepEditOne);
					}
					{
						mniEditManageCategory = new JMenuItem();
						mnuEdit.add(mniEditManageCategory);
						mniEditManageCategory.setText("Gérer les catégories...");
					}
					{
						mniEditManageAuthor = new JMenuItem();
						mnuEdit.add(mniEditManageAuthor);
						mniEditManageAuthor.setText("Gérer les auteurs...");
					}
					{
						sepEditTwo = new JSeparator();
						mnuEdit.add(sepEditTwo);
					}
					{
						mniEditDoExpense = new JMenuItem();
						mnuEdit.add(mniEditDoExpense);
						mniEditDoExpense.setText("Faire une dépense...");
					}
					{
						mniEditDoTransaction = new JMenuItem();
						mnuEdit.add(mniEditDoTransaction);
						mniEditDoTransaction.setText("Faire une transaction...");
					}
				}
				{
					mnuShow = new JMenu();
					mnbMain.add(mnuShow);
					mnuShow.setText("Affichage");
					{
						mnuShowGraphic = new JMenu();
						mnuShow.add(mnuShowGraphic);
						mnuShowGraphic.setText("Graphiques");
					}
					{
						mnuShowList = new JMenu();
						mnuShow.add(mnuShowList);
						mnuShowList.setText("Listes");
						{
							mniShowListLast20 = new JMenuItem();
							mnuShowList.add(mniShowListLast20);
							mniShowListLast20.setText("Les 20 derniers mouvements d'argent");
						}
						{
							mniShowListInterval = new JMenuItem();
							mnuShowList.add(mniShowListInterval);
							mniShowListInterval.setText("Mouvements d'argent dans un interval");
						}
					}
				}
				{
					mnuInterrogation = new JMenu();
					mnbMain.add(mnuInterrogation);
					mnuInterrogation.setText("?");
					{
						mniInterrogationHelp = new JMenuItem();
						mnuInterrogation.add(mniInterrogationHelp);
						mniInterrogationHelp.setText("Aide...");
					}
					{
						mniInterrogationAbout = new JMenuItem();
						mnuInterrogation.add(mniInterrogationAbout);
						mniInterrogationAbout.setText("A propos...");
					}
				}
			}
			pack();
			this.setSize(586, 561);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JComboBox getCmbBudget() {
		return cmbBudget;
	}

}
