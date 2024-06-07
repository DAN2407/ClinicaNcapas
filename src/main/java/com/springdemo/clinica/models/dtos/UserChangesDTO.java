package com.springdemo.clinica.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserChangesDTO {
    @NotBlank
    private String username;
}
