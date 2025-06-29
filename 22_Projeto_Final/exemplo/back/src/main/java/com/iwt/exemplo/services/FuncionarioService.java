package com.iwt.exemplo.services;

import com.iwt.exemplo.models.Funcionario;
import com.iwt.exemplo.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService (FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listar () {
        List<Funcionario> funcionarios = new ArrayList<>(funcionarioRepository.findAll());
        return funcionarios;
    }

    public Funcionario achar (Long id) {
        Funcionario funciario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Funcionario não encontrado para o ID: " + id));
        return funciario;
    }

    public Funcionario registrar (Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(Long id, Funcionario funcionario) {
        Funcionario funcionarioExistente = funcionarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Funcionario não encontrado para o ID: " + id));

        System.out.println(funcionario.toString());
        System.out.println(funcionarioExistente.toString());

        funcionarioExistente.setNome(funcionario.getNome());
        funcionarioExistente.setDataNascimento(funcionario.getDataNascimento());
        funcionarioExistente.setCargo(funcionario.getCargo());
        return funcionarioRepository.save(funcionarioExistente);
    }

    public void excluir(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Funcionario não encontrado para o ID: " + id));

        funcionarioRepository.delete(funcionario);
    }
}
