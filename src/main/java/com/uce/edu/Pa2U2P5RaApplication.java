package com.uce.edu;

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
		
//		Ciudadano ciu = this.iCiudadanoService.buscarPorApelli("Waters");
//		System.out.println(ciu);
		
		
		Ciudadano ciu2 = this.iCiudadanoService.buscarPorNombreApellidoCedulaCriteria("Rober", "Waters", "172434");
		System.out.println(ciu2);
		
		Ciudadano ciu3 = this.iCiudadanoService.buscarPorNombreApellidoCedulaCriteria("Rober", "Waters", "05");
		System.out.println(ciu3);
		
		Ciudadano ciu4 = this.iCiudadanoService.buscarPorNombreApellidoCedulaCriteria("Rober", "Waters", "051234");
		System.out.println(ciu4);
		
		System.out.println("CRITERIA API QUERY AND --- OR");
		Ciudadano ciu5 = this.iCiudadanoService.buscarPorCriteriaAndOr("Rober", "Waters", "172434");
		System.out.println(ciu5);
		
		Ciudadano ciu6 = this.iCiudadanoService.buscarPorCriteriaAndOr("Rober", "Waters", "052434");
		System.out.println(ciu6);
		
	}

}
