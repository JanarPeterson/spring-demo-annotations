package com.luv2code.aop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyAnalyticsAspect {

    @Before("com.luv2code.aop.demo.aspect.LuvAopExpressions.forDaoPackageNoGetterNorSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics ");
    }
}
