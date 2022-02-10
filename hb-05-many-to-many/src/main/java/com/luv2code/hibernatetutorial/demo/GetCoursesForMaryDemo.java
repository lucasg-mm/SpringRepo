package com.luv2code.hibernatetutorial.demo;

import com.luv2code.hibernatetutorial.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetCoursesForMaryDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the student mary from the database
            int theId = 1;
            Student tempStudent = session.get(Student.class, theId);

            System.out.println("\n\nLoaded student: " + tempStudent);
            System.out.println("Courses enrolled in: " + tempStudent.getCourses());



            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }

    }
}
