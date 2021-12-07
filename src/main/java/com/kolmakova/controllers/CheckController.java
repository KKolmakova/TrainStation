package com.kolmakova.controllers;

import com.kolmakova.entities.Passenger;
import com.kolmakova.requestObjects.CheckObject;
import com.kolmakova.services.PassengerService;
import com.kolmakova.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("/check")
public class CheckController {

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private TrainService trainService;

    @GetMapping("{id}")
    public String getOne(Model model,
                         @RequestParam("trainId") Integer trainId,
                         @RequestParam("passengerId") Integer passengerId){
        model.addAttribute("checkForm", true);
        model.addAttribute("passenger", passengerService.getPassengerById(passengerId));
        model.addAttribute("train", trainService.getTrainById(passengerId));

        return "train/select";
    }

    @PostMapping("/create")
    // dto with check required params (userId, trainId)
    public String createCheck(Model model, CheckObject checkObject){

        // save to db check logic
        // redirect to check get method to print check by id
        return "train/select";
    }

}
