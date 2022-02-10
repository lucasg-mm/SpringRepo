package com.luv2code.springdemo;

public class SoccerCoach implements Coach{
    FortuneService fortuneService;

    public SoccerCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "My man menino Ney is going to bring the hexa...";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
