package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    // create and array of strings
    private String[] data = {
            "Beware of the wolf in sheep's clothing",
            "Diligence is the mother good luck",
            "The journey is the reward"
    };

    // create a random number generator
    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        // pick a random string from fortune array
        int index = myRandom.nextInt(data.length);

        String theFortune = data[index];

        return theFortune;
    }
}
