package ru.bankApp.app.entities;

import javax.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import ru.bankApp.app.entities.accountFactory.Account;
import java.io.Serializable;
import java.util.*;


/**
 * @author SvyatoslavK
 * create Client
 * */
@Entity
@Table(appliesTo = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "mobilephone")
    @NotEmpty(message = "phone should not be empty")
    @Size(min = 6, max = 12, message = "phone should be 6-12 ")
    private  String mobilePhone;

    @Column(name = "username")
    @NotEmpty(message = "Name should not be empty")
    @Size(min= 3, max = 12, message = "Name should be 3-12 ")
    private String userName;

    @Column(name = "lastname")
    @NotEmpty(message = "Lastname should not be empty")
    @Size(min= 3, max = 12, message = "Lastname should be 3-12 ")
    private String lastName;

    @Column(name = "age")
    //@Size(min=1,max=120, message = "uncorrect age")
    private int age;

    @Size(min= 3, max = 12, message = "Lastname should be 3-12 ")
    private String nickName;

    @Column(name = "email")
    @NotEmpty(message = "Mail should not be empty")
    @Email(message = "Mail not validate")
    private String eMail;

    @Column(name = "password")
    @NotEmpty(message = "password should not be empty")
    @Size(min = 6, max = 30, message = "Password uncorrect")
    private String password;

    @Column(name = "addressee")
    private String addressee ;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


    public Client() {
    }
    public Client(String mobilePhone, String userName, String lastName, String password, String email, int age, String addressee) {
        this.mobilePhone = mobilePhone;
        this.userName = userName;
        this.lastName = lastName;
        this.eMail = email;
        this.age = age;
        this.addressee= addressee;
        this.password = password;

    }

    public void addAccount(Account account) {
        account.setClient(this);
        account.setClient_id(this.id);
    }

    public String getAddressee() {
        return addressee;
    }
    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", addressee='" + addressee + '\'' +
                '}';
    }
}
