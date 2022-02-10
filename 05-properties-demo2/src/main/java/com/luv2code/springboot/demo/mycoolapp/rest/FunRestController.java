package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for team info
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + ", Team name: " + teamName;
    }

    // expose "/" that return Hello World
    @GetMapping("/")
    public String sayHello(){
        return "Hello World! Time on the server is " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Do pushups, man!";
    }

    @GetMapping("/fortune")
    public String getFortune(){
        return "Today is your lucky day";
    }
}
