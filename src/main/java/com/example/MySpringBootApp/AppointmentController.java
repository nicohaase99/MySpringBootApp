package com.example.MySpringBootApp;

import com.example.MySpringBootApp.model.Appointment;
import com.example.MySpringBootApp.model.Owner;
import com.example.MySpringBootApp.model.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("message", "Welcome to the Pet Clinic Spring Boot Application!");
        return "index";
    }

    @PostMapping("/input")
    public String handleInput(
            @RequestParam String ownerName,
            @RequestParam String ownerAddress,
            @RequestParam String ownerPhone,
            @RequestParam String petName,
            @RequestParam String petType,
            @RequestParam int petAge,
            @RequestParam String appointmentDate,
            Model model
    ) {
        Owner owner = new Owner(null, ownerName, ownerAddress, ownerPhone);
        Pet pet = new Pet(null, petName, petType, petAge, null);
        Appointment appointment = new Appointment(null, null, 0, appointmentDate);

        String message = "Received input for owner: " + owner.getName() +
                ", pet: " + pet.getName() +
                ", appointment date: " + appointment.getDate();

        model.addAttribute("message", message);
        return "result";
    }
}