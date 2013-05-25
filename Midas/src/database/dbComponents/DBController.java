/* ============================================================================
 * Nom du fichier   : DBController.java
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
package database.dbComponents;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import database.utils.DBAccess;
import database.utils.DBErrorHandler;
import database.utils.DatabaseConstraintViolation;
import database.utils.DatabaseException;

/**
 * 
 * Cette classe représente le contrôleur de la base de données.
 * Le contrôleur permet au coeur d'accèder à la base de données.
 * Toute la communication de l'application à la base de données s'effecue à travers de cette classe.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class DBController {
   
   private DBAccess dbAccess;
   
   public DBController() {
      
      this.dbAccess = new DBAccess("jdbc:sqlite:Midas.sqlite3");
      
   }
   
   public void clearDatabase() throws DatabaseException, DatabaseConstraintViolation {
      String sqlString1;
      String sqlString2;
      String sqlString3;
      String sqlString4;
      String sqlString5;
      String sqlString6;
      String sqlString7;
      PreparedStatement preparedStatement1 = null;
      PreparedStatement preparedStatement2 = null;
      PreparedStatement preparedStatement3 = null;
      PreparedStatement preparedStatement4 = null;
      PreparedStatement preparedStatement5 = null;
      PreparedStatement preparedStatement6 = null;
      PreparedStatement preparedStatement7 = null;
      sqlString1 = "DELETE FROM Recurrence";
      sqlString2 = "DELETE FROM FinancialTransaction";
      sqlString3 = "DELETE FROM BudgetOnTheFly";
      sqlString4 = "DELETE FROM Budget";
      sqlString5 = "DELETE FROM User";
      sqlString6 = "DELETE FROM Account";
      sqlString7 = "DELETE FROM Category";
 
      
      preparedStatement1 = dbAccess.getPreparedStatement(sqlString1);
      preparedStatement2 = dbAccess.getPreparedStatement(sqlString2);
      preparedStatement3 = dbAccess.getPreparedStatement(sqlString3);
      preparedStatement4 = dbAccess.getPreparedStatement(sqlString4);
      preparedStatement5 = dbAccess.getPreparedStatement(sqlString5);
      preparedStatement6 = dbAccess.getPreparedStatement(sqlString6);
      preparedStatement7 = dbAccess.getPreparedStatement(sqlString7);

      this.delete(preparedStatement2);
      this.delete(preparedStatement3);
      this.delete(preparedStatement4);
      this.delete(preparedStatement5);
      this.delete(preparedStatement6);
      this.delete(preparedStatement7);
      this.delete(preparedStatement1);
      
      dbAccess.destroyPreparedStatement(preparedStatement1);
   }
      
   private void insert(PreparedStatement preparedStatement, DBComponent dbComponent) throws DatabaseException, DatabaseConstraintViolation {
      try {
         preparedStatement.execute();
         // récupérer l'identifiant créer par la BDD
         ResultSet result = preparedStatement.getGeneratedKeys();
         result.next();
         dbComponent.setId(result.getInt(1));
         
      } catch (SQLException e) {
         if (e.getMessage().contains("[SQLITE_CONSTRAINT]")) { // Violation d'une contrainte de la BDD
            DBErrorHandler.constraintViolation();
         } else {
            DBErrorHandler.executionError(e);
         }
      }
   }
   
   private void insertWithoutSettingID(PreparedStatement preparedStatement, DBComponent dbComponent) throws DatabaseException, DatabaseConstraintViolation {
      try {
         preparedStatement.execute();         
      } catch (SQLException e) {
         if (e.getMessage().contains("[SQLITE_CONSTRAINT]") ) { // Violation d'une contrainte de la BDD
            DBErrorHandler.constraintViolation();
         } else {
            DBErrorHandler.executionError(e);
         }
      }
   }
   
   private void update (PreparedStatement preparedStatement) throws DatabaseException, DatabaseConstraintViolation {
      try {
         preparedStatement.execute();      
      } catch (SQLException e) {
         if (e.getMessage().contains("[SQLITE_CONSTRAINT]") ) { // Violation d'une contrainte de la BDD
            DBErrorHandler.constraintViolation();
         } else {
            DBErrorHandler.executionError(e);
         }
      }
   }
   
   private void delete (PreparedStatement preparedStatement) throws DatabaseException, DatabaseConstraintViolation {
      try {
         preparedStatement.execute();      
      } catch (SQLException e) {
         if (e.getMessage().contains("[SQLITE_CONSTRAINT]") ) { // Violation d'une contrainte de la BDD
            DBErrorHandler.constraintViolation();
         } else {
            DBErrorHandler.executionError(e);
         }
      }
   }

   private ResultSet select (PreparedStatement preparedStatement) throws DatabaseException {
      ResultSet resultSet = null;
      try {
         resultSet = preparedStatement.executeQuery(); 
      } catch (SQLException e) {
         DBErrorHandler.executionError(e);
      }
      return resultSet;
   }
   
   
   // DBUser ------------------------------------------------------------------------------------
   public DBUser createDBUser() {
      return new DBUser();
   }
   
   public DBUser getDbUser(int id) throws DatabaseException {

      String sqlString = "SELECT Use_Id, Name, Enabled " +
                         "FROM User " +
                         "WHERE Use_ID = ?";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBUser dbUser = null;
      
      try {
         preparedStatement.setInt(1, id);
         
         ResultSet result = this.select(preparedStatement);
         
         result.next();
         dbUser = new DBUser();
         dbUser.setId((result.getInt(1)));
         dbUser.setName(result.getString(2));
         dbUser.setEnabled(result.getBoolean(3));

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbUser;
   }
   
   public LinkedList<DBUser> getAllDbUsers() throws DatabaseException {

      String sqlString = "SELECT Use_Id, Name, Enabled " +
                         "FROM User WHERE Enabled = 1";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBUser dbUser;
      LinkedList<DBUser> dbUsers = new LinkedList<DBUser>();
      
      try {
         ResultSet result = this.select(preparedStatement);
         
         while (result.next()) {
            dbUser = new DBUser();
            dbUser.setId((result.getInt(1)));
            dbUser.setName(result.getString(2));
            dbUser.setEnabled(result.getBoolean(3));
            dbUsers.add(dbUser);
         }

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbUsers;
   }
   
   public void saveToDatabase(DBUser dbUser) throws DatabaseException, DatabaseConstraintViolation {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         if (dbUser.getId() == null) {
            sqlString = "INSERT INTO User " +
                        "VALUES (null, ?, ?)";
            
            preparedStatement = dbAccess.getPreparedStatement(sqlString);
            
            preparedStatement.setString(1, dbUser.getName());
            preparedStatement.setBoolean(2, dbUser.getEnabled());
            
            this.insert(preparedStatement, dbUser);
         } else {
            sqlString = "UPDATE User " +
                        "SET Name = ?, Enabled = ? " +
                        "WHERE Use_Id = ?";
            
            preparedStatement = dbAccess.getPreparedStatement(sqlString);
            
            preparedStatement.setString(1, dbUser.getName());
            preparedStatement.setBoolean(2, dbUser.getEnabled());
            preparedStatement.setInt(3, dbUser.getId());
            
            this.update(preparedStatement);
         }
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
   }
   
   public void deleteDbUser(Integer id) throws DatabaseException, DatabaseConstraintViolation {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         sqlString = "DELETE FROM User " +
                     "WHERE Use_Id = ?";
         
         preparedStatement = dbAccess.getPreparedStatement(sqlString);
         
         preparedStatement.setInt(1, id);
         
         this.delete(preparedStatement);
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
   }
   
   // DBAccount ------------------------------------------------------------------------------------
   public DBAccount createDBAccount() {
      return new DBAccount();
   }
   
   public DBAccount getDbAccount(int id) throws DatabaseException {

      String sqlString = "SELECT Acc_ID, Name, Description, BankName, AccountNumber, Amount, AccountLimit, Enabled " +
                         "FROM Account " +
                         "WHERE Acc_ID = ?";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBAccount dbAccount = null;
      
      try {
         preparedStatement.setInt(1, id);
         
         ResultSet result = this.select(preparedStatement);
         
         result.next();
         dbAccount = new DBAccount();
         
         dbAccount.setId((result.getInt(1)));
         dbAccount.setName((result.getString(2)));
         dbAccount.setDescription((result.getString(3)));
         dbAccount.setNameBank((result.getString(4)));
         dbAccount.setAccountNumber((result.getString(5)));
         dbAccount.setAmount((result.getDouble(6)));
         dbAccount.setThreshold((result.getDouble(7)));    
         dbAccount.setEnabled(result.getBoolean(8));

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbAccount;
   }
   
   public LinkedList<DBAccount> getAllDbAccounts() throws DatabaseException {

      String sqlString = "SELECT Acc_Id, Name, Description, BankName, AccountNumber, Amount, AccountLimit, Enabled " +
                         "FROM Account WHERE Enabled = 1";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBAccount dbAccount;
      LinkedList<DBAccount> dbAccounts = new LinkedList<DBAccount>();
      
      try {
         ResultSet result = this.select(preparedStatement);
         
         while (result.next()) {
            dbAccount = new DBAccount();
            
            dbAccount.setId((result.getInt(1)));
            dbAccount.setName((result.getString(2)));
            dbAccount.setDescription((result.getString(3)));
            dbAccount.setNameBank((result.getString(4)));
            dbAccount.setAccountNumber((result.getString(5)));
            dbAccount.setAmount((result.getDouble(6)));
            dbAccount.setThreshold((result.getDouble(7)));    
            dbAccount.setEnabled(result.getBoolean(8));
            
            dbAccounts.add(dbAccount);
         }

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbAccounts;
   }
   
   public void saveToDatabase(DBAccount dbAccount) throws DatabaseException, DatabaseConstraintViolation {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         if (dbAccount.getId() == null) {
            sqlString = "INSERT INTO Account " +
                        "VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
            
            preparedStatement = dbAccess.getPreparedStatement(sqlString);
                        
            preparedStatement.setString(1, dbAccount.getName());
            preparedStatement.setString(2, dbAccount.getDescription());
            preparedStatement.setString(3, dbAccount.getNameBank());
            preparedStatement.setString(4, dbAccount.getAccountNumber());
            preparedStatement.setDouble(5, dbAccount.getAmount());
            preparedStatement.setDouble(6, dbAccount.getThreshold());
            preparedStatement.setBoolean(7,  dbAccount.getEnabled());
            
            this.insert(preparedStatement, dbAccount);
         } else {
            sqlString = "UPDATE Account " +
                        "SET Name = ?, Description = ?, BankName = ?, AccountNumber = ?, Amount = ?, AccountLimit = ?, Enabled = ? " +
                        "WHERE Acc_Id = ?";
            
            preparedStatement = dbAccess.getPreparedStatement(sqlString);
            
            preparedStatement.setString(1, dbAccount.getName());
            preparedStatement.setString(2, dbAccount.getDescription());
            preparedStatement.setString(3, dbAccount.getNameBank());
            preparedStatement.setString(4, dbAccount.getAccountNumber());
            preparedStatement.setDouble(5, dbAccount.getAmount());
            preparedStatement.setDouble(6, dbAccount.getThreshold());
            preparedStatement.setBoolean(7,  dbAccount.getEnabled());
            preparedStatement.setInt(8, dbAccount.getId());
            
            this.update(preparedStatement);
         }
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }   
   }
   
   public void deleteDbAccount(Integer id) throws DatabaseException, DatabaseConstraintViolation {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         sqlString = "DELETE FROM Account " +
                     "WHERE Acc_Id = ?";
         
         preparedStatement = dbAccess.getPreparedStatement(sqlString);
         
         preparedStatement.setInt(1, id);
         
         this.delete(preparedStatement);
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
   }
   
   public DBFinancialTransaction createFinancialTransaction() {
       return new DBFinancialTransaction();
   }
   
   // DBFinancialTransaction ------------------------------------------------------------------------------------
   public DBFinancialTransaction getDbFinancialTransaction(int id) throws DatabaseException {
   
      String sqlString = "SELECT Tra_ID, Rec_Id, Amount, Date, Reason, Acc_ID " +
                         "FROM FinancialTransaction " +
                         "WHERE Tra_ID = ?"; 
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBFinancialTransaction dbFinancialTransaction = null;
      
      try {
         preparedStatement.setInt(1, id);
         
         ResultSet result = this.select(preparedStatement);
         
         result.next();
         dbFinancialTransaction = new DBFinancialTransaction();
         
         dbFinancialTransaction.setId((result.getInt(1)));
         dbFinancialTransaction.setDbRecurrence((result.getInt(2)));
         dbFinancialTransaction.setAmount((result.getDouble(3)));
         dbFinancialTransaction.setDate((result.getDate(4)));
         dbFinancialTransaction.setReason((result.getString(5)));
         dbFinancialTransaction.setDbAccount((result.getInt(6)));

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbFinancialTransaction;
   }
   
   public LinkedList<DBFinancialTransaction>
      getAllDbFinancialTransactionsRelatedToBudget(int budgetId)
      throws DatabaseException {
     
      String sqlString = "SELECT Tra_ID, Rec_Id, Amount, Date, Reason, Acc_ID "
                       + "FROM FinancialTransaction "
                       + "WHERE Bud_ID = ?";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBFinancialTransaction dbFinancialTransaction = null;
      LinkedList<DBFinancialTransaction> dbFinancialTransactions = new LinkedList<DBFinancialTransaction>();
      
      try {
         preparedStatement.setInt(1, budgetId);
         
         ResultSet result = this.select(preparedStatement);
         
         while (result.next()) {
             dbFinancialTransaction = new DBFinancialTransaction();
             
             dbFinancialTransaction.setId((result.getInt(1)));
             dbFinancialTransaction.setDbRecurrence((result.getInt(2)));
             dbFinancialTransaction.setAmount((result.getDouble(3)));
             dbFinancialTransaction.setDate((result.getDate(4)));
             dbFinancialTransaction.setReason((result.getString(5)));
             dbFinancialTransaction.setDbAccount((result.getInt(6)));
             
             dbFinancialTransactions.add(dbFinancialTransaction);
         }

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      
      return dbFinancialTransactions;
   }
   
   public LinkedList<DBFinancialTransaction>
            getAllDbFinancialTransactionsRelatedToAccount(
                                       int accountId) throws DatabaseException {

      String sqlString = "SELECT Tra_ID, Rec_Id, Amount, Date, Reason, Acc_ID "
            + "FROM FinancialTransaction " + "WHERE Acc_ID = ?";

      PreparedStatement preparedStatement = dbAccess
            .getPreparedStatement(sqlString);
      DBFinancialTransaction dbFinancialTransaction = null;
      LinkedList<DBFinancialTransaction> dbFinancialTransactions = new LinkedList<DBFinancialTransaction>();

      try {
         preparedStatement.setInt(1, accountId);

         ResultSet result = this.select(preparedStatement);

         while (result.next()) {
            dbFinancialTransaction = new DBFinancialTransaction();

            dbFinancialTransaction.setId((result.getInt(1)));
            dbFinancialTransaction.setDbRecurrence((result.getInt(2)));
            dbFinancialTransaction.setAmount((result.getDouble(3)));
            dbFinancialTransaction.setDate((result.getDate(4)));
            dbFinancialTransaction.setReason((result.getString(5)));
            dbFinancialTransaction.setDbAccount((result.getInt(6)));

            dbFinancialTransactions.add(dbFinancialTransaction);
         }

      }
      catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }

      return dbFinancialTransactions;
   }
   
   public LinkedList<DBBudget> getAllDbBudgetsRelatedToAccount(int accountId)
      throws DatabaseException {
      
      String sqlString = "SELECT Budget.Bud_Id, Rec_Id, Name, Description, BudgetLimit, Enabled, Acc_ID "
            + "FROM Budget"
            + "WHERE Acc_ID = ?";

      PreparedStatement preparedStatement = dbAccess
            .getPreparedStatement(sqlString);
      DBBudget dbBudget;
      LinkedList<DBBudget> dbBudgets = new LinkedList<DBBudget>();

      try {
         preparedStatement.setInt(1, accountId);
         
         ResultSet result = this.select(preparedStatement);

         while (result.next()) {
            dbBudget = new DBBudget();

            dbBudget.setId(result.getInt(1));
            dbBudget.setDbRecurrence(result.getInt(2));
            dbBudget.setName(result.getString(3));
            dbBudget.setDescription(result.getString(4));
            dbBudget.setLimit(result.getDouble(5));
            dbBudget.setEnabled(result.getBoolean(6));
            dbBudget.setDbAccount(result.getInt(7));

            dbBudgets.add(dbBudget);
         }

      }
      catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbBudgets;
   }
   
   public LinkedList<DBFinancialTransaction> getAllDbFinancialTransactions() throws DatabaseException {

      String sqlString = "SELECT Tra_ID, Rec_Id, Amount, Date, Reason, Acc_ID " +
                         "FROM FinancialTransaction";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBFinancialTransaction dbFinancialTransaction = null;
      LinkedList<DBFinancialTransaction> dbFinancialTransactions = new LinkedList<DBFinancialTransaction>();
      
      try {
         ResultSet result = this.select(preparedStatement);
         
         while (result.next()) {
             dbFinancialTransaction = new DBFinancialTransaction();
             
             dbFinancialTransaction.setId((result.getInt(1)));
             dbFinancialTransaction.setDbRecurrence((result.getInt(2)));
             dbFinancialTransaction.setAmount((result.getDouble(3)));
             dbFinancialTransaction.setDate((result.getDate(4)));
             dbFinancialTransaction.setReason((result.getString(5)));
             dbFinancialTransaction.setDbAccount((result.getInt(6)));
             
             dbFinancialTransactions.add(dbFinancialTransaction);
         }

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbFinancialTransactions;
   }
   
   public void saveToDatabase(DBFinancialTransaction dbFinancialTransaction) throws DatabaseConstraintViolation, DatabaseException {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         if (dbFinancialTransaction.getId() == null) {
            sqlString = "INSERT INTO FinancialTransaction " +
                        "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            preparedStatement = dbAccess.getPreparedStatement(sqlString);
                        
            if (dbFinancialTransaction.getDbRecurrence() != null) {
               preparedStatement.setInt(1, dbFinancialTransaction.getDbRecurrence());
            }
            preparedStatement.setDouble(2, dbFinancialTransaction.getAmount());
            preparedStatement.setDate  (3, new java.sql.Date(dbFinancialTransaction.getDate().getTime()));
            preparedStatement.setString(4, dbFinancialTransaction.getReason());
            if (dbFinancialTransaction.getDbCategory() != null) {
               preparedStatement.setInt(5, dbFinancialTransaction.getDbCategory());
            }
            if (dbFinancialTransaction.getDbBudget() != null) {
               preparedStatement.setInt(6, dbFinancialTransaction.getDbBudget());   
            }
            if (dbFinancialTransaction.getDbAccount() != null) {
               preparedStatement.setInt(7, dbFinancialTransaction.getDbAccount());   
            } else {
               DBErrorHandler.constraintViolation();
            }
            if (dbFinancialTransaction.getDbUser() != null) {
               preparedStatement.setInt(8, dbFinancialTransaction.getDbUser());   
            } else {
               DBErrorHandler.constraintViolation();
            }
            
            this.insert(preparedStatement, dbFinancialTransaction);
         } else {
            sqlString = "UPDATE FinancialTransaction " +
                        "SET Rec_Id, Amount = ?, Date = ?, Reason = ?, Cat_ID = ?, Bud_ID = ?, Acc_ID = ?, Use_ID = ?" +
                        "WHERE Tra_ID = ?";
            
            preparedStatement = dbAccess.getPreparedStatement(sqlString);
            
            if (dbFinancialTransaction.getDbRecurrence() != null) {
               preparedStatement.setInt(1, dbFinancialTransaction.getDbRecurrence());
            }
            preparedStatement.setDouble(2, dbFinancialTransaction.getAmount());
            preparedStatement.setDate  (3, new java.sql.Date(dbFinancialTransaction.getDate().getTime()));
            preparedStatement.setString(4, dbFinancialTransaction.getReason());
            if (dbFinancialTransaction.getDbCategory() != null) {
               preparedStatement.setInt(5, dbFinancialTransaction.getDbCategory());
            }
            if (dbFinancialTransaction.getDbBudget() != null) {
               preparedStatement.setInt(6, dbFinancialTransaction.getDbBudget());   
            }
            if (dbFinancialTransaction.getDbAccount() != null) {
               preparedStatement.setInt(7, dbFinancialTransaction.getDbAccount());   
            } else {
               DBErrorHandler.constraintViolation();
            }
            if (dbFinancialTransaction.getDbUser() != null) {
               preparedStatement.setInt(8, dbFinancialTransaction.getDbUser());   
            } else {
               DBErrorHandler.constraintViolation();
            }
            preparedStatement.setInt(9, dbFinancialTransaction.getId());
            
            this.update(preparedStatement);
         }
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }   
   }
   
   public void deleteDbFinancialTransaction(Integer id) throws DatabaseException, DatabaseConstraintViolation {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         sqlString = "DELETE FROM FinancialTransaction " +
                     "WHERE Tra_Id = ?";
         
         preparedStatement = dbAccess.getPreparedStatement(sqlString);
         
         preparedStatement.setInt(1, id);
         
         this.delete(preparedStatement);
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
   }
   
   
   // DBCategory ------------------------------------------------------------------------------------
   public DBCategory createCategory() {
       return new DBCategory();
    }
   public DBCategory getDbCategory(int id) throws DatabaseException {
    
      String sqlString = "SELECT Cat_ID, Name, Enabled, Par_Cat_ID " +
                         "FROM Category " +
                         "WHERE Cat_ID = ?";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBCategory dbCategory = null;
      
      try {
         preparedStatement.setInt(1, id);
         
         ResultSet result = this.select(preparedStatement);
         
         result.next();
         dbCategory = new DBCategory();
         dbCategory.setId((result.getInt(1)));
         dbCategory.setName((result.getString(2)));
         dbCategory.setEnabled(result.getBoolean(3));
         dbCategory.setParentDBCategory((result.getInt(4)));

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbCategory;
   }
   
   public LinkedList<DBCategory> getAllDbCategories() throws DatabaseException {

      String sqlString = "SELECT Cat_ID, Name, Enabled, Par_Cat_ID " +
                         "FROM Category"; 
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBCategory dbCategory = null;
      LinkedList<DBCategory> dbCategories = new LinkedList<DBCategory>();
      
      try {
         ResultSet result = this.select(preparedStatement);
         
         while (result.next()) {
            dbCategory = new DBCategory();
            
            dbCategory.setId((result.getInt(1)));
            dbCategory.setName((result.getString(2)));
            dbCategory.setEnabled(result.getBoolean(3));
            dbCategory.setParentDBCategory((result.getInt(4)));
            dbCategories.add(dbCategory);
         }

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbCategories;
   }  

   public void saveToDatabase(DBCategory dbCategory) throws DatabaseException, DatabaseConstraintViolation {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         if (dbCategory.getId() == null) {
            sqlString = "INSERT INTO Category " +
                        "VALUES (null, ?, ?, ?)";
            
            preparedStatement = dbAccess.getPreparedStatement(sqlString);
            
            preparedStatement.setString(1, dbCategory.getName());
            preparedStatement.setBoolean(2, dbCategory.getEnabled());   
            if (dbCategory.getParentDBCategory() != null) {
               preparedStatement.setInt(3, dbCategory.getParentDBCategory());
            }
            
            this.insert(preparedStatement, dbCategory);
         } else {
            sqlString = "UPDATE Category " +
                        "SET Name = ?, Enabled = ?,Par_Cat_ID = ? " +
                        "WHERE Cat_ID = ?";
            
            preparedStatement = dbAccess.getPreparedStatement(sqlString);
            
            preparedStatement.setString(1, dbCategory.getName());
            preparedStatement.setBoolean(2, dbCategory.getEnabled());   
            if (dbCategory.getParentDBCategory() != null) {
               preparedStatement.setInt(3, dbCategory.getParentDBCategory());
            }
            preparedStatement.setInt(4, dbCategory.getId());
            
            this.update(preparedStatement);
         }
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }   
   }
   
   public void deleteDbCategory(Integer id) throws DatabaseException, DatabaseConstraintViolation {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         sqlString = "DELETE FROM Category " +
                     "WHERE Cat_ID = ?";
         
         preparedStatement = dbAccess.getPreparedStatement(sqlString);
         
         preparedStatement.setInt(1, id);
         
         this.delete(preparedStatement);
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
   }
   
   public LinkedList<DBCategory> getAllParentCategories() throws DatabaseException {

      String sqlString = "SELECT Cat_ID, Name, Par_Cat_ID, Enabled " +
                         "FROM Category " +
                         "WHERE Par_Cat_Id is NULL";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBCategory dbCategory = null;
      LinkedList<DBCategory> dbCategories = new LinkedList<DBCategory>();
        
      try {
         ResultSet result = this.select(preparedStatement);
           
            while (result.next()) {
               dbCategory = new DBCategory();
               
               dbCategory.setId((result.getInt(1)));
               dbCategory.setName((result.getString(2)));
               dbCategory.setParentDBCategory((result.getInt(3)));
               dbCategory.setEnabled(result.getBoolean(4));
               dbCategories.add(dbCategory);
            }

         } catch (SQLException e) {
            DBErrorHandler.resultSetError(e);
         }
         finally {
            dbAccess.destroyPreparedStatement(preparedStatement);
         }
         return dbCategories;
    }
    
    public LinkedList<DBCategory> getAllChildCategories(int id) throws DatabaseException {

       String sqlString = "SELECT Cat_ID, Name, Par_Cat_ID, Enabled " +
                           "FROM Category " +
                           "WHERE Par_Cat_Id = ?"; 
       
        PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
        DBCategory dbCategory = null;
        LinkedList<DBCategory> dbCategories = new LinkedList<DBCategory>();
        
        try {
           preparedStatement.setInt(1, id);
           
           ResultSet result = this.select(preparedStatement);
           
           while (result.next()) {
            dbCategory = new DBCategory();
            
               dbCategory.setId((result.getInt(1)));
               dbCategory.setName((result.getString(2)));
               dbCategory.setParentDBCategory((result.getInt(3)));
               dbCategory.setEnabled(result.getBoolean(4));
               
               dbCategories.add(dbCategory);
           }

        } catch (SQLException e) {
           DBErrorHandler.resultSetError(e);
        }
        finally {
           dbAccess.destroyPreparedStatement(preparedStatement);
        }
        return dbCategories;
    }  
   
   // DBBudget ------------------------------------------------------------------------------------
   public DBBudget createDbBudget() {
      return new DBBudget();
   }
   
   public DBBudget getDbBudget(int id) throws DatabaseException {

      String sqlString = "SELECT Budget.Bud_Id, Rec_Id, Name, Description, BudgetLimit, Enabled, Acc_ID " +
                         "FROM Budget " +
                         "WHERE Budget.Bud_Id = ?";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBBudget dbBudget = null;
      
      try {
         preparedStatement.setInt(1, id);
         ResultSet result = this.select(preparedStatement);
         
         result.next();
         dbBudget = new DBBudget();
         
         dbBudget.setId(result.getInt(1));
         dbBudget.setDbRecurrence(result.getInt(2));
         dbBudget.setName(result.getString(3));  
         dbBudget.setDescription(result.getString(4));
         dbBudget.setLimit(result.getDouble(5));
         dbBudget.setEnabled(result.getBoolean(6));
         dbBudget.setDbAccount(result.getInt(7));

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbBudget;
   }
   
   public LinkedList<DBBudget> getAllDbBudgets() throws DatabaseException {

      String sqlString = "SELECT Budget.Bud_Id, Rec_Id, Name, Description, BudgetLimit, Enabled, Acc_ID " +
                         "FROM Budget";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBBudget dbBudget;
      LinkedList<DBBudget> dbBudgets = new LinkedList<DBBudget>();
      
      try {
         ResultSet result = this.select(preparedStatement);
         
         while (result.next()) {
            dbBudget = new DBBudget();
            
            dbBudget.setId(result.getInt(1));
            dbBudget.setDbRecurrence(result.getInt(2));
            dbBudget.setName(result.getString(3));  
            dbBudget.setDescription(result.getString(4));
            dbBudget.setLimit(result.getDouble(5));
            dbBudget.setEnabled(result.getBoolean(6));
            dbBudget.setDbAccount(result.getInt(7));
            
            dbBudgets.add(dbBudget);
         }

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbBudgets;
   }
   
   public void saveToDatabase(DBBudget dbBudget) throws DatabaseException, DatabaseConstraintViolation {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         if (dbBudget.getId() == null) {
            sqlString = "INSERT INTO Budget " +
                        "VALUES (null, ?, ?, ?, ?, ?, ?)";
            
            preparedStatement = dbAccess.getPreparedStatement(sqlString);
                        
            if (dbBudget.getDbRecurrence() != null) {
               preparedStatement.setInt(1, dbBudget.getDbRecurrence());
            }
            preparedStatement.setString(2, dbBudget.getName());
            preparedStatement.setString(3, dbBudget.getDescription());
            preparedStatement.setDouble(4, dbBudget.getLimit());
            if (dbBudget.getDbRecurrence() != null) {
               preparedStatement.setInt(5, dbBudget.getDbAccount());   
            } else {
               DBErrorHandler.constraintViolation();
            }
            preparedStatement.setBoolean(6, dbBudget.getEnabled());
            
            this.insert(preparedStatement, dbBudget);
         } else {
            sqlString = "UPDATE Budget " +
                        "SET Name = ?, Description = ?, Rec_Id = ?, BudgetLimit = ?, Enabled = ?, Acc_ID = ? " +
                        "WHERE Bud_Id = ?";
            preparedStatement = dbAccess.getPreparedStatement(sqlString);
            
            if (dbBudget.getDbRecurrence() != null) {
               preparedStatement.setInt(1, dbBudget.getDbRecurrence());
            }
            preparedStatement.setString(2, dbBudget.getName());
            preparedStatement.setString(3, dbBudget.getDescription());
            preparedStatement.setDouble(4, dbBudget.getLimit());
            if (dbBudget.getDbRecurrence() != null) {
               preparedStatement.setInt(5, dbBudget.getDbAccount());   
            } else {
               DBErrorHandler.constraintViolation();
            }
            
            preparedStatement.setInt(7, dbBudget.getId());
            
            this.update(preparedStatement);
         }
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }   
   }
   
   public void deleteDbBudget(Integer id) throws DatabaseException, DatabaseConstraintViolation {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         sqlString = "DELETE FROM Budget " +
                     "WHERE Bud_Id = ?";
         
         preparedStatement = dbAccess.getPreparedStatement(sqlString);
         preparedStatement.setInt(1, id);
         
         this.delete(preparedStatement);
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
   }
   
   
   // DBBudgetOnTheFly ------------------------------------------------------------------------------------
   public DBBudgetOnTheFly createDbBudgetOnTheFly() {
      return new DBBudgetOnTheFly();
   }
   
   public DBBudgetOnTheFly getDbBudgetOnTheFly(int id) throws DatabaseException {

      String sqlString = "SELECT BudgetOnTheFly.Bud_Id, Rec_Id, Name, Description, BudgetLimit, Enabled, Acc_ID, Start, End " +
                         "FROM BudgetOnTheFly " +
                         "JOIN Budget ON Budget.Bud_Id = BudgetOnTheFly.Bud_Id " +
                         "WHERE Budget.Bud_Id = ?";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBBudgetOnTheFly dbBudgetOnTheFly = null;
      
      try {
         preparedStatement.setInt(1, id);
         ResultSet result = this.select(preparedStatement);
         
         result.next();
         dbBudgetOnTheFly = new DBBudgetOnTheFly();
         
         // Budget
         dbBudgetOnTheFly.setId(result.getInt(1));
         dbBudgetOnTheFly.setDbRecurrence(2);
         dbBudgetOnTheFly.setName(result.getString(3));
         dbBudgetOnTheFly.setDescription(result.getString(4)); 
         dbBudgetOnTheFly.setLimit(result.getDouble(5));
         dbBudgetOnTheFly.setEnabled(result.getBoolean(6));
         dbBudgetOnTheFly.setDbAccount(result.getInt(7));
         // BudgetOnTheFly
         dbBudgetOnTheFly.setStart(result.getDate(8));
         dbBudgetOnTheFly.setEnd(result.getDate(9));
         
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbBudgetOnTheFly;
   }
   
   public LinkedList<DBBudgetOnTheFly> getAllDbBudgetOnTheFly() throws DatabaseException {

      String sqlString = "SELECT BudgetOnTheFly.Bud_Id, Rec_Id, Name, Description, BudgetLimit, Enabled, Acc_ID, Start, End " +
                         "FROM BudgetOnTheFly " +
                         "JOIN Budget ON Budget.Bud_Id = BudgetOnTheFly.Bud_Id";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBBudgetOnTheFly dbBudgetOnTheFly;
      LinkedList<DBBudgetOnTheFly> dbBudgetsOnTheFly = new LinkedList<DBBudgetOnTheFly>();
      
      try {
         ResultSet result = this.select(preparedStatement);
         
         while (result.next()) {
            dbBudgetOnTheFly = new DBBudgetOnTheFly();
            
            // Budget
            dbBudgetOnTheFly.setId(result.getInt(1));
            dbBudgetOnTheFly.setDbRecurrence(2);
            dbBudgetOnTheFly.setName(result.getString(3));
            dbBudgetOnTheFly.setDescription(result.getString(4)); 
            dbBudgetOnTheFly.setLimit(result.getDouble(5));
            dbBudgetOnTheFly.setEnabled(result.getBoolean(6));
            dbBudgetOnTheFly.setDbAccount(result.getInt(7));
            // BudgetOnTheFly
            dbBudgetOnTheFly.setStart(result.getDate(8));
            dbBudgetOnTheFly.setEnd(result.getDate(9));
            
            dbBudgetsOnTheFly.add(dbBudgetOnTheFly);
         }

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbBudgetsOnTheFly;
   }
   
   public void saveToDatabase(DBBudgetOnTheFly dbBudgetOnTheFly) throws DatabaseException, DatabaseConstraintViolation {
      String sqlString1;
      String sqlString2;
      java.sql.Connection connection = null;
      PreparedStatement preparedStatement1 = null;
      PreparedStatement preparedStatement2 = null;
      try {
         
         connection = dbAccess.getConnection();
         connection.setAutoCommit(false);
         
         if (dbBudgetOnTheFly.getId() == null) {
            sqlString1 = "INSERT INTO Budget " +
                         "VALUES (null, ?, ?, ?, ?, ?, ?)";
            sqlString2 = "INSERT INTO BudgetOnTheFly " +
                         "VALUES (?, ?, ?); ";
            
            preparedStatement1 = dbAccess.getPreparedStatement(sqlString1);
            preparedStatement2 = dbAccess.getPreparedStatement(sqlString2);
            
            // Budget
            if (dbBudgetOnTheFly.getDbRecurrence() != null) {
               preparedStatement1.setInt(1, dbBudgetOnTheFly.getDbRecurrence());   
            }
            preparedStatement1.setString(2, dbBudgetOnTheFly.getName());
            preparedStatement1.setString(3, dbBudgetOnTheFly.getDescription());
            preparedStatement1.setDouble(4, dbBudgetOnTheFly.getLimit());
            preparedStatement1.setBoolean(5, dbBudgetOnTheFly.getEnabled());
            if (dbBudgetOnTheFly.getDbAccount() != null) {
               preparedStatement1.setInt(6, dbBudgetOnTheFly.getDbAccount());   
            } else {
               DBErrorHandler.constraintViolation();
            }
            
            this.insert(preparedStatement1, dbBudgetOnTheFly);
            
            // BudgetOnTheFly
            preparedStatement2.setInt(1, dbBudgetOnTheFly.getId());
            preparedStatement2.setDate(2, new java.sql.Date(dbBudgetOnTheFly.getStart().getTime()));
            preparedStatement2.setDate(3, new java.sql.Date(dbBudgetOnTheFly.getEnd().getTime()));
            
            this.insertWithoutSettingID(preparedStatement2, dbBudgetOnTheFly);
            
            connection.commit();
         } else {
            sqlString1 = "UPDATE Budget " +
                         "SET Rec_Id = ?, Name = ?, Description = ?, BudgetLimit = ?, Enabled = ?, Acc_ID = ? " +
                         "WHERE Bud_Id = ?";
            sqlString2 = "UPDATE BudgetOnTheFly " +
                         "SET Start = ?, End = ? " +
                         "WHERE Bud_Id = ?";
            
            preparedStatement1 = dbAccess.getPreparedStatement(sqlString1);
            preparedStatement2 = dbAccess.getPreparedStatement(sqlString2);

            // Budget
            if (dbBudgetOnTheFly.getDbRecurrence() != null) {
               preparedStatement1.setInt(1, dbBudgetOnTheFly.getDbRecurrence());   
            }
            preparedStatement1.setString(2, dbBudgetOnTheFly.getName());
            preparedStatement1.setString(3, dbBudgetOnTheFly.getDescription());
            preparedStatement1.setDouble(4, dbBudgetOnTheFly.getLimit());
            preparedStatement1.setBoolean(5, dbBudgetOnTheFly.getEnabled());
            if (dbBudgetOnTheFly.getDbAccount() != null) {
               preparedStatement1.setInt(6, dbBudgetOnTheFly.getDbAccount());   
            } else {
               DBErrorHandler.constraintViolation();
            }
            preparedStatement1.setInt(7, dbBudgetOnTheFly.getId());
            
            this.update(preparedStatement1);
            
            // BudgetOnTheFly
            preparedStatement2.setDate(1, new java.sql.Date(dbBudgetOnTheFly.getStart().getTime()));
            preparedStatement2.setDate(2, new java.sql.Date(dbBudgetOnTheFly.getEnd().getTime()));
            preparedStatement2.setInt(3, dbBudgetOnTheFly.getId());
            this.update(preparedStatement2);
            
            connection.commit();
         }
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
      // preparedStatement2 sera aussi détruit avec cette commande
         dbAccess.destroyPreparedStatement(preparedStatement1); 
      }   
   }
   
   public void deleteDbBudgetOnTheFly(Integer id) throws DatabaseException, DatabaseConstraintViolation {
      String sqlString1;
      String sqlString2;
      java.sql.Connection connection = null;
      PreparedStatement preparedStatement1 = null;
      PreparedStatement preparedStatement2 = null;
      try {
         
         connection = dbAccess.getConnection();
         connection.setAutoCommit(false);
         
         sqlString1 = "DELETE FROM BudgetOnTheFly " +
                      "WHERE Bud_Id = ?";
         sqlString2 = "DELETE FROM Budget " +
                      "WHERE Bud_Id = ?";
         preparedStatement1 = dbAccess.getPreparedStatement(sqlString1);
         preparedStatement2 = dbAccess.getPreparedStatement(sqlString2);

         //Budget
         preparedStatement1.setInt(1, id);
         
         this.update(preparedStatement1);
         // BudgetOnTheFly
         preparedStatement2.setInt(1, id);
         
         this.update(preparedStatement2);
         
         connection.commit();

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
      // preparedStatement2 sera aussi détruit avec cette commande
         dbAccess.destroyPreparedStatement(preparedStatement1); 
      }   
   }
   
   // DBRecurrence ------------------------------------------------------------------------------------
   public DBRecurrence createRecurence() {
      return new DBRecurrence();
   }
   
   public DBRecurrence getDbRecurrence(int id) throws DatabaseException {
   
      String sqlString = "SELECT Rec_Id, Start, End, IntervalRecurrence " +
      		             "FROM Recurrence " +
      		             "WHERE Rec_Id = ?";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBRecurrence dbRecurrence = null;
      
      try {
         preparedStatement.setInt(1, id);
         
         ResultSet result = this.select(preparedStatement);
         
         result.next();
         dbRecurrence = new DBRecurrence();
         
         dbRecurrence.setId((result.getInt(1)));
         dbRecurrence.setStart(result.getDate(2));
         dbRecurrence.setEnd(result.getDate(3));
         dbRecurrence.setIntervalRecurrence(result.getInt(4));
   
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbRecurrence;
   }
   
   public LinkedList<DBRecurrence> getAllDbRecurrences() throws DatabaseException {
   
      String sqlString = "SELECT Rec_Id, Start, End, IntervalRecurrence " +
      		             "FROM Recurrence";
      
      PreparedStatement preparedStatement = dbAccess.getPreparedStatement(sqlString);
      DBRecurrence dbRecurrence;
      LinkedList<DBRecurrence> dbRecurrences = new LinkedList<DBRecurrence>();
      
      try {
         ResultSet result = this.select(preparedStatement);
         
         while (result.next()) {
            dbRecurrence = new DBRecurrence();
            
            dbRecurrence.setId((result.getInt(1)));
            dbRecurrence.setStart(result.getDate(2));
            dbRecurrence.setEnd(result.getDate(3));
            dbRecurrence.setIntervalRecurrence(result.getInt(4));
            
            dbRecurrences.add(dbRecurrence);
         }
   
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
      return dbRecurrences;
   }
   
   public void saveToDatabase(DBRecurrence dbRecurrence) throws DatabaseException, DatabaseConstraintViolation {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         if (dbRecurrence.getId() == null) {
            sqlString = "INSERT INTO Recurrence " +
                        "VALUES (null, ?, ?, ?)";
            
            preparedStatement = dbAccess.getPreparedStatement(sqlString);
            
            preparedStatement.setDate(1, new java.sql.Date(dbRecurrence.getStart().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(dbRecurrence.getEnd().getTime()));
            preparedStatement.setInt(3, dbRecurrence.getintervalRecurrence());
            
            this.insert(preparedStatement, dbRecurrence);
         } else {
            sqlString = "UPDATE Recurrence " +
                        "SET Start = ?, End = ? , IntervalRecurrence = ? " +
                        "WHERE Rec_Id = ?";
            
            preparedStatement = dbAccess.getPreparedStatement(sqlString);
            
            preparedStatement.setDate(1, new java.sql.Date(dbRecurrence.getStart().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(dbRecurrence.getEnd().getTime()));
            preparedStatement.setInt(3, dbRecurrence.getintervalRecurrence());
            preparedStatement.setInt(4, dbRecurrence.getId());
            
            this.update(preparedStatement);
         }
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
   }
   
   public void deleteDbRecurrence(Integer id) throws DatabaseException, DatabaseConstraintViolation {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         sqlString = "DELETE FROM Recurrence " +
                     "WHERE Rec_Id = ?";
         
         preparedStatement = dbAccess.getPreparedStatement(sqlString);
         
         preparedStatement.setInt(1, id);
         
         this.delete(preparedStatement);
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         dbAccess.destroyPreparedStatement(preparedStatement);
      }
   }
}
