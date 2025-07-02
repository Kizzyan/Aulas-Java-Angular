package com.iwt.exemplo.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class UsuarioResponse {
    private Long id;
    private String email;
    private String nome;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime criadoEm;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime alteradoEm;
    private boolean ativo;
    private List<String> roles;
}
