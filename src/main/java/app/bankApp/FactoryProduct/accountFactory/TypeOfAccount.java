package app.bankApp.FactoryProduct.accountFactory;
/**
 * enum that stores constants type of Account
 */
public enum TypeOfAccount {
    STANDARD("Standard_account"),
    CURRENCY("Currency_account"),
    PREMIUM("Premium_account"),
    TRAVEL("Travel_account");

    //значение enum
    String type;
    /**
     * constructor that sets a value enum
     * @param type
     */
    TypeOfAccount(String type){
        this.setType(type);
    }
    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}
