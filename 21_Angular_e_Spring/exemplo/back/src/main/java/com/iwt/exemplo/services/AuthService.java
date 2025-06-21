package com.iwt.exemplo.services;

import com.iwt.exemplo.dtos.LoginUsuarioDto;
import com.iwt.exemplo.dtos.RegistrarUsuarioDto;
import com.iwt.exemplo.models.Usuario;
import com.iwt.exemplo.repositories.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(
            UsuarioRepository usuarioRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registrar(RegistrarUsuarioDto dto) {
        Usuario usuario = Usuario.builder()
                .email(dto.getEmail())
                .nome(dto.getNome())
                .senha(passwordEncoder.encode(dto.getSenha()))
                .build();
        return usuarioRepository.save(usuario);
    }

    public Usuario autenticar(LoginUsuarioDto dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getSenha()
                )
        );

        return usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow();
    }
}

