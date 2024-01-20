package com.wecp.progressive.dao;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Transactions;
import java.util.*;
import java.sql.*;

public class TransactionDAOImpl implements TransactionDAO{
    private Connection connection;

    public TransactionDAOImpl(){
        try{
            connection=DatabaseConnectionManager.getConnection();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    public int addTransaction(Transactions transaction){

        String sql="INSERT INTO transactions(account_id,amount,transaction_date,transaction_type) VALUES(?,?,?,?,?)";
        int n=0;
        try(PreparedStatement ps=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1,transaction.getTransactionAccountID());
            ps.setDouble(2,transaction.getTransactionAmount());
            ps.setDate(3, transaction.getTransactionDate());
            ps.setString(4,transaction.getTransactionType());
            

            ResultSet generatedKeys=ps.getGeneratedKeys();
            if(generatedKeys.next()){
                n=generatedKeys.getInt(1);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return n;
    }
    public Transactions getTransactionById(int transactionId){
        String sql="SELECT * FROM transactions WHERE transaction_id=?";
        Transactions obj=null;
       
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1,transactionId);
            ps.executeUpdate();
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                 obj=new Transactions(rs.getInt(1), rs.getInt(2), rs.getDouble(3),rs.getDate(4),rs.getString(5));
            }
            else{
                throw new Exception("ID not found");
            }

        }
        catch(SQLException e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return obj;

    }


    public void updateTransaction(Transactions transaction){
        String sql="UPDATE accounts SET account_id=? amount=? transaction_date=? transaction_type=?  WHERE transaction_id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1,transaction.getTransactionAccountID());
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public void deleteTransaction(int transactionId) {
        String sql="DELETE FROM transactions WHERE transactio_id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1,transactionId);
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public List<Transactions> getAllTransactions(){
        List<Transactions> al=new ArrayList<Transactions>();
        String sql="SELECT * FROM transactions";
        Transactions obj=null;
        try(Statement st=connection.createStatement()){
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                obj=new Transactions(rs.getInt(1),rs.getInt(2),rs.getDouble(3),rs.getDate(4),rs.getString(5));
                al.add(obj);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return al;
    }

    public void close(){
        try{
            if(connection!=null){
                connection.close();
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
}
