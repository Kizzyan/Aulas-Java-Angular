package com.exemplo.ssr.controller;

import com.exemplo.ssr.model.Livro;
import com.exemplo.ssr.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    public static final String USER_LOGIN = "userLogin";
    private final LivroService service;

    @GetMapping
    public String getLivroPage(Model model, @AuthenticationPrincipal UserDetails userDetails) {

        String username = userDetails.getUsername();

        model.addAttribute(USER_LOGIN, username);

        List<Livro> livros = service.listarLivros(username);

        model.addAttribute("usuarioLivros", livros);
        return "livro_page";
    }

    @GetMapping("/criar")
    public String getCriarLivroPage(Model model) {
        model.addAttribute("newBook", new Livro());
        return "criar_livro_page";
    }

    @PostMapping("/criarlivro")
    public String criarLivro(@ModelAttribute Livro book) {
        service.salvar(book);
        return "redirect:/livros";
    }

    @GetMapping("/editar/{titulo}")
    public String getEditarLivroPage(Model model, @PathVariable String titulo) {
        Livro porTitulo = service.excluirPorTitulo(titulo);
        model.addAttribute("livroEditado", porTitulo);
        return "editar_livro_page";
    }

    @PostMapping("/editarlivro")
    public String editarLivro(@ModelAttribute Livro livro) {
        service.editar(livro);
        return "redirect:/livros";
    }

    @GetMapping("/excluir/{titulo}")
    @PreAuthorize("hasRole('ADMIN')")
    public String excluir(@PathVariable String titulo) {
        service.excluir(titulo);
        return "redirect:/livros";
    }
}