package com.iuv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
    @Override
    public String getDailyFortune() {
        return "You are on in a million.";
    }
}
