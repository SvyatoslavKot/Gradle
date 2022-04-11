package app.bankApp.bankCollection;

import app.bankApp.Bank;
import app.entities.Credit;

import java.util.*;

public class SortCreditList {

    public List<Credit> sortByAmountLow(List<Credit> creditSet) {
        List list = new ArrayList(creditSet);
        Collections.sort(list, new Comparator<Credit>() {
            @Override
            public int compare(Credit o1, Credit o2) {
                if (o1.getAmount() > o2.getAmount()) return 1;
                else if (o1.getAmount() < o2.getAmount()) return -1;
                else return 0;
            }
        });
        return list;
    }


    public List<Credit> sortByAmountHight(List<Credit> creditSet) {
        List list = creditSet;
        Collections.sort(list, new Comparator<Credit>() {
            @Override
            public int compare(Credit o1, Credit o2) {
                if (o1.getAmount() < o2.getAmount()) return 1;
                else if (o1.getAmount() > o2.getAmount()) return -1;
                else return 0;
            }
        });
        return list;
    }


    public List<Credit> sortByName(List<Credit> creditSet) {
        List list = new ArrayList(creditSet);
        Collections.sort(list, new Comparator<Credit>() {
            @Override
            public int compare(Credit o1, Credit o2) {
                return o1.getCreditName().compareTo(o2.getCreditName());
            }
        });
        return list;
    }


    public List<Credit> sortByDate(List<Credit> creditSet) {
        List list = new ArrayList(creditSet);
        Collections.sort(list, new Comparator<Credit>() {
            @Override
            public int compare(Credit o1, Credit o2) {
                return o1.getOpeningDate().compareTo(o2.getOpeningDate());
            }
        });
        return list;
    }

}
