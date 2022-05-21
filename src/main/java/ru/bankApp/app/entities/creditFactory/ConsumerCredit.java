package ru.bankApp.app.entities.creditFactory;

import ru.bankApp.app.bankApp.serviceBank.CreditCalculationPayment;
import ru.bankApp.app.bankApp.serviceBank.GenerateAccountNumber;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.Product;

import java.util.Date;

/**
 * @see Credit
 * create object of AvtoCredit class , extends Credit
 */
public class ConsumerCredit extends Credit {
    Date date = new Date();
    CreditCalculationPayment creditPayment = new CreditCalculationPayment();

    /**
     * method interface of {@link Product#create( Client, double, int)}
     * credit object creation, used constructor
     * @see Credit
     * @param client
     * @param sum
     * @param creditTerm
     * @return Credit
     */
    @Override
    public Credit create(Client client, double sum, int creditTerm) {
        if (sum <= 100000){
            CreditFactory creditFactory = new CreditFactory();
            return creditFactory.createCredit(client,sum,"CREDITCARD", creditTerm);
        }else if (sum > 100000 && sum <= 150000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CONSUMER.type +"_1")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(21.9)
                    .payment_month(creditPayment.calc(sum,21.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 150000 && sum <= 200000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CONSUMER.type +"_2")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(19.9)
                    .payment_month(creditPayment.calc(sum,19.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 200000 && sum <= 700000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CONSUMER.type +"_3")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(17.9)
                    .payment_month(creditPayment.calc(sum,17.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 700000 && sum <= 1500000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CONSUMER.type +"_4")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(14.9)
                    .payment_month(creditPayment.calc(sum,14.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 1500000 && sum <= 3000000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CONSUMER.type +"_5")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(12.9)
                    .payment_month(creditPayment.calc(sum,12.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else {
            return null;
        }
    }
}