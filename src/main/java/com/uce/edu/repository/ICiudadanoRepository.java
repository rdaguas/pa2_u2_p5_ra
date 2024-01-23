package com.uce.edu.repository;

import java.time.LocalDate;
import java.util.List;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {
	
	public void insertar(Ciudadano ciudadano);
	public Ciudadano seleccionar(Integer id);
	public void actualizar(Ciudadano ciudadano);
	public void eliminar(Integer id);
	
	public Empleado seleccionarPorCedula(String cedula);
	

	public Ciudadano seleccionarPorNombre(String nombre);
	public Ciudadano seleccionarPorApellido(String apellido);
	public List<Ciudadano> seleccionarPorEdad(Integer edad);
	public Ciudadano seleccionarPorGenero(String genero);
	public Ciudadano seleccionarPorFechaNacimiento(LocalDate fechaNacimiento);
	
	public List<Ciudadano> seleccionarPorFechaNaci(LocalDate fechaNacimiento);
	public Ciudadano seleccionarPorCedulaCiu(String cedula);
	public Ciudadano seleccionarPorNombreNative(String nombre);
	public Ciudadano seleccionarPorApellidonative(String apellido);
	
	public Ciudadano seleccionarPorApelli(String apellido);
	
	//Funcionalidad que cuando sea Ciudadano de Pichincha lo busque por Nombre
	//Cuando sea de Cotopaxi lo busque por Apellido
	//y Cuando no sea ninguna de la dos(Cotopacy ni pichincha) lo busque por cedula
	public Ciudadano seleccionarPorNombreApellidoCedulaCriteria(String nombre, String apellido, String cedula);
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);

	
}
