package com.luv2code.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        try{
            // create the object mapper
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON to POJO
            Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);

            // print firstName and lastName
            System.out.println("First name: " + theStudent.getFirstName());
            System.out.println("Last name: " + theStudent.getLastName());

            // print out address and city
            System.out.println("Street: " + theStudent.getAddress().getStreet());
            System.out.println("City: " + theStudent.getAddress().getCity());

            // print out languages
            for (String language:
                 theStudent.getLanguages()) {
                System.out.println(language);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
