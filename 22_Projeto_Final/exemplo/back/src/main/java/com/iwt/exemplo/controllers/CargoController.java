package com.iwt.exemplo.controllers;

import com.iwt.exemplo.models.Cargo;
import com.iwt.exemplo.repositories.CargoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cargos")
@SuppressWarnings("unused")
public class CargoController {
    private final CargoRepository cargoRepository;

    public CargoController(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Cargo>> listar() {
        List<Cargo> cargos = cargoRepository.findAll();
        return ResponseEntity.ok(cargos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> achar(@PathVariable("id") Long id) {
        Cargo cargo = cargoRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Cargo não encontrado para id " + id)
        );
        return ResponseEntity.ok(cargo);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registrar")
    public ResponseEntity<Cargo> registrar(@RequestBody Cargo cargo) {
        Cargo cargoCriado = cargoRepository.save(cargo);
        return ResponseEntity.ok(cargoCriado);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cargo> atualizar(@PathVariable("id") Long id, @RequestBody Cargo cargoAtualizado) {
        Cargo cargo = cargoRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Cargo não encontrado para id " + id)
        );
        cargo.setDescricao(cargoAtualizado.getDescricao());
        cargoAtualizado = cargoRepository.save(cargo);
        return ResponseEntity.ok(cargoAtualizado);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
        Cargo cargo = cargoRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Cargo não encontrado para id " + id)
        );
        cargoRepository.delete(cargo);
        return ResponseEntity.noContent().build();
    }
}