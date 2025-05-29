package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Контролер для відображення сторінки реєстрації
public class RegistrationPageController {

    //GET-запит для показу сторінки реєстрації
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }
}
