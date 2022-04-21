package app.bankApp.FactoryProduct.CreditFactory;

import app.bankApp.Bank;
import app.entities.Client;
import app.entities.Credit;

public interface CreditCreater {
    Credit create(Bank bank, Client client,double sum, int creditTerm);
}
