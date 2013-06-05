/* ============================================================================
 * Nom du fichier   : TestRoutine.java
 * ============================================================================
 * Date de création : 02.05.2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package database.test;

import java.util.Date;

import database.dbComponents.DBAccount;
import database.dbComponents.DBBudget;
import database.dbComponents.DBBudgetOnTheFly;
import database.dbComponents.DBCategory;
import database.dbComponents.DBController;
import database.dbComponents.DBFinancialTransaction;
import database.dbComponents.DBRecurrence;
import database.dbComponents.DBUser;
import database.utils.DatabaseConstraintViolation;
import database.utils.DatabaseException;

/**
 * 
 * Cette herberger une routine de test qui teste toutes les fonctionnalités
 * du paquet "database" et ses sous-paquets
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class TestRoutine {
  
   /**
    * Routine de test qui teste toutes les méthodes du DBController
    * @param args
    * @throws DatabaseConstraintViolation 
    * @throws DatabaseException 
    * @throws InterruptedException 
    */
   public static void main(String[] args) throws DatabaseException, DatabaseConstraintViolation, InterruptedException {
      DBController dbController = new DBController();
      
      dbController.clearDatabase();
      
      //----------------------------------------------------------------------------------------
      // create Test
      // ---------------------------------------------------------------------------------------
      System.out.println("----------------------------------------------------------------------");
      System.out.println("create-Test");
      System.out.println("----------------------------------------------------------------------");
      
      DBRecurrence r1 = dbController.createRecurence();
      r1.setIntervalRecurrence(30);
      r1.setStart(new Date(0));
      r1.setEnd(new Date(0));
      dbController.saveToDatabase(r1);
      System.out.println(r1);
      
      DBRecurrence r2 = dbController.createRecurence();
      r2.setIntervalRecurrence(30);
      r2.setStart(new Date(0));
      r2.setEnd(new Date(0));
      dbController.saveToDatabase(r2);
      System.out.println(r2);
      
      DBRecurrence r3 = dbController.createRecurence();
      r3.setIntervalRecurrence(30);
      r3.setStart(new Date(0));
      r3.setEnd(new Date(0));
      dbController.saveToDatabase(r3);
      System.out.println(r3);
      
      DBUser user1 = dbController.createDBUser();
      user1.setName("Marcel Sinniger");
      dbController.saveToDatabase(user1);
      System.out.println(user1);
      
      DBAccount account1 = dbController.createDBAccount();
      account1.setAccountNumber("accountNumber");
      account1.setAmount(100.6);
      account1.setName("Compte 1");
      account1.setDescription("desc2");
      account1.setNameBank("BEKB");
      account1.setThreshold(1.0);
      dbController.saveToDatabase(account1);
      System.out.println(account1);
      
      DBBudget budget1 = dbController.createDbBudget();
      budget1.setDbRecurrence(r1.getId());
      budget1.setName("Voiture");
      budget1.setDescription("description");
      budget1.setLimit(100.0);
      budget1.setDbAccount(account1.getId());
      dbController.saveToDatabase(budget1);
      System.out.println(budget1);
      
      Thread.sleep(500);
      
      DBBudgetOnTheFly budgetOnTheFly1 = dbController.createDbBudgetOnTheFly();
      budgetOnTheFly1.setDbRecurrence(r2.getId());
      budgetOnTheFly1.setName("V");
      budgetOnTheFly1.setDescription("description");
      budgetOnTheFly1.setLimit(100.0);
      budgetOnTheFly1.setDbAccount(account1.getId());
      budgetOnTheFly1.setStart(new Date(0));
      budgetOnTheFly1.setEnd(new Date(0));
      dbController.saveToDatabase(budgetOnTheFly1);
      System.out.println(budgetOnTheFly1);
      
      DBCategory cat1 = dbController.createCategory();
      DBCategory cat11 = dbController.createCategory();
      DBCategory cat2 = dbController.createCategory();
      cat1.setName("Cat 1");
      dbController.saveToDatabase(cat1);
      System.out.println(cat1);
      cat11.setName("Cat 11");
      cat11.setParentDBCategory(cat1.getId());
      dbController.saveToDatabase(cat11);
      System.out.println(cat11);
      cat2.setName("Cat 2");
      dbController.saveToDatabase(cat2);
      System.out.println(cat2);
      
      
      DBFinancialTransaction t = dbController.createFinancialTransaction();
      t.setDbRecurrence(r3.getId());
      t.setAmount(100.0);
      t.setDate(new Date(0));
      t.setDbAccount(account1.getId());
      t.setDbBudget(budget1.getId());
      t.setDbCategory(cat1.getId());
      t.setDbUser(user1.getId());
      t.setReason("That's why!");
      dbController.saveToDatabase(t);
      System.out.println(t);
      
      //----------------------------------------------------------------------------------------
      // select Test
      // ---------------------------------------------------------------------------------------
      System.out.println("----------------------------------------------------------------------");
      System.out.println("select-Test");
      System.out.println("----------------------------------------------------------------------");

      DBRecurrence tempR1 = dbController.createRecurence();
      tempR1 = dbController.getDbRecurrence(r1.getId());
      System.out.println(tempR1);

      DBRecurrence tempR2 = dbController.createRecurence();
      tempR2 = dbController.getDbRecurrence(r2.getId());
      System.out.println(tempR2);
      
      DBRecurrence tempR3 = dbController.createRecurence();
      tempR3 = dbController.getDbRecurrence(r3.getId());
      System.out.println(tempR3);
      
      DBUser tempUser = dbController.createDBUser();
      tempUser = dbController.getDbUser(user1.getId());
      System.out.println(tempUser);
      
      DBAccount tempAccount = dbController.createDBAccount();
      tempAccount = dbController.getDbAccount(account1.getId());
      System.out.println(tempAccount);
      
      DBBudget tempBudget = dbController.createDbBudget();
      tempBudget = dbController.getDbBudget(budget1.getId());
      System.out.println(tempBudget);
      
      DBBudgetOnTheFly tempBudgetOnTheFly1 = dbController.createDbBudgetOnTheFly();
      tempBudgetOnTheFly1 = dbController.getDbBudgetOnTheFly(budgetOnTheFly1.getId());
      System.out.println(tempBudgetOnTheFly1);
      
      DBCategory tempCat = dbController.createCategory();
      tempCat = dbController.getDbCategory(cat1.getId());
      System.out.println(tempCat);
      
      DBFinancialTransaction tempTrans = dbController.createFinancialTransaction();
      tempTrans = dbController.getDbFinancialTransaction(t.getId());
      System.out.println(tempTrans);
      
      //----------------------------------------------------------------------------------------
      // FinancialTransaction tests speciaux
      // ---------------------------------------------------------------------------------------
      for (Object line : dbController.getAllDbFinancialTransactionsRelatedToBudget(1)) {
         System.out.println(line);
      }
      for (Object line : dbController.getAllDbFinancialTransactionsRelatedToAccount(1)) {
         System.out.println(line);
      }
      for (Object line : dbController.getAllDbBudgetsRelatedToAccount(1)) {
         System.out.println(line);
      }
      
      
      
      //----------------------------------------------------------------------------------------
      // update Test
      // ---------------------------------------------------------------------------------------
      System.out.println("----------------------------------------------------------------------");
      System.out.println("update-Test");
      System.out.println("----------------------------------------------------------------------");

      System.out.println(tempR1);
      tempR1.setIntervalRecurrence(365);
      dbController.saveToDatabase(tempR1);
      System.out.println(dbController.getDbRecurrence(tempR1.getId()));

      System.out.println(tempR2);
      tempR2.setIntervalRecurrence(365);
      dbController.saveToDatabase(tempR2);
      System.out.println(dbController.getDbRecurrence(tempR2.getId()));
      
      System.out.println(tempR3);
      tempR3.setIntervalRecurrence(365);
      dbController.saveToDatabase(tempR3);
      System.out.println(dbController.getDbRecurrence(tempR3.getId()));
      
      System.out.println(user1);
      user1.setName("Marcel Sinniger mod");
      dbController.saveToDatabase(user1);
      System.out.println(dbController.getDbUser(user1.getId()));
      
      System.out.println(account1);
      account1.setName("Compte1 mod");
      dbController.saveToDatabase(account1);
      System.out.println(dbController.getDbAccount(account1.getId()));
      
      System.out.println(budget1);
      budget1.setName("Voiture mod");
      dbController.saveToDatabase(budget1);
      System.out.println(dbController.getDbBudget(budget1.getId()));
      
      System.out.println(budgetOnTheFly1);
      budgetOnTheFly1.setName("V mod");
      dbController.saveToDatabase(budgetOnTheFly1);
      System.out.println(dbController.getDbBudgetOnTheFly(budgetOnTheFly1.getId()));
      
      System.out.println(cat1);
      cat1.setName("cat1 mod");
      dbController.saveToDatabase(cat1);
      System.out.println(dbController.getDbCategory(cat1.getId()));
      
      System.out.println(cat11);
      cat11.setName("cat11 mod");
      dbController.saveToDatabase(cat11);
      System.out.println(dbController.getDbCategory(cat11.getId()));
      
      System.out.println(cat2);
      cat2.setName("cat2 mod");
      dbController.saveToDatabase(cat2);
      System.out.println(dbController.getDbCategory(cat2.getId()));
      
      System.out.println(t);
      t.setReason("That's why mod");
      dbController.saveToDatabase(t);
      System.out.println(dbController.getDbFinancialTransaction(t.getId()));
      
      //----------------------------------------------------------------------------------------
      // getAll-Test
      // ---------------------------------------------------------------------------------------
      System.out.println("----------------------------------------------------------------------");
      System.out.println("getAll-Test");
      System.out.println("----------------------------------------------------------------------");
      for (Object line : dbController.getAllDbRecurrences()) {
         System.out.println(line);
      }
      
      for (Object line : dbController.getAllDbAccounts()) {
         System.out.println(line);
      }
      
      for (Object line : dbController.getAllDbBudgetOnTheFly()) {
         System.out.println(line);
      }
      
      for (Object line : dbController.getAllDbBudgets()) {
         System.out.println(line);
      }
      
      for (Object line : dbController.getAllDbCategories()) {
         System.out.println(line);
      }
      
      for (Object line : dbController.getAllDbFinancialTransactions()) {
         System.out.println(line);
      }
      
      for (Object line : dbController.getAllDbUsers()) {
         System.out.println(line);
      }
      
      //----------------------------------------------------------------------------------------
      // delete-Test
      // ---------------------------------------------------------------------------------------
      System.out.println("----------------------------------------------------------------------");
      System.out.println("delete-Test");
      System.out.println("----------------------------------------------------------------------");
      
      System.out.println("Avant suppression");
      System.out.println(user1);
      System.out.println(account1);
      System.out.println(budget1);
      System.out.println(budgetOnTheFly1);
      System.out.println(cat1);
      System.out.println(t);
      System.out.println(r1);
      
      dbController.deleteDbFinancialTransaction(t.getId());
      dbController.deleteDbBudgetOnTheFly(budgetOnTheFly1.getId());
      dbController.deleteDbBudget(budget1.getId());
      dbController.deleteDbAccount(account1.getId());
      //dbController.deleteDbCategory(cat1.getId());
      dbController.deleteDbUser(user1.getId());   
      dbController.deleteDbRecurrence(r1.getId());
      
      
      //----------------------------------------------------------------------------------------
      // Category Special
      // ---------------------------------------------------------------------------------------
      for (Object line : dbController.getAllParentCategories()) {
         System.out.println(line);
      }
      for (Object line : dbController.getAllChildCategories(1)) { // Cat 11 attendu
         System.out.println(line);
      }
      for (Object line : dbController.getAllChildCategories(2)) { // rien attendu
         System.out.println(line);
      }
      

      

   }

}
