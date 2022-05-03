package app.bankApp.recieptBridge;

import app.bankApp.Bank;
import app.entities.Reciept;

import java.util.LinkedList;
import java.util.List;

public class RecieptCreditBridge implements RecieptBridge{
    @Override
    public void addReciept(Reciept reciept) {
        if (Bank.getInstance().getBankCollection().recieptForCredit.get(reciept.getNumOfProduct())!= null){
            LinkedList<Reciept> list = (LinkedList<Reciept>) Bank.getInstance().getBankCollection().recieptForCredit.get(reciept.getNumOfProduct());
            list.add(reciept);
            Bank.getInstance().getBankCollection().recieptForCredit.put(reciept.getNumOfProduct(), list);
        }else {
            List<Reciept> list = new LinkedList<>();
            list.add(reciept);
            Bank.getInstance().getBankCollection().recieptForCredit.put(reciept.getNumOfProduct(), list);
        }
    }
}
