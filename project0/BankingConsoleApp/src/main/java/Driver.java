import Screens.MainMenu;

import java.text.NumberFormat;

public class Driver {
    public static void main(String args[]) {
        MainMenu main = new MainMenu();
        main.render();
    }


    //Hint for print format:
    //NumberFormat nf = NumberFormat.getCurrencyInstance();
    //or: System.out.printf("Balance: $%.2f", balance)



}//A fine entry point for many a would-be program
/////////////////////////////////////////////////
//        try  // connect to the database
//        {
//            Connection conn = ConnectionManager.getConnection();
//            String sql = "SELECT * FROM customers";
//            PreparedStatement prepareStmt = conn.prepareStatement(sql);
//            ResultSet rs=prepareStmt.executeQuery(); //result set
//
//            while(rs.next())
//            {
//                System.out.println(rs.getString("first_name"));
//            }
//
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }
/////////////////////////////////////////////////////////////
//
//        System.out.flush(); // attempted to clear the console... failed.//TROUBLESHOOT
//        System.out.println("Welcome to the banking app!");
//        Scanner sc = new Scanner(System.in); //standard functionality located in java.util
//        boolean y = Menu.welcome();
//        System.out.println("Do you wish to:\n 1. Register(R)\n 2. Login(L)\n 3. Quit(Q)");
//        String welcome = sc.nextLine().toUpperCase();
//        switch (welcome) {
//            case "R":
//                if (Menu.RegisterUser())
//                    System.out.println("In case R - Register...");
//                break;
//            case "L":
//                if (Menu.UserLogin())
//                    System.out.println("In case L - Login...");
//                break;
//            case "Q":
//                Menu.programQuit();
//                break;
//        }
//        if (welcome == "R") {
//            System.out.println("We look forward to serving your banking needs.\n Please enter your name:\n");
//        } else if (welcome == "L") {
//            String name = sc.nextLine();
//            System.out.println("Welcome " + name + ". How can I help you today?");
//            System.out.println("1. Deposit\n 2. Withdrawl\n 3. Check Balance\n 4. View History\n");
//        }
//    }
//}
//Description
//        Your first project should demonstrate your knowledge of the following topics:
//
//        Java
//        SQL
//        JDBC
//        Basic Data Structures
//        Basic File I/O
//        You will be building a console application that persists data in a database with at least 3 tables which adhere to 3rd normal form (3NF). The basic form of this project should be that of a console-based banking app. If you want to mix it up a bit and can come up with a project idea that meets all the same requirements, contact your trainer to discuss and develop user stories. If you decide to go with the bank app, it should implement all of the required user stories listed below.
//
//        You will be expected to complete the minimum viable product by the deadline and give a brief 5 minute presentation demonstrating your project and answering questions from the QC team.
//
//        Minimum Requirements
//        Basic validation (no negative deposits/withdrawals, malformed emails, names with numbers, etc.)
//        All exceptions are properly caught and handled
//        Proper use of OOP principles
//        Documentation (all classes and methods have basic inline documentation)
//        Use of custom data structures (do not use java.util Collection types! Implement your own List)
//        SQL Data Persistance (at least 3 tables; all 3NF (normal form))
//
//        Bonus Features
//        Unit tests for persistance-layer classes
//        Logging messages and exceptions to a file
//        Banking App User Stories
//        These are user stories to describe the banking app. If you are not building the banking app for your project, you will need to discuss with your trainer to establish proper user stories.
//
//        Minimum Viable Product
//        As a user, I can register for an account.
//        As a user, I can login to my account.
//        As a user, I can create one or more bank accounts.
//        As a user, I can deposit funds into my account(s).
//        As a user, I can withdraw funds from my account(s).
//        As a user, I can display all of my accounts in a list which includes current balance.
//        All monetary amounts should be displayed in a proper currency format ($1,234.56).
//        Bonus Stories
//        As a user, I can view the transaction history for an account.
//        As a user, I can share an account with another user.
//        As a user, I can transfer funds between accounts.
//        Tech Stack
//        You should be employing the following technologies in your project.
//
//        Java 8
//        Apache Maven
//        MariaDB deployed on AWS RDS
//        Deadline & Presentation
//        Finalized version of your project must be pushed to your repository within the training originzation by 9:00 AM Central time on the date of the presentation showcase. Commits after that time will not be considered. The most recent commit submitted before that time will be the version of the project that is graded.
//        Presentation Showcase (Due Date): Wednessday, October 6th 2021, 9:00 AM CDT.
//        You will give a brief (<=5 minute) presentation of your project. Be prepared to answer questions about your work from the QC team.
//        Your work MUST BE YOUR OWN. Collaboration is allowed and encouraged, but at the end of the project you must have an excellent understanding of every line of code in your project and be able to answer questions about any part of it.