package com.wecp.progressive.dao;
import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.dto.CustomerAccountInfo;
import com.wecp.progressive.config.DatabaseConnectionManager;
import java.sql.*;
import java.util.*;



public class CustomerDAOImpl implements CustomerDAO{
    private Connection connection;
    public CustomerDAOImpl(){
        try{
            connection =DatabaseConnectionManager.getConnection();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public int addCustomer(Customers customers){
        String sql="INSERT INTO customers(name,email,username,password,role) VALUES(?,?)";
        int n=0;
        try(PreparedStatement ps=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,customers.getCustomerName());
            ps.setString(2,customers.getCustomerEmail());
            ps.setString(3,customers.getCustomerUserName());
            ps.setString(4,customers.getCustomerPassword());
            ps.setString(5,customers.getCustomerRole());
            
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


    public Customers getCustomerById(int customerId){
        String sql="SELECT * FROM accounts WHERE customer_id=?";
        Customers obj=null;
           
            try(PreparedStatement ps=connection.prepareStatement(sql)){
                ps.setInt(1,customerId);
                ps.executeUpdate();
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    obj=new Customers(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6));
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

    public void updateCustomer(Customers customers){
        String sql="UPDATE accounts SET name=? email=? username=? password=? role=/ WHERE customer_id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1,customers.getCustomerID());
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public CustomerAccountInfo getCustomerAccountInfo(int customerId){

        String sql="SELECT * FROM accounts WHERE customer_id=?";
        CustomerAccountInfo obj=null;
           
            try(PreparedStatement ps=connection.prepareStatement(sql)){
                ps.setInt(1,customerId);
                ps.executeUpdate();
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    obj=new CustomerAccountInfo(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4),rs.getDouble(6));
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
    

    public void deleteCustomer(int customerId){
        String sql="DELETE FROM customers WHERE customer_id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1,customerId);
            ps.executeUpdate();

        }
        catch(SQLException e){
            System.out.println(e);
        }

    }

    public List<Customers> getAllCustomers(){
        List<Customers> al=new ArrayList<Customers>();
        String sql="SELECT * FROM customers";
        Customers obj=null;
        try(Statement st=connection.createStatement()){
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                obj=new Customers(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
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



