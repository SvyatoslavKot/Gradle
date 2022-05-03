package app.bankApp.recieptBridge;

public enum TypeOperetion {
    CREDIT_PLUS("Оплата"),
    ACCOUNT_PLUS("Пополнение счёта"),
    ACCOUNT_MINUS("Оплата"),
    ACCOUNT_TRANSFER("Перевод"),
    ACCOUNT_TRANSFER_BETWEEN_OWN("Первод между своими счетами");

    //значение enum
    public String type;
    /**
     * constructor that sets a value enum
     * @param type
     */
    TypeOperetion(String type){
        this.setType(type);
    }
    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}
