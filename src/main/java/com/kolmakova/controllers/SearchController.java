package com.kolmakova.controllers;

import com.kolmakova.dto.TrainSearchRequest;
import com.kolmakova.responseServices.SearchResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchResponseService searchResponseService;

    @GetMapping()
    public String selectTrains(Model model) {
        model.addAttribute("searchForm", true);
        return "train/trainStation";
    }

    @GetMapping("/find")
    public String findSelected(Model model, TrainSearchRequest trainSearchRequest) {
        model.addAttribute("findTrainsForm", true);
        model.addAttribute("searchForm", searchResponseService.getTrainResponse(trainSearchRequest));

        return "train/trainStation";
    }
}
