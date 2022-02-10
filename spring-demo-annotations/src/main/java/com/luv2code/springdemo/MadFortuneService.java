package com.luv2code.springdemo;

public class MadFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "I am flipping mad right now.";
    }
}
