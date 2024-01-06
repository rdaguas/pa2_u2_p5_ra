package com.uce.edu;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5RaApplication implements CommandLineRunner {

	@Autowired
	private ILibroService iLibroService;



	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//Libro
		Libro libro = new Libro();
		libro.setTitulo("Mafalda");
		libro.setFechaPublicacion(LocalDateTime.now());
		
		//Autores
		Autor aut1 = new Autor();
		aut1.setNombre("Roberto");
		aut1.setNacionalidad("Ecuatoriano");
		
		Autor aut2 = new Autor();
		aut2.setNombre("Anthony");
		aut2.setNacionalidad("Africano");
		//Set Autor
		Set<Autor> autores = new HashSet<>();
		autores.add(aut1);
		autores.add(aut2);
		libro.setAutores(autores);
		//Set Libro
		Set<Libro> libros = new HashSet<>();
		libros.add(libro);
		
		aut1.setLibros(libros);
		aut2.setLibros(libros);
		
		
		this.iLibroService.guardar(libro);
		
		

	}

}
