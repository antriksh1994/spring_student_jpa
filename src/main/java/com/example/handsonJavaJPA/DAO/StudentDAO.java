package com.example.handsonJavaJPA.DAO;

import com.example.handsonJavaJPA.Entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findStudentById(int theId);

    List<Student> findAll();

}
