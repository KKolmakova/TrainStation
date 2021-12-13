package com.kolmakova.controllers;

import com.kolmakova.dto.TrainDTO;
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
        model.addAttribute("search", true);
        return "trainStation";
    }

    @GetMapping("/found")
    public String findSelected(Model model, TrainDTO trainDTO) {
        model.addAttribute("found", true);
        model.addAttribute("search", true);
        model.addAttribute("response", searchResponseService.getResponse(trainDTO));

        return "trainStation";
    }
}
