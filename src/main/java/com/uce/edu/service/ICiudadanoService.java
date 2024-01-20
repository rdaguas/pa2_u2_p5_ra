package com.uce.edu.service;

import java.time.LocalDate;
import java.util.List;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {
	
	public void guardar(Ciudadano ciudadano);
	public Ciudadano buscar(Integer id);
	public void actualizar(Ciudadano ciudadano);
	public void eliminar(Integer id);
	
	public Empleado buscarPorCedula(String cedula);
	public Ciudadano buscarPorCedulaCiu(String cedula);
	
	public Ciudadano buscarPorNombre(String nombre);
	public Ciudadano buscarPorApellido(String apellido);
	public List<Ciudadano> buscarPorEdad(Integer edad);
	public Ciudadano buscarPorGenero(String genero);
	public Ciudadano buscarPorFechaNacimiento(LocalDate fechaNacimiento);
	
	public List<Ciudadano> buscarPorFechaNaci(LocalDate fechaNacimiento);
	public Ciudadano buscarPorNombreNative(String nombre);
	public Ciudadano buscarPorApellidonative(String apellido);


}
