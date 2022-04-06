package app.bankApp.FactoryProduct.CreditFactory;

import app.entities.Credit;

public class CreditFactory {
    public Credit createCredit (String creditType){
        switch (creditType) {
            case "avto" : return new AvtoCredit();

            default: return null;
        }
    }
}
