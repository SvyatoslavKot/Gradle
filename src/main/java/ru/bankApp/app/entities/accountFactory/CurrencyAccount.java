package ru.bankApp.app.entities.accountFactory;

import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.Product;

import java.util.Date;

/**
 * @see Account
 * create object of CurrencyAccount class , extends Account
 */
public class CurrencyAccount extends Account {
    Date date = new Date();
    /**
     * method interface of {@link Product#create( Client, int, String, String)}
     * Account object creation cycle ,using param of level {@link LevelOfAccount}
     *  and used constructor of Account {@link Account#create( Client, int, String, String)}
     * @see Account
     * @param client
     * @param creditTerm
     * @param pin
     * @param level
     * @return Account
     */
    @Override

    public Account create(Client client, int creditTerm, String pin, String level) {
        if (level.equals("LIGHT")) {
            return new Account.AccountBuilder()
                    .name(TypeOfAccount.STANDARD.type+"_"+LevelOfAccount.LIGHT.level)
                    .credit_term(creditTerm)
                    .payment(500)
                    .cashBack(0)
                    .client_id(client.getId())
                    .date(new Date(date.getTime()))
                    .money_in_account(0)
                    .build();
        } else if (level.equals("STANDARD")) {
            return new Account.AccountBuilder()
                    .name(TypeOfAccount.STANDARD.type+"_"+LevelOfAccount.LIGHT.level)
                    .credit_term(creditTerm)
                    .payment(750)
                    .cashBack(0)
                    .client_id(client.getId())
                    .date(new Date(date.getTime()))
                    .money_in_account(0)
                    .build();
        } else if (level.equals("GOLD")) {
            return new Account.AccountBuilder()
                    .name(TypeOfAccount.STANDARD.type+"_"+LevelOfAccount.LIGHT.level)
                    .credit_term(creditTerm)
                    .payment(880)
                    .cashBack(0)
                    .client_id(client.getId())
                    .date(new Date(date.getTime()))
                    .money_in_account(0)
                    .build();
        }  {
            return null;
        }
    }
}
