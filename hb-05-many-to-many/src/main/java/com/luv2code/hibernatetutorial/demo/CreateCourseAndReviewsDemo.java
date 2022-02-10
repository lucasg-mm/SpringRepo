package com.luv2code.hibernatetutorial.demo;

import com.luv2code.hibernatetutorial.entity.Course;
import com.luv2code.hibernatetutorial.entity.Instructor;
import com.luv2code.hibernatetutorial.entity.InstructorDetail;
import com.luv2code.hibernatetutorial.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // create a course
            Course tempCourse = new Course("Pacman");

            // add some reviews
            tempCourse.addReview(new Review("Great course!!!"));
            tempCourse.addReview(new Review("Nice"));
            tempCourse.addReview(new Review("Goooood"));

            // save the course
            session.save(tempCourse);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }

    }
}
