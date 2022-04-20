package app.bankApp.DBtextformat;

import app.bankApp.Bank;
import app.entities.Account;
import app.entities.Client;
import app.entities.Credit;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class WriteAccount {
    private static WriteAccount writeAccount;
    private WriteAccount() {
    }
    public static WriteAccount getInstance(){
        if (writeAccount == null) {
            writeAccount = new WriteAccount();
        }
        return writeAccount;
    }
    String path = "C:/Users/NADEZHDA/IdeaProjects/Gradle/src/main/resources/textDB/accounts.txt";
    Client client;
    public void writeAccount (Bank bank)  {
        File file = new File(path);
        try {
            FileOutputStream os = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os));
            bufferedWriter.write("");
            HashSet<Account> accounts = bank.getBankCollection().getAccountList();
            for (Account account : accounts) {
                bufferedWriter.write("nameAccount:" + account.getNameAccount() + " ");
                bufferedWriter.write("accountNumber:" + account.getAccountNumber() + " ");
                bufferedWriter.write("moneyInAccount:" + account.getMoneyInAccount() + " ");
                bufferedWriter.write("term:" + account.getCreditTerm() + " ");
                bufferedWriter.write("payment:" + account.getPayment() + " ");
                bufferedWriter.write("cashBack:" + account.getCashBack() + " ");
                bufferedWriter.write("idHolder:" + account.getIdHolder() + " ");
                bufferedWriter.write("pin:" + account.getPin() + " ");
                bufferedWriter.write("\n");

                bufferedWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
