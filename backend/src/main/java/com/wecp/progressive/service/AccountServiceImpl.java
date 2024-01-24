package com.wecp.progressive.service;
import java.sql.SQLException;
import java.util.List;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.service.AccountService;
import java.util.*;
import com.wecp.progressive.dao.AccountDAO;



public class AccountServiceImpl  implements AccountService{
    private static List<Accounts> al=new ArrayList<Accounts>();
    private AccountDAO accountDao;

    public AccountServiceImpl(AccountDAO accountDao){
        this.accountDao=accountDao;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public List<Accounts> addAccountToArrayList(Accounts accounts) {
        // TODO Auto-generated method stub
        al.add(accounts);
        return al;
    }

    @Override
    public void deleteAccount(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void emptyArrayList() {
        // TODO Auto-generated method stub
        al = new ArrayList<>();
        
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Accounts> getAccountsByUser(int userId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Accounts> getAllAccountsFromArrayList() {
        // TODO Auto-generated method stub
        return al;
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalanceFromArrayList() {
        // TODO Auto-generated method stub
        List<Accounts> sortedal=al;
        Collections.sort(sortedal);
        return sortedal;
    }

    @Override
    public void updateAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
        
    }
    
}