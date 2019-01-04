package com.iuv2code.springdemo;

public class SadFortuneService implements FortuneService {

    @Override
    public String getDailyFortune() {
        return "Today is a sad day.";
    }
}
