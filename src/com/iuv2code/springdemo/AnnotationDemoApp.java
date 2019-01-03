package com.iuv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach javaCoach = context.getBean("javaCoach", Coach.class);
        System.out.println(javaCoach.getDailyWorkout());
        System.out.println(javaCoach.getDailyFortune());

        context.close();
    }
}
