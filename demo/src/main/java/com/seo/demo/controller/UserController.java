package com.seo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String loginRedirection() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupRedirection() {
        return "signup";
    }


}
