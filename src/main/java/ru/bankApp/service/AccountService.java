package ru.bankApp.service;

import org.springframework.stereotype.Service;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.bankApp.serviceBank.GenerateAccountNumber;
import ru.bankApp.dao.AccountDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class AccountService {

    AccountDao accountDao;
    GenerateAccountNumber genAccNumber = new GenerateAccountNumber();
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    public void  addAccount (Account account){
        accountDao.add(account);
    }

    public Account getById(int id){
       return accountDao.getById(id);
    }
    public List<Account> all(){
        return accountDao.allAccount();
    }
    public Account getByNum(String num){
        return accountDao.getByNum(num);
    }
    public Account genAccNum(Account a){
       String num;
        num = genAccNumber.accountNumber();
        while (null != accountDao.getByNum(num)){
            num = genAccNumber.accountNumber();
        }
        a.setAccount_num(num);
        return a;
    }
    public void delete (int id){
        accountDao.delete(id);
    }
    public  void  upDateClientId(int id, int clientId){
        accountDao.upDateClientId(id,clientId);
    }
    public List<Account> accountsByClientId(int clientId){
        return accountDao.accountsByClient(clientId);
    }

    public List<Account> sortByNumHi(List<Account> accounts){
        List list = new ArrayList(accounts);
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getAccount_num().compareTo(o2.getAccount_num());
            }
        });
        return list;
    }

    public List<Account> sortByNumlow(List<Account> accounts){
        List list = new ArrayList(accounts);
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o2.getAccount_num().compareTo(o1.getAccount_num());
            }
        });
        return list;
    }

    public List<Account> sortByName(List<Account> accounts){
        List list = new ArrayList(accounts);
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return list;
    }
    public List<Account> sortByBalance(List<Account> accounts){
        List list = new ArrayList(accounts);
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                if (o1.getMoney_in_account() < o2.getMoney_in_account()) return 1;
                else if (o1.getMoney_in_account() > o2.getMoney_in_account()) return -1;
                else return 0;
            }
        });
        return list;
    }
    public List<Account> sortByTermlow(List<Account> accounts) {
        List list = new ArrayList(accounts);
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                if (o1.getCredit_term() > o2.getCredit_term()) return 1;
                else if (o1.getCredit_term() < o2.getCredit_term()) return -1;
                else return 0;
            }
        });
        return list;
    }
    public List<Account> sortByTermHi(List<Account> accounts) {
        List list = new ArrayList(accounts);
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                if (o1.getCredit_term() < o2.getCredit_term()) return 1;
                else if (o1.getCredit_term() > o2.getCredit_term()) return -1;
                else return 0;
            }
        });
        return list;
    }
}
