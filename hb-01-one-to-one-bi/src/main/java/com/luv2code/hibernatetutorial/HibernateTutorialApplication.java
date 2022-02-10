package com.luv2code.hibernatetutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class HibernateTutorialApplication {

	public static void main(String[] args) {

		SpringApplication.run(HibernateTutorialApplication.class, args);

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";

		try{
			System.out.println("Connecting to database: " + jdbcUrl);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Connection successful!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
