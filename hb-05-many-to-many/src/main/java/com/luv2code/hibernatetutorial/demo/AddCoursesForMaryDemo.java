package com.luv2code.hibernatetutorial.demo;

import com.luv2code.hibernatetutorial.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForMaryDemo {
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
            int theId = 2;
            Student tempStudent = session.get(Student.class, theId);

            System.out.println("\n\nLoaded student: " + tempStudent);
            System.out.println("Courses enrolled in: " + tempStudent.getCourses());

            // create more courses
            Course course1 = new Course("Rubik's cube - how to speed cube");
            Course course2 = new Course("Atari 2600 - Gaming Development");

            // add student to courses
            course1.addStudent(tempStudent);
            course2.addStudent(tempStudent);

            // save the courses
            System.out.println("\n\nSaving the courses...");
            session.save(course1);
            session.save(course2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }

    }
}
