package com.sjpademo.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Student {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "mysqgen"
    )
    @SequenceGenerator(name = "mysqgen",
                initialValue = 1, allocationSize = 1
    )
    Integer id;

    @Column(nullable = false, name = "firstname")
    String firstName;

    @Column(name = "lastname")
    String lastName;

    @Column(unique = true)
    String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    Collection <FeePayment> feePaymentCollection;

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        feePaymentCollection = new ArrayList<>();
    }

    public Student() {};

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
