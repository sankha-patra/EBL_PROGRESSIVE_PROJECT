package com.wecp.progressive.entity;
import java.util.*;

public class Accounts implements Comparable<Accounts>{
    private int accountID;
    private int customerID;
    private double balance;

    public Accounts(int accountID,int customerID,double balance){
        this.accountID=accountID;
        this.customerID=customerID;
        this.balance=balance;
    }
    public Accounts(){
        
    }
    public int getAccountID(){
        return accountID;
    }
    public void setAccountID(int acntd){
        accountID=acntd;
    }
    public int getCustomerID(){
        return customerID;
    }
    public void setCustomerID(int cstd){
        customerID=cstd;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balnc){
        balance=balnc;
    }

    public int compareTo(Accounts obj){
        if(this.getBalance()>obj.getBalance()){
            return 1;
        }
        if(this.getBalance()<obj.getBalance()){
            return -1;
        }
        else {
            return 0;
        }
    }

}

class AccountIDCompare implements Comparator<Accounts>{
    public int compare(Accounts a,Accounts b){
        return a.getAccountID()-b.getAccountID();
    }
}

class CustomerIDCompare implements Comparator<Accounts>{
    public int compare(Accounts a,Accounts b){
        return a.getCustomerID()-b.getCustomerID();
    }
}