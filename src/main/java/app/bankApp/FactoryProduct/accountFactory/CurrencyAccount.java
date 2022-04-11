package app.bankApp.FactoryProduct.accountFactory;

import app.bankApp.Bank;
import app.entities.Account;
import app.entities.Client;

public class CurrencyAccount extends Account {
    @Override
    public Account create(Bank bank, Client client, int creditTerm, String pin, String level) {
        if (level.equals("LIGHT")) {
            return new Account(bank,TypeOfAccount.CURRENCY.type+"_"+LevelOfAccount.LIGHT.level,creditTerm,500,0, client.getNickName(), pin);
        } else if (level.equals("STANDARD")) {
            return new Account(bank,TypeOfAccount.CURRENCY.type+"_"+LevelOfAccount.STANDARD.level,creditTerm,750,0, client.getNickName(), pin);
        } else if (level.equals("GOLD")) {
            return new Account(bank,TypeOfAccount.CURRENCY.type+"_"+LevelOfAccount.GOLD.level,creditTerm,880,0, client.getNickName(), pin);
        }  {
            return null;
        }
    }
}
