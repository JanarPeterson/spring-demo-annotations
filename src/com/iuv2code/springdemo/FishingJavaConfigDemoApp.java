package com.iuv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FishingJavaConfigDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HuntConfig.class);

        Coach javaCoach = context.getBean("fishingCoach", Coach.class);
        System.out.println(javaCoach.getDailyWorkout());
        System.out.println(javaCoach.getDailyFortune());

        context.close();
    }
}
