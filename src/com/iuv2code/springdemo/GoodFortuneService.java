package com.iuv2code.springdemo;

public class GoodFortuneService implements FortuneService {
    @Override
    public String getDailyFortune() {
        return "You'r gonna catch big one today.";
    }
}
