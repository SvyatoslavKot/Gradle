package ru.bankApp.app.entities;


import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.Table;


@Entity
@Table(appliesTo = "employ_tasks")
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
    @Column(name = "apply_id")
    private int apply_id;
    @Column(name = "apply_credit_num")
    private String apply_credit_num;

    public EmployTask(int applyId, String apply_credit_num) {
        this.apply_id = applyId;
        this.apply_credit_num = apply_credit_num;
    }
}
