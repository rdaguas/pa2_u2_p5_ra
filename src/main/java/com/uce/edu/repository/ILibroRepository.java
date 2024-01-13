package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroRepository {

	public void insertar(Libro libro);

	public Libro seleccionar(Integer id);

	public void actualizar(Libro libro);

	public void eliminar(Integer id);

	public void insertar(Libro2 libro2);
	//Por Query
	public Libro seleccionarPorTitulo(String titulo);
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion);
	//Por TypedQuey
	public Libro seleccionarPorTituloTyped(String titulo);
	public List<Libro> seleccionarPorFechaPublicacionTyped(LocalDateTime fechaPublicacion);
	//NamedQuery
	public Libro seleccionarPorTituloNamed(String titulo);
	public List<Libro> seleccionarPorFechaPublicacionNamed(LocalDateTime fechaPublicacion);
}
