package models;

//abstract class - methods ... account_id, account_balance, account_type
public class Account {
    private int account_id;
    private double account_balance;
    private String account_type;



    public Account(int id, double bal, String type){ // Constructor
        account_id = id;
        account_balance = bal;
        account_type = type;
    }

    public Account(double account_balance, String account_type) {
        this.account_balance = account_balance;
        this.account_type = account_type;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }
}

