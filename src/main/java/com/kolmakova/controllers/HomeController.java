package com.kolmakova.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToSearch(HttpServletRequest request) {
        return "redirect: " + request.getContextPath() + "/search";
    }
}
