package com.luv2code.aop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {


    @Pointcut("execution(* com.luv2code.aop.demo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution(* com.luv2code.aop.demo.dao.*.get*(..))")
    private void getter() {
    }

    @Pointcut("execution(* com.luv2code.aop.demo.dao.*.set*(..))")
    private void setter() {
    }

    @Pointcut("forDaoPackage() && !(setter() || getter())")
    public void forDaoPackageNoGetterNorSetter() {
    }
}
