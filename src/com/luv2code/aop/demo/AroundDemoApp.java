package com.luv2code.aop.demo;

import com.luv2code.aop.demo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TrafficFortuneService.class);

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain program ... AroundDemoApp");
        System.out.println("\nFortune service: today's fortune is: " + fortuneService.getFortune());
        System.out.println("Finished!");

        context.close();
    }
}
