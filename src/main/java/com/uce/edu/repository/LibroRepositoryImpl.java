package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Transactional
@Repository
public class LibroRepositoryImpl implements ILibroRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public Libro seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libro);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Libro libro = this.seleccionar(id);
		this.entityManager.remove(libro);
	}

	@Override
	public void insertar(Libro2 libro2) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro2);
	}

	@Override
	public Libro seleccionarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		//SQL: Select * FROM libro l WHERE l.libr_titulo = ?
		//JPQL: SELECT l FROM Libro l WHERE  l.titulo =:variable
		Query myQuery =  this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo =:variable");
		myQuery.setParameter("variable", titulo);
		return (Libro) myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		//SQL: SELECT * FROM libro WHERE l.libr_fecha:publicacion >= ?
		//JPQL: SELECT l FROM Libro l WHERE l.fechaPublicacion >=:fecha
		Query myQuery=  this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >=:fecha");
		myQuery.setParameter("fecha", fechaPublicacion); // busca el texto en query y remplaza por loq ue esta despues de la coma
		return (List<Libro>)myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTituloTyped(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myTypedQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo =:titulo", Libro.class);
		myTypedQuery.setParameter("titulo", titulo);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicacionTyped(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myTypedQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >=:fecha", Libro.class);
		myTypedQuery.setParameter("fecha", fechaPublicacion);
		return myTypedQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTituloNamed(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myTypedQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo", Libro.class);
		myTypedQuery.setParameter("titulo", titulo);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicacionNamed(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myTypedQuery =this.entityManager.createNamedQuery("Libro.queryBuscarPorFecha", Libro.class);
		myTypedQuery.setParameter("fecha", fechaPublicacion);
		return myTypedQuery.getResultList();
	}

}
