package com.AluraChallenge.LiterAlura.Repository;

import com.AluraChallenge.LiterAlura.Model.Libro;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends ListCrudRepository<Libro, Long> {
    Optional<Libro> findByTitulo(String nombre);
    List<Libro> findByIdioma(String idioma);
}
