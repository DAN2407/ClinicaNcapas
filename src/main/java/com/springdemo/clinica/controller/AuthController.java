package com.springdemo.clinica.controller;

import com.springdemo.clinica.models.dtos.*;
import com.springdemo.clinica.models.entities.Token;
import com.springdemo.clinica.models.entities.User;
import com.springdemo.clinica.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public ResponseEntity<GeneralResponse> login(@RequestBody @Valid UserLoginDTO info) throws Exception {
        User user = userService.findByIdentifier(info.getIdentifier());
        if(user == null){
            return GeneralResponse.getResponse(HttpStatus.CONFLICT, "User not found");
        }

        if(!userService.checkPassword(user, info.getPassword()) || !userService.isActive(user)){
            return GeneralResponse.getResponse(HttpStatus.NOT_FOUND, "User not found");
        }

        Token token = userService.registerToken(user);
        return GeneralResponse.getResponse(HttpStatus.OK, new TokenDTO(token));
    }

    @PatchMapping("/toggle-active")
    public ResponseEntity<?> toggleActive(@RequestBody @Valid UserChangesDTO info) {
        String username = info.getUsername();

        User user = userService.findByIdentifier(username);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        userService.toggleEnable(username);

        return GeneralResponse.getResponse(HttpStatus.OK,"Toggle Active");
    }
}
