package ru.bankApp.app.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employ_tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EmployTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "apply_credit_num")
    private String apply_credit_num;

    public EmployTask(String apply_credit_num) {
        this.apply_credit_num = apply_credit_num;
    }
}
