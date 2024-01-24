package com.wecp.progressive.entity;
import java.util.*;



public class Customers implements Comparable<Customers>{
    private int customerID;
    private String name;
    private String email;
    private String username;
    private String password;
    private String role;

    public Customers( int customerID,String name, String email,String username,String password,String role){
        this.customerID=customerID;
        this.name=name;
        this.email=email;
        this.username=username;
        this.password=password;
        this.role=role;
    }
    public Customers(){
        
    }

    public int getCustomerID(){
        return customerID;
    }
    public void setCustomerID(int cstid){
        customerID=cstid;
    }
    public String getCustomerName(){
        return name;
    }
    public void setCustomerName(String cstnm){
        name=cstnm;
    }
    public String getCustomerEmail(){
        return email;
    }
    public void setCustomerEmail(String eml){
        email=eml;
    }
    public String getCustomerUserName(){
        return username;
    }
    public void getCustomerUserName(String usrnm){
        username=usrnm;
    }
    public String getCustomerPassword(){
        return password;
    }
    public void getCustomerPassword(String pswrd){
        password=pswrd;
    }
    public String getCustomerRole(){
        return role;
    }
    public void setCustomerRole(String rl){
        role=rl;
    }

    public int compareTo(Customers obj){
        return this.getCustomerName().compareTo(obj.getCustomerName());
    }
}

// class RoleCompare implements Comparator<Customers>{
//     public int compare(Customers a,Customers b){
//         return a.getCustomerRole().compareTo(b.getCustomerRole());
//     }
// }

// class PasswordCompare implements Comparator<Customers>{
//     public int compare(Customers a,Customers b){
//         return a.getCustomerPassword().compareTo(b.getCustomerPassword());
//     }
// }

class UserCompare implements Comparator<Customers>{
    public int compare(Customers a,Customers b){
        return a.getCustomerUserName().compareTo(b.getCustomerUserName());
    }
}

class EmailCompare implements Comparator<Customers>{
    public int compare(Customers a,Customers b){
        return a.getCustomerEmail().compareTo(b.getCustomerEmail());
    }
}

class NameCompare implements Comparator<Customers>{
    public int compare(Customers a,Customers b){
        return a.getCustomerName().compareTo(b.getCustomerName());
    }
}