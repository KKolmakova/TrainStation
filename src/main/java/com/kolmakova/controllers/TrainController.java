package com.kolmakova.controllers;

import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Train;
import com.kolmakova.dto.ControllerDTO;
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
    public String selectTrains(){
        return "train/select";
    }

    @PostMapping("/find")
    public String findSelected(Model model, Train train) {
        List<Train> trains = trainService.getByArrivalPlace(train.getArrivalPlace());
        model.addAttribute("find",true);
        model.addAttribute("train", trains);
        model.addAttribute("trainsId", trainService.getTrainsId(trains));

        return "train/select";
    }

    @PostMapping("/choose")
    public String chooseTrain(Model model, Train train, @RequestParam(value="trainsId") Integer[] trainsId) {
        model.addAttribute("choose",true);
        model.addAttribute("train", trainService.getTrainById(train.getId()));
        model.addAttribute("trains", trainService.getTrainsByIdes(trainsId));

        return "/train/select";
    }

    @PostMapping("/newPassenger")
    public String enterNewPassenger(Model model, ControllerDTO controllerDTO) {
        model.addAttribute("train", trainService.getTrainById(controllerDTO.getTrain().getId()));
        model.addAttribute("newPassenger", true);

        return "/train/select";
    }

    @PostMapping("/create")
    public String addNewPassenger(Model model, Passenger passenger) {
        model.addAttribute("passenger", passengerService.getAllPassengers());

        return "/train/select";
    }
}
