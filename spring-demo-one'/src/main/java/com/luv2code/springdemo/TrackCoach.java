package com.luv2code.springdemo;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }

    // add an init method
    private void doMyStartUpStuff(){
        System.out.println("TrackCoach: inside method doMyStartUpStuff");
    }
    // add a destroy method
    private void doMyCleanUpStuffYoYo(){
        System.out.println("TrackCoach: inside method doMyCleanUpStuffYoYo");
    }
}
