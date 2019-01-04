package com.iuv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        Coach javaCoach = context.getBean("tennisCoach", Coach.class);
        System.out.println(javaCoach.getDailyWorkout());
        System.out.println(javaCoach.getDailyFortune());

        context.close();
    }
}
