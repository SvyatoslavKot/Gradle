package ru.bankApp.app.entities.creditFactory;

import ru.bankApp.app.bankApp.Bank;
import ru.bankApp.app.bankApp.serviceBank.CreditCalculationPayment;
import ru.bankApp.app.bankApp.serviceBank.GenerateAccountNumber;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.Product;

import java.util.Date;

public class CreditCard extends Credit {
    Date date = new Date();
    CreditCalculationPayment creditPayment = new CreditCalculationPayment();

    /**
     * method interface of {@link Product#create( Client, double, int)}
     * credit object creation cycle , used constructor {@link Credit#Credit()}
     * @see Credit
     * @param client
     * @param sum
     * @param creditTerm
     * @return Credit
     */
    @Override
    public Credit create(Client client, double sum, int creditTerm) {
        if (sum <= 30000 && sum >=10000 && creditTerm <= 6){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CREDITCARD.type +"_1")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(30.1)
                    .payment_month(creditPayment.calc(sum,30.1,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum <= 30000 && creditTerm > 6){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CREDITCARD.type +"_2")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(29.3)
                    .payment_month(creditPayment.calc(sum,29.3,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 30000 && sum <= 500000 && creditTerm <= 6){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CREDITCARD.type +"_3")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(28.9)
                    .payment_month(creditPayment.calc(sum,28.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 30000 && sum <= 500000 && creditTerm > 6){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CREDITCARD.type +"_4")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(27.9)
                    .payment_month(creditPayment.calc(sum,27.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 50000 && sum <= 100000 && creditTerm <= 6 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CREDITCARD.type +"_5")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(26.9)
                    .payment_month(creditPayment.calc(sum,26.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 50000 && sum <= 100000 && creditTerm > 6 && creditTerm<=12 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CREDITCARD.type +"_6")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(25.9)
                    .payment_month(creditPayment.calc(sum,25.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 50000 && sum <= 100000 && creditTerm > 12 && creditTerm <=24 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CREDITCARD.type +"_7")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(24.9)
                    .payment_month(creditPayment.calc(sum,24.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 100000 && sum <= 150000 && creditTerm <= 6  ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CREDITCARD.type +"_8")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(23.9)
                    .payment_month(creditPayment.calc(sum,23.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 100000 && sum <= 150000 && creditTerm > 6 && creditTerm<=12 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CREDITCARD.type +"_9")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(22.9)
                    .payment_month(creditPayment.calc(sum,22.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else if (sum > 100000 && sum <= 150000 && creditTerm > 12 && creditTerm<=24 ){
            return new Credit.CreditBuilder()
                    .credit_term(creditTerm)
                    .name(TypeOfCredit.CREDITCARD.type +"_10")
                    .client_id(client.getId())
                    .amount(sum)
                    .ptc(21.9)
                    .payment_month(creditPayment.calc(sum,21.9,creditTerm))
                    .opening_date(new Date(date.getTime()))
                    .build();
        }else {
            CreditFactory creditFactory = new CreditFactory();
            return creditFactory.createCredit(client,sum,"CONSUMER", creditTerm);
        }
    }

    @Override
    public boolean minusMoney(double money) {
        return false;
    }
}
