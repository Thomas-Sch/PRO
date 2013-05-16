/* ============================================================================
 * Nom du fichier   : TestRoutine2.java
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
public class TestRoutine2 {
  
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
      r1.setStart(new Date(2012, 04, 1));
      r1.setEnd(new Date(2012, 04, 1));
      dbController.saveToDatabase(r1);
      System.out.println(r1);
      
      DBRecurrence r2 = dbController.createRecurence();
      r2.setIntervalRecurrence(30);
      r2.setStart(new Date(2012, 04, 1));
      r2.setEnd(new Date(2012, 04, 1));
      dbController.saveToDatabase(r2);
      System.out.println(r2);
      
      DBRecurrence r3 = dbController.createRecurence();
      r3.setIntervalRecurrence(30);
      r3.setStart(new Date(2012, 04, 1));
      r3.setEnd(new Date(2012, 04, 1));
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
      account1.setNameBank("BEKB");
      account1.setOverdraftLimit(1.0);
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
      t.setDbRecurrence(r3.getId());
      t.setAmount(100.0);
      t.setDate(new Date(2012, 04, 1));
      t.setDbAccount(account1.getId());
      t.setDbBudget(budget1.getId());
      t.setDbCategory(cat1.getId());
      t.setDbUser(user1.getId());
      t.setReason("That's why!");
      dbController.saveToDatabase(t);
      System.out.println(t);
      }
}
