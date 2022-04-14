package app.bankApp.FactoryProduct.accountFactory;

import app.bankApp.Bank;
import app.bankApp.FactoryProduct.CreditFactory.AvtoCredit;
import app.bankApp.FactoryProduct.CreditFactory.TypeOfCredit;
import app.entities.Account;
import app.entities.Client;
/**
 * pattern Factory. This class disigned to create objects as a child of the Account class
 */
public class AccountFactory {
    /**
     * create an object of Account class according to the specified parameters type {@link TypeOfAccount} which is const
     * @param bank
     * @param client
     * @param type
     * @param creditTerm
     * @param pin
     * @param level
     * @return Account
     */
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
