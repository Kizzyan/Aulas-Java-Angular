package com.iwt.exemplo.controllers;

import com.iwt.exemplo.dtos.RegistroRequest;
import com.iwt.exemplo.dtos.RegistroResponse;
import com.iwt.exemplo.dtos.UsuarioDto;
import com.iwt.exemplo.models.Funcionario;
import com.iwt.exemplo.models.Role;
import com.iwt.exemplo.models.Usuario;
import com.iwt.exemplo.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/usuarios")
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

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioDto> acharUsuario(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.acharUsuario(id);
        UsuarioDto response = UsuarioDto.builder()
                .id(usuario.getId())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .criadoEm(usuario.getCriadoEm())
                .alteradoEm(usuario.getAlteradoEm())
                .roles(usuario.getRoles().stream().map(Role::getDescricao).toList())
                .build();
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @PutMapping("/usuarios/atualizar/{id}")
    public ResponseEntity<RegistroResponse> atualizar(@PathVariable("id") Long id, @RequestBody RegistroRequest usuario) {
        RegistroResponse usuarioAtualizado = usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }
}
