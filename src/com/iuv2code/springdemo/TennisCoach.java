package com.iuv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Practice your serve for 1.5 hours.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }

    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println(">> TennisCoach: inside doMyStartUpStuff.");
    }

    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println(">> TennisCoach: inside doMyCleanUpStuff.");
    }
}
