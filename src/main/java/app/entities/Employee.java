package app.entities;

import java.util.Objects;

public class Employee {
    private  String mobilePhone;
    private String userName;
    private String lastName;
    private String id;
    private String nickName;
    private String password;
    private String position;
    private int age;

    private Employee(Builder builder) {
        this.mobilePhone = builder.mobilePhone;
        this.userName = builder.userName;
        this.lastName = builder.lastName;
        this.id = builder.id;
        this.nickName = builder.nickName;
        this.password = builder.password;
        this.position = builder.position;
        this.age = builder.age;
    }
    public static class Builder{
        private  String mobilePhone;
        private String userName;
        private String lastName;
        private String id;
        private String nickName;
        private String password;
        private String position;
        private int age;


        public Builder(String mobilePhone, String userName, String password) {
            this.mobilePhone = mobilePhone;
            this.userName = userName;
            this.password = password;
        }
        public Builder lastName (String lN){
            lastName = lN;
            return this;
        }
        public Builder id (String iD){
            id = iD;
            return this;
        }
        public Builder nickName (String nN){
            nickName = nN;
            return this;
        }
        public Builder position (String p){
            position = p;
            return this;
        }
        public Builder age (int aGe){
            age = aGe;
            return this;
        }
        public Employee build(){
            return new Employee(this);
        }
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(mobilePhone, employee.mobilePhone) && Objects.equals(userName, employee.userName) && Objects.equals(lastName, employee.lastName) && Objects.equals(id, employee.id) && Objects.equals(nickName, employee.nickName) && Objects.equals(password, employee.password) && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobilePhone, userName, lastName, id, nickName, password, position, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "mobilePhone='" + mobilePhone + '\'' +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                '}';
    }
}
