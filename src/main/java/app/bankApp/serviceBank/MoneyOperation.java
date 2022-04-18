package app.bankApp.serviceBank;

import app.bankApp.exeption.AccountOperationExeption;
import app.bankApp.exeption.CreditExeption;
import app.bankApp.serviceBank.CreditCalculationPayment;
import app.entities.Account;
import app.entities.Credit;

public class MoneyOperation {

    public synchronized boolean CreditPaymentFromAccount(Credit credit, Account account) throws CreditExeption, AccountOperationExeption{
        double pay = credit.getPaymentMonth();
        if (account.getMoney(pay)){
            if (credit.getAmount()> pay){
                credit.setMoney(pay);
                return true;
            }
            else account.setMoney(pay - credit.getAmount());
            throw new CreditExeption("Кредит закрыт", credit,pay);
        }
        else throw new AccountOperationExeption("На балансе недостаточно средств");
    }

    public synchronized boolean CreditPaySumFromAccount(Credit credit, Account account, int sum) throws CreditExeption, AccountOperationExeption {
        if (account.getMoney(sum)){
            if (credit.getAmount()> sum){
                credit.setMoney(sum);
                return true;
            }else
                account.setMoney(sum- credit.getAmount());
                throw new CreditExeption("Кредит закрыт", credit,sum);

        }else throw new AccountOperationExeption("На балансе недостаточно средств");

    }

    public synchronized boolean AccountTakeMoney (Account account, double sum) throws AccountOperationExeption{
            if (account.getMoney(sum)){
                return true;
            }
            throw new AccountOperationExeption("На балансе недостаточно средств");
    }

    public synchronized boolean AccountPutMoneyOn(Account account, int sum){
        account.setMoney(sum);
        return true;
    }
    public  synchronized boolean AccountTransferMoney (Account sender, Account addressee, double money) throws AccountOperationExeption {
        if (sender.getMoney(money)){
            addressee.setMoney(money);
            return true;
        }
        throw new AccountOperationExeption("На балансе недостаточно средств");
    }

}
