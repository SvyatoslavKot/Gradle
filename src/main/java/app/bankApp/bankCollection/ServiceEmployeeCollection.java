package app.bankApp.bankCollection;

import app.bankApp.Bank;
import app.bankApp.exeption.EmployNotNullEx;
import app.entities.Client;
import app.entities.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ServiceEmployeeCollection {

    Bank bank = Bank.getInstance();

    public void putEmployee(Employee e) throws EmployNotNullEx {
        HashMap<String, Employee> employeeMap = bank.getBankCollection().getEmployeeHashMap();
        if (employeeMap.get(e.getMobilePhone())!= null){
            throw new EmployNotNullEx("Клиент с таким логином уже существует");
        }else {
           bank.getBankCollection().getEmployeeHashMap().put(e.getMobilePhone(),e);
        }
    }

    public ArrayList<Employee> getAllEmployee (){
        Collection<Employee> values = bank.getBankCollection().getEmployeeHashMap().values();
        ArrayList<Employee> employees = new ArrayList<>();
        return employees;
    }

    public Employee getEmployeeByPhone ( String  phone ){
        Employee e = bank.getBankCollection().getEmployeeHashMap().get(phone);
        if (e != null){
            return  e;
        }else return null;
    }
}
