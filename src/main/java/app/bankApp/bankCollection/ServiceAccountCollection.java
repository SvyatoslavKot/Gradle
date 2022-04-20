package app.bankApp.bankCollection;

import app.bankApp.Bank;
import app.entities.Account;
import app.entities.Client;

import java.util.ArrayList;

public class ServiceAccountCollection {
    Bank bank = Bank.getInstance();

    public ArrayList<Account> getAllAccounts(){
        ArrayList<Account> listAccount = new ArrayList<>(bank.getBankCollection().getAccountList());
        return listAccount;
    }

    public Account getAccountByNum(String number){

        ArrayList<Account> listAccount = new ArrayList<>(bank.getBankCollection().getAccountList());
        Account a = null;
        for (Account account : listAccount){
            if (account.getAccountNumber().equals(number)) {
               a = account;
            }
        }
        return a;
    }
    public ArrayList<Account> getAccountByClient(Client c){
        ArrayList<Account> listAccount = new ArrayList<>(bank.getBankCollection().getAccountList());
        ArrayList<Account> accontListClient = new ArrayList<>();
        for (Account account : listAccount){
            if (account.getIdHolder().equals(c.getNickName())){
                accontListClient.add(account);
            }
        }return accontListClient;
    }

    public boolean addAccount (Account account){
        if (account.getAccountNumber()!=null){
            if (!bank.getBankCollection().getAccountList().contains(account)){
                bank.getBankCollection().getAccountList().add(account);
                return true;
            }return false;
        }return false;
    }

    public boolean removeAccount (Account account){
        if (account.getMoneyInAccount() == 0){
                bank.getBankCollection().getAccountList().remove(account);
                return true;
        }return false;
    }
}
