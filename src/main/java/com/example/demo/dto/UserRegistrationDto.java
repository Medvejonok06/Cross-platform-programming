package com.example.demo.dto;

//DTO (Data Transfer Object) — використовується для передачі даних між формою реєстрації та бекендом
public class UserRegistrationDto {
    private String username;
    private String password;
    private String role;

    //Геттери і сеттери

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
