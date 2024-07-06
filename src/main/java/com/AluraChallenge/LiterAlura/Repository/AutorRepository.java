package com.AluraChallenge.LiterAlura.Repository;

import com.AluraChallenge.LiterAlura.Model.Autor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import java.util.Optional;
import java.util.List;


public interface AutorRepository extends ListCrudRepository<Autor, Long> {
    Optional<Autor> findByNombre(String nombre);
    @Query(
            value = "SELECT * FROM autores a WHERE :año BETWEEN a.año_nacimiento AND a.año_fallecimiento",
            nativeQuery = true)
    List<Autor> autorPorAño(Integer año);
}
