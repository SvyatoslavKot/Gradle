package app.bankApp;


import app.bankApp.bankCollection.ServiceRecipt;
import app.bankApp.exeption.RecieptNullEx;
import app.bankApp.recieptBridge.RecieptAccountBridge;
import app.entities.Employee;
import app.entities.Reciept;

import java.util.LinkedList;

public class TestBank {


    public static void main(String[] args){
        Employee e = new Employee.Builder("7987786","Иван", "000").age(22).id("21").build();
        System.out.println(e);
    }

}
