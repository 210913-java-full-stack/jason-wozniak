package models;


import datastructures.MyArray;

// abstract classes - methods that will be used... account_name, account_id, balance
public class User {
    private String first_name;
    private String last_name;
    private int id;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyArray<Account> getAccounts() {
        return accounts; //returning the array of accounts... matches SQL database
    }

    public void setAccounts(MyArray<Account> accounts) {
        this.accounts = accounts;
    }

    private MyArray<Account> accounts;

    public User(int id,String first_name, String last_name, MyArray<Account> accounts) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.id = id;
        this.accounts = accounts;
    }
}


