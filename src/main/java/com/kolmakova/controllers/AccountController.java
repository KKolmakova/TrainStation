package com.kolmakova.controllers;

import com.kolmakova.dto.AccountDto;
import com.kolmakova.responseServices.AccountResponseService;
import com.kolmakova.responses.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class AccountController {

    @Autowired
    private AccountResponseService accountResponseService;

    @GetMapping({"/signIn", "/signIn/{registered}"})
    public String getSignInPage(@PathVariable(value = "registered", required = false) Boolean registered, Model model) {
        if (Boolean.TRUE.equals(registered)) {
            model.addAttribute("registered", true);
        }

        model.addAttribute("signIn", true);

        return "trainStation";
    }

    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("signUp", true);

        return "trainStation";
    }

    @PostMapping("/signUp")
    public String signIn(HttpServletRequest request, Model model, AccountDto accountDto) {
        AccountResponse response = accountResponseService.registerNewUser(accountDto);

        if (response.isUserAlreadyExists()) {
            model.addAttribute("signUp", true);
            model.addAttribute("response", response);
            return "trainStation";
        }

        return "redirect: " + request.getContextPath() + "/user/signIn/true";
    }
}
