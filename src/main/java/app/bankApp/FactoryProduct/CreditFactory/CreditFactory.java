package app.bankApp.FactoryProduct.CreditFactory;

import app.bankApp.Bank;
import app.entities.Client;
import app.entities.Credit;

/**
 * pattern Factory. This class disigned to create objects as a child of the credit class
 * @see AvtoCredit
 */
public class CreditFactory {
    /**
     * create an object of credit class according to the specified parameters creditType
     * @param bank
     * @param client
     * @param sum
     * @param type defines the class of child
     * @param creditTerm
     * @return Credit
     */
    public Credit createCredit (Bank bank, Client client, int sum, String type, int creditTerm){
        switch (type) {
            case "AVTO" : return new AvtoCredit().create(bank,client,sum,creditTerm);
            case "CONSUMER" : return new ConsumerCredit().create(bank,client,sum,creditTerm);
            case "HYPOTHEC" : return new Hypothec().create(bank,client,sum,creditTerm);

            default: return null;
        }
    }
}
