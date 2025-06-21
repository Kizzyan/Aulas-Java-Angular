package com.iwt.exemplo.controllers;

import com.iwt.exemplo.models.Funcionario;
import com.iwt.exemplo.services.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/usuarios")
@RestController
@SuppressWarnings("unused")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listar();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> achar(@PathVariable("id") Long id) {
        Funcionario funcionario = funcionarioService.achar(id);
        return ResponseEntity.ok(funcionario);
    }

    @GetMapping("/registrar")
    public ResponseEntity<Funcionario> registrar(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioCriado = funcionarioService.registrar(funcionario);
        return ResponseEntity.ok(funcionarioCriado);
    }

    @GetMapping("/atualizar/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable("id") Long id, @RequestBody Funcionario funcionario) {
        Funcionario funcionarioAtualizado = funcionarioService.atualizar(id, funcionario);
        return ResponseEntity.ok(funcionarioAtualizado);
    }

    @GetMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
        funcionarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}