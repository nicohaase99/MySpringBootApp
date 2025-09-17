package com.example.MySpringBootApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.MySpringBootApp.model.Appointment;
import com.example.MySpringBootApp.model.Owner;
import com.example.MySpringBootApp.model.Pet;

import java.util.Scanner;
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
        System.out.println("Application Started successfully at http://localhost:9090");
	}
}