package com.iwt.exemplo.repositories;

import com.iwt.exemplo.models.Privilege;
import com.iwt.exemplo.models.Role;
import com.iwt.exemplo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Optional<Privilege> findByDescricao(String descricao);
}