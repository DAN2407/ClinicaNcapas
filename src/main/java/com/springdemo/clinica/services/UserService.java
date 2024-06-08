package com.springdemo.clinica.services;

import com.springdemo.clinica.models.dtos.UserRegisterDTO;
import com.springdemo.clinica.models.entities.Role;
import com.springdemo.clinica.models.entities.Token;
import com.springdemo.clinica.models.entities.User;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface UserService {
    User findByIdentifier(String identifier);
    User findByUsernameOrEmail(String username, String email);
    void create(UserRegisterDTO info);
    void toggleEnable(String username);
    boolean checkPassword(User user, String password);
    Token registerToken(User user) throws Exception;
    Boolean isTokenValid(User user, String token);
    void cleanTokens(User user) throws Exception;
    boolean isActive(User user);
    User findUserAuthenticated();
    void updatePassword(String identifier, String newPassword);


}
