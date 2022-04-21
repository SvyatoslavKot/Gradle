package app.bankApp.FactoryProduct.CreditFactory;

import app.bankApp.Bank;
import app.bankApp.serviceBank.CreditCalculationPayment;
import app.bankApp.serviceBank.GenerateAccountNumber;
import app.entities.Client;
import app.entities.Credit;

/**
 * @see app.entities.Credit
 * create object of AvtoCredit class , extends Credit
 */
public class ConsumerCredit extends Credit {
    //генерирует номер счета , необходимо доработать
    GenerateAccountNumber genNum = new GenerateAccountNumber();
    // расчет ежемесячного плптежа
    CreditCalculationPayment creditPayment = new CreditCalculationPayment();

    /**
     * method interface of {@link CreditCreater#create(Bank, Client, double, int)}
     * credit object creation, used constructor {@link Credit#Credit(Bank, String, String, double, double, int)}
     * @see CreditCreater
     * @see Credit
     * @param bank
     * @param client
     * @param sum
     * @param creditTerm
     * @return Credit
     */
    @Override
    public Credit create(Bank bank, Client client, double sum, int creditTerm) {
        if (sum <= 100000){
            CreditCard creditCard = new CreditCard();
            return creditCard.create(bank, client, sum, creditTerm);
        }else if (sum > 100000 && sum <= 150000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CONSUMER.type + "_1",  sum,27.9,creditTerm);
        }else if (sum > 150000 && sum <= 200000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CONSUMER.type + "_2",  sum,25.9,creditTerm);
        }else if (sum > 200000 && sum <= 700000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CONSUMER.type + "_3",  sum,21.9,creditTerm);
        }else if (sum > 700000 && sum <= 1500000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CONSUMER.type + "_4",  sum,19.9,creditTerm);
        }else if (sum > 1500000 && sum <= 3000000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.CONSUMER.type + "_5",  sum,17.9,creditTerm);
        }else {
            return null;
        }
    }
}