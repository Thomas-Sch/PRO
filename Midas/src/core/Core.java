/* ============================================================================
 * Nom du fichier   : Core.java
 * ============================================================================
 * Date de création : 7 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core;

import java.util.Comparator;
import java.util.LinkedList;

import core.components.Budget;
import core.components.BudgetOnTheFly;
import core.components.Category;
import core.components.Account;
import core.components.FinancialTransaction;
import core.components.User;
import core.components.UserList;
import database.dbComponents.DBController;
import database.dbComponents.DBUser;
import database.utils.DatabaseConstraintViolation;
import database.utils.DatabaseException;
import settings.Settings;

/**
 * Coeur du programme servant à recenser les fonctionnalités du logiciel.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class Core {
   
   private Settings settings;
   
   private DBController dbController;
   
   private UserList users;
   
   public Core() {
      settings = new Settings();
      dbController = new DBController();
      
      users = new UserList(this);
      
      settings.loadSettings();
      
      loadUsers();
   }
   
   private void loadUsers() {
      LinkedList<DBUser> dbUsers = null;
      try {
         dbUsers = dbController.getAllDbUsers();
      }
      catch (DatabaseException e) {
         
      }
      
      if (dbUsers != null) {
         LinkedList<User> userTemp = new LinkedList<>();
         
         for (DBUser dbUser : dbUsers) {
            userTemp.add(new User(this, dbUser));
         }
         
         users.setUsers(userTemp);
      }
     
   }
   
   
   /**
    * Créer un nouveau compte, à compléter par l'utilisateur.
    * @return le nouveau compte.
    */
   public Account createAccount() {
      return new Account(this, dbController.createDBAccount());
   }
   
   /**
    * Retourne le compte ayant pour identifiant celui passé en paramètres.
    * @param id - l'identifiant du compte souhaité.
    * @return le compte correspondant à l'identifiant, null le cas échéant.
    */
   public Account getAccount(int id) {
      Account result = null;
      
      try {
         result = new Account(this, dbController.getDbAccount(id));
      }
      catch (DatabaseException e) {
         MidasLogs.errors.push("Core", "Unable to get the account with id "
                               + id + " from the database.");
      }
      
      return result;
   }
   
   /**
    * Sauvegarde ou met à jour le compte donné dans la base de donnée.
    * @param account - le compte à sauver.
    */
   public void saveAccount(Account account) {
      try {
         dbController.saveToDatabase(account.getDBAccount());
      }
      catch (DatabaseConstraintViolation e) {
         MidasLogs.errors.push("Core", "Unable to save the account with id "
               + /* id + */ " to database, because of constraint violation.");
      }
      catch (DatabaseException e) {
         MidasLogs.errors.push("Core", "Unable to save the account with id "
               + /* id + */ " to database.");
      }
      
   }
   
   /**
    * Créer une nouvelle catégorie dont les champs sont à compléter.
    * @return la catégorie à compléter.
    */
   public Category createCategory(){
      
      return new Category(this, dbController.createCategory());
      
   }
   
   /**
    * Retourne la catégorie ayant pour identifiant celui passé en paramètres.
    * @param id - l'identifiant de la catégorie souhaitée.
    * @return la catégorie correspondant à l'identifiant, null le cas échéant.
    */
   public Category getCategory(int id) {
      Category result = null;
      
      try {
         result = new Category(this, dbController.getDbCategory(id));
      }
      catch (DatabaseException e) {
         
      }
      
      return result; 
   }
   
   /**
    * Sauvegarde ou met à jour la catégorie donnée dans la base de donnée.
    * @param category - la catégorie à sauver.
    */
   public void saveCategory(Category category) {
      try {
         dbController.saveToDatabase(category.getDBCategory());
      }
      catch (DatabaseConstraintViolation e) {
         MidasLogs.errors.push("Core", "Unable to save the category with id "
               + /* id + */ " to database, because of constraint violation.");
      }
      catch (DatabaseException e) {
         MidasLogs.errors.push("Core", "Unable to save the category with id "
               + /* id + */ " to database.");
      }
   }
   
   /**
    * Créer un nouveau budget dont les champs sont à compléter.
    * @return le budget à compléter.
    */
   public Budget createBudget(){
      return new Budget(this, dbController.createDbBudget());
   }
   
   /**
    * Retourne le budget ayant pour identifiant celui passé en paramètres.
    * @param id - l'identifiant du budget souhaité.
    * @return le budget correspondant à l'identifiant, null le cas échéant.
    */
   public Budget getBudget(int id) {
      Budget result = null;
      
      try {
         result = new Budget(this, dbController.getDbBudget(id));
      }
      catch (DatabaseException e) {
         
      }
      
      return result; 
   }
   
   /**
    * Sauvegarde ou met à jour le budget donné dans la base de donnée.
    * @param budget - le budget à sauver.
    */
   public void saveBudget(Budget budget) {
      try {
         dbController.saveToDatabase(budget.getDBBudget());
      }
      catch (DatabaseConstraintViolation e) {
         MidasLogs.errors.push("Core", "Unable to save the budget with id "
               + /* id + */ " to database, because of constraint violation.");
      }
      catch (DatabaseException e) {
         MidasLogs.errors.push("Core", "Unable to save the budget with id "
               + /* id + */ " to database.");
      }
   }
   
   /**
    * TODO Créer un nouveau budget à la volée dont les champs sont à compléter.
    * @return le budget à compléter.
    */
   public BudgetOnTheFly createBudgetOnTheFly(){
      return new BudgetOnTheFly(this, dbController.createDbBudgetOnTheFly());
   }
   
   /**
    * TODO Retourne le budget ayant pour identifiant celui passé en paramètres.
    * @param id - l'identifiant du budget souhaité.
    * @return la catégorie correspondant à l'identifiant, null le cas échéant.
    */
   public BudgetOnTheFly getBudgetOnTheFlyID(int id) {
      BudgetOnTheFly result = null;
      
      
//      try {
//         result = new BudgetOnTheFly(dbController.getDbBudgetOnTheFly(id));
//      }
//      catch (DatabaseException e) {
//         
//      }
      
      return result; 
   }
   
   /**
    * TODO Sauvegarde ou met à jour le budget à la volée donné dans la base de
    * donnée.
    * @param budget - le budget à sauver.
    */
   public void saveBudgetOnTheFly(BudgetOnTheFly budget) {
      
//      try {
//         dbController.saveToDatabase(budget.getDBBudget());
//      }
//      catch (DatabaseConstraintViolation e) {
//         MidasLogs.errors.push("Core", "Unable to save the budget with id "
//               + /* id + */ " to database, because of constraint violation.");
//      }
//      catch (DatabaseException e) {
//         MidasLogs.errors.push("Core", "Unable to save the budget with id "
//               + /* id + */ " to database.");
//      }
      
   }
   
   /**
    * Créer un nouvel utilisateur dont les champs sont à compléter.
    * @return l'utilisateur à compléter.
    */
   public User createUser(){
      return new User(this, dbController.createDBUser());
   }
   
   /**
    * Retourne l'utilisateur ayant pour identifiant celui passé en paramètres.
    * @param id - l'identifiant de l'utilisateur souhaité.
    * @return l'utilisateur correspondant à l'identifiant, null le cas échéant.
    */
   public User getUser(int id) {      
      return users.get(id); 
   }
   
   public UserList getAllUsers(){
      return users;
   }
   
   /**
    * Sauvegarde ou met à jour l'utilisateur donné dans la base de donnée.
    * @param user - l'utilisateur à sauver.
    */
   public void saveUser(User user) {
      try {
         dbController.saveToDatabase(user.getDBUser());
         
         users.addUser(user);
      }
      catch (DatabaseConstraintViolation e) {
         MidasLogs.errors.push("Core", "Unable to save the user with id "
               + /* id + */ " to database, because of constraint violation.");
      }
      catch (DatabaseException e) {
         MidasLogs.errors.push("Core", "Unable to save the user with id "
               + /* id + */ " to database.");
      }
   }
   
   /**
    * Créer une nouvelle transaction dont les champs sont à compléter.
    * @return la transaction à compléter.
    */
   public FinancialTransaction createFinancialTransaction(){
      return new FinancialTransaction(this,
                                    dbController.createFinancialTransaction());
   }
   
   /**
    * Retourne la transaction ayant pour identifiant celui passé en paramètres.
    * @param id - l'identifiant de la transaction souhaitée.
    * @return la transaction correspondant à l'identifiant, null le cas échéant.
    */
   public FinancialTransaction getFinancialTransaction(int id) {
      FinancialTransaction result = null;
      
      try {
         result = new FinancialTransaction(this,
                                 dbController.getDbFinancialTransaction(id));
      }
      catch (DatabaseException e) {
         
      }
      
      return result; 
   }
   
   /**
    * TODO Sauvegarde ou met à jour la transaction donnée dans la base de donnée.
    * @param transaction - la transaction à sauver.
    */
   public void saveFinancialTransaction(FinancialTransaction transaction) {
//      try {
//         dbController.saveToDatabase(transaction.getDBFinancialTransaction());
//      }
//      catch (DatabaseConstraintViolation e) {
//         MidasLogs.errors.push("Core", "Unable to save the budget with id "
//               + /* id + */ " to database, because of constraint violation.");
//      }
//      catch (DatabaseException e) {
//         MidasLogs.errors.push("Core", "Unable to save the budget with id "
//               + /* id + */ " to database.");
//      }
   }
   
   
   
}
