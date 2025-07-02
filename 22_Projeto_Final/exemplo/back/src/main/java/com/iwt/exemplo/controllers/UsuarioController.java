package com.iwt.exemplo.controllers;

import com.iwt.exemplo.dtos.UsuarioDto;
import com.iwt.exemplo.dtos.UsuarioRequest;
import com.iwt.exemplo.dtos.UsuarioResponse;
import com.iwt.exemplo.models.Funcionario;
import com.iwt.exemplo.models.Role;
import com.iwt.exemplo.models.Usuario;
import com.iwt.exemplo.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/usuarios")
@RestController
@SuppressWarnings("unused")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listar() {
        List<UsuarioResponse> usuarios = usuarioService.listarUsuarios().stream().map(usuario -> UsuarioResponse.builder()
                .id(usuario.getId())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .criadoEm(usuario.getCriadoEm())
                .alteradoEm(usuario.getAlteradoEm())
                .roles(usuario.getRoles().stream().map(Role::getDescricao).toList())
                .build()).toList();
        return ResponseEntity.ok(usuarios);
    }


    @PreAuthorize("hasRole('ADMIN') or #userId == authentication.principal.id")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> achar(@PathVariable("id") Long id) {
        UsuarioResponse usuario = usuarioService.achar(id);
        return ResponseEntity.ok(usuario);
    }

    @PreAuthorize("hasRole('ADMIN') or #userId == authentication.principal.id")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioResponse> atualizar(@PathVariable("id") Long id, @RequestBody UsuarioRequest usuario) {
        UsuarioResponse usuarioAtualizado = usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }
}
