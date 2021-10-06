//package DAOs;
//
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public interface BankingCRUD <T>{
//
//
//
//    //Create
//      //customers - register user and give account
//    public boolean newCust(String customer_id, String first_name, String last_name, String password, String username) throws SQLException;
//      //account - First instance
//    public boolean newAcct(int id, double bal, String type) throws SQLException;
//
//    //Read
//      //balance
////    public ArrayList<T> acctBalance (int id) throws SQLException;
//      //verify username - password
//    public boolean checkUser(String username, String password) throws SQLException;
//      //confirmation?? Know your customer
//
//      //test SELECT * FROM customers  getAll()
//    public void testDB() throws SQLException; // just for testing the database
//
//
//    //Update
//      //Deposit
//    public boolean deposit(double money) throws SQLException;
//      //Withdrawl
//    public boolean withdrawl(double money) throws SQLException;
//      //Transfer to another account
//    public boolean transfer(double money) throws SQLException;
//
//    //Delete
//      public boolean delAcct(int id);
//      //Close Account
//}
