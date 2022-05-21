package ru.bankApp.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bankApp.app.entities.EmployTask;
import ru.bankApp.app.entities.accountFactory.Account;

import java.util.Date;

@Component
public class EmployTasksDao {
    private final JdbcTemplate jdbcTemplate;

    public EmployTasksDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  void add(EmployTask employTask){
        jdbcTemplate.update("INSERT INTO employ_tasks(apply_credit_num) VALUES(?)",
                employTask.getApply_credit_num());
    }
}
