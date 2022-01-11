package com.kolmakova.controllers;

import com.kolmakova.responseServices.RegistrationResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration/pricing/{pricingId}")
public class PassengerRegistrationController {

    @Autowired
    private RegistrationResponseService registrationResponseService;

    @GetMapping("/print")
    public String registerPassenger(Model model,
                                    @PathVariable("pricingId") Integer pricingId) {
        model.addAttribute("registration", true);
        model.addAttribute("response", registrationResponseService.getResponse(pricingId));

        return "trainStation";
    }
}
