package ru.bankApp.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bankApp.app.entities.ApplyCredit;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.EmployTask;
import ru.bankApp.app.entities.accountFactory.Account;

import java.util.Date;
import java.util.List;

@Component
public class ApplyCreditDao {
    private final JdbcTemplate jdbcTemplate;
    private Date date = new Date();

    public ApplyCreditDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  void add(ApplyCredit applyCredit){
        jdbcTemplate.update("INSERT INTO apply_credit(status,credit_id,client_id,child,family_status,income,other_credit,experience,age,solvency,number ) VALUES(?,?,?,?,?,?,?,?,?,?,?)",
                applyCredit.getStatus(),applyCredit.getCredit_id(),applyCredit.getClient_id(),applyCredit.getChild(),
        applyCredit.isFamily_status(),applyCredit.getIncome(),applyCredit.getOther_credit(),applyCredit.getExperience(),
                applyCredit.getAge(),applyCredit.getSolvency(),applyCredit.getNumber());
    }
    public ApplyCredit getById(int id){
        return jdbcTemplate.query("SELECT * FROM apply_credit WHERE id=?", new Object[]{id},new BeanPropertyRowMapper<>(ApplyCredit.class))
                .stream().findAny().orElse(null);
    }

    public  ApplyCredit  getByNum (String num){
        return jdbcTemplate.query("SELECT * FROM apply_credit WHERE number =?", new Object[]{num},new BeanPropertyRowMapper<>(ApplyCredit.class))
                .stream().findAny().orElse(null);
    }
    public List<ApplyCredit> allApplyCredit(){
        return jdbcTemplate.query("SELECT * FROM apply_credit", new BeanPropertyRowMapper<>(ApplyCredit.class));
    }

    public void upDate(int id, ApplyCredit ac){
        jdbcTemplate.update("UPDATE apply_credit SET status= ?,credit_id= ?,client_id= ?,child= ?,family_status= ?,income= ?,other_credit= ?,experience= ?,age= ?,solvency= ?,number = ? WHERE id=?",
                ac.getStatus(),ac.getCredit_id(),ac.getClient_id(),ac.getChild(),
                ac.isFamily_status(),ac.getIncome(),ac.getOther_credit(),ac.getExperience(),
                ac.getAge(),ac.getSolvency(),ac.getNumber(), id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM apply_credit WHERE id=?", id);

    }
}
