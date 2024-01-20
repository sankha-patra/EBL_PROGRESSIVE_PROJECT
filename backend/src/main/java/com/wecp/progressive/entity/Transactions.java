package com.wecp.progressive.entity;
//import java.util.Date;
import java.sql.Date;


public class Transactions {
    private int transaction_id;
    private int account_id;
    private double amount;
    private Date transaction_date;
    private String transaction_type;

    public Transactions( int transaction_id,int account_id,double amount, Date transaction_date,String transaction_type){
        this.transaction_id=transaction_id;
        this.account_id=account_id;
        this.amount=amount;
        this.transaction_date=transaction_date;
        this.transaction_type=transaction_type;
    }
    public int getTransactionID(){
        return transaction_id;
    }
    public void setTransactionID(int tid){
        transaction_id=tid;
    }
    public int getTransactionAccountID(){
        return account_id;
    }
    public void setTransactionAccountID(int taid){
        account_id=taid;
    }
    public double getTransactionAmount(){
        return amount;
    }
    public void getTransactionAmount(double ta){
        amount=ta;
    }
    public Date getTransactionDate(){
        return transaction_date;
    }
    public void setTransactionDate(Date da){
        transaction_date=da;
    }
    public String getTransactionType(){
        return transaction_type;
    }
    public void setTransactionType(String tt){
        transaction_type=tt;
    }

}
