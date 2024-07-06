package com.AluraChallenge.LiterAlura.Model;

import com.AluraChallenge.LiterAlura.Dto.DataAutor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer añoNacimiento;
    private Integer añoFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Libro> libros = new ArrayList<Libro>();

    public Autor(String nombre, Integer fechaNacimiento, Integer fechaFallecimiento) {
        this.nombre = nombre;
        this.añoNacimiento = fechaNacimiento;
        this.añoFallecimiento = fechaFallecimiento;
    }
    public Autor(){}

    public Autor(DataAutor dataAutor){
        this.nombre = dataAutor.nombre();
        this.añoFallecimiento = dataAutor.añoFallecimiento();
        this.añoNacimiento = dataAutor.añoNacimiento();

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAñoNacimiento(Integer añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public void setAñoFallecimiento(Integer añoFallecimiento) {
        this.añoFallecimiento = añoFallecimiento;
    }

    public String getNombre() {
        return nombre;
    }



    public Integer getAñoNacimiento() {
        return añoNacimiento;
    }



    public Integer getAñoFallecimiento() {
        return añoFallecimiento;
    }


    public List<Libro> getLibros() {
        return libros;
    }

    public void addLibro(Libro libro){
        this.getLibros().add(libro);
        libro.setAutor(this);

    }

    @Override
    public String toString() {
        return STR."""
        --------------------------------
        Nombre: \{this.getNombre()}
        Año de nacimiento: \{this.getAñoNacimiento()}
        Año de fallecimiento:\{this.getAñoFallecimiento()}
        Libros: 
            \{this.libros.stream().map(Libro::getTitulo).collect(Collectors.joining("\n\t"))}
        --------------------------------""";
    }
}
