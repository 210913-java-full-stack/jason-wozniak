package Screens;

import utils.DAO;

import java.util.Scanner;

public class MainMenu extends Screen{


    public void render() {

        boolean quit = false;
        while(!quit){
            Screen.clearScreen();
            System.out.println("+++++++++++++++++++++++");
            System.out.println("+ Welcome to the Bank +\n+    1) Register      +\n+    2) Login         +\n+    3) Quit          +");
            System.out.println("+++++++++++++++++++++++");
            Scanner sc = new Scanner(System.in);
            String reg = sc.next();
            switch(reg){
                case "R":
                case "1":
                    DAO.RegisterUser();
                break;
                case "2":
                case "L":
                    Login l = new Login();
                    l.render();
                    break;
                case "3":
                case "Q":
                    quit = true;
                    break;


            }

        }
    }
}
