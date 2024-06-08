package com.springdemo.clinica.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChangeRoleDTO {
    @NotBlank
    private String Document_id;
    @NotNull
    private List<String> roles;
}
