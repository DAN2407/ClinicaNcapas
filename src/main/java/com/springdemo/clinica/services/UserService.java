package com.springdemo.clinica.services;

import com.springdemo.clinica.models.dtos.UserRegisterDTO;
import com.springdemo.clinica.models.entities.Role;
import com.springdemo.clinica.models.entities.User;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface UserService {
    void registerUser(UserRegisterDTO userRegisterDTO);
    List<User> findAll();
    User findByEmail(String correo);

    //Manejando tabla cruzada N:N
    //roles
    void changeRoles(String document_id, @NotNull List<String> role);
    Role getRoleById(String role);
    List<Role> getRoles();
}
