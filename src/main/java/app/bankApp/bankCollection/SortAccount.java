package app.bankApp.bankCollection;

import app.entities.Account;
import app.entities.Credit;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class for sorting Account
 */
public class SortAccount {
    /**
     * Sort Account by param {@link Account#getMoneyInAccount()} Low to Height, accept input Collection List<Account>
     * used the method sort of the class Collection {@link Collections#sort(List, Comparator)} which override method compare
     * @param accountList
     * @return List
     */
    public List<Account> sortByMoneyLow(List<Account> accountList) {
        List list = new ArrayList(accountList);
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                if (o1.getMoneyInAccount() > o2.getMoneyInAccount()) return 1;
                else if (o1.getMoneyInAccount() < o2.getMoneyInAccount()) return -1;
                else return 0;
            }
        });
        return list;
    }

    /**
     * Sort Account by param {@link Account#getMoneyInAccount()}Height to Low, accept input Collection List<Account>
     * used the method sort of the class Collection {@link Collections#sort(List, Comparator)} which override method compare
     * @param accountList
     * @return List
     */
    public List<Account> sortByMoneyHight(List<Account> accountList) {
        List list = accountList;
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                if (o1.getMoneyInAccount() < o2.getMoneyInAccount()) return 1;
                else if (o1.getMoneyInAccount() > o2.getMoneyInAccount()) return -1;
                else return 0;
            }
        });
        return list;
    }
    /**
     * Sort Account by param {@link Account#getPayment()}Height to Low, accept input Collection List<Account>
     * used the method sort of the class Collection {@link Collections#sort(List, Comparator)} which override method compare
     * @param accountList
     * @return List
     */
    public List<Account> sortByPaymentHeight(List<Account> accountList) {
        List list = accountList;
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                if (o1.getPayment() < o2.getPayment()) return 1;
                else if (o1.getPayment() > o2.getPayment()) return -1;
                else return 0;
            }
        });
        return list;
    }
    /**
     * Sort Account by param {@link Account#getPayment()}Low to Height, accept input Collection List<Account>
     * used the method sort of the class Collection {@link Collections#sort(List, Comparator)} which override method compare
     * @param accountList
     * @return List
     */
    public List<Account> sortByPaymentLow(List<Account> accountList) {
        List list = new ArrayList(accountList);
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                if (o1.getPayment() > o2.getPayment()) return 1;
                else if (o1.getPayment() < o2.getPayment()) return -1;
                else return 0;
            }
        });
        return list;
    }



    /**
     * Sort Account by param {@link Account#getNameAccount()}, accept input Collection List<Account>
     * used the method sort of the class Collection {@link Collections#sort(List, Comparator)} which override method compare
     * @param accountList
     * @return List
     */
    public List<Account> sortByName(List<Account> accountList) {
        List list = new ArrayList(accountList);
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getNameAccount().compareTo(o2.getNameAccount());
            }
        });
        return list;
    }

    /**
     * Sort Account by param {@link Account#getIdHolder()}, accept input Collection List<Account>
     * used the method sort of the class Collection {@link Collections#sort(List, Comparator)} which override method compare
     * @param accountList
     * @return List
     */
    public List<Account> sortByIdHolder(List<Account> accountList) {
        List list = new ArrayList(accountList);
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getIdHolder().compareTo(o2.getIdHolder());
            }
        });
        return list;
    }

}
