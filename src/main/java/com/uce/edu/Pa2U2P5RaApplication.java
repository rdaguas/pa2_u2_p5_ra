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
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5RaApplication implements CommandLineRunner {

	@Autowired
	private ILibroService iLibroService;

	@Autowired
	private IAutorService iAutorService;


	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		//Para LIBRO
//		//Libro
//		Libro libro = new Libro();
//		libro.setTitulo("SIMSOMPS");
//		libro.setFechaPublicacion(LocalDateTime.now());
//		
//		//Autores
//		Autor aut1 = new Autor();
//		aut1.setNombre("Jack");
//		aut1.setNacionalidad("Aleman");
//		
//		Autor aut2 = new Autor();
//		aut2.setNombre("Hill");
//		aut2.setNacionalidad("USA");
//		//Set Autor
//		Set<Autor> autores = new HashSet<>();
//		autores.add(aut1);
//		autores.add(aut2);
//		libro.setAutores(autores);
//		//Set Libro
//		Set<Libro> libros = new HashSet<>();
//		libros.add(libro);
//		
//		aut1.setLibros(libros);
//		aut2.setLibros(libros);
//		this.iLibroService.guardar(libro);
//		
//		//buscar libro
//		Libro buslibro = this.iLibroService.buscar(3);
//		System.out.println("Se encontro el: "+buslibro);
//		
//		//Actualizar libro
//		Libro actLibro = this.iLibroService.buscar(2);
//		actLibro.setTitulo("TITANIC");
//		this.iLibroService.actualizar(actLibro);
//		System.out.println("Se actualizo el Titulo de: " + actLibro);
//		
//		//Eliminar Libro
//		this.iLibroService.eliminar(4);		
		
		//PARA AUTOR
		Autor a1 = new Autor();
		a1.setNombre("Charles Perrault");
		a1.setNacionalidad("Frances");
		
		Libro l1 = new Libro();
		l1.setTitulo("LA");
		l1.setFechaPublicacion(LocalDateTime.now());
		
		Libro l2 = new Libro();
		l2.setTitulo("Blanca");
		l2.setFechaPublicacion(LocalDateTime.now());
		
		Libro l3 = new Libro();
		l3.setTitulo("Nieves");
		l3.setFechaPublicacion(LocalDateTime.now());
		
		Set<Libro> libross = new HashSet<>();
		libross.add(l1);
		libross.add(l2);
		libross.add(l3);
		a1.setLibros(libross);
		
		Set<Autor>autoress = new HashSet<>();
		autoress.add(a1);
		l1.setAutores(autoress);
		l2.setAutores(autoress);
		l3.setAutores(autoress);
		//insertar Autor
		this.iAutorService.guardar(a1);
		
		//buscar autor
		Autor buscAutor = this.iAutorService.buscar(12);
		System.out.println("Se encontro el: " + buscAutor);
		
		//actualizar actor
		Autor actAutor = this.iAutorService.buscar(9);
		actAutor.setNacionalidad("Cubano");
		this.iAutorService.actualizar(actAutor);
		
		//eliminar Autor
		this.iAutorService.eliminar(5);
		

	}

}
