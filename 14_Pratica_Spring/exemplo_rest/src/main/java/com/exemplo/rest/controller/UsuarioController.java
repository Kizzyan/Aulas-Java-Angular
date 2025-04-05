package com.exemplo.rest.controller;

import com.exemplo.rest.model.Usuario;
import com.exemplo.rest.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login_page";
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario) {
        service.registrar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso");
    }
}