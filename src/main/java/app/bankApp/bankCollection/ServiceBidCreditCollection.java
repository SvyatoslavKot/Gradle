package app.bankApp.bankCollection;

import app.bankApp.Bank;
import app.entities.BidCredit;
import app.entities.Client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ServiceBidCreditCollection {

    Bank bank = Bank.getInstance();
    public ArrayList<BidCredit> getAllBids() {
        Collection<BidCredit> values = bank.getBankCollection().getCreditBids().values();
        ArrayList<BidCredit> listBids = new ArrayList<>(values);
        return listBids;
    }

    public BidCredit getNum (int num){
        BidCredit bid = bank.getBankCollection().getCreditBids().get(num);
        return bid;
    }

    public void addBid (BidCredit bidCredit){
        bank.getBankCollection().getCreditBids().put(bidCredit.getNumBid(),bidCredit);
    }
    public ArrayList<BidCredit> getBiClient(Client client){
        HashMap<Integer,BidCredit> bidCreditHashMap = bank.getBankCollection().getCreditBids();
        ArrayList<BidCredit> bidCreditsList = new ArrayList<>();
        for (Map.Entry<Integer, BidCredit> bid: bidCreditHashMap.entrySet()){
            BidCredit bidCredit = bid.getValue();
            if (bidCredit.getCredit().getPhoneHolder().equals(client.getMobilePhone())){
                bidCreditsList.add(bidCredit);
            }
        }
        return bidCreditsList;
    }

    public void removeBidCredit (BidCredit bidCredit){
        if ( bank.getBankCollection().getCreditBids().get(bidCredit.getNumBid())!= null){
            bank.getBankCollection().getCreditBids().remove(bidCredit.getNumBid());
        }
    }

}
