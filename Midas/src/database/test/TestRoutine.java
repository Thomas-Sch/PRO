package database.test;

import java.util.Date;

import database.dbComponents.*;
import database.utils.DatabaseConstraintViolation;
import database.utils.DatabaseException;

public class TestRoutine {
  
   /**
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
      
      DBUser user1 = dbController.createDBUser();
      user1.setFirstName("Marcel");
      user1.setLastName("Sinniger");
      dbController.saveToDatabase(user1);
      System.out.println(user1);
      
      DBAccount account1 = dbController.createDBAccount();
      account1.setAccountNumber("accountNumber");
      account1.setAmount(100.6);
      account1.setName("Compte 1");
      account1.setNameBank("BEKB");
      account1.setOverdraftLimit(1.0);
      dbController.saveToDatabase(account1);
      System.out.println(account1);
      
      DBBudget budget1 = dbController.createDbBudget();
      budget1.setName("Voiture");
      budget1.setLimit(100.0);
      budget1.setDbAccount(account1.getId());
      dbController.saveToDatabase(budget1);
      System.out.println(budget1);
      
      Thread.sleep(500);
      
      DBBudgetOnTheFly budgetOnTheFly1 = dbController.createDbBudgetOnTheFly();
      budgetOnTheFly1.setName("V");
      budgetOnTheFly1.setLimit(100.0);
      budgetOnTheFly1.setDbAccount(account1.getId());
      budgetOnTheFly1.setStart(new Date(2012, 04, 1));
      budgetOnTheFly1.setEnd(new Date(2010, 03, 1));
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
      t.setAmount(100.0);
      t.setDate(new Date(2012, 04, 1));
      t.setDbAccount(account1.getId());
      t.setDbBudget(budget1.getId());
      t.setDbCategory(cat1.getId());
      t.setDbRecurrence(null);
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
      
      DBUser tempUser = dbController.createDBUser();
      tempUser = dbController.getUBUser(user1.getId());
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
      // update Test
      // ---------------------------------------------------------------------------------------
      System.out.println("----------------------------------------------------------------------");
      System.out.println("update-Test");
      System.out.println("----------------------------------------------------------------------");
      
      System.out.println(user1);
      user1.setFirstName("Marcel mod");
      System.out.println(user1);
      
      System.out.println(account1);
      account1.setName("Compte1 mod");
      System.out.println(account1);
      
      System.out.println(budget1);
      budget1.setName("Voiture mod");
      System.out.println(budget1);
      
      System.out.println(budgetOnTheFly1);
      budgetOnTheFly1.setName("V mod");
      System.out.println(budgetOnTheFly1);
      
      System.out.println(cat1);
      cat1.setName("cat1 mod");
      System.out.println(cat1);
      
      System.out.println(t);
      t.setReason("That's why mod");
      System.out.println(t);
      
      //----------------------------------------------------------------------------------------
      // getAll-Test
      // ---------------------------------------------------------------------------------------
      System.out.println("----------------------------------------------------------------------");
      System.out.println("getAll-Test");
      System.out.println("----------------------------------------------------------------------");
      for (Object line : dbController.getAllDBAccounts()) {
         System.out.println(line);
      }
      
      for (Object line : dbController.getAllDbBudgetOnTheFly()) {
         System.out.println(line);
      }
      
      for (Object line : dbController.getAllDbBudgets()) {
         System.out.println(line);
      }
      
      for (Object line : dbController.getAllDBCategory()) {
         System.out.println(line);
      }
      
      for (Object line : dbController.getAllDBFinancialTransactions()) {
         System.out.println(line);
      }
      
      for (Object line : dbController.getAllDBUsers()) {
         System.out.println(line);
      }
      
      //----------------------------------------------------------------------------------------
      // delete-Test
      // ---------------------------------------------------------------------------------------
      
      
      
   }

}
