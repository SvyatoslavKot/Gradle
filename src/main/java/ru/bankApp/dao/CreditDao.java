package ru.bankApp.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.creditFactory.Credit;

import java.util.Date;
import java.util.List;

@Component
public class CreditDao {
    private final JdbcTemplate jdbcTemplate;
    private Date date = new Date();

    public CreditDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Credit> all(){
        return jdbcTemplate.query("SELECT * FROM credits", new BeanPropertyRowMapper<>(Credit.class));
    }

    public  void add(Credit credit){
        jdbcTemplate.update("INSERT INTO credits(client_id,account_link_id,name,account_number,amount,ptc,opening_date,credit_term,payment_month) VALUES(?,?,?,?,?,?,?,?,?)",
                0,credit.getAccount_link_id(),credit.getName(),credit.getAccount_number(),credit.getAmount(),
                credit.getPtc(),new Date(date.getTime()),credit.getCredit_term(),credit.getPayment_month());
    }
    public  Credit  getById (int id){
        return jdbcTemplate.query("SELECT * FROM credits WHERE id=?", new Object[]{id},new BeanPropertyRowMapper<>(Credit.class))
                .stream().findAny().orElse(null);
    }

    public  Credit  getByNum (String number){
        return jdbcTemplate.query("SELECT * FROM credits WHERE account_number=?", new Object[]{number},new BeanPropertyRowMapper<>(Credit.class))
                .stream().findAny().orElse(null);
    }

    public List<Credit> getByClient (int clientId){
        return jdbcTemplate.query("SELECT * FROM credits WHERE client_id=?", new Object[]{clientId},new BeanPropertyRowMapper<>(Credit.class));
    }

    public void upDateClientId(int id, int clientId){
        jdbcTemplate.update("UPDATE credits SET client_id= ? WHERE id=?",
                clientId, id);
    }

    public void upDate(int id, Credit credit){
        jdbcTemplate.update("UPDATE credits SET client_id= ?,account_link_id= ?,name= ?,account_number= ?,amount= ?,ptc= ?,opening_date= ?,credit_term= ?,payment_month= ? WHERE id=?",
                credit.getClient_id(),credit.getAccount_link_id(),credit.getName(),credit.getAccount_number(),credit.getAmount(),
                credit.getPtc(),credit.getOpening_date(),credit.getCredit_term(),credit.getPayment_month(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM credits WHERE id=?", id);
    }


}
