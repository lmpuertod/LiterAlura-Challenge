package com.AluraChallenge.LiterAlura;


import com.AluraChallenge.LiterAlura.Repository.AutorRepository;
import com.AluraChallenge.LiterAlura.Repository.LibroRepository;
import com.AluraChallenge.LiterAlura.Service.AplicacionPrincipal;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.InputMismatchException;


@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner{

	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private ConfigurableApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);

	}

	@Override
	public void run(String[] args) throws JsonProcessingException {
		AplicacionPrincipal aplicacion = new AplicacionPrincipal(autorRepository, libroRepository, context);

			aplicacion.mostrarMenu();


	}



}

