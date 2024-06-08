package com.springdemo.clinica.controller;

import com.springdemo.clinica.models.dtos.ChangeRoleDTO;
import com.springdemo.clinica.models.dtos.FindUser;
import com.springdemo.clinica.models.dtos.UserRegisterDTO;
import com.springdemo.clinica.services.UserService;
import com.springdemo.clinica.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<String> AddUser(@RequestBody UserRegisterDTO user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User added successfully");
    }

    @PostMapping("/find-user")
    public ResponseEntity<User> getUserByName(@RequestBody FindUser user){
        String useremail = user.getCorreo();
        User userId = userService.findByEmail(useremail);
        if(userId != null){
            return ResponseEntity.ok(userId);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/change-roles")
    public ResponseEntity<String> changeRoles(@RequestBody ChangeRoleDTO user){
        String username = user.getDocument_id();
        System.out.println("Esta cosa no sirve, encontro: "+ user);
        userService.changeRoles(username, user.getRoles());
        return ResponseEntity.ok("Roles changed successfully");
    }
}
