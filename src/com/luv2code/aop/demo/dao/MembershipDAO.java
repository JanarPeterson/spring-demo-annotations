package com.luv2code.aop.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount(){
        System.out.println(getClass() + ": doing some stuff");
    }
}
