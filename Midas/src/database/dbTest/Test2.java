package database.dbTest;

import java.util.Calendar;
import java.util.Date;

import database.dbComponents.*;
import database.utils.DatabaseConstraintViolation;
import database.utils.DatabaseException;

public class Test2 {
  

   /**
    * @param args
    * @throws DatabaseConstraintViolation 
    * @throws DatabaseException 
    */
   public static void main(String[] args) throws DatabaseException, DatabaseConstraintViolation {
      DBController dbController = new DBController();
      
      dbController.evilTestFunctionFromMarcel();
      
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
      
      DBBudgetOnTheFly budgetOnTheFly1 = dbController.createDbBudgetOnTheFly();
      budgetOnTheFly1.setName("V");
      budgetOnTheFly1.setLimit(100.0);
      budgetOnTheFly1.setDbAccount(account1.getId());
      budgetOnTheFly1.setStart(new Date(2012, 04, 1));
      budgetOnTheFly1.setEnd(new Date(2010, 03, 1));
      dbController.saveToDatabase(budgetOnTheFly1);
      System.out.println(budgetOnTheFly1);
      
      DBFinancialTransaction t = dbController.createFinancialTransaction();
      t.setAmount(100.0);
      t.setDate(new Date(2012, 04, 1));
      t.setDbAccount(account1.getId());
      //t.setDbBudget(null);
      //t.setDbCategory(null)
      t.setDbRecurrence(null);
      t.setDbUser(user1.getId());
      t.setReason("That's why!");
      dbController.saveToDatabase(t);
      System.out.println(t);
      
      //----------------------------------------------------------------------------------------
      // getAll-Test
      // ---------------------------------------------------------------------------------------
      
      
      
   }

}
