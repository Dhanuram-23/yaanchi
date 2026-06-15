package com.yaanchii.controller;

import com.yaanchii.model.User;
import com.yaanchii.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(
            UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {

        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(
            @ModelAttribute User user) {

        userService.registerUser(user);

        return "redirect:/login";
    }
}