package com.iwt.exemplo.services;

import com.iwt.exemplo.dtos.UsuarioRequest;
import com.iwt.exemplo.dtos.UsuarioResponse;
import com.iwt.exemplo.models.Funcionario;
import com.iwt.exemplo.models.Role;
import com.iwt.exemplo.models.Usuario;
import com.iwt.exemplo.repositories.UsuarioRepository;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@SuppressWarnings("unused")
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService (UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> listarUsuarios () {
        List<Usuario> usuarios = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuarios::add);
        return usuarios;
    }

    public UsuarioResponse achar (Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado para o ID: " + id));
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .criadoEm(usuario.getCriadoEm())
                .alteradoEm(usuario.getAlteradoEm())
                .roles(usuario.getRoles().stream().map(Role::getDescricao).toList())
                .build();
    }

    public UsuarioResponse atualizar(Long id, UsuarioRequest usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuario não encontrado para o ID: " + id));

        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setAlteradoEm(LocalDateTime.now());
        if (usuario.getSenha() != null) {
            usuarioExistente.setSenha(passwordEncoder.encode(usuario.getSenha()));
        }
        usuarioRepository.save(usuarioExistente);

        return UsuarioResponse.builder()
                .id(usuarioExistente.getId())
                .email(usuarioExistente.getEmail())
                .nome(usuarioExistente.getNome())
                .criadoEm(usuarioExistente.getCriadoEm())
                .alteradoEm(usuarioExistente.getAlteradoEm())
                .roles(usuarioExistente.getRoles().stream().map(Role::getDescricao).toList())
                .build();
    }

}
