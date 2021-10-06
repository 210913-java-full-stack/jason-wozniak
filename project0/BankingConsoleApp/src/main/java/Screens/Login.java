package Screens;

import Screens.Customer.CustomerScreen;
import datastructures.MyArray;
import models.Account;
import models.User;
import utils.ConnectionManager;
import utils.Request;

import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login extends Screen{

     public void render() {
        boolean quit = false;
        while(!quit){
            Screen.clearScreen();
            System.out.print("Login Screen\n");
            Request.username();
            Scanner sc = new Scanner(System.in);
            String username = sc.next();
            Request.password();
//            Console console = System.console();  // Attempt to give password privacy
//            char[] passwordChars = console.readPassword();
//            String password = new String(passwordChars);
//            System.out.println("DEBUG - Login.render - password:" + password);
            String password = sc.next();
            try{
                Connection conn = ConnectionManager.getConnection();
                String sql = "SELECT * FROM customers WHERE username = ? AND password = ?";
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setString(1, username);
                pstm.setString(2, password);
//                ResultSet rs = pstm.executeQuery();
//
//                rs.next(); // move the cursor to the next line
                //grab the id
                int tmpUserID = 0;
                String tmpFirstName = null;
                String tmpLastName = null;

                //create another result set to loop through for the user accounts
                ResultSet rs2 = pstm.executeQuery();



                //while loop through the RS
                while(rs2.next()){
                    tmpUserID = rs2.getInt("customer_id");
                    tmpFirstName = rs2.getString("first_name");
                    tmpLastName = rs2.getString("last_name");
                }
                // System.out.println("DEBUG Login.render - Temp user: " + tmpUserID + ", " + tmpFirstName + " " + tmpLastName);


                //Here I would do a second query to gather all the account info for your array, and leave the
                // user-specific stuff above
//                String sql = "SELECT * FROM customers c JOIN junction_accounts_customers jac ON c.customer_id = jac.customer_id " +
//                        "JOIN accounts a ON jac.account_id = a.account_id WHERE c.username = ? AND c.password = ?";
                //create an array list for the account Objects to be added to
                MyArray<Account> accountArray = new MyArray<>();
                /*
                                    //grab the account info
                    int accountID = rs2.getInt("account_id");
                    double balance = rs2.getDouble("account_balance");
                    String type = rs2.getString("account_type");


                    // create account with the info from above.
                    Account tmpAcc = new Account(accountID, balance, type);
                    accountArray.add(tmpAcc);
                 */



                //create a new customer
                User newUser = new User(tmpUserID, tmpFirstName, tmpLastName, accountArray);
                System.out.println(newUser.getFirst_name() + " " + newUser.getLast_name() + " " + newUser.getId());
                // create customer screen....
                CustomerScreen cs = new CustomerScreen();
                cs.render(newUser);
                quit=true;








            // catch when the username and password don't exist in the database.
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
