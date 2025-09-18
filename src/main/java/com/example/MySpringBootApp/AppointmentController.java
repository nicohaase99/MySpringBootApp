package com.example.MySpringBootApp;

import com.example.MySpringBootApp.model.Appointment;
import com.example.MySpringBootApp.model.Owner;
import com.example.MySpringBootApp.model.Pet;

import org.springframework.web.bind.annotation.*;

@RestController
public class AppointmentController {

    @GetMapping("/")
    public String root() {
        return "Welcome to the Pet Clinic Spring Boot Application!";
    }

    @GetMapping("/api")
    public String apiRoot() {
        return "Pet Clinic API is running.";
    }

    @GetMapping("/pet/owner")
    public String getLatestAppointmentDetails() {
        return "Jenkins Pipeline Successfully Deployed Spring Boot Application!";
    }

    @PostMapping("/input")
    public String handleInput(
            @RequestParam String ownerName,
            @RequestParam String ownerAddress,
            @RequestParam String ownerPhone,
            @RequestParam String petName,
            @RequestParam String petType,
            @RequestParam int petAge,
            @RequestParam String appointmentDate
    ) {
        Owner owner = new Owner(null, ownerName, ownerAddress, ownerPhone);
        Pet pet = new Pet(null, petName, petType, petAge, null);
        Appointment appointment = new Appointment(null, null, 0, appointmentDate);

        return "Received input for owner: " + owner.getName() +
                ", pet: " + pet.getName() +
                ", appointment date: " + appointment.getDate();
    }
}