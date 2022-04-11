package app.bankApp.DBtextformat;

import app.bankApp.Bank;
import app.entities.Account;
import app.entities.Client;
import app.entities.Credit;

import java.io.*;
import java.util.ArrayList;

public class ReadAccount {
    private  static ReadAccount bdReadAccount;

    private ReadAccount() {
    }

    public static ReadAccount getInstance(){
        if(bdReadAccount == null){
            bdReadAccount = new ReadAccount();
        }return bdReadAccount;
    }


    String path = "C:/Users/NADEZHDA/IdeaProjects/Gradle/src/main/resources/textDB/accounts.txt";
    Account account;
    private ArrayList<Account> accounts  = new ArrayList<>();

    public  void readBD (Bank bank){
        try {
            FileInputStream fi = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fi));
            String currentLine = " ";
            while (null != (currentLine = br.readLine())) {
                account = convertStringToCredit(currentLine);
                Client client = bank.getBankCollection().getClientHashMap().get(account.getIdHolder());
                client.getAccountListPersn().add(account);
                accounts.add(account);
            }
            bank.getBankCollection().getAccountList().clear();
            bank.getBankCollection().getAccountList().addAll(accounts);
            accounts.clear();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public Account convertStringToCredit (String currentLine){
        String[] sp = currentLine.split(" ");
        Account account = new Account();
        for (String s : sp){
            readAccountName(s,account);
            readAccountNumber(s,account);
            readMoneyInAcc(s,account);
            readCashBack(s,account);
            readPin(s,account);
            readTerm(s,account);
            readPayment(s,account);
            readIdHolder(s,account);
        }
        return account;
    }

    private void readIdHolder(String s, Account account) {
        if (s!= null && s.contains("idHolder:")){
            account.setIdHolder(s.split(":")[1]);
        }
    }

    private void readPayment(String s, Account account) {
        if (s!= null && s.contains("payment:")){
            account.setPayment(Integer.parseInt(s.split(":")[1]));
        }
    }

    private void readTerm(String s, Account account) {
        if (s!= null && s.contains("term:")){
           account.setCreditTerm(Integer.parseInt(s.split(":")[1]));
        }
    }

    private void readAccountName (String s, Account account){
        if (s!= null && s.contains("nameAccount:")){
            account.setNameAccount(s.split(":")[1]);
        }
    }
    private void readAccountNumber (String s , Account account){
        if ( s!= null && s.contains("accountNumber:")){
            account.setAccountNumber(s.split(":")[1]);
        }
    }
    private void readMoneyInAcc(String s, Account account) {
        if ( s!= null && s.contains("moneyInAccount:")){
           account.setMoneyInAccount(Integer.parseInt(s.split(":")[1]));
        }
    }
    private void readCashBack(String s, Account account) {
        if ( s!= null && s.contains("cashBack:")){
            account.setCashBack(Double.parseDouble(s.split(":")[1]));
        }
    }
    public  void readPin(String s, Account account){
        if ( s!= null && s.contains("pin:")){
            account.setPin(s.split(":")[1]);
        }
    }
}
