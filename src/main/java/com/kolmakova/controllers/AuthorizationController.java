package com.kolmakova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/define")
public class AuthorizationController {

    @GetMapping("/sign_in")
    public String signIn(Model model) {
        model.addAttribute("sign_in", true);

        return "trainStation";
    }

    @GetMapping("/sign_up")
    public String signUp(Model model) {
        model.addAttribute("sign_up", true);

        return "trainStation";
    }
}
