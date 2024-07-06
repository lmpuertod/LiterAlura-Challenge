package com.AluraChallenge.LiterAlura.Service;

import com.AluraChallenge.LiterAlura.Model.Libro;
import org.springframework.web.client.RestClient;

import java.util.Optional;

public class obtenerLibrosAPI {

    private final static String URI_BASE = "https://gutendex.com/books/";

    public static String obtenerLibro(String libroPalabraClave){

        RestClient restClient = RestClient.builder()
                .baseUrl(URI_BASE)
                .build();

        return restClient.get()
                .uri("?search={libroPalabraClave}",libroPalabraClave)
                .retrieve()
                .body(String.class);

    }

}
