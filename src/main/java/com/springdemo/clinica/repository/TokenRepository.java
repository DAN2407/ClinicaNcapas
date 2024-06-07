package com.springdemo.clinica.repository;

import com.springdemo.clinica.models.entities.Token;
import com.springdemo.clinica.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {

    List<Token> findByUserAndActive(User user, Boolean active);

}
