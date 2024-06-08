package com.springdemo.clinica.controller;

import com.springdemo.clinica.models.dtos.CreateHistorialDTO;
import com.springdemo.clinica.models.dtos.CreateRoleDTO;
import com.springdemo.clinica.models.entities.Role;
import com.springdemo.clinica.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/add-role")
    public ResponseEntity<String> AddHistorial(@RequestBody CreateRoleDTO role) {
        roleService.addRole(role.getRole());
        return ResponseEntity.ok("Role added successfully");
    }
    @PostMapping("/find-role")
    public ResponseEntity<Role> FindRole(@RequestBody CreateRoleDTO requestRole) {
        Role role = roleService.getRolebyId(requestRole.getRole());
        return ResponseEntity.ok(role);
    }
}
