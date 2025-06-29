package com.iwt.exemplo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Privilege {

    public Privilege(String descricao) {
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descricao;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}
