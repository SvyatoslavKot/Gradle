package app.bankApp.serviceBank;

import app.bankApp.exeption.CreditExeption;
import app.bankApp.serviceBank.CreditCalculationPayment;
import app.entities.Account;
import app.entities.Credit;

public class MoneyOperation {

    public String CreditPaymentFromAccount(Credit credit, Account account) throws CreditExeption{
        double pay = credit.getPaymentMonth();
        int balance = account.getMoneyInAccount();

        if (pay > balance){
            return "Набалансе недостаточно денег";
        } else if (credit.getAmount()<=0){
            return  "Кредит закрыт";
        }else {
            if (pay > credit.getAmount()){
                pay = pay - credit.getAmount();
                account.setMoneyInAccount((int) (balance - pay));
                credit.setAmount((int) (credit.getAmount()-pay));
                return "Кредит закрыт";
            }else {
                account.setMoneyInAccount((int) (balance - pay));
                credit.setAmount((int) (credit.getAmount()-pay));
                return "платеж внесен";
            }
        }
    }
    public String CreditPaymentFromAccount(Credit credit, Account account, int sum) throws CreditExeption {
        double pay = sum;
        int balance = account.getMoneyInAccount();

        if (pay > balance) {
            return "Набалансе недостаточно денег";
        } else if (credit.getAmount()<=0){
            return  "Кредит закрыт";
        }else {
            if (pay > credit.getAmount()) {
                pay = pay - credit.getAmount();
                account.setMoneyInAccount((int) (balance - pay));
                credit.setAmount((int) (credit.getAmount() - pay));
                return "Кредит закрыт";
            } else {
                account.setMoneyInAccount((int) (balance - pay));
                credit.setAmount((int) (credit.getAmount() - pay));
                return "платеж внесен";
            }
        }
    }

    public boolean TakeMoneyFromAccount(Account account, int sum){
        if (sum > account.getMoneyInAccount()){
            return false;
        }else
                account.setMoneyInAccount(account.getMoneyInAccount() - sum);
        return true;
    }

    public boolean PutMoneyOnAccount(Account account, int sum){
        account.setMoneyInAccount(account.getMoneyInAccount()+sum);
        return true;
    }


}
