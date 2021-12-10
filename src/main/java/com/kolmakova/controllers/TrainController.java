package com.kolmakova.controllers;

import com.kolmakova.responseServices.TrainResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/find/trains/{trainsIds}/train/{trainId}")
public class TrainController {

    @Autowired
    private TrainResponseService trainResponseService;

    @GetMapping("/print")
    public String registerPassenger(Model model,
                                    @PathVariable("trainsIds") List<Integer> trainsIds,
                                    @PathVariable("trainId") Integer trainId) {
        model.addAttribute("registrationPassengerForm", true);
        model.addAttribute("trainForm", trainResponseService.createRegisterPassenger(trainId,trainsIds));

        return "train/trainStation";
    }
}
