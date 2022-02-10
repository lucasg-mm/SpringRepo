package com.luv2code.hibernatetutorial.demo;

import com.luv2code.hibernatetutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try{
            // use the session object to save Java object
            System.out.println("Creating 3 student objects");

            // create 3 students objects
            Student tempStudent1 = new Student("John", "Doe", "john@love2code.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@love2code.com");
            Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@love2code.com");

            // start a transaction
            session.beginTransaction();

            // save the student
            System.out.println("Saving the student");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
