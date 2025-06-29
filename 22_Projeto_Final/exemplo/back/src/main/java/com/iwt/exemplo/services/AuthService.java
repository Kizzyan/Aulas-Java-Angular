package com.iwt.exemplo.services;

import com.iwt.exemplo.dtos.LoginRequest;
import com.iwt.exemplo.dtos.RegistroRequest;
import com.iwt.exemplo.dtos.RegistroResponse;
import com.iwt.exemplo.models.Usuario;
import com.iwt.exemplo.repositories.RoleRepository;
import com.iwt.exemplo.repositories.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(
            UsuarioRepository usuarioRepository,
            RoleRepository roleRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegistroResponse registrar(RegistroRequest dto) {
        Usuario usuario = Usuario.builder()
                .email(dto.getEmail())
                .nome(dto.getNome())
                .senha(passwordEncoder.encode(dto.getSenha()))
                .roles(List.of(roleRepository.findByDescricao("USER").get()))
                .ativo(true)
                .build();
        usuario = usuarioRepository.save(usuario);
        return RegistroResponse.builder()
                .id(usuario.getId())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .build();
    }

    public Usuario autenticar(LoginRequest dto) {
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

