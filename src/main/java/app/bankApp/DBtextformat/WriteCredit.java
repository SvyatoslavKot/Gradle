package app.bankApp.DBtextformat;

import app.bankApp.Bank;
import app.entities.Client;
import app.entities.Credit;

import java.io.*;
import java.util.*;

public class WriteCredit {
    private static WriteCredit writeCredit;
    private WriteCredit() {
    }

    public static WriteCredit getInstance(){
        if (writeCredit == null) {
            writeCredit = new WriteCredit();
        }
        return writeCredit;
    }

    String path = "C:/Users/NADEZHDA/IdeaProjects/Gradle/src/main/resources/textDB/credits.txt";
    Client client;
    public void writeCredit (Bank bank)  {
        File file = new File(path);

        try {
            FileOutputStream os = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os));
            bufferedWriter.write("");
            HashSet<Credit> credits = bank.getBankCollection().getCreditListOfBank();
            for (Credit credit : credits) {
                bufferedWriter.write("creditName:" + credit.getCreditName() + " ");
                bufferedWriter.write("accountNumber:" + credit.getAccountNumber() + " ");
                bufferedWriter.write("amount:" + credit.getAmount() + " ");
                bufferedWriter.write("ptc:" + credit.getPtc() + " ");
                bufferedWriter.write("data:" + credit.getOpeningDate() + " ");
                bufferedWriter.write("creditTerm:" + credit.getCreditTerm() + " ");
                bufferedWriter.write("payment:" + credit.getPaymentMonth() + " ");
                bufferedWriter.write("phoneHolder:" + credit.getPhoneHolder() + " ");
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
