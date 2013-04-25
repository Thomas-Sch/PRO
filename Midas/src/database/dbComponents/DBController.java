package database.dbComponents;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;



public class DBController {
   
   private final String dbPath = "jdbc:sqlite:Midas.sqlite3";
   
   private Connection getConnection() {
      
      Connection connection = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
      } catch (ClassNotFoundException e) {
         System.err.println(e);
      }
      
      try {
         connection = DriverManager.getConnection(dbPath);
      }
      catch (SQLException e) {
         DBErrorHandler.connectionError(e);
      }
      
      return connection;
      
   }
   
   private PreparedStatement getPreparedStatement(String sqlString) {
      Connection connection = this.getConnection();
      PreparedStatement preparedStatement = null;
      try {
         preparedStatement = connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
         preparedStatement.setQueryTimeout(30);
      } catch (SQLException e) {
         DBErrorHandler.preparedStatementError(e);
      }
      
      return preparedStatement;
   }
   
   private void destroyPreparedStatement(PreparedStatement preparedStatement) {
      try {
         if (preparedStatement.getConnection() != null) {
            preparedStatement.getConnection().close();
         }
      } catch (SQLException e) {
         DBErrorHandler.preparedStatementError(e);
      }
   }
      
   private void insert(PreparedStatement preparedStatement, DBComponent dbComponent) {
      try {
         preparedStatement.execute();
         // récupérer l'identifiant créer par la BDD
         ResultSet result = preparedStatement.getGeneratedKeys();
         result.next();
         dbComponent.setId(result.getInt(1));
         
      } catch (SQLException e) {
         DBErrorHandler.executeError(e);
      }
   }
   
   private void update (PreparedStatement preparedStatement) {
      try {
         preparedStatement.execute();      
      } catch (SQLException e) {
         DBErrorHandler.executeError(e);
      }
   }
   
   private ResultSet select (PreparedStatement preparedStatement) {
      ResultSet resultSet = null;
      try {
         resultSet = preparedStatement.executeQuery(); 
      } catch (SQLException e) {
         DBErrorHandler.executeError(e);
      }
      return resultSet;
   }
   
   public DBUser createDBUser() {
      return new DBUser();
   }
   
   public DBUser getUBUser(int id) {

      String sqlString = "SELECT Use_Id, firstName, lastName FROM User WHERE Use_ID = ?";
      PreparedStatement preparedStatement = this.getPreparedStatement(sqlString);
      DBUser dbUser = null;
      
      try {
         preparedStatement.setInt(1, id);
         ResultSet result = this.select(preparedStatement);
         
         result.next();
         dbUser = new DBUser();
         dbUser.setId((result.getInt(1)));
         dbUser.setFirstName(result.getString(2));
         dbUser.setLastName(result.getString(3));

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         this.destroyPreparedStatement(preparedStatement);
      }
      return dbUser;
   }
   
   public LinkedList<DBUser> getAllDBUsers() {

      String sqlString = "SELECT Use_Id, firstName, lastName FROM User";
      PreparedStatement preparedStatement = this.getPreparedStatement(sqlString);
      DBUser dbUser;
      LinkedList<DBUser> dbUsers = new LinkedList<DBUser>();
      
      try {
         ResultSet result = this.select(preparedStatement);
         
         while (result.next()) {
            dbUser = new DBUser();
            dbUser.setId((result.getInt(1)));
            dbUser.setFirstName(result.getString(2));
            dbUser.setLastName(result.getString(3));
            dbUsers.add(dbUser);
         }

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         this.destroyPreparedStatement(preparedStatement);
      }
      return dbUsers;
   }
   
   public void saveToDatabase(DBUser dbUser) {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         if (dbUser.getId() == null) {
            sqlString = "INSERT INTO User " +
                        "VALUES (null, ?, ?)";
            preparedStatement = this.getPreparedStatement(sqlString);
            preparedStatement.setString(1, dbUser.getFirstName());
            preparedStatement.setString(2, dbUser.getLastName());
            this.insert(preparedStatement, dbUser);
         } else {
            sqlString = "UPDATE User " +
                        "SET firstName = ?, lastName = ? " +
                        "WHERE Use_Id = ?";
            preparedStatement = this.getPreparedStatement(sqlString);
            preparedStatement.setString(1, dbUser.getFirstName());
            preparedStatement.setString(2, dbUser.getLastName());
            preparedStatement.setInt(3, dbUser.getId());
            this.update(preparedStatement);
         }
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         this.destroyPreparedStatement(preparedStatement);
      }
   }
   
   
   public DBAccount createDBAccount() {
      return new DBAccount();
   }
   
   public DBAccount getDBAccount(int id) {

      String sqlString = "SELECT Acc_ID, Name, BankName, AccountNumber, Amount, AccountLimit FROM Account WHERE Use_ID = ?";
      PreparedStatement preparedStatement = this.getPreparedStatement(sqlString);
      DBAccount dbAccount = null;
      
      try {
         preparedStatement.setInt(1, id);
         ResultSet result = this.select(preparedStatement);
         
         result.next();
         dbAccount = new DBAccount();
         dbAccount.setId((result.getInt(1)));
         dbAccount.setName((result.getString(2)));
         dbAccount.setNameBank((result.getString(3)));
         dbAccount.setAccountNumber((result.getString(4)));
         dbAccount.setAmount((result.getDouble(5)));
         dbAccount.setOverdraftLimit((result.getDouble(6)));     

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         this.destroyPreparedStatement(preparedStatement);
      }
      return dbAccount;
   }
   
   public LinkedList<DBAccount> getAllDBAccounts() {

      String sqlString = "SELECT Acc_Id, Name, BankName, AccountNumber, Amount, AccountLimit FROM Account";
      PreparedStatement preparedStatement = this.getPreparedStatement(sqlString);
      DBAccount dbAccount;
      LinkedList<DBAccount> dbAccounts = new LinkedList<DBAccount>();
      
      try {
         ResultSet result = this.select(preparedStatement);
         
         while (result.next()) {
            dbAccount = new DBAccount();
            dbAccount.setId((result.getInt(1)));
            dbAccount.setName((result.getString(2)));
            dbAccount.setNameBank((result.getString(3)));
            dbAccount.setAccountNumber((result.getString(4)));
            dbAccount.setAmount((result.getDouble(5)));
            dbAccount.setOverdraftLimit((result.getDouble(6)));
            dbAccounts.add(dbAccount);
         }

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         this.destroyPreparedStatement(preparedStatement);
      }
      return dbAccounts;
   }
   
   public void saveToDatabase(DBAccount dbAccount) {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         if (dbAccount.getId() == null) {
            sqlString = "INSERT INTO Account " +
                        "VALUES (null, ?, ?, ?, ?, ?, ?)";
            preparedStatement = this.getPreparedStatement(sqlString);
                        
            preparedStatement.setInt(1, dbAccount.getId());
            preparedStatement.setString(2, dbAccount.getName());
            preparedStatement.setString(3, dbAccount.getNameBank());
            preparedStatement.setString(4, dbAccount.getAccountNumber());
            preparedStatement.setDouble(5, dbAccount.getAmount());
            preparedStatement.setDouble(6, dbAccount.getOverdraftLimit());
            
            this.insert(preparedStatement, dbAccount);
         } else {
            sqlString = "UPDATE Account " +
                        "SET Name = ?, BankName = ?, AccountNumber = ?, Amount = ?, AccountLimit = ? " +
                        "WHERE Acc_Id = ?";
            preparedStatement = this.getPreparedStatement(sqlString);
            preparedStatement.setString(1, dbAccount.getName());
            preparedStatement.setString(2, dbAccount.getNameBank());
            preparedStatement.setString(3, dbAccount.getAccountNumber());
            preparedStatement.setDouble(4, dbAccount.getAmount());
            preparedStatement.setDouble(5, dbAccount.getOverdraftLimit());
            preparedStatement.setInt(7, dbAccount.getId());
            this.update(preparedStatement);
         }
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         this.destroyPreparedStatement(preparedStatement);
      }   
   }
   
   public DBFinancialTransaction createFinancialTransaction() {
       return new DBFinancialTransaction();
    }
   
   public DBFinancialTransaction getFinancialTransaction(int id) {

	  //Manque certaines infos encore (pas à gérer à priori d'ici le 23.04.2013 	
      String sqlString = "SELECT Tra_ID, Amount, Date, Reason, Acc_ID FROM FinacialTransaction WHERE Tra_ID = ?"; 
      PreparedStatement preparedStatement = this.getPreparedStatement(sqlString);
      DBFinancialTransaction dbFinancialTransaction = null;
      
      try {
         preparedStatement.setInt(1, id);
         ResultSet result = this.select(preparedStatement);
         
         result.next();
         dbFinancialTransaction = new DBFinancialTransaction();
         dbFinancialTransaction.setId((result.getInt(1)));
         dbFinancialTransaction.setAmount((result.getDouble(2)));
         dbFinancialTransaction.setDate((result.getDate(3)));
         dbFinancialTransaction.setReason((result.getString(4)));
         dbFinancialTransaction.setDbAccount((result.getInt(5)));

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         this.destroyPreparedStatement(preparedStatement);
      }
      return dbFinancialTransaction;
   }
   
   public LinkedList<DBFinancialTransaction> getAllDBFinancialTransactions() {

	  String sqlString = "SELECT Tra_ID, Amount, Date, Reason, Acc_ID FROM FinacialTransaction"; 
      PreparedStatement preparedStatement = this.getPreparedStatement(sqlString);
      DBFinancialTransaction dbFinancialTransaction = null;
      LinkedList<DBFinancialTransaction> dbFinancialTransactions = new LinkedList<DBFinancialTransaction>();
      
      try {
         ResultSet result = this.select(preparedStatement);
         
         while (result.next()) {
             dbFinancialTransaction = new DBFinancialTransaction();
             dbFinancialTransaction.setId((result.getInt(1)));
             dbFinancialTransaction.setAmount((result.getDouble(2)));
             dbFinancialTransaction.setDate((result.getDate(3)));
             dbFinancialTransaction.setReason((result.getString(4)));
             dbFinancialTransaction.setDbAccount((result.getInt(5)));
             dbFinancialTransactions.add(dbFinancialTransaction);
         }

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         this.destroyPreparedStatement(preparedStatement);
      }
      return dbFinancialTransactions;
   }
   
   public void saveToDatabase(DBFinancialTransaction dbFinancialTransaction) {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         if (dbFinancialTransaction.getId() == null) {
            sqlString = "INSERT INTO FinacialTransaction " +
                        "VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = this.getPreparedStatement(sqlString);
                        
            preparedStatement.setDouble(1, dbFinancialTransaction.getAmount());
            preparedStatement.setDate  (2, (Date) dbFinancialTransaction.getDate());
            preparedStatement.setString(3, dbFinancialTransaction.getReason());
            if (dbFinancialTransaction.getDbCategory() != null) {
               preparedStatement.setInt(4, dbFinancialTransaction.getDbCategory());
            }
            if (dbFinancialTransaction.getDbBudget() != null) {
               preparedStatement.setInt(5, dbFinancialTransaction.getDbBudget());   
            }
            if (dbFinancialTransaction.getDbAccount() != null) {
               preparedStatement.setInt(6, dbFinancialTransaction.getDbAccount());   
            } else { // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! temporairement tricher avec les contraintes de la BDD
               preparedStatement.setInt(6, 0);
            }
            if (dbFinancialTransaction.getDbUser() != null) {
               preparedStatement.setInt(7, dbFinancialTransaction.getDbUser());   
            } else { // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! temporairement tricher avec les contraintes de la BDD
               preparedStatement.setInt(7, 0);
            }
            
            this.insert(preparedStatement, dbFinancialTransaction);
         } else {
            sqlString = "UPDATE FinacialTransaction " +
                        "SET Amount = ?, Date = ?, Reason = ?, Cat_ID = ?, Bud_ID = ?, Acc_ID = ?, Use_ID = ?" +
                        "WHERE Tra_ID = ?";
            preparedStatement.setDouble(1, dbFinancialTransaction.getAmount());
            preparedStatement.setDate  (2, (Date) dbFinancialTransaction.getDate());
            preparedStatement.setString(3, dbFinancialTransaction.getReason());
            preparedStatement.setInt(4, 0);
            preparedStatement.setString(5, "B");
            preparedStatement.setDouble(6, dbFinancialTransaction.getDbAccount());
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, dbFinancialTransaction.getId());
            this.update(preparedStatement);
         }
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         this.destroyPreparedStatement(preparedStatement);
      }   
   }
   
   public DBCategory createCategory() {
       return new DBCategory();
    }
   public DBCategory getCategory(int id) {

	  //Manque certaines infos encore (pas à gérer à priori d'ici le 23.04.2013 	
      String sqlString = "SELECT Cat_ID, Name, Par_Cat_ID FROM Category WHERE Cat_ID = ?"; 
      PreparedStatement preparedStatement = this.getPreparedStatement(sqlString);
      DBCategory dbCategory = null;
      
      try {
         preparedStatement.setInt(1, id);
         ResultSet result = this.select(preparedStatement);
         
         result.next();
         dbCategory = new DBCategory();
         dbCategory.setId((result.getInt(1)));
         dbCategory.setName((result.getString(2)));
         dbCategory.setParentDBCategory((result.getInt(3)));

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         this.destroyPreparedStatement(preparedStatement);
      }
      return dbCategory;
   }
   
   public LinkedList<DBCategory> getAllDBCategory() {

	  String sqlString = "SELECT Cat_ID, Name, Par_Cat_ID FROM Category"; 
      PreparedStatement preparedStatement = this.getPreparedStatement(sqlString);
      DBCategory dbCategory = null;
      LinkedList<DBCategory> dbCategories = new LinkedList<DBCategory>();
      
      try {
         ResultSet result = this.select(preparedStatement);
         
         while (result.next()) {
        	 dbCategory = new DBCategory();
             dbCategory.setId((result.getInt(1)));
             dbCategory.setName((result.getString(2)));
             dbCategory.setParentDBCategory((result.getInt(3)));
             dbCategories.add(dbCategory);
         }

      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         this.destroyPreparedStatement(preparedStatement);
      }
      return dbCategories;
   }  

   public void saveToDatabase(DBCategory dbCategory) {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         if (dbCategory.getId() == null) {
            sqlString = "INSERT INTO Category " +
                        "VALUES (null, ?, ?)";
            preparedStatement = this.getPreparedStatement(sqlString);
                        
            preparedStatement.setString(1, dbCategory.getName());
            if (dbCategory.getParentDBCategory() != null) {
               preparedStatement.setInt(2, dbCategory.getParentDBCategory());
            }
            
            this.insert(preparedStatement, dbCategory);
         } else {
            sqlString = "UPDATE Category " +
                        "SET Name = ?, Par_Cat_ID = ? " +
                        "WHERE Cat_ID = ?";
            preparedStatement = this.getPreparedStatement(sqlString);
            preparedStatement.setString(1, dbCategory.getName());
            preparedStatement.setInt(2, dbCategory.getParentDBCategory());
            preparedStatement.setInt(3, dbCategory.getId());
            
            
            this.update(preparedStatement);
         }
      } catch (SQLException e) {
         DBErrorHandler.resultSetError(e);
      }
      finally {
         this.destroyPreparedStatement(preparedStatement);
      }   
   }
}
