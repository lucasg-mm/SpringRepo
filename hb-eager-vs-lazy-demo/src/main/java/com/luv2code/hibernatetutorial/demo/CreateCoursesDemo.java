package com.luv2code.hibernatetutorial.demo;

import com.luv2code.hibernatetutorial.entity.Course;
import com.luv2code.hibernatetutorial.entity.Instructor;
import com.luv2code.hibernatetutorial.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the instructor from the db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            Course course1 = new Course("Java is very nice");
            Course course2 = new Course("Ladders");
            Course course3 = new Course("Introduction to advanced");

            // create some courses and associate them to the instructor
            tempInstructor.add(course1);
            tempInstructor.add(course2);
            tempInstructor.add(course3);

            // save courses
            session.save(course1);
            session.save(course2);
            session.save(course3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }

    }
}
