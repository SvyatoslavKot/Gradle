package ru.bankApp.app.entities.creditFactory;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.Table;
import ru.bankApp.app.entities.Product;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.Client;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(appliesTo = "credits")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Credit implements Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="client_id")
    private int client_id;
    @Column(name ="account_link_id")
    private int account_link_id;
    @Column(name ="name")
    private String name ;
    @Column(name ="account_number")
    private String account_number;
    @Column(name ="amount")
    private double amount;
    @Column(name ="ptc")
    private double ptc;
    @Column(name ="opening_date")
    private Date opening_date;
    @Column(name ="credit_term")
    private int credit_term;
    @Column(name ="payment_month")
    private double payment_month;

    @Override
    public Credit create(Client client, double sum, int creditTerm) {
        return null;
    }
    @Override
    public Account create(Client client, int creditTerm, String pin, String level) {
        return null;
    }
    @Override
    public boolean reName(String name) {
            return true;
    }

    @Override
    synchronized public boolean pluseMoney(double money) {
        double balance;
        balance = this.amount - money;
        this.setAmount(balance);
        return true;
    }

    @Override
    synchronized public boolean minusMoney(double money) {
        return false;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", account_link_id=" + account_link_id +
                ", name='" + name + '\'' +
                ", account_number='" + account_number + '\'' +
                ", amount=" + amount +
                ", ptc=" + ptc +
                ", opening_date=" + opening_date +
                ", credit_term=" + credit_term +
                ", payment_month=" + payment_month +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return id == credit.id && client_id == credit.client_id && account_link_id == credit.account_link_id && Double.compare(credit.amount, amount) == 0 && Double.compare(credit.ptc, ptc) == 0 && credit_term == credit.credit_term && Double.compare(credit.payment_month, payment_month) == 0 && Objects.equals(name, credit.name) && Objects.equals(account_number, credit.account_number) && Objects.equals(opening_date, credit.opening_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client_id, account_link_id, name, account_number, amount, ptc, opening_date, credit_term, payment_month);
    }
}
