package com.exemplo.ssr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="titulo", nullable=false, unique = true)
    private String titulo;

    @Column(name="isbn", nullable=false)
    private Integer ano;

    @Column(name="autor", nullable=false)
    private String autor;
}
