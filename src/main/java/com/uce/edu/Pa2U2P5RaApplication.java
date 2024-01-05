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

		// Empleado
		Empleado empl = new Empleado();
		empl.setSalario(new BigDecimal(600));
		empl.setFechaIngreso(LocalDateTime.now());
		//this.iEmpleadoService.guardar(empl);

		// Ciudadano
		// Insertar Ciudadano clase mater o Padre
		Ciudadano ciud = new Ciudadano();
		ciud.setNombre("Martha");
		ciud.setApellido("Valencia");
		ciud.setEmpleado(empl);
		empl.setCiudadano(ciud);
		this.iCiudadanoService.guardar(ciud);

		// Actualizar
		 Ciudadano ciud2 = this.iCiudadanoService.buscar(1);
		 ciud2.setNombre("Daniel");
		 this.iCiudadanoService.actualizar(ciud2);

		// Buscar
		 Ciudadano ciud1 = this.iCiudadanoService.buscar(6);
		 System.out.println(ciud1);

		// eliminar un Ciudadano
		 this.iCiudadanoService.eliminar(7);

		// Buscar
		 Empleado emple1 = this.iEmpleadoService.buscar(1);
		 System.out.println(emple1);

		// actualizar
		 Empleado empl2 = this.iEmpleadoService.buscar(2);
		 empl2.setSalario(new BigDecimal(780));
		 this.iEmpleadoService.actualizar(empl2);

		// Eliminar

		 this.iEmpleadoService.eliminar(4);

	}

}
