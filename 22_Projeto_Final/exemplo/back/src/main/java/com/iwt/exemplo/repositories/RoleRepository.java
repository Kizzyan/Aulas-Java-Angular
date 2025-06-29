package com.iwt.exemplo.repositories;

import com.iwt.exemplo.models.Role;
import com.iwt.exemplo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByDescricao(String descricao);
}