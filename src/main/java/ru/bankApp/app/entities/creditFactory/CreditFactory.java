package ru.bankApp.app.entities.creditFactory;

import ru.bankApp.app.entities.Client;

/**
 * pattern Factory. This class disigned to create objects as a child of the credit class
 * @see AvtoCredit
 */
public class CreditFactory {
    /**
     * create an object of credit class according to the specified parameters creditType {@link TypeOfCredit} which is const
     * @param client
     * @param sum
     * @param type defines the class of child
     * @param creditTerm
     * @return Credit
     */
    public Credit createCredit ( Client client, double sum, String type, int creditTerm){
        switch (type) {
            case "AVTO" : return new AvtoCredit().create(client,sum,creditTerm);
            case "CONSUMER" : return new ConsumerCredit().create(client,sum,creditTerm);
            case "HYPOTHEC" : return new Hypothec().create(client,sum,creditTerm);

            default: return null;
        }
    }
}
