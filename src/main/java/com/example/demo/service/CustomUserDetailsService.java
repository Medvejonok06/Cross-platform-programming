package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

//Використовується для пошуку користувача у базі даних під час аутентифікації
@Service //Позначає цей клас як компонент служби (bean), який керується Spring
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // Ін’єкція залежності UserRepository
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Метод, який викликається Spring Security під час логіну
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Пошук користувача в БД
        User user = userRepository.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("Користувача не знайдено");

        //Повертаємо об'єкт типу UserDetails з логіном, паролем і роллю
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(
                        new SimpleGrantedAuthority("ROLE_" + user.getRole())
                )
        );
    }
}
