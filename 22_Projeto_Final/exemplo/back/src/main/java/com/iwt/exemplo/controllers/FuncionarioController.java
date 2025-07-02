package com.iwt.exemplo.controllers;

import com.iwt.exemplo.models.Cargo;
import com.iwt.exemplo.models.Funcionario;
import com.iwt.exemplo.services.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@SuppressWarnings("unused")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listar() {
        List<Funcionario> funcionarios = funcionarioService.listar();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> achar(@PathVariable("id") Long id) {
        Funcionario funcionario = funcionarioService.achar(id);
        return ResponseEntity.ok(funcionario);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registrar")
    public ResponseEntity<Funcionario> registrar(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioCriado = funcionarioService.registrar(funcionario);
        return ResponseEntity.ok(funcionarioCriado);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable("id") Long id, @RequestBody Funcionario funcionario) {
        Funcionario funcionarioAtualizado = funcionarioService.atualizar(id, funcionario);
        return ResponseEntity.ok(funcionarioAtualizado);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
        funcionarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}