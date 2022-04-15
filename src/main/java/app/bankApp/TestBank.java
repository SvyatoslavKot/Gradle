package app.bankApp;

import app.bankApp.FactoryProduct.CreditFactory.CreditFactory;
import app.bankApp.FactoryProduct.accountFactory.AccountFactory;
import app.bankApp.exeption.CreditExeption;
import app.bankApp.serviceBank.MoneyOperation;
import app.bankApp.serviceBank.PasswordCheck;
import app.entities.Account;
import app.entities.Client;
import app.entities.Credit;

public class TestBank {


    public static void main(String[] args) throws CreditExeption {
        Client client = new Client("Iv","iv", "6","ivan","000");
        Client client2 = new Client("Iv","iv", "6","egor","002");
        AccountFactory accountFactory = new AccountFactory();
        Account account = accountFactory.createAccount(Bank.getInstance(), client, "STANDARD", 12, "00", "LIGHT");
        MoneyOperation moneyOperation = new MoneyOperation();
        Account account3 = accountFactory.createAccount(Bank.getInstance(), client, "STANDARD", 12, "00", "LIGHT");
        CreditFactory creditFactory = new CreditFactory();
        Credit credit = new Credit(Bank.getInstance(), client.getNickName(), "AVTO", 100, 17.9, 12);
        Bank bank = Bank.getInstance();

        bank.getBankCollection().getClientHashMap().put("ivan", client);
        bank.getBankCollection().getClientHashMap().put("egor", client2);
        PasswordCheck passwordCheck = new PasswordCheck();
        Client a = passwordCheck.chekPassword("ivan","000");
        Client b = passwordCheck.chekPassword("egor","002");
        System.out.println(a);
        System.out.println(b);
    }


}
