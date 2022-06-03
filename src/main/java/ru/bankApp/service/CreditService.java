package ru.bankApp.service;

import org.springframework.stereotype.Service;
import ru.bankApp.app.bankApp.serviceBank.GenerateAccountNumber;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.creditFactory.Credit;
import ru.bankApp.dao.CreditDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CreditService {
    CreditDao creditDao;
    GenerateAccountNumber genAccNumber = new GenerateAccountNumber();

    public CreditService(CreditDao creditDao) {
        this.creditDao = creditDao;
    }

    public Credit genAccNum(Credit c){
        String num;
        num = genAccNumber.accountNumber();
        while (null != creditDao.getByNum(num)){
            num = genAccNumber.accountNumber();
        }
        c.setAccount_number(num);
        return c;
    }
    public List<Credit> all(){
        return creditDao.all();
    }

    public void add (Credit credit){
        creditDao.add(credit);
    }

    public Credit getById (int id){
        return creditDao.getById(id);
    }
    public List<Credit> getByClientId(int clientId){
        return creditDao.getByClient(clientId);
    }

    public Credit getByNum(String num){
        return creditDao.getByNum(num);
    }

    public  void  upDateClientId(int id, int clientId){
        creditDao.upDateClientId(id,clientId);
    }

    public void  upDate(int id, Credit credit){
        creditDao.upDate(id, credit);
    }

    public void delete(int id){
        creditDao.delete(id);
    }

    public List<Credit> sortByNumHi(List<Credit> credits){
        List list = new ArrayList(credits);
        Collections.sort(list, new Comparator<Credit>() {
            @Override
            public int compare(Credit o1, Credit o2) {
                return o1.getAccount_number().compareTo(o2.getAccount_number());
            }
        });
        return list;
    }

    public List<Credit> sortByNumlow(List<Credit> credits){
        List list = new ArrayList(credits);
        Collections.sort(list, new Comparator<Credit>() {
            @Override
            public int compare(Credit o1, Credit o2) {
                return o2.getAccount_number().compareTo(o1.getAccount_number());
            }
        });
        return list;
    }

    public List<Credit> sortByName(List<Credit> credits){
        List list = new ArrayList(credits);
        Collections.sort(list, new Comparator<Credit>() {
            @Override
            public int compare(Credit o1, Credit o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return list;
    }
    public List<Credit> sortByBalance(List<Credit> credits){
        List list = new ArrayList(credits);
        Collections.sort(list, new Comparator<Credit>() {
            @Override
            public int compare(Credit o1, Credit o2) {
                if (o1.getAmount() < o2.getAmount()) return 1;
                else if (o1.getAmount() > o2.getAmount()) return -1;
                else return 0;
            }
        });
        return list;
    }
    public List<Credit> sortByTermlow(List<Credit> credits) {
        List list = new ArrayList(credits);
        Collections.sort(list, new Comparator<Credit>() {
            @Override
            public int compare(Credit o1, Credit o2) {
                if (o1.getCredit_term() > o2.getCredit_term()) return 1;
                else if (o1.getCredit_term() < o2.getCredit_term()) return -1;
                else return 0;
            }
        });
        return list;
    }
    public List<Credit> sortByTermHi(List<Credit> credits) {
        List list = new ArrayList(credits);
        Collections.sort(list, new Comparator<Credit>() {
            @Override
            public int compare(Credit o1, Credit o2) {
                if (o1.getCredit_term() < o2.getCredit_term()) return 1;
                else if (o1.getCredit_term() > o2.getCredit_term()) return -1;
                else return 0;
            }
        });
        return list;
    }
}
