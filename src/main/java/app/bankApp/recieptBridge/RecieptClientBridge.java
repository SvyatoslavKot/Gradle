package app.bankApp.recieptBridge;

import app.bankApp.Bank;
import app.entities.Reciept;

import java.util.LinkedList;
import java.util.List;

public class RecieptClientBridge implements RecieptBridge{
    @Override
    public void addReciept(Reciept reciept) {
        if (Bank.getInstance().getBankCollection().recieptForLogin.get(reciept.getNumOfProduct())!= null){
            LinkedList<Reciept> list = (LinkedList<Reciept>) Bank.getInstance().getBankCollection().recieptForLogin.get(reciept.getNumOfProduct());
            list.add(reciept);
            Bank.getInstance().getBankCollection().recieptForLogin.put(reciept.getNumOfProduct(), list);
        }else {
            List<Reciept> list = new LinkedList<>();
            list.add(reciept);
            Bank.getInstance().getBankCollection().recieptForLogin.put(reciept.getNumOfProduct(), list);
        }
    }
}
