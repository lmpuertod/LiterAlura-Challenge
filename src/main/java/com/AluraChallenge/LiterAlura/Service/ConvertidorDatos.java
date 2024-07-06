package com.AluraChallenge.LiterAlura.Service;

import com.AluraChallenge.LiterAlura.Model.Libro;
import com.AluraChallenge.LiterAlura.Dto.DataLibro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class ConvertidorDatos  {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Optional<Libro> convertirLibro(String jsonResponse) throws JsonProcessingException {
        JsonNode node = objectMapper.readTree(jsonResponse).get("results");
        if(node.isEmpty()){
            return Optional.empty();
        }else{
            Libro libro = new Libro(objectMapper.treeToValue(node.get(0), DataLibro.class));
            return Optional.of(libro);
        }
    }
}

