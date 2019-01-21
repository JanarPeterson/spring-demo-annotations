package com.luv2code.aop.demo.dao;

import com.luv2code.aop.demo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account account, boolean vip){
        System.out.println(getClass() + " DOING MY DB WORK: Adding an account.");
    }

    public boolean doWork(){
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public List<Account> findAccounts(boolean tripWire){

        if (tripWire){
            throw new RuntimeException("No soup for you!");
        }

        List<Account> accounts = new ArrayList<>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platium");
        Account temp3 = new Account("Luka", "Gold");

        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

        return accounts;
    }
}
