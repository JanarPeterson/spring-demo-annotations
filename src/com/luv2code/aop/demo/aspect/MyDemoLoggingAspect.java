package com.luv2code.aop.demo.aspect;

import com.luv2code.aop.demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.luv2code.aop.demo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;

        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            logger.warning(throwable.getMessage());

//            throw throwable;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        logger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");

        return "Major accident, but no worries, your private AOP helicopter is on the way to pick you up!";
    }

    @After("execution(* com.luv2code.aop.demo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        System.out.println("===>> Executing on @After (finally) advice on a method: " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(pointcut = "execution(* com.luv2code.aop.demo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        System.out.println("===>>> Executing @AfterThrowing on method: " + joinPoint.getSignature().toShortString());

        System.out.println("====>> The exception is: " + exc);
    }

    @AfterReturning(pointcut = "execution(* com.luv2code.aop.demo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("====>>> Executing on method: @AfterReturning on findAccounts()");

        System.out.println("The result: " + result);

        convertResultNamesToUpperCase(result);

        System.out.println("The result: " + result);
    }

    private void convertResultNamesToUpperCase(List<Account> result) {

        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    @Before("com.luv2code.aop.demo.aspect.LuvAopExpressions.forDaoPackageNoGetterNorSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on updateAccount() ");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + signature);

        Object[] args = joinPoint.getArgs();

        for (Object temp : args) {
            System.out.println(temp);

            if (temp instanceof Account) {
                Account account = (Account) temp;

                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }
}
