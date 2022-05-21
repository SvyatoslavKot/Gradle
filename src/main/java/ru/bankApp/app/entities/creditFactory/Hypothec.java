package ru.bankApp.app.entities.creditFactory;

import ru.bankApp.app.bankApp.Bank;
import ru.bankApp.app.bankApp.serviceBank.CreditCalculationPayment;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.Product;

import java.util.Date;

public class Hypothec extends Credit {
    Date date = new Date();
    CreditCalculationPayment creditPayment = new CreditCalculationPayment();
    /**
     * method interface of {@link Product#create(, Client, double, int)}
     * credit object creation cycle , used constructor {@link Credit#Credit()}
     * @see Credit
     * @param client
     * @param sum
     * @param creditTerm
     * @return Credit
     */
    @Override
    public Credit create(Client client, double sum, int creditTerm) {
        if (sum <= 300000){
            CreditFactory creditFactory = new CreditFactory();
            return creditFactory.createCredit(client,sum,"CONSUMER", creditTerm);
        }else if (sum > 300000 && sum <= 1000000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.HYPOTHEC.type +"_1")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(18.9)
                    .payment_month(creditPayment.calc(sum,18.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 1000000 && sum <= 2300000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.HYPOTHEC.type +"_2")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(16.9)
                    .payment_month(creditPayment.calc(sum,16.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 2300000 && sum <= 3700000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.HYPOTHEC.type +"_3")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(14.9)
                    .payment_month(creditPayment.calc(sum,14.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 3700000 && sum <= 5000000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.HYPOTHEC.type +"_4")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(12.9)
                    .payment_month(creditPayment.calc(sum,12.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 5000000 && sum <= 10000000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.HYPOTHEC.type +"_5")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(10.9)
                    .payment_month(creditPayment.calc(sum,10.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 10000000 && sum <= 20000000 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.HYPOTHEC.type +"_6")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(9.9)
                    .payment_month(creditPayment.calc(sum,9.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else {
            return null;
        }
    }
}
