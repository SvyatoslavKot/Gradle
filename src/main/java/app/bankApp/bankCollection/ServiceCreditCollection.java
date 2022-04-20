package app.bankApp.bankCollection;

import app.bankApp.Bank;
import app.entities.Account;
import app.entities.Client;
import app.entities.Credit;

import java.util.ArrayList;

public class ServiceCreditCollection {
    Bank bank = Bank.getInstance();

    public ArrayList<Credit> getAllCredits (){
        ArrayList<Credit> credits = new ArrayList<>(bank.getBankCollection().getCreditListOfBank());
        return credits;
    }

    public Credit getCreditByNum(String number){
        ArrayList<Credit> credits = new ArrayList<>(bank.getBankCollection().getCreditListOfBank());
        for (Credit credit : credits){
            if (credit.getAccountNumber().equals(number)) {
                return credit;
            }return null;
        }
        return null;

    }

    public ArrayList<Credit> getAccountByClient(Client c){
        ArrayList<Credit> credits = new ArrayList<>(bank.getBankCollection().getCreditListOfBank());
        ArrayList<Credit> creditList = new ArrayList<>();
        for (Credit credit : credits){
            if (credit.getIdHolder().equals(c.getNickName())){
                creditList.add(credit);
            }
        }return creditList;
    }

    public boolean addCredit (Credit credit){
        if (credit.getAccountNumber()!=null){
            if (!bank.getBankCollection().getCreditListOfBank().contains(credit)){
                bank.getBankCollection().getCreditListOfBank().add(credit);
                return true;
            }return false;
        }return false;
    }

    public boolean removeCredit (Credit credit){
        if (credit.getAmount() == 0){
            bank.getBankCollection().getCreditListOfBank().remove(credit);
            return true;
        }return false;
    }
}
