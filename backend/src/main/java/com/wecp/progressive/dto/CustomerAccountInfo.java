package com.wecp.progressive.dto;

public class CustomerAccountInfo {

    private int customerId;
    private String customerName;
    private String email;
    private int accountId;
    private double balance;

    public CustomerAccountInfo( int customerId,String customerName,String email,int accountId,double balance){
        this.customerId=customerId;
        this.customerName=customerName;
        this.email=email;
        this.accountId=accountId;
        this.balance=balance;
    }
    public int getCustomerAccountInfoCustomerID(){
        return customerId;
    }
    public void setCustomerAccountInfoCustomerID(int cid){
        customerId=cid;
    }
    public String getCustomerAccountInfoName(){
        return customerName;
    }
    public void setCustomerAccountInfoName(String cnm){
        customerName=cnm;
    }
    public String getCustomerAccountInfoEmail(){
        return email;
    }
    public void setCustomerAccountInfoEmail(String enm){
        email=enm;
    }
    public int getCustomerAccountInfoAccountID(){
        return accountId;
    }
    public void setCustomerAccountInfoAccountID(int acn){
        accountId=acn;
    }
    public double getCustomerAccountInfoBalance(){
        return balance;
    }
    public void getCustomerAccountInfoBalance(double blnc){
        balance=blnc;
    }
    

    
}
