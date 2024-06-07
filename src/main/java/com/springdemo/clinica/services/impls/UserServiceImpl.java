package com.springdemo.clinica.services.impls;

import com.springdemo.clinica.models.dtos.UserRegisterDTO;
import com.springdemo.clinica.models.entities.User;
import com.springdemo.clinica.repository.UserRepository;
import com.springdemo.clinica.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
