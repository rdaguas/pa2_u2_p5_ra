package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5RaApplication implements CommandLineRunner {

	// Existen 3 tipos de querys
	// 1. Query (Usa JPQL: LENGUAJE QUE PERMITE REALIZAR CONSULTAS A LA BASE DE
	// DATOS)
	// 1.1 TypedQuery
	// 1.2 NamedQuery

	// 2. Native Query
	// 3. Criteria API Query

	@Autowired
	private ICiudadanoService iCiudadanoService;
	
	@Autowired
	private IEmpleadoService iEmpleadoService;
	
	@Autowired
	private ILibroService iLibroService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Ciudadano ciu = new Ciudadano();
		ciu.setApellido("Bolañ");
		ciu.setCedula("1234567");
		ciu.setNombre("Patricio");
		ciu.setEdad(47);
		ciu.setFechaNacimiento(LocalDate.of(1977, 1, 20));
		ciu.setGenero("Masculino");
		
		Empleado empl = new Empleado();
		empl.setSalario(new BigDecimal(3000));
		empl.setFechaIngreso(LocalDateTime.now());
		ciu.setEmpleado(empl);
		empl.setCiudadano(ciu);
		//this.iCiudadanoService.guardar(ciu);
		
//		Empleado empl = this.iCiudadanoService.buscarPorCedula("17243");
//		System.out.println(empl);
		
		//buscar 5 por TypedQuery
		System.out.println("-----------------------------------------TYPED QUERY---------------------------------------");
		Ciudadano ciud1 = this.iCiudadanoService.buscarPorNombre("Rober");
		System.out.println(ciud1);
		
		Ciudadano ciud2 = this.iCiudadanoService.buscarPorApellido("Cayambe");
		System.out.println(ciud2);
	
		this.iCiudadanoService.buscarPorEdad(22).stream().forEach(System.out::println);
		
		Ciudadano ciud4 = this.iCiudadanoService.buscarPorFechaNacimiento(LocalDate.of(2001, 3, 24));
		System.out.println(ciud4);
		
		Ciudadano ciud5 = this.iCiudadanoService.buscarPorGenero("Femenino");
		System.out.println(ciud5);
		
		
		//buscar 5 por NATIVE QUERY
		System.out.println("-----------------------------------------NATIVE QUERY---------------------------------------");

		this.iCiudadanoService.buscarPorFechaNaci(LocalDate.of(2000, 1, 1)).stream().forEach(System.out::println);

		Ciudadano ciu2 = this.iCiudadanoService.buscarPorCedulaCiu("17243");
		System.out.println(ciu2);
		
		Ciudadano ciu3 = this.iCiudadanoService.buscarPorNombreNative("Edison");
		System.out.println(ciu3);
		
		Ciudadano ciu4 = this.iCiudadanoService.buscarPorApellidonative("Bolañ");
		System.out.println(ciu4);
		
		//this.iEmpleadoService.buscarPorSalario(new BigDecimal(700)).stream().forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		// otra opcion mas sencilla
//		// this.iLibroService.buscarPorFechaPublicacion(LocalDateTime.of(2023, 1, 1, 7,
//		// 15)).forEach(System.out::println);
//
//		System.out.println("------------------------------QUERY LIST---------------------------------");
//		List<Libro> lista = this.iLibroService.buscarPorFechaPublicacion(LocalDateTime.of(2023, 1, 1, 7, 15));
//		for (Libro libro : lista) {
//			System.out.println(libro);
//		}
//
//		System.out.println("------------------------------TYPED QUERY---------------------------------");
//		Libro l1 = this.iLibroService.buscarPorTituloTyped("Blanca");
//		System.out.println(l1);
//
//		System.out.println("---------------------------TYPED QUERY LIST------------------------------------");
//		List<Libro> listaa = this.iLibroService.buscarPorFechaPublicacionTyped(LocalDateTime.of(2023, 1, 1, 7, 15));
//		for (Libro libro : listaa) {
//			System.out.println(libro);
//		}
//
//		System.out.println("---------------------------NAMED QUERY------------------------------------");
//		Libro l2 = this.iLibroService.buscarPorTituloNamed("GIO");
//		System.out.println(l2);
//
//		System.out.println("---------------------------NAMED QUERY LIST------------------------------------");
//		List<Libro> lista3 = this.iLibroService.buscarPorFechaPublicacionNamed(LocalDateTime.of(2023, 1, 1, 7, 15));
//		for (Libro libro : lista3) {
//			System.out.println(libro);
//		}

	}

}
