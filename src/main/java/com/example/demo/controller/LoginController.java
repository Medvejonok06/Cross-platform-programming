package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Позначає клас як контролер Spring MVC
public class LoginController {

    //Відображення сторінки входу
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}
