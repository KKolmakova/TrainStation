package com.kolmakova.controllers;

import com.kolmakova.responseServices.PassengerListResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/passengerList")
public class PassengerListController {

    @Autowired
    private PassengerListResponseService passengerListResponseService;

    @GetMapping()
    public String passengerList(Model model) {
        model.addAttribute("passengerList", true);
        model.addAttribute("response", passengerListResponseService.getResponse());

        return "trainStation";
    }
}
