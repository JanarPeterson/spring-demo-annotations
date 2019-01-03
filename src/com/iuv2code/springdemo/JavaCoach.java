package com.iuv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JavaCoach implements Coach {

    @Autowired
    @Qualifier("cookieFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Define 2 new entities.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }
}
