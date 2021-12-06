package com.kolmakova.controllers;

import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Train;
import com.kolmakova.services.PassengerService;
import com.kolmakova.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;
    @Autowired
    private PassengerService passengerService;

    @GetMapping("/select")
    public String selectTrains() {
        return "train/select";
    }

    @PostMapping("/find")
    public String findSelected(Model model, Train train) {
        List<Train> trains = trainService.getByArrivalPlace(train.getArrivalPlace());
        model.addAttribute("find", true);
        model.addAttribute("trains", trains);
        model.addAttribute("trainsId", trainService.getTrainsId(trains));

        return "train/select";
    }

    @PostMapping("/choose")
    public String chooseTrain(Model model, Train train, @RequestParam(value = "trainsId") Integer[] trainsId) {
        model.addAttribute("choose", true);
        model.addAttribute("trains", trainService.getTrainsByIdes(trainsId));
        model.addAttribute("train", trainService.getTrainById(train.getId()));

        return "train/select";
    }

    @PostMapping("/newPassenger")
    public String enterNewPassenger(Model model, Passenger passenger, Train train) {
        model.addAttribute("newPassenger", true);
        model.addAttribute("passenger", passenger);
        model.addAttribute("train", trainService.getTrainById(train.getId()));

        return "train/select";
    }
}
