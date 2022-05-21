package ru.bankApp.app.entities.accountFactory;

import ru.bankApp.app.entities.Client;

/**
 * pattern Factory. This class disigned to create objects as a child of the Account class
 */
public class AccountFactory {
    /**
     * create an object of Account class according to the specified parameters type {@link TypeOfAccount} which is const
     * @param client
     * @param type
     * @param creditTerm
     * @param pin
     * @param level
     * @return Account
     */
    public Account createAccount ( Client client, String type, int creditTerm, String pin, String level){
        switch (type){
            case "STANDARD" : return new StandartAccount().create(client,creditTerm,pin,level);
            case "CURRENCY" : return new CurrencyAccount().create(client,creditTerm,pin,level);
            case "PREMIUM"  : return new PremiumAccount().create(client,creditTerm,pin,level);
            case "TRAVEL"   : return new TravelAccount().create(client,creditTerm,pin,level);
            default: return null;
        }
    }
}
