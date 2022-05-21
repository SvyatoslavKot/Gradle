package ru.bankApp.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.Employee;

import java.util.List;

@Component
public class EmployeeDao {
    JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> all(){
        return jdbcTemplate.query("SELECT * FROM employee", new BeanPropertyRowMapper<>(Employee.class));
    }
    public  void add(Employee employee){
        jdbcTemplate.update("INSERT INTO employee(mobile_phone,name,last_name,password,position,age,activity) VALUES(?,?,?,?,?,?,?)",
                employee.getMobile_phone(),employee.getName(),employee.getLast_name(),employee.getPassword(),employee.getPosition(),
                employee.getAge(),employee.isActivity());
    }
    public  Employee  getByPhone (String phone){
        return jdbcTemplate.query("SELECT * FROM employee WHERE mobile_phone=?", new Object[]{phone},new BeanPropertyRowMapper<>(Employee.class))
                .stream().findAny().orElse(null);
    }
    public Employee getById(int id){
        return jdbcTemplate.query("SELECT * FROM employee WHERE id=?", new Object[]{id},new BeanPropertyRowMapper<>(Employee.class))
                .stream().findAny().orElse(null);
    }
    public void upDate(int id, Employee employee){
        jdbcTemplate.update("UPDATE employee SET mobile_phone=?, name=?,last_name=?,password=?,position=?,age = ?,activity = ? WHERE id=?",
                employee.getMobile_phone(),employee.getName(),employee.getLast_name(),employee.getPassword(),employee.getPosition(),
                employee.getAge(),employee.isActivity(), id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM employee WHERE id=?", id);
    }
}
