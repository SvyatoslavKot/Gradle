package app.bankApp.FactoryProduct.accountFactory;

import app.bankApp.Bank;
import app.bankApp.FactoryProduct.CreditFactory.AvtoCredit;
import app.entities.Account;
import app.entities.Client;

public class AccountFactory {

    public Account createAccount (Bank bank, Client client, String type,int creditTerm, String pin, String level){
        switch (type){
            case "STANDARD" : return new StandartAccount().create(bank,client,creditTerm,pin,level);
            case "CURRENCY" : return new CurrencyAccount().create(bank,client,creditTerm,pin,level);
            case "PREMIUM"  : return new PremiumAccount().create(bank,client,creditTerm,pin,level);
            case "TRAVEL"   : return new TravelAccount().create(bank,client,creditTerm,pin,level);
            default: return null;
        }
    }
}
