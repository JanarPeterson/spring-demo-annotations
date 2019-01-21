package com.luv2code.aop.demo;

import com.luv2code.aop.demo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;

        try {

            boolean tripWire = false;

            accounts  = dao.findAccounts(tripWire);
        }
        catch (Exception e){
            System.out.println("\n\nMain program ... caught exception: " + e);
        }

        System.out.println("AccountDAO: printing accounts");
        System.out.println(accounts);
        context.close();
    }
}
