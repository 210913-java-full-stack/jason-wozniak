package utils;

import models.Account;
import models.User;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class DAO {


    public void addAccount(User a) {
        Request.depositAmount();
        Scanner scan = new Scanner(System.in);

        double dep = scan.nextDouble();
        // CREATE A NEW ACCOUNT IN DATABASE, grab new account number
        int lastAccountId = 0;
        try{
            Connection conn = ConnectionManager.getConnection();
            String findID = "SELECT * FROM accounts;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(findID);
            while (rs.next()){
                lastAccountId = rs.getInt(1);
                rs.getRow();
            }
            lastAccountId++;



            String sql = "INSERT INTO accounts (account_id, account_balance, account_type) VALUES (?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,lastAccountId);
            pstm.setDouble(2,dep);
            pstm.setString(3,"Checking");
            pstm.executeUpdate();
            Account p = new Account(lastAccountId,dep, "Checking");
            a.getAccounts().add(p);


            System.out.println("?DEBUG DAO.addAccount - a.getId(): " + a.getId());

            // ADD JUNCTION TABLE INSERT HERE TO COMPLETE THE THINGS!

            String sql2 = "INSERT INTO junction_accounts_customers (account_id, customer_id) VALUES (?,?)";
            PreparedStatement pstm2 = conn.prepareStatement(sql2);
            pstm2.setInt(1,lastAccountId);
            pstm2.setInt(2,a.getId());
            pstm2.executeUpdate();


        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(lastAccountId + " is the account you created.");

    }

    public boolean deposit(User a) {
        boolean isValid = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number to deposit: ");
        int acct = sc.nextInt(); // scan the account
        for (Account x : a.getAccounts()) {

            if (x.getAccount_id() == acct) {
                isValid = true;
                break;
            }

        }


        if (isValid) {
            System.out.println("Enter the amount to deposit: ");
            double wdrw = sc.nextDouble();
            ////////////////////////////  CONNECTION TO DATABASE WITHDRAW///////////////////////////
            try  // this block used to test basic connectivity to database
            {
                Connection conn = ConnectionManager.getConnection();  // create connection to database
                String sql = "UPDATE accounts a SET a.account_balance = (a.account_balance + ?) WHERE account_id = ?";
                PreparedStatement prepareStmt = conn.prepareStatement(sql); //prepare SQL statement to be used on DB
                prepareStmt.setDouble(1,wdrw); // replace first ? with wdrw (Double)
                prepareStmt.setInt(2,acct); // replace second ? with acct (Int)
                ResultSet rs = prepareStmt.executeQuery(); //result set - possibly multiple rows
                System.out.println("rs: " + rs);
                while (rs.next()) { // List one or more account balances
                    String atyp = rs.getString("account_type");
                    String abal = rs.getString("account_balance");
                    System.out.println("Your balance for " + atyp + " account # " + acct + ": " + abal);
                }

            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
            ////////////////////////////  CONNECTION TO DATABASE END WITHDRAW///////////////////////////

            System.out.println("Deposited " + wdrw + " dollars. from Account: " + acct);  // confirm amount withdrawn
            // withdraw from database
            return true;} else {return false;}
    }
//        boolean isValid = false;
//        Scanner sc = new Scanner(System.in);
//        Request.depositAccount();
//        int acct = sc.nextInt(); // scan the account
//        for (Account x : a.getAccounts()) {
//
//            if (x.getAccount_id() == acct) {
//                isValid = true;
//                break;
//            }
//
//        }
//
//
//        if (isValid) {
//            Request.depositAmount();
//            double dep = sc.nextDouble();
//            ////////////////////////////  CONNECTION TO DATABASE DEPOSIT///////////////////////////
//            try
//            {
//                Connection conn = ConnectionManager.getConnection();
//                String sql = "UPDATE accounts a SET a.account_balance = (a.account_balance + ?) WHERE account_id = ?";
//                //System.out.println(sql);
//                PreparedStatement prepareStmt = conn.prepareStatement(sql);
//                prepareStmt.setDouble(1, dep);
//                prepareStmt.setInt(2, a.getId());
//                ResultSet rs = prepareStmt.executeQuery(); //result set
//                //TODO MAKE SURE ALL THE METHODS TAKE IN A USER AND DON
//
//                while (rs.next()) {
//                    String atyp = rs.getString("account_type");
//                    String abal = rs.getString("account_balance");
//                    System.out.println("Your balance for " + atyp + " account # " + acct + ": " + abal);
//                    // TROUBLESHOOT... Why isn't abal showing?
//                }
//
//            } catch (SQLException | IOException e) {
//                e.printStackTrace();
//            }
//            ////////////////////////////  CONNECTION TO DATABASE END DEPOSIT///////////////////////////
//            System.out.println("Deposited " + dep + " dollars to Account: " + acct); // confirm amount deposited
//            // send deposit to database
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean withdraw(User a) {
        boolean isValid = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number to withdraw: ");
        int acct = sc.nextInt(); // scan the account
        for (Account x : a.getAccounts()) {

            if (x.getAccount_id() == acct) {
                isValid = true;
                break;
            }

        }


        if (isValid) {
        System.out.println("Enter the amount to withdraw: ");
        double wdrw = sc.nextDouble();
        ////////////////////////////  CONNECTION TO DATABASE WITHDRAW///////////////////////////
        try  // this block used to test basic connectivity to database
        {
            Connection conn = ConnectionManager.getConnection();  // create connection to database
            String sql = "UPDATE accounts a SET a.account_balance = (a.account_balance - ?) WHERE account_id = ?";
            PreparedStatement prepareStmt = conn.prepareStatement(sql); //prepare SQL statement to be used on DB
            prepareStmt.setDouble(1,wdrw); // replace first ? with wdrw (Double)
            prepareStmt.setInt(2,acct); // replace second ? with acct (Int)
            ResultSet rs = prepareStmt.executeQuery(); //result set - possibly multiple rows
            System.out.println("rs: " + rs);
            while (rs.next()) { // List one or more account balances
                String atyp = rs.getString("account_type");
                String abal = rs.getString("account_balance");
                System.out.println("Your balance for " + atyp + " account # " + acct + ": " + abal);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        ////////////////////////////  CONNECTION TO DATABASE END WITHDRAW///////////////////////////

        System.out.println("Withdrew " + wdrw + " dollars. from Account: " + acct);  // confirm amount withdrawn
        // withdraw from database
        return true;} else {return false;}
    }

    public boolean balance(User a) {



                ////////////////////////////  CONNECTION TO DATABASE BALANCE///////////////////////////
                try  // this block used to test basic connectivity to database
                {
                    Connection conn = ConnectionManager.getConnection();
                    String sql = "SELECT * FROM accounts a JOIN junction_accounts_customers jac  " +
                            "ON a.account_id = jac.account_id JOIN customers c ON jac.customer_id = c.customer_id WHERE c.customer_id = ?";
                    PreparedStatement prepareStmt = conn.prepareStatement(sql);
                    prepareStmt.setInt(1, a.getId());
                    ResultSet rs = prepareStmt.executeQuery(); //result set
                    System.out.println("DEBUG DAO.balance -  user id: " + a.getId()); // TROUBLESHOOTING
                    while(rs.next()) {
                        String acct = rs.getString("account_id");
                        String atyp = rs.getString("account_type");
                        String abal = rs.getString("account_balance");
                        System.out.printf("%s Account#: %s: $%s%n",atyp, acct, abal);
                    }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        ////////////////////////////  CONNECTION TO DATABASE END BALANCE///////////////////////////
        return true;
    }
//    public static boolean programQuit(){ //quit program
//        System.exit(0);
//        return true;
//    }
//    public static boolean UserLogin (){
//        Scanner sc = new Scanner(System.in);
//        // need to get input from persistent source... database for FIRSTNAME and LASTNAME
//
//        System.out.println("Please enter your username: ");
//        String uname = sc.nextLine();
//        System.out.println("Please enter a password to use for logging in: ");
//        String pw = sc.nextLine();
//        if(uname == "Jason" && pw == "Boss"){ // need to retrieve from database USERNAME and PASSWORD
//            System.out.println("Jason" + " " + "Wozniak" + " " + "your username is: " + uname + " and password is: " + pw);
//            System.out.println("You have logged in");
//            return true;}
//        else{return false;}}


    public static void RegisterUser() {
        Scanner sc = new Scanner(System.in);

        Request.firstname();
        String fname = sc.nextLine();

        Request.lastname();
        String lname = sc.nextLine();

        System.out.println("Welcome " + fname + " " + lname + ". We are glad to see you.");

        Request.username();
        String uname = sc.nextLine();

        String pw;
        do{Request.newlogin();
        pw = sc.nextLine();
        } while(!Valid.validPass(pw));

        ////////////////////////////  CONNECTION TO DATABASE REGISTER///////////////////////////

        try {

            Connection conn = ConnectionManager.getConnection();
            String sql1 = "INSERT INTO customers (first_name, last_name, username, password) VALUES(?,?,?,?)";
//            String sql2 = "SELECT * FROM accounts WHERE account_id = " + acct;
//            String sql3 = "SELECT * FROM accounts WHERE account_id = " + acct;
            PreparedStatement prepareStmt = conn.prepareStatement(sql1);
            prepareStmt.setString(1,fname);
            prepareStmt.setString(2,lname);
            prepareStmt.setString(3,uname);
            prepareStmt.setString(4,pw);
            prepareStmt.executeUpdate(); //result set


        } catch (SQLException | IOException e){
            e.printStackTrace();
    }
}
}

