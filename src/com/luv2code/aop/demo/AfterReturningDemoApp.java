package com.luv2code.aop.demo;

import com.luv2code.aop.demo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = dao.findAccounts(false);

        System.out.println("AccountDAO: printing accounts");
        for (Account temp : accounts){
            System.out.println(temp);
        }

        context.close();
    }
}
