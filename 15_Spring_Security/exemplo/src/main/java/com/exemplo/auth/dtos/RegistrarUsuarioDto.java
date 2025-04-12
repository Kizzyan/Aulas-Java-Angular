package com.exemplo.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrarUsuarioDto {
    private String email;
    private String senha;
    private String nome;
}
