package ru.bankApp.app.entities;


import javax.persistence.*;
import lombok.Data;


@Data
@Table(name = "users")
@Entity
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column( name = "phone")
    private String phone;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private String status;
}
