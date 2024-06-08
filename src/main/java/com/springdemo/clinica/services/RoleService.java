package com.springdemo.clinica.services;

import com.springdemo.clinica.models.entities.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    public void addRole(String role);
    Role getRolebyId(String role);
    List<Role> getAllRoles();
}
