package com.exemplo.ssr.controller;

import com.exemplo.ssr.model.Usuario;
import com.exemplo.ssr.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login_page";
    }

    @GetMapping("/registrar")
    public String getRegistroPage(Model model) {
        model.addAttribute("user", new Usuario());
        return "registro_page";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        service.registrar(usuario);
        return "redirect:/login?success";
    }
}