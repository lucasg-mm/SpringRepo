package com.luv2code.hibernatetutorial.demo;

import com.luv2code.hibernatetutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try{
            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            // display students
            displayStudents(theStudents);

            // query students: lastName=Doe
            theStudents = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();

            System.out.println("Students who have the last name of Doe");
            displayStudents(theStudents);

            //  query students: lastName=Doe OR firstName=Daffy
            theStudents = session.createQuery("from Student s where s.lastName = 'Doe' OR s.firstName = 'Daffy'").getResultList();

            System.out.println("Students who have the last name of Doe OR first name of Daffy");
            displayStudents(theStudents);

            // query students where the emails ends with luv2code.com

            theStudents = session.createQuery("from Student s where s.email LIKE '%love2code.com'").getResultList();

            System.out.println("Students who have an email that ends with love2code.com");
            displayStudents(theStudents);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }
}
