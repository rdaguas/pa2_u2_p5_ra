package com.uce.edu.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepository iCiudadanoRepository;

	
	@Override
	public void guardar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.insertar(ciudadano);
	}

	@Override
	public Ciudadano buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.actualizar(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.eliminar(id);
	}

	@Override
	public Empleado buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public Ciudadano buscarPorCedulaCiu(String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCedulaCiu(cedula);
	}

	@Override
	public Ciudadano buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorNombre(nombre);
	}

	@Override
	public Ciudadano buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorApellido(apellido);
	}

	@Override
	public List<Ciudadano>buscarPorEdad(Integer edad) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorEdad(edad);
	}

	@Override
	public Ciudadano buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorGenero(genero);
	}

	@Override
	public Ciudadano buscarPorFechaNacimiento(LocalDate fechaNacimiento) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorFechaNacimiento(fechaNacimiento);
	}

	@Override
	public List<Ciudadano> buscarPorFechaNaci(LocalDate fechaNacimiento) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorFechaNaci(fechaNacimiento);
	}

	@Override
	public Ciudadano buscarPorNombreNative(String nombre) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorNombreNative(nombre);
	}

	@Override
	public Ciudadano buscarPorApellidonative(String apellido) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorApellidonative(apellido);
	}

	@Override
	public Ciudadano buscarPorApelli(String apellido) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorApelli(apellido);
	}

	@Override
	public Ciudadano buscarPorNombreApellidoCedulaCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorNombreApellidoCedulaCriteria(nombre, apellido, cedula);
	}

	@Override
	public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCriteriaAndOr(nombre, apellido, cedula);
	}

	@Override
	public Ciudadano buscarPorNombreCriteria(String nombre) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorNombreCriteria(nombre);
	}

	@Override
	public List<Ciudadano> buscarPorEdadCriteria(Integer edad) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorEdadCriteria(edad);
	}

	@Override
	public List<Ciudadano> buscarPorGeneroCriteria(String genero, Integer edad) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorGeneroCriteria(genero, edad);
	}



}
