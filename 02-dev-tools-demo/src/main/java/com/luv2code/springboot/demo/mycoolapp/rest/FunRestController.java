package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {
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
