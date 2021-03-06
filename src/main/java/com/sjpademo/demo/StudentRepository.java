package com.sjpademo.demo;

import org.springframework.data.repository.Repository;

public interface StudentRepository extends Repository <Student, Integer> {

    void save(Student s);

    Student findById(Integer id);
}
