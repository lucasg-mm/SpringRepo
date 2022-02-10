package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService{
    String[] fortunes = {"Today is a bad day", "Today is a good day", "Today is a day"};

    @Override
    public String getFortune() {
        int randomIndex = new Random().nextInt(fortunes.length);
        return fortunes[randomIndex];
    }
}
