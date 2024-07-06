package com.AluraChallenge.LiterAlura.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAutor(
        @JsonAlias("name")
        String nombre,
        @JsonAlias("birth_year")
        Integer añoNacimiento,
        @JsonAlias("death_year")
        Integer añoFallecimiento
) {}
