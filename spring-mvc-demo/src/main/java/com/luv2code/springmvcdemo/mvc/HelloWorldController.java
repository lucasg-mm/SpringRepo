package com.luv2code.springmvcdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("hello")
public class HelloWorldController {
    // need a controller to show the initial form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // need a controller to process the form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // new method to read form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // read the req param from the HTML form
        String theName = request.getParameter("studentName");

        // convert everything to uppercase
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add the message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    // new method to read form data and add data to the model
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){
        // convert everything to uppercase
        theName = theName.toUpperCase();

        // create the message
        String result = "Hey my friend from v3! " + theName;

        // add the message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
