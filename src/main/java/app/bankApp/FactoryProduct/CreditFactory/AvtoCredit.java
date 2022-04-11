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
public class AvtoCredit extends Credit{
    //генерирует номер счета , необходимо доработать
    GenerateAccountNumber genNum = new GenerateAccountNumber();
    // расчет ежемесячного плптежа
    CreditCalculationPayment creditPayment = new CreditCalculationPayment();

    /**
     * method interface of {@link CreditCreater#create(Bank, Client, int,int)}
     * credit object creation cycle of three parameters
     * @see CreditCreater
     * @param bank
     * @param client
     * @param sum
     * @param creditTerm
     */
    @Override
    public Credit create(Bank bank, Client client, int sum,int creditTerm) {
        if (sum <= 300000){
            ConsumerCredit consumerCredit = new ConsumerCredit();
            return consumerCredit.create(bank,client,  sum,creditTerm);
        }else if (sum > 300000 && sum <= 1000000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.AVTO.type + "_1",  sum,17.9,creditTerm);
        }else if (sum > 1000000 && sum <= 1300000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.AVTO.type + "_2",  sum,15.9,creditTerm);
        }else if (sum > 1300000 && sum <= 1700000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.AVTO.type + "_3",  sum,13.9,creditTerm);
        }else if (sum > 1700000 && sum <= 2500000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.AVTO.type + "_4",  sum,12.9,creditTerm);
        }else if (sum > 2500000 && sum <= 5000000 ){
            return new Credit(bank,client.getNickName(),TypeOfCredit.AVTO.type + "_5",  sum,10.9,creditTerm);
        }else {
            return null;
        }
    }
}
