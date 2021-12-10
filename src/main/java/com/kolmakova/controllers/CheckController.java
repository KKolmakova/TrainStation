package com.kolmakova.controllers;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.responseServices.CheckResponseService;
import com.kolmakova.responses.CheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/check")
public class CheckController {

    @Autowired
    private CheckResponseService checkResponseService;

    @GetMapping("{id}")
    public String getOne(Model model,
                         @PathVariable("id") Integer checkId) {
        model.addAttribute("checkForm", true);
        model.addAttribute("checkResponse", checkResponseService.getCheckResponse(checkId));

        return "train/trainStation";
    }

    @PostMapping("/create")
    public String createCheck(Model model,
                              PassengerDTO passengerDTO,
                              @RequestParam("trainId") Integer trainId) {
//        CheckResponse checkResponse = checkResponseService.createCheckForm(passengerDTO, trainId);
//        model.addAttribute("checkResponse", checkResponse);

        return "redirect:" + checkResponseService.createCheck(passengerDTO, trainId);
    }
}
