package ru.bankApp.app.entities.creditFactory;

import ru.bankApp.app.bankApp.serviceBank.CreditCalculationPayment;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.Product;

import java.util.Date;

/**
 * @see Credit
 * create object of AvtoCredit class , extends Credit
 */
public class AvtoCredit extends Credit{
    Date date = new Date();
    CreditCalculationPayment creditPayment = new CreditCalculationPayment();

    /**
     * method interface of {@link Product#create( Client, double, int)}
     * credit object creation cycle , used constructor {@link Credit#Credit}
     * @see Credit
     * @param client
     * @param sum
     * @param creditTerm
     * @return Credit
     */
    @Override
    public Credit create( Client client, double sum,int creditTerm) {
        if (sum <= 300000){
            CreditFactory creditFactory = new CreditFactory();
            return creditFactory.createCredit(client,sum,"CONSUMER", creditTerm);
        }else if (sum > 300000 && sum <= 1000000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.AVTO.type +"_1")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(17.9)
                    .payment_month(creditPayment.calc(sum,17.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 1000000 && sum <= 1300000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.AVTO.type +"_2")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(15.9)
                    .payment_month(creditPayment.calc(sum,15.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 1300000 && sum <= 1700000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.AVTO.type +"_3")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(13.9)
                    .payment_month(creditPayment.calc(sum,13.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 1700000 && sum <= 2500000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.AVTO.type +"_4")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(11.5)
                    .payment_month(creditPayment.calc(sum,11.5,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 2500000 && sum <= 5000000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.AVTO.type +"_1")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(10.9)
                    .payment_month(creditPayment.calc(sum,10.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else {
            return null;
        }
    }
}
