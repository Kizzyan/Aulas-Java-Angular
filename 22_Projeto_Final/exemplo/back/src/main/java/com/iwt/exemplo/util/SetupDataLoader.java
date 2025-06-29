package com.iwt.exemplo.util;

import com.iwt.exemplo.models.Privilege;
import com.iwt.exemplo.models.Role;
import com.iwt.exemplo.models.Usuario;
import com.iwt.exemplo.repositories.PrivilegeRepository;
import com.iwt.exemplo.repositories.RoleRepository;
import com.iwt.exemplo.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@SuppressWarnings("unused")
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup) return;
        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
        createRoleIfNotFound("ADMIN", adminPrivileges);
        createRoleIfNotFound("USER", Arrays.asList(readPrivilege));

        Role adminRole = roleRepository.findByDescricao("ADMIN").orElseThrow(
                () -> new NoSuchElementException("Role com descrição fornecida não encontrada.")
        );
        Usuario usuario = new Usuario();
        usuario.setNome("Admin");
        usuario.setSenha(passwordEncoder.encode("12345"));
        usuario.setEmail("admin@test.com");
        usuario.setRoles(Collections.singletonList(adminRole));
        usuario.setAtivo(true);
        usuarioRepository.save(usuario);

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String descricao) {
        return privilegeRepository.findByDescricao(descricao).orElse(
            privilegeRepository.save(new Privilege(descricao))
        );
    }

    @Transactional
    void createRoleIfNotFound(String descricao, Collection<Privilege> privileges) {
        roleRepository.findByDescricao(descricao);
        roleRepository.save(new Role(descricao, privileges));
    }
}
