package com.kolmakova.controllers;

import com.kolmakova.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/find/trains/{trainsIds}/train/{trainId}")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping("/print")
    public String registerPassenger(Model model,
                                    @PathVariable("trainsIds") List<Integer> ids,
                                    @PathVariable("trainId") Integer trainId) {
        model.addAttribute("registrationPassengerForm", true);
        model.addAttribute("trains", trainService.getTrainsByIds(ids));
        model.addAttribute("train", trainService.getTrainById(trainId));

        return "train/select";
    }
}
