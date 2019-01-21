package com.luv2code.aop.demo;

import com.luv2code.aop.demo.dao.AccountDAO;
import com.luv2code.aop.demo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        Account account = new Account();
        account.setLevel("Platinum");
        account.setName("Madhu");
        dao.addAccount(account, true);
        dao.doWork();

        dao.setName("fooBar");
        dao.setServiceCode("silver");

        String name = dao.getName();
        String code = dao.getServiceCode();

        membershipDAO.addAccount();
        context.close();
    }
}
