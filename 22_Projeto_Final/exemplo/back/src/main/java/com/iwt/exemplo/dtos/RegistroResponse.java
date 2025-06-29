package com.iwt.exemplo.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegistroResponse {
    private Long id;
    private String email;
    private String nome;
}
