package com.exemplo.ssr.service;

import com.exemplo.ssr.model.Livro;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LivroService {
    private static List<Livro> livros;

    static {
        livros = new ArrayList<>();
        livros.add(new Livro(1L, "Memórias Póstuma das Brás Cubas", 1881, "Machado de Assis"));
        livros.add(new Livro(2L, "O Alienista", 1889, "Machado de Assis"));
        livros.add(new Livro(3L, "Guerra do Velho", 2005, "John Scalzi"));
        livros.add(new Livro(4L, "Java Efetivo", 2008, "Joshua Bloch"));
        livros.add(new Livro(1L, "Memórias Póstuma das Brás Cubas", 1881, "Machado de Assis"));
        livros.add(new Livro(1L, "Memórias Póstuma das Brás Cubas", 1881, "Machado de Assis"));
        livros.add(new Livro(1L, "Memórias Póstuma das Brás Cubas", 1881, "Machado de Assis"));
        livros.add(new Livro(2L, "O Alienista", 1889, "Machado de Assis"));
        livros.add(new Livro(3L, "Guerra do Velho", 2005, "John Scalzi"));
        livros.add(new Livro(4L, "Java Efetivo", 2008, "Joshua Bloch"));
        livros.add(new Livro(2L, "O Alienista", 1889, "Machado de Assis"));
        livros.add(new Livro(3L, "Guerra do Velho", 2005, "John Scalzi"));
        livros.add(new Livro(4L, "Java Efetivo", 2008, "Joshua Bloch"));
        livros.add(new Livro(2L, "O Alienista", 1889, "Machado de Assis"));
        livros.add(new Livro(3L, "Guerra do Velho", 2005, "John Scalzi"));
        livros.add(new Livro(4L, "Java Efetivo", 2008, "Joshua Bloch"));
    }

    public List<Livro> listarLivros(String login) {
        if (login != null) {
            return livros;
        }

        return livros.stream()
                .filter(livro -> livro.getAno() > 1951)
                .toList();
    }

    public void salvar(Livro livro) {
        livros.add(livro);
    }

    public Livro excluirPorTitulo(String title) {
        Livro livro = livros.stream()
                .filter(l -> l.getTitulo().equals(title))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        livros.remove(livro);
        return livro;
    }

    public void editar(Livro livro) {
        salvar(livro);
    }

    public void excluir(String titulo) {
        excluirPorTitulo(titulo);
    }
}
