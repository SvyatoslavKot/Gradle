package app.bankApp.FactoryProduct.CreditFactory;

import app.bankApp.Bank;
import app.bankApp.serviceBank.CreditCalculationPayment;
import app.bankApp.serviceBank.GenerateAccountNumber;
import app.entities.Client;
import app.entities.Credit;

public class AvtoCredit extends Credit{
    GenerateAccountNumber genNum = new GenerateAccountNumber();
    CreditCalculationPayment creditPayment = new CreditCalculationPayment();
    @Override
    public void create(Bank bank, Client client, int sum, String type, int creditTerm) {
        if (sum <= 300000){

        }else if (sum > 300000 && sum <= 1000000 ){
            this.setCreditName("Avto_1");
            this.setAccountNumber(String.valueOf(genNum.genNum()));
            this.setAmount(sum);
            this.setPtc(17.9);
            this.setCreditTerm(creditTerm);
            this.setPaymentMonth(creditPayment.calc(sum,17.9,creditTerm));
            this.setIdHolder(client.getId());
        }else if (sum > 1000000 && sum <= 1300000 ){
            this.setCreditName("Avto_2");
            this.setAccountNumber(String.valueOf(genNum.genNum()));
            this.setAmount(sum);
            this.setPtc(15.9);
            this.setCreditTerm(creditTerm);
            this.setPaymentMonth(creditPayment.calc(sum,17.9,creditTerm));
            this.setIdHolder(client.getId());
        }else if (sum > 1300000 && sum <= 1700000 ){
            this.setCreditName("Avto_3");
            this.setAccountNumber(String.valueOf(genNum.genNum()));
            this.setAmount(sum);
            this.setPtc(13.9);
            this.setCreditTerm(creditTerm);
            this.setPaymentMonth(creditPayment.calc(sum,17.9,creditTerm));
            this.setIdHolder(client.getId());

        }else if (sum > 1700000 && sum <= 2500000 ){
            this.setCreditName("Avto_4");
            this.setAccountNumber(String.valueOf(genNum.genNum()));
            this.setAmount(sum);
            this.setPtc(12.9);
            this.setCreditTerm(creditTerm);
            this.setPaymentMonth(creditPayment.calc(sum,17.9,creditTerm));
            this.setIdHolder(client.getId());
        }else if (sum > 2500000 && sum <= 5000000 ){
            this.setCreditName("Avto_5");
            this.setAccountNumber(String.valueOf(genNum.genNum()));
            this.setAmount(sum);
            this.setPtc(10.9);
            this.setCreditTerm(creditTerm);
            this.setPaymentMonth(creditPayment.calc(sum,10.9,creditTerm));
            this.setIdHolder(client.getId());

        }else {

        }
    }
}
