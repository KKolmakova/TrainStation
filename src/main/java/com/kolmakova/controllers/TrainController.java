package com.kolmakova.controllers;

import com.kolmakova.execute.Execute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/train")
public class TrainController {

    private final Execute execute;

    @Autowired
    public TrainController(Execute execute) {
        this.execute = execute;
    }

    @GetMapping
    public String allTrains(Model model) throws SQLException {
        model.addAttribute("train", execute. getAllTrains());
        return "train/all-trains";
    }

    @GetMapping("/trains")
    public String show(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("train", execute. getAllTrains());
        return "train/show";
    }
}
