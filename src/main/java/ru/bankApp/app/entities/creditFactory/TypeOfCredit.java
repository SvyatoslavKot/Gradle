package ru.bankApp.app.entities.creditFactory;

/**
 * enum that stores constants type of credit
 */
public enum TypeOfCredit {
    AVTO("Avto_Credit"),
    CONSUMER("Consumer"),
    HYPOTHEC("Hypothec"),
    CREDITCARD("Credit Card");

    //значение enum
    String type;
    /**
     * constructor that sets a value enum
     * @param type
     */
    TypeOfCredit(String type){
        this.setType(type);
    }
    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}
