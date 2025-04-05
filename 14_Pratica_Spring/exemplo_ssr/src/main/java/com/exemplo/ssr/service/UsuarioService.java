package com.exemplo.ssr.service;

import com.exemplo.ssr.model.Role;
import com.exemplo.ssr.model.Usuario;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {
    private static List<Usuario> usuarios = new ArrayList<>();
    private final PasswordEncoder encoder;

    @PostConstruct
    public void postConstruct() {
        Usuario usuario = new Usuario();
        usuario.setRole(Role.ADMIN);
        usuario.setUsername("admin");
        usuario.setPassword(encoder.encode("abc"));
        usuarios.add(usuario);
    }

    public void registrar(Usuario usuario) {
        usuario.setRole(Role.USER);
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        usuarios.add(usuario);
    }

    public Usuario acharPorLogin(String login) {
        return usuarios.stream().filter(usuario -> usuario.getUsername().equals(login))
                .findFirst()
                .orElse(null);
    }
}
