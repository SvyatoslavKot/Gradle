package ru.bankApp.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bankApp.app.entities.accountFactory.Account;

import java.util.Date;
import java.util.List;

@Component
public class AccountDao {
    private final JdbcTemplate jdbcTemplate;
   private Date date = new Date();

    @Autowired
    public AccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Account> allAccount(){
        return jdbcTemplate.query("SELECT * FROM account_table", new BeanPropertyRowMapper<>(Account.class));
    }

    public  void add(Account account){
        jdbcTemplate.update("INSERT INTO account_table(name,account_num,money_in_account,payment,credit_term,cash_back,date,client_id) VALUES(?,?,?,?,?,?,?,?)",
                account.getName(),account.getAccount_num(),account.getMoney_in_account(),account.getPayment(),account.getCredit_term(),
                account.getCashBack(),new Date(date.getTime()),0);
    }
    public  Account  getName (String name){
        return jdbcTemplate.query("SELECT * FROM account_table WHERE name=?", new Object[]{name},new BeanPropertyRowMapper<>(Account.class))
                .stream().findAny().orElse(null);
    }

    public  Account  getByNum (String number){
        return jdbcTemplate.query("SELECT * FROM account_table WHERE account_num=?", new Object[]{number},new BeanPropertyRowMapper<>(Account.class))
                .stream().findAny().orElse(null);
    }

    public Account getById(int id){
        return jdbcTemplate.query("SELECT * FROM account_table WHERE id=?", new Object[]{id},new BeanPropertyRowMapper<>(Account.class))
                .stream().findAny().orElse(null);
    }
    public List<Account> accountsByClient(int clientId){
        List<Account> account= jdbcTemplate.query("SELECT * FROM account_table WHERE client_id=?", new Object[]{clientId},new BeanPropertyRowMapper<>(Account.class));
        return account;
    }


    public void upDate(int id, Account account){
        jdbcTemplate.update("UPDATE account_table SET name =?,account_num = ?,money_in_account= ?,payment= ?,credit_term= ?,client_id= ?,cash_back= ? WHERE id=?",
                account.getName(),account.getAccount_num(),account.getMoney_in_account(),account.getPayment(),account.getCredit_term(),
                account.getClient_id(),account.getCashBack(), id);
    }
    public void upDateClientId(int id, int clientId){
        jdbcTemplate.update("UPDATE account_table SET client_id= ? WHERE id=?",
                clientId, id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM account_table WHERE id=?", id);
    }

}
