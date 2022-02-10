package com.luv2code.hibernatetutorial.demo;

import com.luv2code.hibernatetutorial.entity.Instructor;
import com.luv2code.hibernatetutorial.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the instructor detail object
            int theId = 3;
            InstructorDetail instructorDetailTemp = session.get(InstructorDetail.class, theId);

            // print the instructor detail
            System.out.println("Retrieved InstructorDetail: " + instructorDetailTemp);

            // print the associated instructor
            System.out.println("Associated instructor: " + instructorDetailTemp.getInstructor());

            // now let's delete them
            System.out.println("Deleting InstructorDetail...");
            session.delete(instructorDetailTemp);

            instructorDetailTemp.getInstructor().setInstructorDetail(null);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }

    }
}
