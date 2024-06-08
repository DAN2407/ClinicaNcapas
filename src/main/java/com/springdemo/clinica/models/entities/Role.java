package com.springdemo.clinica.models.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
public enum Role {
    ADMIN(Set.of(Permission.ADMIN_READ, Permission.ADMIN_CREATE, Permission.ADMIN_UPDATE, Permission.ADMIN_DELETE)),
    USER(Collections.emptySet()),
    MEDIC(Set.of(Permission.MEDIC_READ, Permission.MEDIC_CREATE, Permission.MEDIC_UPDATE, Permission.MEDIC_DELETE));

    ;
    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = permissions.stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .toList();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
    }



}
