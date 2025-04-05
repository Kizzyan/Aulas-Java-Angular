package com.exemplo.rest.controller;

import com.exemplo.rest.model.Livro;
import com.exemplo.rest.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    public static final String USER_LOGIN = "userLogin";
    private final LivroService service;

    @GetMapping
    public ResponseEntity<List<Livro>> getLivros(@AuthenticationPrincipal UserDetails userDetails) {

        String username = userDetails.getUsername();
        List<Livro> livros = service.listarLivros();
        return ResponseEntity.ok(livros);
    }

    @PostMapping("/criarlivro")
    public ResponseEntity<String> criarLivro(@RequestBody Livro livro) {
        service.salvar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body("Livro criado com sucesso");
    }

    @PutMapping("/editarlivro")
    public ResponseEntity<String> editarLivro(@RequestBody Livro livro) {
        service.editar(livro);
        return ResponseEntity.ok("Livro editado com sucesso");
    }

    @DeleteMapping("/excluir/{titulo}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> excluir(@PathVariable String titulo) {
        service.excluir(titulo);
        return ResponseEntity.noContent().build();
    }
}