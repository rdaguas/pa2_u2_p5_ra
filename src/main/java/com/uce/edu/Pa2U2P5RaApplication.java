package com.uce.edu;

import java.time.LocalDate;
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

	//Existen 3 tipos de querys
	//1. Query (Usa JPQL: LENGUAJE QUE PERMITE REALIZAR CONSULTAS A LA BASE DE DATOS)
	//1.1 TypedQuery
	//1.2 NamedQuery
	
	//2. Native Query
	//3. Criteria API Query
	
	
	
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
		//otra opcion mas sencilla
		//this.iLibroService.buscarPorFechaPublicacion(LocalDateTime.of(2023, 1, 1, 7, 15)).forEach(System.out::println);
		
		System.out.println("------------------------------QUERY LIST---------------------------------");
		List<Libro> lista = this.iLibroService.buscarPorFechaPublicacion(LocalDateTime.of(2023, 1, 1, 7, 15));
		for(Libro libro : lista) {
			System.out.println(libro);
		}
		
		System.out.println("------------------------------TYPED QUERY---------------------------------");
		Libro l1 = this.iLibroService.buscarPorTituloTyped("Blanca");
		System.out.println(l1);
		
		System.out.println("---------------------------TYPED QUERY LIST------------------------------------");
		List<Libro> listaa = this.iLibroService.buscarPorFechaPublicacionTyped(LocalDateTime.of(2023, 1, 1, 7, 15));
		for(Libro libro : listaa) {
			System.out.println(libro);
		}
		
		System.out.println("---------------------------NAMED QUERY------------------------------------");
		Libro l2 =this.iLibroService.buscarPorTituloNamed("GIO");
		System.out.println(l2);
		
		System.out.println("---------------------------NAMED QUERY LIST------------------------------------");
		List<Libro> lista3 = this.iLibroService.buscarPorFechaPublicacionNamed(LocalDateTime.of(2023, 1, 1, 7, 15));
		for(Libro libro : lista3) {
			System.out.println(libro);
		}
		
	}

}
