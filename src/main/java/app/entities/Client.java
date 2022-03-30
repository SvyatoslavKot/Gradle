package app.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author SvyatoslavK
 * создает объект клиента
 * */
public class Client implements Serializable {
    private String userName;
    private String lastName;
    private String id;
    private String nickName;
    private String password;

    public Client() {
    }
    /**
     *конструктор создания клиента
     * @param userName
     * @param password
     */
    public Client(String userName, String password) {
        this.userName = userName;
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

    @Override
    public String toString() {
        return "Client{" +
                "userName='" + userName + '\'' +
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
