package com.springdemo.clinica.services.impls;

import com.springdemo.clinica.models.dtos.UserRegisterDTO;
import com.springdemo.clinica.models.entities.Role;
import com.springdemo.clinica.models.entities.User;
import com.springdemo.clinica.repository.RoleRepository;
import com.springdemo.clinica.repository.UserRepository;
import com.springdemo.clinica.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setContrasena(userRegisterDTO.getContrasena());
        user.setCorreo(userRegisterDTO.getCorreo());
        user.setNombre_usuario(userRegisterDTO.getNombre_usuario());
        user.setTelefono(userRegisterDTO.getTelefono());
        user.setDocumentoDeIdentidad(userRegisterDTO.getDocumento_de_identidad());

        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByEmail(String correo) {

        return userRepository.findByCorreo(correo);
    }


    //Manejando tabla cruzada N:N
    //roles
    @Override
    public void changeRoles(String username, List<String> role) {
        User user = userRepository.findByCorreo(username);
        if(user == null) {
            throw new EntityNotFoundException("User not found with username: " + username);
        }

        List<Role> roles = new ArrayList<>();
        role.forEach(r -> {
            Role role1 = roleRepository.findByRole(r);
            if(role1 != null) {
                roles.add(role1); //Agregando a la lista de roles
            }
        });

        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public Role getRoleById(String role) {
        return roleRepository.findByRole(role);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

}
