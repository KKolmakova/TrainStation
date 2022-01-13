package com.kolmakova.controllers;

import com.kolmakova.dto.TrainDTO;
import com.kolmakova.responseServices.SearchTrainResponseService;
import com.kolmakova.services.ArrivalPlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchTrainController {

    @Autowired
    private SearchTrainResponseService searchTrainResponseService;
    @Autowired
    private ArrivalPlacesService arrivalPlacesService;

    @GetMapping()
    public String selectTrains(Model model) {
        model.addAttribute("search", true);
        model.addAttribute("arrivalResponse", arrivalPlacesService.getResponse());

        return "trainStation";
    }

    @GetMapping("/found")
    public String findSelected(Model model, TrainDTO trainDTO) {
        model.addAttribute("found", true);
        model.addAttribute("search", true);
        model.addAttribute("response", searchTrainResponseService.getResponse(trainDTO));
        model.addAttribute("arrivalResponse", arrivalPlacesService.getResponse());

        return "trainStation";
    }
}
