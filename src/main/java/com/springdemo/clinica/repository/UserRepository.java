package com.springdemo.clinica.repository;

import com.springdemo.clinica.models.entities.Role;
import com.springdemo.clinica.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsernameOrEmail(String username, String Email);

}
