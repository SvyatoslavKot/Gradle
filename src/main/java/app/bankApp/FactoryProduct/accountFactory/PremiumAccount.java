package app.bankApp.FactoryProduct.accountFactory;

import app.bankApp.Bank;
import app.entities.Account;
import app.entities.Client;
/**
 * @see app.entities.Account
 * create object of PremiumAccount class , extends Account
 */
public class PremiumAccount extends Account {
    /**
     * method interface of {@link AccountCreater#create(Bank, Client, int, String, String)}
     * Account object creation cycle ,using param of level {@link LevelOfAccount}
     * and used constructor of Account {@link Account#create(Bank, Client, int, String, String)}
     * @see AccountCreater
     * @see Account
     * @param bank
     * @param client
     * @param creditTerm
     * @param pin
     * @param level
     * @return Account
     */
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
