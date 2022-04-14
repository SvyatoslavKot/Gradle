package app.bankApp.FactoryProduct.CreditFactory;

import app.bankApp.Bank;
import app.bankApp.serviceBank.CreditCalculationPayment;
import app.bankApp.serviceBank.GenerateAccountNumber;
import app.entities.Client;
import app.entities.Credit;

public class CreditCard extends Credit {
    //генерирует номер счета , необходимо доработать
    GenerateAccountNumber genNum = new GenerateAccountNumber();
    // расчет ежемесячного плптежа
    CreditCalculationPayment creditPayment = new CreditCalculationPayment();

    /**
     * method interface of {@link CreditCreater#create(Bank, Client, int, int)}
     * credit object creation cycle , used constructor {@link Credit#Credit(Bank, String, String, int, double, int)}
     * @see CreditCreater
     * @see Credit
     * @param bank
     * @param client
     * @param sum
     * @param creditTerm
     * @return Credit
     */
    @Override
    public Credit create(Bank bank, Client client, int sum, int creditTerm) {
        if (sum <= 30000 && sum >=10000 && creditTerm <= 6){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CREDITCARD.type + "_1",  sum,41.9,creditTerm);
        }else if (sum <= 30000 && creditTerm > 6){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CREDITCARD.type + "_2",  sum,35.9,creditTerm);
        }else if (sum > 30000 && sum <= 500000 && creditTerm <= 6){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CREDITCARD.type + "_3",  sum,40.9,creditTerm);
        }else if (sum > 30000 && sum <= 500000 && creditTerm > 6){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CREDITCARD.type + "_4",  sum,37.9,creditTerm);
        }else if (sum > 50000 && sum <= 100000 && creditTerm <= 6 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CREDITCARD.type + "_5",  sum,35.9,creditTerm);
        }else if (sum > 50000 && sum <= 100000 && creditTerm > 6 && creditTerm<=12 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CREDITCARD.type + "_6",  sum,33.9,creditTerm);
        }else if (sum > 50000 && sum <= 100000 && creditTerm > 12 && creditTerm <=24 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CREDITCARD.type + "_7",  sum,30.9,creditTerm);
        }else if (sum > 100000 && sum <= 150000 && creditTerm <= 6  ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CREDITCARD.type + "_8",  sum,31.9,creditTerm);
        }else if (sum > 100000 && sum <= 150000 && creditTerm > 6 && creditTerm<=12 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CREDITCARD.type + "_9",  sum,27.9,creditTerm);
        }else if (sum > 100000 && sum <= 150000 && creditTerm > 12 && creditTerm<=24 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CREDITCARD.type + "_10",  sum,25.9,creditTerm);
        }else {
            ConsumerCredit credit = new ConsumerCredit();
            return credit.create(bank,client,  sum,creditTerm);
        }
    }
}
