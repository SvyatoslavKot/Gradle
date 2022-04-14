package app.bankApp.FactoryProduct.CreditFactory;

import app.bankApp.Bank;
import app.bankApp.serviceBank.CreditCalculationPayment;
import app.bankApp.serviceBank.GenerateAccountNumber;
import app.entities.Client;
import app.entities.Credit;

public class Hypothec extends Credit {

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
        if (sum <= 300000){
            ConsumerCredit consumerCredit = new ConsumerCredit();
            return consumerCredit.create(bank,client,  sum,creditTerm);
        }else if (sum > 300000 && sum <= 1000000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.HYPOTHEC.type + "_1",  sum,25.9,creditTerm);
        }else if (sum > 1000000 && sum <= 2300000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.HYPOTHEC.type + "_2",  sum,19.9,creditTerm);
        }else if (sum > 2300000 && sum <= 3700000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.HYPOTHEC.type + "_3",  sum,17.9,creditTerm);
        }else if (sum > 3700000 && sum <= 5000000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.HYPOTHEC.type + "_4",  sum,15.9,creditTerm);
        }else if (sum > 5000000 && sum <= 10000000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.HYPOTHEC.type + "_5",  sum,13.9,creditTerm);
        }else if (sum > 10000000 && sum <= 20000000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.HYPOTHEC.type + "_5",  sum,12.9,creditTerm);
        }else {
            return null;
        }
    }
}
