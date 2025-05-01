package com.example.handsonJavaJPA;

import com.example.handsonJavaJPA.DAO.StudentDAO;
import com.example.handsonJavaJPA.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HandsonJavaJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandsonJavaJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			findStudentById(studentDAO);
		};
	}
	public void createStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Paul", "Den", "Paul@gmail.com");
		studentDAO.save(tempStudent);
		System.out.println("Saving student: " + tempStudent);
	}
	public void findStudentById (StudentDAO studentDAO) {
		int id = 1;
		System.out.println("===inside find student====");
		Student tempStudent = studentDAO.findStudentById(id);
		System.out.println("===Finding student====" + tempStudent);
	}
}
//The method main() in HandsonJavaJpaApplication.java is called.
//Spring Boot starts and initializes the Spring context
// The @Bean annotated method commandLineRunner() is executed after the application context is loaded.
// Spring injects a StudentDAO instance into this method.
// The CommandLineRunner triggers the method createStudent(studentDAO)
// Inside createStudent()
// A new Student object is created.
// The constructor sets its firstName, lastName, and email.
// studentDAO.save(tempStudent); calls save() in your StudentDAOImpl.
// The EntityManager is JPA's way of interacting with the database.
// persist() tells JPA to insert the student into the database.
// Since @Transactional is used, this runs in a transaction.