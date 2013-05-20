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

import java.util.LinkedList;
import settings.Settings;
import core.cache.Cache;
import core.components.Account;
import core.components.AccountList;
import core.components.Budget;
import core.components.BudgetList;
import core.components.BudgetOnTheFly;
import core.components.Category;
import core.components.CategoryList;
import core.components.FinancialTransaction;
import core.components.Recurrence;
import core.components.User;
import core.components.UserList;
import database.dbComponents.DBAccount;
import database.dbComponents.DBBudget;
import database.dbComponents.DBCategory;
import database.dbComponents.DBController;
import database.dbComponents.DBUser;
import database.utils.DatabaseConstraintViolation;
import database.utils.DatabaseException;

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
   
   private Cache cache;
   
   private UserList users;
   private AccountList accounts;
   private CategoryList primaryCategories;
   private BudgetList budgets;
   
   public Core() {
      settings = new Settings();
      dbController = new DBController();
      cache = new Cache();
      
      users = new UserList(this);
      accounts = new AccountList(this);
      primaryCategories = new CategoryList(this);
      budgets = new BudgetList(this);
      
      settings.loadSettings();
      
      loadUsers();
      loadAccounts();
      loadPrimaryCategories();
      loadBudgets();
   }
   
   private void loadBudgets() {
      LinkedList<DBBudget> dbBudgets = null;
      try {
         dbBudgets = dbController.getAllDbBudgets();
      }
      catch (DatabaseException e) {
         
      }
      
      if (dbBudgets != null) {
         LinkedList<Budget> budgetTemp = new LinkedList<>();
         
         for (DBBudget dbBudget : dbBudgets) {
            budgetTemp.add(new Budget(this, dbBudget));
         }
         
         budgets.setItems(budgetTemp);
      }
   }
   
   public void deleteAccount(Account account) throws DatabaseException, DatabaseConstraintViolation {
      dbController.deleteDbAccount(account.getId());
      accounts.removeItem(account);
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
         
         users.setItems(userTemp);
      }
   }
   
   private void loadAccounts() {
      LinkedList<DBAccount> dbAccounts = null;
      try {
         dbAccounts = dbController.getAllDbAccounts();
      }
      catch (DatabaseException e) {
         
      }
      
      if (dbAccounts != null) {
         LinkedList<Account> accountTemp = new LinkedList<>();
         
         for (DBAccount dbAccount : dbAccounts) {
            accountTemp.add(new Account(this, dbAccount));
         }
         
         accounts.setItems(accountTemp);
      }
   }
   
   private void loadPrimaryCategories() {
      LinkedList<DBCategory> dbCategories = null;
      try {
         dbCategories = dbController.getAllParentCategories();
      }
      catch (DatabaseException e) {
         
      }
      
      if (dbCategories != null) {
         LinkedList<Category> categoryTemp = new LinkedList<>();
         
         for (DBCategory dbCategory : dbCategories) {
            categoryTemp.add(new Category(this, dbCategory));
         }
         primaryCategories.setItems(categoryTemp);
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
    * Créer une nouvelle récurrnce.
    * @return la nouvelle récurrence.
    */
   public Recurrence createReccurence() {
      return new Recurrence(this, dbController.createRecurence());
   }
   
   /**
    * Retourne le compte ayant pour identifiant celui passé en paramètres.
    * @param id - l'identifiant du compte souhaité.
    * @return le compte correspondant à l'identifiant, null le cas échéant.
    */
   public Account getAccount(int id) {
      Account result = accounts.get(id);
      
      // Si pas présent dans le coeur, demander à la base de données pour vérifier
      if (result == null) {
         try {
            result = new Account(this, dbController.getDbAccount(id));
            
            // Mise à jour de la liste si présent dans la base de données
            accounts.addItem(result);
         }
         catch (DatabaseException e) {
            MidasLogs.errors.push("Core", "Unable to get the account with id "
                                  + id + " from the database.");
         }
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
         accounts.addItem(account);
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
      Category result = primaryCategories.get(id);
      
      if (result == null) {
         try {
            result = new Category(this, dbController.getDbCategory(id));
            
            primaryCategories.addItem(result);
         }
         catch (DatabaseException e) {
            
         }
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
         primaryCategories.addItem(category);
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
   
   public void saveSubCategory(Category category, CategoryList list) {
      try {
         dbController.saveToDatabase(category.getDBCategory());
         list.addItem(category);
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
      Budget result = budgets.get(id);
      
      try {
         result = new Budget(this, dbController.getDbBudget(id));
         
         budgets.addItem(result);
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
         budgets.addItem(budget);
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
    * Créer un nouveau budget à la volée dont les champs sont à compléter.
    * @return le budget à compléter.
    */
   public BudgetOnTheFly createBudgetOnTheFly(){
      return new BudgetOnTheFly(this, dbController.createDbBudgetOnTheFly());
   }
   
   /**
    * Retourne le budget ayant pour identifiant celui passé en paramètres.
    * @param id - l'identifiant du budget souhaité.
    * @return la catégorie correspondant à l'identifiant, null le cas échéant.
    */
   public BudgetOnTheFly getBudgetOnTheFly(int id) {
      BudgetOnTheFly result = cache.getReference(BudgetOnTheFly.class, id);
      
      // Si pas présent dans le cache, demander à la base de données
      if (result == null) {
         try {
            result = new BudgetOnTheFly(this, dbController.getDbBudgetOnTheFly(id));
            
            // Mise à jour du cache
            cache.putToCache(result);
         }
         catch (DatabaseException e) {
            
         }
      }
      
      return result; 
   }
   
   /**
    * Sauvegarde ou met à jour le budget à la volée donné dans la base de
    * donnée.
    * @param budget - le budget à sauver.
    */
   public void saveBudgetOnTheFly(BudgetOnTheFly budget) {
      try {
         dbController.saveToDatabase(budget.getDBBudgetOnTheFly());
         
         cache.putToCache(budget);
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
   
   public AccountList getAllAccounts() {
      return accounts;
   }
   
   public CategoryList getAllPrimaryCategories() {
      return primaryCategories;
   }
   
   public BudgetList getAllBudgets() {
      return budgets;
   }
   
   /**
    * Sauvegarde ou met à jour l'utilisateur donné dans la base de donnée.
    * @param user - l'utilisateur à sauver.
    */
   public void saveUser(User user) {
      try {
         dbController.saveToDatabase(user.getDBUser());
         
         users.addItem(user);
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
      FinancialTransaction result = cache.getReference(FinancialTransaction.class, id);
      
      // Si pas présent dans le cache, demander à la base de données
      if (result == null) {
         try {
            result = new FinancialTransaction(this,
                                    dbController.getDbFinancialTransaction(id));
            
            // Mise à jour du cache
            cache.putToCache(result);
         }
         catch (DatabaseException e) {
            
         }
      }
      return result; 
   }
   
   /**
    * Sauvegarde ou met à jour la transaction donnée dans la base de donnée.
    * @param transaction - la transaction à sauver.
    */
   public void saveFinancialTransaction(FinancialTransaction transaction) {
      try {
         dbController.saveToDatabase(transaction.getDBFinancialTransaction());
         
         cache.putToCache(transaction);
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
    * Retourne la recurence ayant pour identifiant celui passé en paramètres.
    * @param id - l'identifiant de la recurence souhaitée.
    * @return la recurence correspondante à l'identifiant, null le cas échéant.
    */
   public Recurrence getRecurrence(int id) {
      Recurrence result = cache.getReference(Recurrence.class, id);
      
      // Si pas présent dans le cache, demander à la base de données
      if (result == null) {
         try {
            result = new Recurrence(this, dbController.getDbRecurrence(id));
            
            // Mise à jour du cache
            cache.putToCache(result);
         }
         catch (DatabaseException e) {
            
         }
      }
      
      return result; 
   }  
   
   public CategoryList getChildren(Category category) {
      CategoryList result = new CategoryList(this);
      LinkedList<DBCategory> dbChildren = null;
      try {
         dbChildren = dbController.getAllChildCategories(category.getId());
      }
      catch (DatabaseException e) {
         
      }
      
      if (dbChildren != null) {
         LinkedList<Category> categoryTemp = new LinkedList<>();
         
         for (DBCategory dbCategory : dbChildren) {
            categoryTemp.add(new Category(this, dbCategory));
         }
         result.setItems(categoryTemp);
      }
      return result;
   }
}
