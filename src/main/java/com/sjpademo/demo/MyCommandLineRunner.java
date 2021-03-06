package com.sjpademo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private final StudentRepository sturep;

    @Autowired
    public MyCommandLineRunner(StudentRepository sturep) {
        this.sturep = sturep;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world");
        Student student1 = new Student("foo", "bar", "foobar@iisc.ac.in");

        FeePayment fee1 = new FeePayment(10000, student1);
        FeePayment fee2 = new FeePayment(20000, student1);
        student1.feePaymentCollection.add(fee1);
        student1.feePaymentCollection.add(fee2);
        sturep.save(student1);
    }
}
