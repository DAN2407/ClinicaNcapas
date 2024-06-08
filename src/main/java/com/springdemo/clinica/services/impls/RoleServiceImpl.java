package com.springdemo.clinica.services.impls;

import com.springdemo.clinica.models.entities.Role;
import com.springdemo.clinica.repository.RoleRepository;
import com.springdemo.clinica.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void addRole(String role) {
        Role newRole = new Role();
        newRole.setRole(role);
        roleRepository.save(newRole);
    }

    @Override
    public Role getRolebyId(String role) {
        return roleRepository.findByRole(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

}
