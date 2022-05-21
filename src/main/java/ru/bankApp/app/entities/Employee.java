package ru.bankApp.app.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name ="employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "mobile_phone")
    private  String mobile_phone;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "password")
    private String password;
    @Column(name = "position")
    private String position;
    @Column(name = "age")
    private int age;
    @Column(name = "activity")
    private boolean activity;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", activity=" + activity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && activity == employee.activity && Objects.equals(mobile_phone, employee.mobile_phone) && Objects.equals(name, employee.name) && Objects.equals(last_name, employee.last_name) && Objects.equals(password, employee.password) && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mobile_phone, name, last_name, password, position, age, activity);
    }
}
