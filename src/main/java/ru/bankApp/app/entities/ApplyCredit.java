package ru.bankApp.app.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "apply_credit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ApplyCredit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name ="number")
    private String number;
    @Column(name ="status")
    private String status;
    @Column(name ="credit_id")
    private int credit_id;
    @Column(name ="client_id")
    private int client_id;
    @Column(name ="child")
    private int child;
    @Column(name ="family_status")
    private boolean family_status;
    @Column(name ="income")
    private int income;
    @Column(name ="other_credit")
    private double other_credit;
    @Column(name ="experience")
    private int experience;
    @Column(name ="age")
    private int age;
    @Column(name ="solvency")
    private double solvency;

    public ApplyCredit(String number, int client_id, int child, String family_status, int income, int experience, int age, double other_credit) {
        if (family_status.equals("0")){
            this.family_status = false;
        }else {
            this.family_status = true;
        }
        this.other_credit = other_credit;
        this.number = number;
        this.client_id = client_id;
        this.child = child;
        this.income = income;
        this.experience = experience;
        this.age = age;
    }

    /*
    public double calckSolvency(){
        double otherPayment = 0;
        double kof = 1;
        Client client = serviceClient.getClientByPhone(this.credit.getPhoneHolder());
        ArrayList<Credit> credits = serviceCredit.getAccountByClient(client);

        if (child ==1){kof = kof+ 0.2;}
        else if (child ==2){kof = kof+ 0.3;}
        else if (child ==3){kof = kof+ 0.4;}
        else if (child >3){kof = kof+ 0.5;}

        if (experience == 0 ){kof = kof + 0.6;}
        else if (experience == 1 ){kof = kof + 0.5;}
        else if (experience == 2 ){kof = kof + 0.4;}
        else if (experience == 3 ){kof = kof + 0.3;}

        if (age < 19){kof = kof +0.6;}
        else if (age >= 19 && age<21){kof = kof +0.5;}
        else if (age >= 21 && age<27 && age >= 57){kof = kof +0.2;}

        if (credits.size()!=0){
            for (Credit c : credits){
               otherPayment = otherPayment + c.getPaymentMonth();
            }
        }

        otherPayment = otherPayment + otherCredit;
        return (income - otherPayment)/kof;
    }

 */
/*
    public void checkPaymentForSolvency(){
        double pay = this.credit.getPaymentMonth();
        double sol = this.solvency;
        if ((sol - pay) < 0){
            this.status = StatusBidCreditEnum.PREV_DENIED.status;
        }else {
            this.status = StatusBidCreditEnum.PREV_APPROVED.status;
        }
    }
*/

    @Override
    public String toString() {
        return "ApplyCredit{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", credit_id=" + credit_id +
                ", client_id=" + client_id +
                ", child=" + child +
                ", family_status=" + family_status +
                ", income=" + income +
                ", other_credit=" + other_credit +
                ", experience=" + experience +
                ", age=" + age +
                ", solvency=" + solvency +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplyCredit that = (ApplyCredit) o;
        return id == that.id && credit_id == that.credit_id && client_id == that.client_id && child == that.child && family_status == that.family_status && income == that.income && Double.compare(that.other_credit, other_credit) == 0 && experience == that.experience && age == that.age && Double.compare(that.solvency, solvency) == 0 && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, credit_id, client_id, child, family_status, income, other_credit, experience, age, solvency);
    }
}
