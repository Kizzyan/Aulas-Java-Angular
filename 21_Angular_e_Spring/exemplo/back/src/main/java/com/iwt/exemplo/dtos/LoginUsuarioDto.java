package com.iwt.exemplo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUsuarioDto {
    @NotBlank(message = "Email não pode estar vazio")
    @Email(message = "Email inválido")
    private String email;
    @NotBlank(message = "Senha não pode estar vazia")
    private String senha;
}
