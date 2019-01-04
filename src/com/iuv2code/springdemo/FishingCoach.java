package com.iuv2code.springdemo;

public class FishingCoach implements Coach {

    private FortuneService fortuneService;

    public FishingCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Dig some worms.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }
}
