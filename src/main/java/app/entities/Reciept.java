package app.entities;

import app.bankApp.recieptBridge.RecieptBridge;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Reciept {
    private String typeOfProduct;
    private String type;
    private String title;
    private String value;
    private String numOfProduct;
    private String userPhone;
    private long date;

    Date d = new Date();

    RecieptBridge bridge;

    public Reciept(RecieptBridge bridge, String typeOfProduct, String type, String title, String value, String numOfProduct, String userPhone) {
        this.bridge= bridge;
        this.date = d.getTime();
        this.typeOfProduct = typeOfProduct;
        this.type = type;
        this.title = title;
        this.value = value;
        this.numOfProduct = numOfProduct;
        this.userPhone = userPhone;
        addHistory();
    }

    public void addHistory(){
        bridge.addReciept(this);
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    public String getNumOfProduct() {
        return numOfProduct;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reciept{" +
                "typeOfProduct='" + typeOfProduct + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", numOfProduct='" + numOfProduct + '\'' +
                ", nameOfUser='" + userPhone + '\'' +
                '}';
    }
}
