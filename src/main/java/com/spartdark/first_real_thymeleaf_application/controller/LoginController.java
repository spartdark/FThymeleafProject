package com.spartdark.first_real_thymeleaf_application.controller;

import com.spartdark.first_real_thymeleaf_application.model.UserCredential;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author vladimirsaldivar
 * @project first_real_thymeleaf_application 2018
 * ...:::vsaldivarm@gmail.com:::...
 **/
@Controller
public class LoginController {

    @GetMapping("/")
    public String redirectToLogIn() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLogInForm(Model model, @RequestParam(name = "error", required = false) String error,
                                @RequestParam(name = "logout", required = false) String logout) {
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        model.addAttribute("userCredentials", new UserCredential());
        return "login";
    }

    @PostMapping("/loginCheck")
    public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredential userCredential) {
        if (userCredential.getUserName().equals("user") && userCredential.getPassword().equals("pass")) {
            return "contacts";
        } else {
            return "redirect:/login?error";
        }

    }
}
