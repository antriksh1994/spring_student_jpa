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
			createStudent(studentDAO);
		};
	}
	public void createStudent(StudentDAO theStudent) {
		Student tempStudent = new Student("Paul", "Den", "Paul@gmail.com");
		theStudent.save(tempStudent);
		System.out.println("Saving student: " + tempStudent);
	}
}
