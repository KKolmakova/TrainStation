package com.kolmakova.controllers;

import com.kolmakova.components.TrainComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/train")
public class TrainController {

    private final TrainComponent trainComponent;

    @Autowired
    public TrainController(TrainComponent trainComponent) {
        this.trainComponent = trainComponent;
    }

    @GetMapping
    public String allTrains(Model model) throws SQLException {
        model.addAttribute("train", trainComponent.getAllTrains());
        return "train/all-trains";
    }

//    @GetMapping("/trains")
//    public String show(@PathVariable("id") int id, Model model) throws SQLException {
//        model.addAttribute("train", execute. getAllTrains());
//        return "train/show";
//    }
}
