package com.kolmakova.controllers;

import com.kolmakova.responseServices.RegistrationOnTrainResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration/pricing/{pricingId}")
public class RegistrationOnTrainController {

    @Autowired
    private RegistrationOnTrainResponseService registrationOnTrainResponseService;

    @GetMapping("/print")
    public String registerPassenger(Model model,
                                    @PathVariable("pricingId") Integer pricingId) {
        model.addAttribute("registerOnTrain", true);
        model.addAttribute("response", registrationOnTrainResponseService.getResponse(pricingId));

        return "trainStation";
    }
}
