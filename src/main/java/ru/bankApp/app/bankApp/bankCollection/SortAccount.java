package ru.bankApp.app.bankApp.bankCollection;

import ru.bankApp.app.entities.accountFactory.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class for sorting Account
 */
public class SortAccount {
    /**
     * Sort Account by param {@link Account#getMoney_in_account()} Low to Height, accept input Collection List<Account>
     * used the method sort of the class Collection {@link Collections#sort(List, Comparator)} which override method compare
     * @param accountList
     * @return List
     */
    public List<Account> sortByMoneyLow(List<Account> accountList) {
        List list = new ArrayList(accountList);
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                if (o1.getMoney_in_account() > o2.getMoney_in_account()) return 1;
                else if (o1.getMoney_in_account() < o2.getMoney_in_account()) return -1;
                else return 0;
            }
        });
        return list;
    }

    /**
     * Sort Account by param {@link Account#getMoney_in_account()}Height to Low, accept input Collection List<Account>
     * used the method sort of the class Collection {@link Collections#sort(List, Comparator)} which override method compare
     * @param accountList
     * @return List
     */
    public List<Account> sortByMoneyHight(List<Account> accountList) {
        List list = accountList;
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                if (o1.getMoney_in_account() < o2.getMoney_in_account()) return 1;
                else if (o1.getMoney_in_account() > o2.getMoney_in_account()) return -1;
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
     * Sort Account by param {@link Account#getName()}, accept input Collection List<Account>
     * used the method sort of the class Collection {@link Collections#sort(List, Comparator)} which override method compare
     * @param accountList
     * @return List
     */
    public List<Account> sortByName(List<Account> accountList) {
        List list = new ArrayList(accountList);
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return list;
    }

    /**
     * Sort Account by param {@link Account}, accept input Collection List<Account>
     * used the method sort of the class Collection {@link Collections#sort(List, Comparator)} which override method compare
     * @param accountList
     * @return List
     */
    public List<Account> sortByIdHolder(List<Account> accountList) {
    return  null;
    }

}
