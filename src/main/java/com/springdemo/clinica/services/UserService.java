package com.springdemo.clinica.services;

import com.springdemo.clinica.models.dtos.UserRegisterDTO;
import com.springdemo.clinica.models.entities.User;

public interface UserService {

    void create(UserRegisterDTO info);
    User findByUsernameOrEmail(String username, String email);
    User findByIdentifier(String identifier);



}
