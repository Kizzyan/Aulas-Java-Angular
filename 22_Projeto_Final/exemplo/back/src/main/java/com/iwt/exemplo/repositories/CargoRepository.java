package com.iwt.exemplo.repositories;

import com.iwt.exemplo.models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface CargoRepository extends JpaRepository<Cargo, Long> {
}