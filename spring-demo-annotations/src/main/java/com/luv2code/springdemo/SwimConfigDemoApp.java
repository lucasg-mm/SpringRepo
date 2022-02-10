package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimConfigDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get bean from spring container
        Coach theCoach = context.getBean("soccerCoach", Coach.class);

        // call methods from bean
        System.out.println(theCoach.getDailyWorkout());

        // call method for daily fortune
        System.out.println(theCoach.getDailyFortune());


        // close the context
        context.close();
    }
}
