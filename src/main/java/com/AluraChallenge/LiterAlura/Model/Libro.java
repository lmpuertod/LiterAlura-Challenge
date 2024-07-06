package com.AluraChallenge.LiterAlura.Model;


import com.AluraChallenge.LiterAlura.Dto.DataLibro;
import com.AluraChallenge.LiterAlura.Utils.ConversorIdiomas;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Autor autor;
    private String idioma;
    @JsonAlias("name")
    private Integer numDescargas;

    public Libro(String titulo, Autor autor, String idioma, Integer numDescargas) {
        this.titulo = titulo;
        this.autor = autor;
        autor.addLibro(this);
        this.idioma = idioma;
        this.numDescargas = numDescargas;
    }

    public Libro() {
    }

    public Libro(DataLibro dataLibro){
        this.titulo = dataLibro.titulo();
        this.autor = new Autor(dataLibro.autores().getFirst());
        this.autor.addLibro(this);
        this.idioma = dataLibro.idiomas().getFirst();
        this.numDescargas = dataLibro.numDescargas();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {



        return STR."""
                *************************  Libro  *************************
                Titulo: \{this.getTitulo()}
                Autor: \{this.getAutor().getNombre()}
                Idioma: \{ConversorIdiomas.conversorIdiomas.getOrDefault(this.getIdioma(),this.getIdioma())}
                Numero de Descargas: \{this.getNumDescargas()}
                ***********************************************************
                """
                        ;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(Integer numDescargas) {
        this.numDescargas = numDescargas;
    }
}
