package com.kolmakova.controllers;

import com.kolmakova.components.TrainComponent;
import com.kolmakova.entities.Train;
import com.kolmakova.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping
    public String allTrains(Model model) throws SQLException {
        model.addAttribute("train", trainService.list());
        return "train/all";
    }

//    @GetMapping("/select")
//    public String selectedTrains(Model model){
//        return "train/select";
//    }
//
//    @PostMapping("/find")
//    public String find(Model model, Train train) throws SQLException {
//        model.addAttribute("find",true);
//        model.addAttribute("train",trainComponent.findSelectedTrains(train));
//        return "/train/select";
//    }
}
