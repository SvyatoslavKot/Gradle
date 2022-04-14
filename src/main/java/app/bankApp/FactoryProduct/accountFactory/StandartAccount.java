package app.bankApp.FactoryProduct.accountFactory;

import app.bankApp.Bank;
import app.entities.Account;
import app.entities.Client;
/**
 * @see app.entities.Account
 * create object of StandardAccount class , extends Account
 */
public class StandartAccount extends Account {
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
    public Account create(Bank bank, Client client, int creditTerm, String pin,String level) {
        if (level.equals("LIGHT")) {
            return new Account(bank,TypeOfAccount.STANDARD.type+"_"+LevelOfAccount.LIGHT.level,creditTerm,200,3.5, client.getNickName(), pin);
        } else if (level.equals("STANDARD")) {
            return new Account(bank,TypeOfAccount.STANDARD.type+"_"+LevelOfAccount.STANDARD.level,creditTerm,350,4.5, client.getNickName(), pin);
        } else if (level.equals("GOLD")) {
            return new Account(bank,TypeOfAccount.STANDARD.type+"_"+LevelOfAccount.GOLD.level,creditTerm,600,5.5, client.getNickName(), pin);
        } {
            return null;
        }
    }

}
