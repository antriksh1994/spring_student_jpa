package com.example.handsonJavaJPA.DAO;

import com.example.handsonJavaJPA.Entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Transactional
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
