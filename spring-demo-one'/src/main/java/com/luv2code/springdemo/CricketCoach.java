package com.luv2code.springdemo;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;

    private String emailAddress;

    private String team;

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach: inside setter method - emailAddress");

        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter method - team");

        this.team = team;
    }

    public CricketCoach() {
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    // our setter method
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside setter method - fortuneService");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 min/day.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }
}
