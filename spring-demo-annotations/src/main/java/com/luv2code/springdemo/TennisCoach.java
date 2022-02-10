package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach{
    @Autowired
    @Qualifier("randomFortuneService")
    FortuneService fortuneService;

    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

//    @Autowired
//    public void doSomeCrazyStuff(FortuneService fortuneService) {
//        System.out.println(">> TennisCoach: inside doSomeCrazyStuff");
//        this.fortuneService = fortuneService;
//    }

    //    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    // define init method
    @PostConstruct
    private void doMyStartupStuff(){
        System.out.println(">> TennisCoach: inside doMyStartupStuff");
    }

    // define end method
    @PreDestroy
    private void doMyCleanUpStuff() {
        System.out.println(">> TennisCoach: inside doMyCleanUpStuff");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
