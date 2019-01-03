package com.iuv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    @Override
    public String getDailyFortune() {
        Random random = new Random();
        String[] fortunes = {"Just do it!", "You are on fire!", "You were born to do this!"};
        return fortunes[random.nextInt(fortunes.length)];
    }
}
