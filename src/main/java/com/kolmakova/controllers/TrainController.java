package com.kolmakova.controllers;

import com.kolmakova.entities.Train;
import com.kolmakova.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping
    public String allTrains(Model model) {
        model.addAttribute("train", trainService.list());
        return "train/all";
    }

    @GetMapping("/select")
    public String selectedTrains(Model model){
        return "train/select";
    }

    @PostMapping("/find")
    public String find(Model model, Train train) {
        model.addAttribute("find",true);
        model.addAttribute("train", trainService.getByArrivalPlace(train.getArrivalPlace()));
        return "/train/select";
    }
}
