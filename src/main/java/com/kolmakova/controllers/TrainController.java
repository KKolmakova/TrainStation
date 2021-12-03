package com.kolmakova.controllers;

import com.kolmakova.components.TrainComponent;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        return "train/all";
    }

    @GetMapping("/select")
    public String selectedTrains(Model model){
        model.addAttribute("train", new Train());
        return "train/select";
    }

    @PostMapping()
    public String find(@ModelAttribute("train") Train train) throws SQLException {
        trainComponent.find(train);
        return "redirect:/train";
    }

//    @GetMapping("/trains")
//    public String show(@PathVariable("id") int id, Model model) throws SQLException {
//        model.addAttribute("train", execute. getAllTrains());
//        return "train/show";
//    }
}
