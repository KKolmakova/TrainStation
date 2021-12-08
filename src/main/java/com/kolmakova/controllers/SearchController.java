package com.kolmakova.controllers;

import com.kolmakova.dto.TrainSearchRequest;
import com.kolmakova.entities.Train;
import com.kolmakova.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private TrainService trainService;

    @GetMapping()
    public String selectTrains() {
        return "train/select";
    }

    @GetMapping("/find")
    public String findSelected(Model model, TrainSearchRequest trainSearchRequest) {
        List<Train> trains = trainService.getByArrivalPlace(trainSearchRequest.getArrivalPlace());

        model.addAttribute("findTrainsForm", true);
        model.addAttribute("trains", trains);
        model.addAttribute("trainsIds", trainService.getSelectedTrainsUrl(trains));

        return "train/select";
    }
}
