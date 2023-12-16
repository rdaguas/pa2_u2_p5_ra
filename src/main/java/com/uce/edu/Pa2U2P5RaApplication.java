package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5RaApplication implements CommandLineRunner{

	@Autowired
	private IEstudianteService iEstudianteService;
	
	@Autowired
	private IAlumnoService iAlumnoService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		// ------ ESTUDIANTE -------
		
		//insertar
		Estudiante estu = new Estudiante();
		estu.setNombre("Roberto");
		estu.setApellido("Aguas");
		estu.setCedula("1724");
		estu.setFechaNacimiento(LocalDateTime.of(2001, 03, 03, 20, 19));
		//this.iEstudianteService.guardar(estu);
		
		Estudiante estu2 = new Estudiante();
		estu2.setNombre("Daniel");
		estu2.setApellido("Valencia");
		estu2.setCedula("17244");
		estu2.setFechaNacimiento(LocalDateTime.of(2002, 04, 04, 10, 19));
		//this.iEstudianteService.guardar(estu2);
		
		//buscar
		Estudiante estub = this.iEstudianteService.buscar(21);
		System.out.println(estub);
		
		//eliminar
		//System.out.println("Se ha eliminado a: " );
		//this.iEstudianteService.eliminar(16);
		
		//actualizar
		Estudiante estub2 = this.iEstudianteService.buscar(22);
		estub2.setNombre("Asdas");
		this.iEstudianteService.actualizar(estub2);
		System.out.println(estub2);
		*/
		
		// ------------- ALUMNO ------------
		
		//Insertar Alumno
		Alumno alum = new Alumno();
		alum.setNombre("Daniel");
		this.iAlumnoService.guardar(alum);
		
		//buscar
		Alumno alumb = this.iAlumnoService.buscar(2);
		System.out.println("Se encontro al alumno: " + alumb);
		
		//actualizar
		Alumno alumAct = this.iAlumnoService.buscar(1);
		alumAct.setNombre("Karennn");
		this.iAlumnoService.actualizar(alumAct);
		
		//eliminar
		this.iAlumnoService.eliminar(5);
		
		
	
		
	}

}
