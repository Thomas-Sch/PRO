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

import java.util.Iterator;
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
import database.dbComponents.DBFinancialTransaction;
import database.dbComponents.DBRecurrence;
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
    * Créer un nouveau budget dont les champs sont à compléter.
    * @return le budget à compléter.
    */
   public Budget createBudget(){
      return new Budget(this, dbController.createDbBudget());
   }
   
   /**
    * Créer un nouveau budget à la volée dont les champs sont à compléter.
    * @return le budget à compléter.
    */
   public BudgetOnTheFly createBudgetOnTheFly(){
      return new BudgetOnTheFly(this, dbController.createDbBudgetOnTheFly());
   }
   
   /**
    * Créer un nouvel utilisateur dont les champs sont à compléter.
    * @return l'utilisateur à compléter.
    */
   public User createUser(){
      return new User(this, dbController.createDBUser());
   }
   
   /**
    * Créer une nouvelle récurrnce.
    * @return la nouvelle récurrence.
    */
   public Recurrence createReccurence() {
      return new Recurrence(this, dbController.createRecurence());
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
    * Créer une nouvelle catégorie dont les champs sont à compléter.
    * @return la catégorie à compléter.
    */
   public Category createCategory(){
      return new Category(this, dbController.createCategory());   
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
    * Retourne l'utilisateur ayant pour identifiant celui passé en paramètres.
    * @param id - l'identifiant de l'utilisateur souhaité.
    * @return l'utilisateur correspondant à l'identifiant, null le cas échéant.
    */
   public User getUser(int id) {      
      return users.get(id); 
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
    * Retourne la récurrence ayant pour identifiant celui passé en paramètres.
    * @param id - l'identifiant de la récurrence souhaitée.
    * @return la récurrence correspondante à l'identifiant, null le cas échéant.
    */
   public Recurrence getRecurrence(int id) {
      Recurrence result = cache.getReference(Recurrence.class, id);
      
      // Si pas présent dans le cache, demander à la base de données
      if (result == null) {
         try {
            DBRecurrence dbRec = dbController.getDbRecurrence(id);
            
            if (dbRec != null) {
               result = new Recurrence(this, dbRec);
               
               // Mise à jour du cache
               cache.putToCache(result);
            }
            
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
   
   public LinkedList<FinancialTransaction> getAllFinancialTransaction() {
      LinkedList<DBFinancialTransaction> list;
      LinkedList<FinancialTransaction> result;
      result = cache.getAll(FinancialTransaction.class);
      
      try {
         list = dbController.getAllDbFinancialTransactions();
         
         boolean alreadyExist = false;
         
         for (DBFinancialTransaction dbItem : list) {
            
            alreadyExist = false;
            for (FinancialTransaction financialTransaction : result) {
               
               if(dbItem.getId() == financialTransaction.getId()) {
                  alreadyExist = true;
                  break;
               }
            }
            
            if (!alreadyExist) {
               result.add(new FinancialTransaction(this, dbItem));
            }
            
         }
      }
      catch (DatabaseException e) {
         
      }
      return result;
   }
   
   public LinkedList<FinancialTransaction>
                     getAllFinancialTransactionRelatedToBudget(int budgetId) {
      LinkedList<DBFinancialTransaction> list;
      LinkedList<FinancialTransaction> result;
      result = cache.getAll(FinancialTransaction.class);
      
      Iterator<FinancialTransaction> iterator = result.iterator();
      FinancialTransaction temp;
      while (iterator.hasNext()) {
         temp = iterator.next();
         // Suppression si le budget ne correspond pas
         if (temp.getBudgetId() == budgetId) {
            iterator.remove();
         }
      }
      
      try {
         list = dbController.getAllDbFinancialTransactionsRelatedToBudget(budgetId);
         
         boolean alreadyExist = false;
         
         for (DBFinancialTransaction dbItem : list) {
            
            alreadyExist = false;
            for (FinancialTransaction financialTransaction : result) {
               
               if(dbItem.getId() == financialTransaction.getId()) {
                  alreadyExist = true;
                  break;
               }
            }
            
            if (!alreadyExist) {
               result.add(new FinancialTransaction(this, dbItem));
            }
            
         }
         
      }
      catch (DatabaseException e) {
         
      }
      return result;
   }
   
   public LinkedList<FinancialTransaction>
                     getAllFinancialTransactionRelatedToAccount(int accountId) {
      LinkedList<DBFinancialTransaction> list;
      LinkedList<FinancialTransaction> result;
      result = cache.getAll(FinancialTransaction.class);

      Iterator<FinancialTransaction> iterator = result.iterator();
      FinancialTransaction temp;
      while (iterator.hasNext()) {
         temp = iterator.next();
         // Suppression si le budget ne correspond pas
         if (temp.getAccountId() == accountId) {
            iterator.remove();
         }
      }

      try {
         list = dbController
               .getAllDbFinancialTransactionsRelatedToAccount(accountId);

         boolean alreadyExist = false;

         for (DBFinancialTransaction dbItem : list) {

            alreadyExist = false;
            for (FinancialTransaction financialTransaction : result) {

               if (dbItem.getId() == financialTransaction.getId()) {
                  alreadyExist = true;
                  break;
               }
            }

            if (!alreadyExist) {
               result.add(new FinancialTransaction(this, dbItem));
            }

         }

      }
      catch (DatabaseException e) {

      }
      return result;
   }
   
   public LinkedList<Budget> getAllBudgtesRelatedToAccount(int accountId) {
      LinkedList<DBBudget> list;
      LinkedList<Budget> result;
      
      result = cache.getAll(Budget.class);

      Iterator<Budget> iterator = result.iterator();
      Budget temp;
      while (iterator.hasNext()) {
         temp = iterator.next();
         // Suppression si le compte ne correspond pas
         if (temp.getBindedAccountId() == accountId) {
            iterator.remove();
         }
      }

      try {
         list = dbController
               .getAllDbBudgetsRelatedToAccount(accountId);

         boolean alreadyExist = false;

         for (DBBudget dbItem : list) {

            alreadyExist = false;
            for (Budget budget : result) {

               if (dbItem.getId() == budget.getId()) {
                  alreadyExist = true;
                  break;
               }
            }

            if (!alreadyExist) {
               result.add(new Budget(this, dbItem));
            }

         }

      }
      catch (DatabaseException e) {

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
         
         if(!accounts.contains(account)) {
            accounts.addItem(account);
         }
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
    * Sauvegarde ou met à jour la catégorie donnée dans la base de donnée.
    * @param category - la catégorie à sauver.
    */
   public void saveCategory(Category category) {
      try {
         dbController.saveToDatabase(category.getDBCategory());
         
         if(!primaryCategories.contains(category)) {
            primaryCategories.addItem(category);
         }
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
         
         if(!list.contains(category)) {
            list.addItem(category);
         }
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
    * Sauvegarde ou met à jour l'utilisateur donné dans la base de donnée.
    * @param user - l'utilisateur à sauver.
    */
   public void saveUser(User user) {
      try {
         dbController.saveToDatabase(user.getDBUser());
         
         if(!users.contains(user)) {
            users.addItem(user);
         }
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
    * Supprime une recurrence dans la base de donnee.
    * @param account - la recurrence a supprimer
    */
   public void deleteRecurrence(Recurrence recurrence) {
      try {
         dbController.deleteDbRecurrence(recurrence.getId());
      }
      catch (DatabaseException | DatabaseConstraintViolation e) {
         MidasLogs.errors.push("Core " + "error when deleting a recurrence");
      }
   }
   
   /**
    * Supprime la recurrence d'un budget dans la base de donnee.
    * @param account - la recurrence a supprimer
    */
   public void deleteRecurrenceBudget(Budget budget) {
      try {
         int tmpId = budget.getRecurrence().getId();
         budget.getDBBudget().setDbRecurrence(null);
         saveBudget(budget);
         dbController.deleteDbRecurrence(tmpId);
      }
      catch (DatabaseException | DatabaseConstraintViolation e) {
         MidasLogs.errors.push("Core " + "error when deleting a recurrence of budget");
      }
   }
   
   /**
    * Supprime la recurrence d'une transaction fianaciere dans la base de donnee.
    * @param account - la recurrence d'une transaction financiere a supprimer
    */
   public void deleteRecurrenceFinancialTransaction(FinancialTransaction transaction) {
      try {
         int tmpId = transaction.getRecurrence().getId();
         transaction.getDBFinancialTransaction().setDbRecurrence(null);
         saveFinancialTransaction(transaction);
         dbController.deleteDbRecurrence(tmpId);
      }
      catch (DatabaseException | DatabaseConstraintViolation e) {
         MidasLogs.errors.push("Core " + "error when deleting a recurrence of fianancial transaction");
      }
   }
   
   /**
    * Desactive un compte, le compte est archive dans la base de donnee 
    * et n'est plus disponible dans les operations comptables.
    * @param account - le compte a desactiver
    */
   public void desactivateAccount(Account account) {
      account.getDBAccount().setEnabled(false);
      saveAccount(account);
      accounts.removeItem(account);
   }
   
   /**
    * Desactive un budget, le budget est archive dans la base de donnee 
    * et n'est plus disponible dans les operations comptables.
    * @param budget - le budget a desactiver
    */
   public void desactivateBudget(Budget budget) {
      budget.getDBBudget().setEnabled(false);
      saveBudget(budget);
      budgets.removeItem(budget);
   }
   
   /**
    * Desactive un utilisateur, l'utilisateur est archive dans la base de donnee 
    * et n'est plus disponible dans les operations comptables.
    * @param user - l'utilisateur a desactiver
    */
   public void desactivateUser(User user) {
      user.getDBUser().setEnabled(false);
      saveUser(user);
      users.removeItem(user);
   }
   
   /**
    * Desactive une categorie, la categorie est archive dans la base de donnee 
    * et n'est plus disponible dans les operations comptables.
    * @param category - la categorie a desactiver
    */
   public void desactivateCategory(Category category) {
      category.getDBCategory().setEnabled(false);
      saveCategory(category);
      primaryCategories.removeItem(category);
   }
   
   public void deleteAccount(Account account) throws DatabaseException, DatabaseConstraintViolation {
      dbController.deleteDbAccount(account.getId());
      accounts.removeItem(account);
   }

   
}
