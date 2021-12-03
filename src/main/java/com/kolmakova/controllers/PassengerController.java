package com.kolmakova.controllers;

import com.kolmakova.components.PassengerComponent;
import com.kolmakova.entities.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerComponent passengerComponent;

    @Autowired
    public PassengerController(PassengerComponent passengerComponent) {
        this.passengerComponent = passengerComponent;
    }

    @GetMapping
    public String allPassengers(Model model) throws SQLException {
        model.addAttribute("passenger", passengerComponent.getAllPassengers());
        return "passenger/all";
    }

    @GetMapping("/new")
    public String newPassenger(Model model) {
        model.addAttribute("passenger", new Passenger());
        return "passenger/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("passenger") Passenger passenger) throws SQLException {
        passengerComponent.save(passenger);
        return "redirect:/passenger";
    }
}
