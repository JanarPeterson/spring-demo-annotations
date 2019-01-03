package com.iuv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach coach = context.getBean("tennisCoach", Coach.class);
        Coach alphacoach = context.getBean("tennisCoach", Coach.class);


        boolean result = (coach==alphacoach);

        System.out.println("\nPointing to the same object: " + result);
        System.out.println("\nMemory location of the coach: " + coach);
        System.out.println("\nMemory location of the alphacoach: " + alphacoach);

        context.close();
    }
}
