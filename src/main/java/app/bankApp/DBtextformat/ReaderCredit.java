package app.bankApp.DBtextformat;

import app.bankApp.Bank;
import app.entities.Client;
import app.entities.Credit;

import java.io.*;
import java.util.ArrayList;

public class ReaderCredit {
    private  static ReaderCredit bdReadCredit;

    private ReaderCredit() {
    }

    public static ReaderCredit getInstance(){
        if(bdReadCredit == null){
            bdReadCredit = new ReaderCredit();
        }return bdReadCredit;
    }


    String path = "C:/Users/NADEZHDA/IdeaProjects/Gradle/src/main/resources/textDB/credits.txt";
    Credit credit;
    private ArrayList<Credit> credits  = new ArrayList<>();

    public  void readBD (Bank bank){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
            String currentLine = " ";
            while (null != (currentLine = br.readLine())) {
                credit = convertStringToCredit(currentLine);
                Client client = bank.getBankCollection().getClientHashMap().get(credit.getIdHolder());
                client.getCreditListPersn().add(credit);
                bank.getBankCollection().getCreditListOfBank().add(credit);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public Credit convertStringToCredit (String currentLine){
        String[] sp = currentLine.split(" ");
        Credit credit = new Credit();
        for (String s : sp){
            readCreditName(s,credit);
            readAccountNumber(s,credit);
            readAmount(s,credit);
            readPtc(s,credit);
            readDate(s,credit);
            readCreditTerm(s,credit);
            readPayment(s,credit);
            readIdHolder(s,credit);
        }
        return credit;
    }

    private void readIdHolder(String s, Credit credit) {
        if (s!= null && s.contains("idHolder:")){
            credit.setIdHolder(s.split(":")[1]);
        }
    }

    private void readPayment(String s, Credit credit) {
        if (s!= null && s.contains("payment:")){
            credit.setPaymentMonth(Double.parseDouble(s.split(":")[1]));
        }
    }

    private void readCreditTerm(String s, Credit credit) {
        if (s!= null && s.contains("creditTerm:")){
            credit.setCreditTerm(Integer.parseInt(s.split(":")[1]));
        }
    }

    private void readCreditName (String s, Credit credit){
        if (s!= null && s.contains("creditName:")){
            credit.setCreditName(s.split(":")[1]);
        }
    }
    private void readAccountNumber (String s , Credit credit){
        if ( s!= null && s.contains("accountNumber:")){
            credit.setAccountNumber(s.split(":")[1]);
        }
    }
    private void readAmount(String s, Credit credit) {
        if ( s!= null && s.contains("amount:")){
            credit.setAmount(Double.parseDouble(s.split(":")[1]));
        }
    }
    private void readPtc(String s, Credit credit) {
        if ( s!= null && s.contains("ptc:")){
            credit.setPtc(Double.parseDouble(s.split(":")[1]));
        }
    }
    public  void readDate(String s, Credit credit){
        if ( s!= null && s.contains("data:")){
            credit.setOpeningDate(s.split(":")[1]);
        }
    }
}
