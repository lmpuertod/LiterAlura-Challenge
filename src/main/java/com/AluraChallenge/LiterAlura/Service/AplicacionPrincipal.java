package com.AluraChallenge.LiterAlura.Service;

import com.AluraChallenge.LiterAlura.Model.Autor;
import com.AluraChallenge.LiterAlura.Model.Libro;
import com.AluraChallenge.LiterAlura.Repository.AutorRepository;
import com.AluraChallenge.LiterAlura.Repository.LibroRepository;
import com.AluraChallenge.LiterAlura.Utils.ConversorIdiomas;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import static org.springframework.util.StringUtils.capitalize;

import java.util.*;


public class AplicacionPrincipal {

    private final Scanner input = new Scanner(System.in);
	private final AutorRepository autorRepository;
	private final LibroRepository libroRepository;
	private final ConfigurableApplicationContext context;
	private ConvertidorDatos convertidor = new ConvertidorDatos();

	public AplicacionPrincipal(AutorRepository autorRepository, LibroRepository libroRepository, ConfigurableApplicationContext context) {
		this.autorRepository = autorRepository;
		this.libroRepository = libroRepository;
		this.context = context;
	}

	public void mostrarMenu() throws JsonProcessingException {

		int opcion = -1;

        String menu = """
				------------------  Menu principal  ------------------

				Selecciona una de las siguientes opciones:
				
				1. Consultar libro por titulo.
				2. Mostrar libros consultados.
				3. Mostrar autores consultados.
				4. Mostrar autores vivos en un año dado.
				5. Mostrar libros consultados por idioma.
				0. Salir

				------------------------------------------------------""";


		while(opcion != 0){
			System.out.println(menu);

			opcion = input.nextInt();
			input.nextLine();


			switch(opcion){
				case 1:
					consultarLibro();
					break;
				case 2:
					mostrarLibrosConsulados();
					break;
				case 3:
					mostrarAutoresComsultados();
					break;
				case 4:
					mostrarAutoresPorAño();
					break;
				case 5:
					mostrarLibrosPorIdioma();
					break;
				case 0:
					System.out.println("Cerrando la aplicación.");
					context.close();
					break;
				default:
					System.out.println("Opción invalida, selecciona una opción valida.");

			}

		}
    }

	public void consultarLibro() throws JsonProcessingException {
		System.out.println("Ingresa una palabra que aparezca en el titulo del libro que deseas consultar.");
		String libroPalabraClave = input.nextLine();
		String jsonResponse = obtenerLibrosAPI.obtenerLibro(libroPalabraClave);
		Optional<Libro> libroEncontrado = convertidor.convertirLibro(jsonResponse);
		if(libroEncontrado.isEmpty()){
			System.out.println(STR."No pudimos encontrar un libro que contenga '\{libroPalabraClave}' en su titulo.");
		}else{
			Libro libro = libroEncontrado.get();
			Optional<Libro> libroEnDB = libroRepository.findByTitulo(libro.getTitulo());
			if(libroEnDB.isPresent()){
				System.out.println(STR."Ya habías consultado el libro '\{libro.getTitulo()}'");
			}else{
				System.out.println("Encontramos el siguiente libro:");
				System.out.println(libro);
				Optional<Autor> autorEnDB = autorRepository.findByNombre(libro.getAutor().getNombre());
				if(autorEnDB.isPresent()){
					Autor autor= autorEnDB.get();
					autor.addLibro(libro);
					autorRepository.save(libro.getAutor());
				}else{
					autorRepository.save(libro.getAutor());
				}
			}

		}
	}

	public void mostrarLibrosConsulados(){
		libroRepository.findAll().stream()
				.sorted(Comparator.comparingInt(Libro::getNumDescargas).reversed())
				.forEach(System.out::println);
	}

	public void mostrarAutoresComsultados(){
		autorRepository.findAll().stream()
				.sorted(Comparator.comparing(Autor::getNombre))
				.forEach(System.out::println);
	}

	public void mostrarAutoresPorAño(){
		System.out.println("Escribe el año:");
		Integer año = input.nextInt();
		autorRepository.autorPorAño(año)
				.stream()
				.forEach(System.out::println);
	}

	public void mostrarLibrosPorIdioma(){
		System.out.println("Escribe el idioma:");
		String idioma = capitalize(input.nextLine().trim());

		List<Libro> libros = libroRepository.findByIdioma(ConversorIdiomas.conversorIdiomasInverso.getOrDefault(idioma,idioma));
		System.out.println(STR."Encontramos \{libros.size()} libros en idioma \{idioma} que son:");
		libros.stream().forEach(System.out::println);

	}
}
