package com.springdemo.clinica.models.entities;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),
    USER_READ("user:read"),
    USER_CREATE("user:create"),
    USER_UPDATE("user:update"),
    USER_DELETE("user:delete"),
    MEDIC_READ("medic:read"),
    MEDIC_CREATE("medic:create"),
    MEDIC_UPDATE("medic:update"),
    MEDIC_DELETE("medic:delete"),
    ASSISTANT_READ("assistant:read"),
    ASSISTANT_CREATE("assistant:create"),
    ASSISTANT_UPDATE("assistant:update"),
    ASSISTANT_DELETE("assistant:delete");

    @Getter
    private final String permission;
}
