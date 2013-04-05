

import javax.swing.*;


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
	private JMenuBar jMenuBar1;

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
			setSize(400, 300);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					mnuFile = new JMenu();
					jMenuBar1.add(mnuFile);
					mnuFile.setText("Fichier");
					{
						mniFileQuit = new JMenuItem();
						mnuFile.add(mniFileQuit);
						mniFileQuit.setText("Quitter");
					}
				}
				{
					mnuEdit = new JMenu();
					jMenuBar1.add(mnuEdit);
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
					jMenuBar1.add(mnuShow);
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
					jMenuBar1.add(mnuInterrogation);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
