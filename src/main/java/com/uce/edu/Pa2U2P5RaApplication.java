package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;

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
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//CRITERIA API QUERY
		
		Ciudadano ciu1 = this.iCiudadanoService.buscarPorApelli("Waters");
		System.out.println(ciu1);
		
		
		Ciudadano ciu2 = this.iCiudadanoService.buscarPorCriteriaAndOr("Rober", "Waters", "172434");
		System.out.println(ciu2);
		
		Ciudadano ciu3 = this.iCiudadanoService.buscarPorNombreCriteria("Jose");
		System.out.println(ciu3);
		
		this.iCiudadanoService.buscarPorEdadCriteria(22).forEach(System.out::println);
		
		this.iCiudadanoService.buscarPorGeneroCriteria("F", 24).stream().forEach(System.out::println);
		this.iCiudadanoService.buscarPorGeneroCriteria("M", 24).stream().forEach(System.out::println);

	
		
	}

}
