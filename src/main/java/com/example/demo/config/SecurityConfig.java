package com.example.demo.config;

import com.example.demo.handler.CustomAuthenticationSuccessHandler;
import com.example.demo.service.CustomUserDetailsService;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration //Вказує, що це клас конфігурації Spring
@EnableWebSecurity //Вмикає підтримку Spring Security
public class SecurityConfig {

    //Ін’єкція кастомного сервісу для завантаження користувачів з БД
    private final CustomUserDetailsService userDetailsService;

    //Ін’єкція енкодера паролів (BCrypt)
    private final BCryptPasswordEncoder passwordEncoder;

    //Обробник успішної аутентифікації (переадресація)
    private final CustomAuthenticationSuccessHandler successHandler;

    //Конструктор з ін’єкцією всіх потрібних компонентів
    public SecurityConfig(CustomUserDetailsService userDetailsService,
                          BCryptPasswordEncoder passwordEncoder,
                          CustomAuthenticationSuccessHandler successHandler) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.successHandler = successHandler;
    }

    //Основна конфігурація фільтра безпеки (хто і до чого має доступ)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/api/register", "/login", "/css/**", "/js/**").permitAll()

                        //Дозволено лише ADMIN: створення, редагування, видалення категорій
                        .requestMatchers("/categories/add", "/categories/save",
                                "/categories/edit/**", "/categories/update",
                                "/categories/delete").hasRole("ADMIN")

                        //Доступ для обох ролей: перегляд списку категорій
                        .requestMatchers("/categories").hasAnyRole("ADMIN", "USER")

                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .successHandler(successHandler)
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }

    //Налаштування authenticationProvider (поєднує UserDetailsService та PasswordEncoder)
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService); //кастомна логіка завантаження користувача
        provider.setPasswordEncoder(passwordEncoder);       //BCrypt — шифрування паролів
        return provider;
    }
}
