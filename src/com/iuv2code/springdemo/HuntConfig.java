package com.iuv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.iuv2code.springdemo")
public class HuntConfig {

    @Bean
    public FortuneService goodFortuneService(){
        return new GoodFortuneService();
    }

    @Bean
    public Coach fishingCoach(){
        return new FishingCoach(goodFortuneService());
    }
}
