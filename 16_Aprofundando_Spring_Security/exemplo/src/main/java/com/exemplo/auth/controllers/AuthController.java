package com.exemplo.auth.controllers;

import com.exemplo.auth.dtos.LoginResponse;
import com.exemplo.auth.dtos.LoginUsuarioDto;
import com.exemplo.auth.dtos.RegistrarUsuarioDto;
import com.exemplo.auth.models.Usuario;
import com.exemplo.auth.services.AuthService;
import com.exemplo.auth.services.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {
    private final JwtService jwtService;
    private final AuthService authService;

    public AuthController (JwtService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@Valid @RequestBody RegistrarUsuarioDto dto) {
        Usuario usuarioRegistrado = authService.registrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRegistrado);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> autenticar(@Valid @RequestBody LoginUsuarioDto dto) {
        Usuario usuarioAutenticado = authService.autenticar(dto);
        String jwtToken = jwtService.generateToken(usuarioAutenticado);
        LoginResponse loginResponse = LoginResponse.builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).build();
        return ResponseEntity.ok(loginResponse);
    }
}
