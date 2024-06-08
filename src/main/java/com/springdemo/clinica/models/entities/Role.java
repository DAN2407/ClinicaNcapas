package com.springdemo.clinica.models.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
public enum Role {
    ADMIN(Set.of(Permission.ADMIN_READ, Permission.ADMIN_CREATE, Permission.ADMIN_UPDATE, Permission.ADMIN_DELETE)),
    USER(Set.of(Permission.USER_READ, Permission.USER_CREATE, Permission.USER_UPDATE, Permission.USER_DELETE)),
    MEDIC(Set.of(Permission.MEDIC_READ, Permission.MEDIC_CREATE, Permission.MEDIC_UPDATE, Permission.MEDIC_DELETE)),
    ASSISTANT(Set.of(Permission.ASSISTANT_READ, Permission.ASSISTANT_CREATE, Permission.ASSISTANT_UPDATE, Permission.ASSISTANT_DELETE));

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
