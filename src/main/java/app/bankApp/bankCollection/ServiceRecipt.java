package app.bankApp.bankCollection;

import app.bankApp.Bank;
import app.bankApp.exeption.RecieptNullEx;
import app.entities.Client;
import app.entities.Reciept;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ServiceRecipt {

    public LinkedList<Reciept> getListByClient (Client client){
        String key = client.getNickName();
        HashMap<String, List<Reciept>> receiptMap = Bank.getInstance().getBankCollection().recieptForLogin;
        LinkedList<Reciept> listOfReceipt = (LinkedList<Reciept>) receiptMap.get(key);
        return listOfReceipt;
    }

    public LinkedList<Reciept> getListByAccount (String accNum) throws RecieptNullEx {
        String key = accNum;
        if (Bank.getInstance().getBankCollection().recieptForAccount!=null){
            HashMap<String, List<Reciept>> receiptMap = Bank.getInstance().getBankCollection().recieptForAccount;
            LinkedList<Reciept> listOfReceipt = (LinkedList<Reciept>) receiptMap.get(key);
            return listOfReceipt;
        } else throw new RecieptNullEx("История не найдена");


    }

    public LinkedList<Reciept> getListByCredit (String creditNum){
        String key = creditNum;
        HashMap<String, List<Reciept>> receiptMap = Bank.getInstance().getBankCollection().recieptForCredit;
        LinkedList<Reciept> listOfReceipt = (LinkedList<Reciept>) receiptMap.get(key);
        return listOfReceipt;
    }

    public LinkedList<Reciept> getLastTenForClient (Client client) throws RecieptNullEx {
        String key = client.getNickName();
        LinkedList<Reciept> lasts = new LinkedList<>();
        LinkedList<Reciept> list =  getListByAccount(key);
        while (list.size()>0 && lasts.size()<11){
            lasts.add(list.pollLast());
        }
        return lasts;
    }
    public LinkedList<Reciept> getLastTenForCredit (String creditNum) throws RecieptNullEx {
        String key = creditNum;
        LinkedList<Reciept> lasts = new LinkedList<>();
        LinkedList<Reciept> list =  getListByAccount(key);
        if (list!=null){
            while (list.size()>0 && lasts.size()<11){
                lasts.add(list.pollLast());
            }
            return lasts;
        }else return null;

    }

    public LinkedList<Reciept> getLastTenForAccount (String accountNum) throws RecieptNullEx {
        String key = accountNum;
        LinkedList<Reciept> lasts = new LinkedList<>();
       LinkedList<Reciept> list =  getListByAccount(key);
       if (list!=null){
           while (list.size()>0 && lasts.size()<11){
               lasts.add(list.pollLast());
           }
           return lasts;
       }else throw new RecieptNullEx("История не найдена");

    }
}
