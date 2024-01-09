package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
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

		//Para LIBRO
		//Libro
		Libro2 libro = new Libro2();
		libro.setTitulo("JAVA2");
		libro.setFechaPublicacion(LocalDateTime.now());
		
		//Autores
		Autor2 aut1 = new Autor2();
		aut1.setNombre("Jack");
		aut1.setNacionalidad("ECUADOR");
		
		Autor2 aut2 = new Autor2();
		aut2.setNombre("Hill");
		aut2.setNacionalidad("ECUADOR");
		//Set Autor
		Set<Autor2> autores = new HashSet<>();
		autores.add(aut1);
		autores.add(aut2);
		
		AutorLibro autorLibro1 = new AutorLibro();
		autorLibro1.setLibro2(libro);
		autorLibro1.setAutor2(aut1);
		autorLibro1.setFecha(LocalDateTime.now());
		
		AutorLibro autorLibro2 = new AutorLibro();
		autorLibro2.setLibro2(libro);
		autorLibro2.setAutor2(aut2);
		autorLibro2.setFecha(LocalDateTime.now());
		
		List<AutorLibro> lista = new ArrayList<>();
		lista.add(autorLibro1);
		lista.add(autorLibro2);
		
		libro.setAutoresLibros(lista);
		//this.iLibroService.guardar(libro);
		
		Libro libroTitulo = this.iLibroService.buscarPorTitulo("GIO");
		System.out.println(libroTitulo);
		
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
//		

		

	}

}
