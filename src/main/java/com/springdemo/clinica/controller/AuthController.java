package com.springdemo.clinica.controller;

import com.springdemo.clinica.models.dtos.GeneralResponse;
import com.springdemo.clinica.models.dtos.UserRegisterDTO;
import com.springdemo.clinica.models.entities.User;
import com.springdemo.clinica.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<GeneralResponse> register(@RequestBody @Valid UserRegisterDTO info) {
        User user = userService.findByUsernameOrEmail(info.getUsername(), info.getEmail());
        if(user != null){
            return GeneralResponse.getResponse(HttpStatus.CONFLICT, "User already exists");
        }

        userService.create(info);
        return GeneralResponse.getResponse(HttpStatus.CREATED, "User registered successfully");

    }
}
