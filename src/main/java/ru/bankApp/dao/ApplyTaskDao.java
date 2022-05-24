package ru.bankApp.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bankApp.app.entities.ApplyCredit;
import ru.bankApp.app.entities.EmployTask;

import java.util.List;

@Component
public class ApplyTaskDao {
    private final JdbcTemplate jdbcTemplate;

    public ApplyTaskDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  void add(EmployTask employTask){
        jdbcTemplate.update("INSERT INTO employ_tasks(apply_credit_num,apply_id) VALUES(?,?)",
                employTask.getApply_credit_num(),employTask.getApply_id());
    }
    public EmployTask getTask(){
        return jdbcTemplate.query("SELECT * FROM employ_tasks first ", new BeanPropertyRowMapper<>(EmployTask.class))
                .stream().findAny().orElse(null);
    }

    public List<EmployTask> allTask(){
        return jdbcTemplate.query("SELECT * FROM employ_tasks", new BeanPropertyRowMapper<>(EmployTask.class));
    }

    public EmployTask getById(int id){
        return jdbcTemplate.query("SELECT * FROM employ_tasks WHERE id=?", new Object[]{id},new BeanPropertyRowMapper<>(EmployTask.class))
                .stream().findAny().orElse(null);
    }

    public  EmployTask  getByApplyNum (String num){
        return jdbcTemplate.query("SELECT * FROM employ_tasks WHERE apply_credit_num=?", new Object[]{num},new BeanPropertyRowMapper<>(EmployTask.class))
                .stream().findAny().orElse(null);

    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM employ_tasks WHERE id=?", id);

    }
}
