package app.bankApp.FactoryProduct.accountFactory;

import app.bankApp.Bank;
import app.entities.Account;
import app.entities.Client;
/**
 * @see app.entities.Account
 * create object of TravelAccount class , extends Account
 */
public class TravelAccount extends Account {
    /**
     * method interface of {@link app.bankApp.FactoryProduct.Product#create(Bank, Client, int, String, String)}
     * Account object creation cycle ,using param of level {@link LevelOfAccount}
     * and used constructor of Account {@link Account#create(Bank, Client, int, String, String)}
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
            return new Account(bank,TypeOfAccount.TRAVEL.type+"_"+LevelOfAccount.LIGHT.level,creditTerm,500,5.5, client.getMobilePhone(), pin);
        } else if (level.equals("STANDARD")) {
            return new Account(bank,TypeOfAccount.TRAVEL.type+"_"+LevelOfAccount.STANDARD.level,creditTerm,750,7.5, client.getMobilePhone(), pin);
        } else if (level.equals("GOLD")) {
            return new Account(bank,TypeOfAccount.TRAVEL.type+"_"+LevelOfAccount.GOLD.level,creditTerm,990,9.5, client.getMobilePhone(), pin);
        } {
            return null;
        }
    }
}
