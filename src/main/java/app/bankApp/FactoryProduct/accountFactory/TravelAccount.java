package app.bankApp.FactoryProduct.accountFactory;

import app.bankApp.Bank;
import app.entities.Account;
import app.entities.Client;

public class TravelAccount extends Account {
    @Override
    public Account create(Bank bank, Client client, int creditTerm, String pin, String level) {
        if (level.equals("LIGHT")) {
            return new Account(bank,TypeOfAccount.TRAVEL.type+"_"+LevelOfAccount.LIGHT.level,creditTerm,500,5.5, client.getNickName(), pin);
        } else if (level.equals("STANDARD")) {
            return new Account(bank,TypeOfAccount.TRAVEL.type+"_"+LevelOfAccount.STANDARD.level,creditTerm,750,7.5, client.getNickName(), pin);
        } else if (level.equals("GOLD")) {
            return new Account(bank,TypeOfAccount.TRAVEL.type+"_"+LevelOfAccount.GOLD.level,creditTerm,990,9.5, client.getNickName(), pin);
        } {
            return null;
        }
    }
}
