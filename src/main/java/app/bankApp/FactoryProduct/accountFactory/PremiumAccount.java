package app.bankApp.FactoryProduct.accountFactory;

import app.bankApp.Bank;
import app.entities.Account;
import app.entities.Client;

public class PremiumAccount extends Account {
    @Override
    public Account create(Bank bank, Client client, int creditTerm, String pin, String level) {
        if (level.equals("LIGHT")) {
            return new Account(bank,TypeOfAccount.PREMIUM.type+"_"+LevelOfAccount.LIGHT.level,creditTerm,1000,7.5, client.getNickName(), pin);
        } else if (level.equals("STANDARD")) {
            return new Account(bank,TypeOfAccount.PREMIUM.type+"_"+LevelOfAccount.STANDARD.level,creditTerm,1500,9.5, client.getNickName(), pin);
        } else if (level.equals("GOLD")) {
            return new Account(bank,TypeOfAccount.PREMIUM.type+"_"+LevelOfAccount.GOLD.level,creditTerm,2000,12.5, client.getNickName(), pin);
        } else {
            return null;
        }
    }
}
