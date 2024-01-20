package com.wecp.progressive.dao;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Accounts;
import java.sql.*;

import java.util.*;

// FOR JDBC
// public class AccountDAOImpl implements AccountDAO{
//     private Connection connection;
//     public AccountDAOImpl(){
//         try{
//             connection=DatabaseConnectionManager.getConnection();
//         }
//         catch(SQLException e){
//             System.out.println(e);
//         }
//     }
//         public int addAccount(Accounts accounts){

//             String sql="INSERT INTO accounts(customer_id,balance) VALUES(?,?)";
//             int n=0;
//             try(PreparedStatement ps=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
//                 ps.setInt(1,accounts.getCustomerID());
//                 ps.setDouble(2,accounts.getBalance());
                

//                 ResultSet generatedKeys=ps.getGeneratedKeys();
//                 if(generatedKeys.next()){
//                     n=generatedKeys.getInt(1);
//                 }
//             }
//             catch(SQLException e){
//                 System.out.println(e);
//             }
//             return n;
//         }

//         public void updateAccount(Accounts accounts){
//             String sql="UPDATE accounts SET customer_id=? balance=? WHERE account_id=?";
//             try(PreparedStatement ps=connection.prepareStatement(sql)){
//                 ps.setInt(1,accounts.getAccountID());
//                 ps.executeUpdate();
//             }
//             catch(SQLException e){
//                 System.out.println(e);
//             }
//         }


//         public Accounts getAccountById(int accountId){
//             String sql="SELECT * FROM accouns WHERE account_id=?";
//             Accounts obj=null;
           
//             try(PreparedStatement ps=connection.prepareStatement(sql)){
//                 ps.setInt(1,accountId);
//                 ps.executeUpdate();
//                 ResultSet rs=ps.executeQuery();
//                 if(rs.next()){
//                      obj=new Accounts(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
//                 }
//                 else{
//                     throw new Exception("ID not found");
//                 }

//             }
//             catch(SQLException e){
//                 System.out.println(e);
//             }
//             catch(Exception e){
//                 System.out.println(e);
//             }
//             return obj;

//         }

//         public void deleteAccount(int accountId){
//             String sql="DELETE FROM accounts WHERE account_id=?";
//             try(PreparedStatement ps=connection.prepareStatement(sql)){
//                 ps.setInt(1,accountId);
//                 ps.executeUpdate();

//             }
//             catch(SQLException e){
//                 System.out.println(e);
//             }
//         }

//         public List<Accounts> getAllAccounts(){
//             List<Accounts> al=new ArrayList<Accounts>();
//             String sql="SELECT * FROM accounts";
//             Accounts obj=null;
//             try(Statement st=connection.createStatement()){
//                 ResultSet rs=st.executeQuery(sql);
//                 while(rs.next()){
//                     obj=new Accounts(rs.getInt(1),rs.getInt(2),rs.getDouble(3));
//                     al.add(obj);
//                 }
//             }
//             catch(SQLException e){
//                 System.out.println(e);
//             }
//             return al;
//         }

//         public void close(){
//             try{
//                 if(connection!=null){
//                     connection.close();
//                 }
//             }
//             catch(SQLException e){
//                 System.out.println(e);
//             }
//         }

// }

// using ArrayList as backend


public class AccountDAOImpl implements AccountDAO{

    List<Accounts> al=new ArrayList<Accounts>();
    public int addAccount(Accounts accounts){
        int i=0;
        for(Accounts obj:al){
            if(obj.getAccountID()==accounts.getAccountID()){
                i=-1;
                break;
            }
            continue;
        }
        if(i==0){
            al.add(accounts);
            return 1;
        }
        else {
            return -1;
        }
    }
    public Accounts getAccountById(int accountId){
        
        Accounts obj=null;
        for(Accounts ac:al){
            if(ac.getAccountID()==accountId){
                obj=new Accounts(ac.getAccountID(),ac.getCustomerID(),ac.getBalance());
                break;
            }
            continue;
        }
        return obj;
    }
    public void updateAccount(Accounts accounts){
        List<Accounts> al=getAllAccounts();
        for(int i=0;i<al.size();i++){
            if(al.get(i).getAccountID()==accounts.getAccountID()){
                al.set(i,accounts);
                break;
            }
            else{
                continue;
            }
        }
    }
    public void deleteAccount(int accountId){
        Iterator<Accounts> itr = al.iterator();
        while (itr.hasNext()) {
            if (itr.next().getAccountID() == accountId) {
                itr.remove(); 
                break; 
            }
            continue;
        }
    }
    public List<Accounts> getAllAccounts(){
        return al;
    }

}