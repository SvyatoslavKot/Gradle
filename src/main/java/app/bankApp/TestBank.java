package app.bankApp;

import app.bankApp.FactoryProduct.CreditFactory.CreditFactory;
import app.bankApp.FactoryProduct.accountFactory.AccountFactory;
import app.bankApp.exeption.CreditExeption;
import app.bankApp.serviceBank.MoneyOperation;
import app.entities.Account;
import app.entities.Client;
import app.entities.Credit;

public class TestBank {


    public static void main(String[] args) throws CreditExeption {
        Client client = new Client();
        AccountFactory accountFactory = new AccountFactory();
        Account account = accountFactory.createAccount(Bank.getInstance(), client, "STANDARD", 12, "00", "LIGHT");
        MoneyOperation moneyOperation = new MoneyOperation();
        Account account3 = accountFactory.createAccount(Bank.getInstance(), client, "STANDARD", 12, "00", "LIGHT");
        CreditFactory creditFactory = new CreditFactory();
        Credit credit = new Credit(Bank.getInstance(), client.getNickName(), "AVTO", 100, 17.9, 12);
        account.setMoneyInAccount(1000);
        System.out.println(moneyOperation.CreditPaymentFromAccount(credit,account));
        System.out.println(moneyOperation.CreditPaymentFromAccount(credit,account3));

        moneyOperation.PutMoneyOnAccount(account3,1000);
        System.out.println(moneyOperation.CreditPaymentFromAccount(credit,account3,100));
        System.out.println(moneyOperation.CreditPaymentFromAccount(credit,account3));
    }


}
