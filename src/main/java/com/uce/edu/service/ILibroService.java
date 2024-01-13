package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {

	public void guardar(Libro libro);
	public Libro buscar(Integer id);
	public void actualizar(Libro libro);
	public void eliminar(Integer id);

	public void guardar(Libro2 libro2);
	
	public Libro buscarPorTitulo(String titulo);
	public List<Libro> buscarPorFechaPublicacion(LocalDateTime fechaPublicacion);
	
	public Libro buscarPorTituloTyped(String titulo);
	public List<Libro> buscarPorFechaPublicacionTyped(LocalDateTime fechaPublicacion);
	
	public Libro buscarPorTituloNamed(String titulo);
	public List<Libro> buscarPorFechaPublicacionNamed(LocalDateTime fechaPublicacion);
}

