package com.iwt.exemplo.controllers;

import com.iwt.exemplo.dtos.LoginResponse;
import com.iwt.exemplo.dtos.LoginRequest;
import com.iwt.exemplo.dtos.RegistroRequest;
import com.iwt.exemplo.dtos.RegistroResponse;
import com.iwt.exemplo.models.Usuario;
import com.iwt.exemplo.services.AuthService;
import com.iwt.exemplo.services.JwtService;
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
    public ResponseEntity<RegistroResponse> registrar(@Valid @RequestBody RegistroRequest dto) {
        RegistroResponse usuarioRegistrado = authService.registrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRegistrado);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> autenticar(@Valid @RequestBody LoginRequest dto) {
        Usuario usuarioAutenticado = authService.autenticar(dto);
        String jwtToken = jwtService.generateToken(usuarioAutenticado);
        LoginResponse loginResponse = LoginResponse.builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).build();
        return ResponseEntity.ok(loginResponse);
    }
}
