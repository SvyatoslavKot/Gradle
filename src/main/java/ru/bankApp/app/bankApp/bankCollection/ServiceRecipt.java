package ru.bankApp.app.bankApp.bankCollection;

import ru.bankApp.app.bankApp.Bank;
import ru.bankApp.app.bankApp.exeption.RecieptNullEx;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.Receipt;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ServiceRecipt {

    public LinkedList<Receipt> getListByClient (Client client){
        String key = client.getNickName();
        HashMap<String, List<Receipt>> receiptMap = Bank.getInstance().getBankCollection().recieptForLogin;
        LinkedList<Receipt> listOfReceipt = (LinkedList<Receipt>) receiptMap.get(key);
        return listOfReceipt;
    }

    public LinkedList<Receipt> getListByAccount (String accNum) throws RecieptNullEx {
        String key = accNum;
        if (Bank.getInstance().getBankCollection().recieptForAccount!=null){
            HashMap<String, List<Receipt>> receiptMap = Bank.getInstance().getBankCollection().recieptForAccount;
            LinkedList<Receipt> listOfReceipt = (LinkedList<Receipt>) receiptMap.get(key);
            return listOfReceipt;
        } else throw new RecieptNullEx("История не найдена");


    }

    public LinkedList<Receipt> getListByCredit (String creditNum){
        String key = creditNum;
        HashMap<String, List<Receipt>> receiptMap = Bank.getInstance().getBankCollection().recieptForCredit;
        LinkedList<Receipt> listOfReceipt = (LinkedList<Receipt>) receiptMap.get(key);
        return listOfReceipt;
    }

    public LinkedList<Receipt> getLastTenForClient (Client client) throws RecieptNullEx {
        String key = client.getNickName();
        LinkedList<Receipt> lasts = new LinkedList<>();
        LinkedList<Receipt> list =  getListByAccount(key);
        while (list.size()>0 && lasts.size()<11){
            lasts.add(list.pollLast());
        }
        return lasts;
    }
    public LinkedList<Receipt> getLastTenForCredit (String creditNum) throws RecieptNullEx {
        String key = creditNum;
        LinkedList<Receipt> lasts = new LinkedList<>();
        LinkedList<Receipt> list =  getListByAccount(key);
        if (list!=null){
            while (list.size()>0 && lasts.size()<11){
                lasts.add(list.pollLast());
            }
            return lasts;
        }else return null;

    }

    public LinkedList<Receipt> getLastTenForAccount (String accountNum) throws RecieptNullEx {
        String key = accountNum;
        LinkedList<Receipt> lasts = new LinkedList<>();
       LinkedList<Receipt> list =  getListByAccount(key);
       if (list!=null){
           while (list.size()>0 && lasts.size()<11){
               lasts.add(list.pollLast());
           }
           return lasts;
       }else throw new RecieptNullEx("История не найдена");

    }
}
