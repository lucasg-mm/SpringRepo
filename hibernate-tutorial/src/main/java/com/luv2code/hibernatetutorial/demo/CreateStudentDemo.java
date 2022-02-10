package com.luv2code.hibernatetutorial.demo;

import com.luv2code.hibernatetutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try{
            // use the session object to save Java object
            System.out.println("Creating a new student object");

            // create student object
            Student tempStudent = new Student("Paul", "Wall", "paul@love2code.com");

            // start a transaction
            session.beginTransaction();

            // save the student
            System.out.println("Saving the student");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }
}
