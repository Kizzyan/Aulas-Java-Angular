package com.iwt.exemplo.controllers;

import com.iwt.exemplo.dtos.UsuarioDto;
import com.iwt.exemplo.models.Role;
import com.iwt.exemplo.models.Usuario;
import com.iwt.exemplo.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/admin/usuarios")
@RestController
@SuppressWarnings("unused")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        List<UsuarioDto> usuarios = usuarioService.listarUsuarios().stream().map(usuario -> UsuarioDto.builder()
                .id(usuario.getId())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .criadoEm(usuario.getCriadoEm())
                .alteradoEm(usuario.getAlteradoEm())
                .roles(usuario.getRoles().stream().map(Role::getDescricao).toList())
                .build()).toList();
        return ResponseEntity.ok(usuarios);
    }
}
