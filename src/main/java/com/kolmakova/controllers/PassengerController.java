package com.kolmakova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/passenger")
public class PassengerController {

//    private final PassengerComponent passengerComponent;
//
//    @Autowired
//    public PassengerController(PassengerComponent passengerComponent) {
//        this.passengerComponent = passengerComponent;
//    }
//
//    @GetMapping
//    public String allPassengers(Model model) throws SQLException {
//        model.addAttribute("passenger", passengerComponent.getAllPassengers());
//        return "passenger/all";
//    }
//
//    @GetMapping("/new")
//    public String newPassenger(Model model) {
//        model.addAttribute("passenger", new Passenger());
//        return "passenger/new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("passenger") Passenger passenger) throws SQLException {
//        passengerComponent.save(passenger);
//        return "redirect:/passenger";
//    }
}
