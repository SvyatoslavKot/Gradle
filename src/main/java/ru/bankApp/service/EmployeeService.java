package ru.bankApp.service;

import org.springframework.stereotype.Service;
import ru.bankApp.app.entities.Employee;
import ru.bankApp.dao.EmployeeDao;

import java.util.List;

@Service
public class EmployeeService {
    EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public  void addEmployee(Employee employee){
        employeeDao.add(employee);
    }
    public List<Employee> listAll(){
       return employeeDao.all();
    }
    public Employee getById(int id){
       return employeeDao.getById(id);
    }

    public void delete(int id){
        employeeDao.delete(id);
    }

    public Employee getByPhone(String phone){
       return employeeDao.getByPhone(phone);
    }
}
