package app.bankApp;

import app.bankApp.FactoryProduct.CreditFactory.CreditFactory;
import app.bankApp.FactoryProduct.accountFactory.AccountFactory;
import app.bankApp.exeption.AccountOperationExeption;
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
        Account account3 = accountFactory.createAccount(Bank.getInstance(), client, "STANDARD", 12, "00", "LIGHT");
        MoneyOperation moneyOperation = new MoneyOperation();
        moneyOperation.AccountPutMoneyOn(account, 1000);
        CreditFactory creditFactory = new CreditFactory();
        Credit credit = new Credit(Bank.getInstance(), client.getNickName(), "AVTO", 100, 17.9, 12);

        System.out.println(account);
        System.out.println(credit);
        try {
            moneyOperation.CreditPaymentFromAccount(credit,account);
        } catch (AccountOperationExeption e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(credit);

        try {
            moneyOperation.CreditPaySumFromAccount(credit,account,70);
        } catch (AccountOperationExeption e) {
            e.printStackTrace();
        }
        System.out.println(credit);
        System.out.println(account);

        try {
            moneyOperation.CreditPaySumFromAccount(credit,account,10);
        } catch (AccountOperationExeption e) {
            e.printStackTrace();
        }
        System.out.println(credit);
        System.out.println(account);

        try {
            moneyOperation.CreditPaySumFromAccount(credit,account,10000);
        } catch (AccountOperationExeption | CreditExeption e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            moneyOperation.CreditPaymentFromAccount(credit,account);
        } catch (AccountOperationExeption | CreditExeption e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(credit);
        System.out.println(account);

        try {
            moneyOperation.CreditPaySumFromAccount(credit,account,11);
        } catch (AccountOperationExeption | CreditExeption e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(credit);
        System.out.println(account);


    }


}
