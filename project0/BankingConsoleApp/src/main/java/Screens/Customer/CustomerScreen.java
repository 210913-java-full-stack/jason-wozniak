package Screens.Customer;

import Screens.Screen;
import models.User;
import utils.DAO;

import java.util.Scanner;

public class CustomerScreen extends Screen {



    public void render() {


    }

    public void render(User a){
        DAO d = new DAO();
        boolean quit = false;
        while(!quit){

            System.out.println("+++++++++++++++++++++++++");
            System.out.println("+   Do you wish to:     +\n+    1. Add Account     +\n+    2. Deposit         +\n+    3. Withdraw        +\n+    4. Show Balance    +\n+    5. Quit            +");
            System.out.println("+++++++++++++++++++++++++");
            Scanner userinput = new Scanner(System.in);
            String input = userinput.next();
            switch (input) {
                    case "1":
                        d.addAccount(a);
                        break;
                    case "2":
                        d.deposit(a);
                        break;
                    case "3":
                        d.withdraw(a);
                        break;
                    case "4":
                        d.balance(a);
                        break;
                    case "5":
                    case "Q":
                        quit = true;
                        break;
                }
        } // end WHILE

    }
}
