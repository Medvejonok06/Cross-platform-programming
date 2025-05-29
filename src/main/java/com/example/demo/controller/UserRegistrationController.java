package com.example.demo.controller;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller //Контролер обробки запитів на реєстрацію користувача
@RequestMapping("/api")
public class UserRegistrationController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserRegistrationController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //Обробка POST-запиту на /api/register
    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserRegistrationDto registrationDto, HttpServletRequest request) {
        //Створення нового користувача
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRole(registrationDto.getRole());
        userRepository.save(user);

        //Автоматичний логін після реєстрації
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        null,
                        Collections.singleton(() -> "ROLE_" + user.getRole()) //встановлюємо роль у форматі ROLE_USER / ROLE_ADMIN
                );
        SecurityContextHolder.getContext().setAuthentication(authToken); //авторизація в контексті безпеки

        //Створення сесії для Spring Security
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

        return "redirect:/categories";
    }
}
