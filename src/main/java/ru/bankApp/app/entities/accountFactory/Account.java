package ru.bankApp.app.entities.accountFactory;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.bankApp.app.entities.Product;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.creditFactory.Credit;

import javax.persistence.*;
import java.util.Date;

/**
 * @author SvyatoslavK
 * create Account implements interface  {@link Product#create( Client, int, String, String)} , this entities Account object
 * */
@Entity
@Table (name = "account_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public  class  Account  implements Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;
    @Column(name ="name")
    private String name;
    @Column(name ="account_num")
    private String account_num;
    @Column(name ="money_in_account")
    private double money_in_account;
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @Column(name ="date")
    private Date date;
    @Column(name ="credit_term")
    private int credit_term;
    @Column(name ="payment")
    private double payment;
    @Column(name ="cash_back")
    private double cashBack;
    @Column(name ="client_id")
    private int client_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account_num='" + account_num + '\'' +
                ", money_in_account=" + money_in_account +
                ", date=" + date +
                ", creditTerm=" + credit_term +
                ", payment=" + payment +
                ", cashBack=" + cashBack +
                ", client_id=" + client_id +
                ", client=" + client +
                '}';
    }

    @Override
    public Account create( Client client, int creditTerm, String pin, String level) {
        return null;
    }

    @Override
    public Credit create(Client client, double sum, int creditTerm) {
        return null;
    }

    @Override
    public boolean reName(String name) {
        return false;
    }

    @Override
    public boolean setMoney(double money) {
        double balance;
        balance = this.getMoney_in_account() + money;
        this.setMoney_in_account(balance);
        return true;
    }

    @Override
    public boolean getMoney(double money) {
        if (this.getMoney_in_account()<money){
            return false;
        }else {
            double balance = this.money_in_account -money;
            this.setMoney_in_account(balance);
            return true;
        }
    }

}
