package com.luv2code.hibernatetutorial.demo;

import com.luv2code.hibernatetutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try{
            // use the session object to save Java object
            System.out.println("Creating a new student object");

            // create student object
            Student tempStudent = new Student("Daffy", "Duck", "daffy@love2code.com");

            // start a transaction
            session.beginTransaction();

            // save the student
            System.out.println("Saving the student");
            System.out.println(tempStudent);
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            // NEW CODE

            // find out the student's id: primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the primary key
            System.out.println("Getting student with the id: " + tempStudent.getId());

            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("Get complete: " + myStudent);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }
}
