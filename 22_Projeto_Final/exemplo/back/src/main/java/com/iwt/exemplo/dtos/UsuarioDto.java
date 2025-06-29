package com.iwt.exemplo.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class UsuarioDto {
    private Long id;

    private String nome;

    private String email;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime criadoEm;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime alteradoEm;

    private boolean ativo;

    private List<String> roles;
}
