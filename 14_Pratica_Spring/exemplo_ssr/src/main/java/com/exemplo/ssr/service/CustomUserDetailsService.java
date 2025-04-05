package com.exemplo.ssr.service;

import com.exemplo.ssr.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario porLogin = service.acharPorLogin(username);
        if (porLogin == null) {
            return null;
        }
        return User.builder()
                .username(porLogin.getUsername())
                .password(porLogin.getPassword())
                .roles(porLogin.getRole().name())
                .build();
    }
}