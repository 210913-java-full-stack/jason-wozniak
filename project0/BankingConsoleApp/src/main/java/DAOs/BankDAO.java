//package DAOs;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class BankDAO implements BankingCRUD{
//    private Connection conn;
//
//    public BankDAO(Connection conn) {
//        this.conn = conn;
//    }
//// getAll()
//
//    @Override
//    public boolean newCust(String customer_id, String first_name, String last_name, String password, String username) throws SQLException {
//        return false;
//    }
//
//    @Override
//    public boolean newAcct(int id, double bal, String type) throws SQLException {
//        return false;
//    }
//
////    @Override
////    public Array<T> acctBalance(int id) throws SQLException {
////
////////
////    }
//    @Override
//    public boolean checkUser(String user, String password) throws SQLException {
//        return false;
//    }
//
//    @Override
//    public void testDB() throws SQLException {
//        String str = "SELECT * FROM customers";
//        PreparedStatement selectStatement = conn.prepareStatement(str);
//        ResultSet exist = selectStatement.executeQuery();
//
//        System.out.println(exist);
//    }
//
//    @Override
//    public boolean deposit(double money) throws SQLException {
//        return false;
//    }
//
//    @Override
//    public boolean withdrawl(double money) throws SQLException {
//        return false;
//    }
//
//    @Override
//    public boolean transfer(double money) throws SQLException {
//        return false;
//    }
//
//    @Override
//    public boolean delAcct(int id) {
//        return false;
//    }
//}
