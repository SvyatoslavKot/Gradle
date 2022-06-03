package ru.bankApp.app.bankApp.serviceBank;

/**
 *
 * class for job with money operation
 */
public class Operation {
/*
    /**
     * synchronized method for money operation for payment Credit from Account, for pay is take double parameter {@link Credit#getPaymentMonth()}.
     * If {@link Account#getMoney(double)} return false, than an exception AccountOperationException
     * If pay is more than amount{@link Credit#getAmount()} , than an exception CreditException
     * @param credit  {@link Credit}
     * @param account {@link Account}
     * @return boolean
     * @throws CreditExeption
     * @throws AccountOperationExeption

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

    /**
     * synchronized method for money operation for payment Credit from Account, for pay is take int param sum,
     *  if {@link Account#getMoney(double)} return false, than an exception AccountOperationException
     *  if pay is more than amount{@link Credit#getAmount()} , than an exception CreditException
     * @param credit {@link Credit}
     * @param account {@link Account}
     * @param sum Integer
     * @return boolean
     * @throws CreditExeption
     * @throws AccountOperationExeption

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

    /**
     * synchronized method for withdraw money from a bank {@link Account}. If {@link Account#getMoney(double)} return false ,
     * than an Exception
     * @param account {@link Account}
     * @param sum double
     * @return boolean
     * @throws AccountOperationExeption

    public synchronized boolean AccountTakeMoney (Account account, double sum) throws AccountOperationExeption{
            if (account.getMoney(sum)){
                return true;
            }
            throw new AccountOperationExeption("На балансе недостаточно средств");
    }

    /**
     * synchronized method for put money on bank {@link Account}
     * @param account  {@link Account}
     * @param sum Integer
     * @return boolean

    public synchronized boolean AccountPutMoneyOn(Account account, int sum){
        account.setMoney(sum);
        return true;
    }

    /**
     * synchronized method for transfer money between {@link Account}. If sender {@link Account#getMoney(double)} return false,
     * than an exception AccountOperationException
     * @param sender {@link Account}
     * @param addressee {@link Account}
     * @param money double
     * @return boolean
     * @throws AccountOperationExeption

    public  synchronized boolean AccountTransferMoney (Account sender, Account addressee, double money) throws AccountOperationExeption {
        if (sender.getMoney(money)){
            addressee.setMoney(money);
            return true;
        }
        throw new AccountOperationExeption("На балансе недостаточно средств");
    }
*/
}
