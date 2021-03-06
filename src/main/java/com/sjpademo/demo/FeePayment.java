package com.sjpademo.demo;

import javax.persistence.*;

@Entity
public class FeePayment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "mysqgen2"
    )

    @SequenceGenerator(name = "mysqgen2",
            initialValue = 1, allocationSize = 1
    )
    Integer id;

    Integer amount;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    public FeePayment() {};

    public FeePayment(Integer amount, Student student) {
        this.amount = amount;
        this.student = student;
    }
}
