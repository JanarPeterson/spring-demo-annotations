package com.iuv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        Coach javaCoach = context.getBean("swimCoach", SwimCoach.class);
        System.out.println(javaCoach.getDailyWorkout());
        System.out.println(javaCoach.getDailyFortune());
        System.out.println(((SwimCoach) javaCoach).getEmail());
        System.out.println(((SwimCoach) javaCoach).getTeam());

        context.close();
    }
}
