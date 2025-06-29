package com.iwt.exemplo.services;

import com.iwt.exemplo.dtos.RegistroRequest;
import com.iwt.exemplo.dtos.RegistroResponse;
import com.iwt.exemplo.dtos.UsuarioDto;
import com.iwt.exemplo.models.Funcionario;
import com.iwt.exemplo.models.Usuario;
import com.iwt.exemplo.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@SuppressWarnings("unused")
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService (
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> listarUsuarios () {
        List<Usuario> usuarios = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuarios::add);
        return usuarios;
    }

    public Usuario acharUsuario (Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado para o ID: " + id));
        return usuario;
    }

    public RegistroResponse atualizar(Long id, RegistroRequest usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado para o ID: " + id));

        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());
        if (usuario.getSenha() != null) {
            usuarioExistente.setSenha(passwordEncoder.encode(usuario.getSenha()));
        }
        usuarioExistente.setAlteradoEm(LocalDateTime.now());
        usuarioExistente = usuarioRepository.save(usuarioExistente);
        return RegistroResponse.builder()
                .id(usuarioExistente.getId())
                .email(usuarioExistente.getEmail())
                .nome(usuarioExistente.getNome())
                .build();
    }
}
