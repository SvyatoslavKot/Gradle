package app.bankApp.serviceBank;

import app.bankApp.Bank;
import app.bankApp.BankCollection;
import app.bankApp.bankCollection.ServiceEmployeeCollection;
import app.bankApp.exeption.EmployeePasswordEx;
import app.entities.Client;
import app.entities.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * Class login password check
 * indicate Class Bank and clientHashMap
 */
public class PasswordCheck {

    Bank bank = Bank.getInstance();
    HashMap<String, Client> clientHashMap = bank.getBankCollection().getClientHashMap();

    Client client;

    /**
     * When creating a class, using class Bank {@link Bank} which is Singleton ,
     * and ref HashMap {@link BankCollection#getClientHashMap()} with Client this Bank,
     * and object client type of {@link Client},
     * method chekPassword gets object Client from HashMap by key which String param 'nickName',
     * create new Client object 'a', and assign a value gets from HashMap,
     * if 'a' not null compare {@link Client#getPassword()} and @param password, if equals  return 'a' else null
     * @param phone
     * @param password
     * @return Client
     */
    public Client chekPassword(String phone, String password) {
        Client a = clientHashMap.get(phone);
        if (a!= null){
            if (a.getPassword().equals(password)){
                return a;
            }else {
                return null;
            }
        }else {
            return null;
        }

    }

    public Employee checkPasswordEmployy(String phone, String password) throws EmployeePasswordEx {
         if (bank.getBankCollection().getEmployeeHashMap().get(phone) != null){
             Employee e = bank.getBankCollection().employeeHashMap.get(phone);
             if (e.getPassword().equals(password)){
                 return e;
             }else {
                 throw new EmployeePasswordEx("Неверный Пароль");
             }
         }
         throw  new EmployeePasswordEx("Пользователя с таким логином не существует");
    }
}
