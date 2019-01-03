package com.iuv2code.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class CookieFortuneService implements FortuneService {

    @Override
    @PostConstruct
    public String getDailyFortune() {

        List<String> fortunes = new ArrayList<>();
        System.out.println(">> CookieFortuneService: starting to read fortunes from the fortunes.txt file.");

        try {
            fortunes = Files.readAllLines(Paths.get("/Users/janarpeterson/IdeaProjects/spring-demo-annotations/src/fortunes.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();

        return fortunes.get(random.nextInt(fortunes.size()));
    }
}
