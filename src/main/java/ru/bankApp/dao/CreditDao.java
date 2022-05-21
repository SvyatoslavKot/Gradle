package ru.bankApp.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.creditFactory.Credit;

import java.util.Date;

@Component
public class CreditDao {
    private final JdbcTemplate jdbcTemplate;
    private Date date = new Date();

    public CreditDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public  void add(Credit credit){
        jdbcTemplate.update("INSERT INTO credits(client_id,account_link_id,name,account_number,amount,ptc,opening_date,credit_term,payment_month) VALUES(?,?,?,?,?,?,?,?,?)",
                0,credit.getAccount_link_id(),credit.getName(),credit.getAccount_number(),credit.getAmount(),
                credit.getPtc(),new Date(date.getTime()),credit.getCredit_term(),credit.getPayment_month());
    }


}
