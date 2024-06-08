package com.springdemo.clinica.repository;

import com.springdemo.clinica.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByRole(String role);

}
