package app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author SvyatoslavK
 * create Client
 * */
public class Client implements Serializable {
    private String userName;
    private String lastName;
    private String id;
    private String nickName;
    private String password;
    private ArrayList<Credit> CreditList = new ArrayList<>();

    public Client() {
    }
    /**
     * Constructor Client object
     * @param userName
     * @param lastName
     * @param id
     * @param nickName
     * @param password
     */
    public Client(String userName, String lastName, String id, String nickName, String password) {
        this.userName = userName;
        this.lastName = lastName;
        this.id = id;
        this.nickName = nickName;
        this.password = password;
    }
    /**
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     *
     * @return id
     */
    public String getId() {
        return id;
    }
    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     *
     * @return nickName
     */
    public String getNickName() {
        return nickName;
    }
    /**
     *
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    /**
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }
    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return CreditList
     */
    public ArrayList<Credit> getCreditList() {
        return CreditList;
    }

    /**
     *
     * @param creditList
     */
    public void setCreditList(ArrayList<Credit> creditList) {
        CreditList = creditList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!Objects.equals(userName, client.userName)) return false;
        return Objects.equals(password, client.password);

    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
