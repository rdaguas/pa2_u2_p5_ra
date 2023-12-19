package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;

@SpringBootApplication
public class Pa2U2P5RaApplication implements CommandLineRunner {

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

		// Ciudadano
		Ciudadano ciud = new Ciudadano();
		ciud.setNombre("Roberto");
		ciud.setApellido("Aguas");
		//this.iCiudadanoService.guardar(ciud);
		
		Ciudadano ciud1 = this.iCiudadanoService.buscar(2);
		System.out.println(ciud1);
		
		
		// Empleado
		Empleado empl = new Empleado();
		empl.setSalario(new BigDecimal(200));
		empl.setFechaIngreso(LocalDateTime.now());
		empl.setCiudadano(ciud1);
		this.iEmpleadoService.guardar(empl);
		
//		ciud.setEmpleado(empl);
//		empl.setCiudadano(ciud);
	}

}
