package com.uce.edu.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Ciudadano ciu = this.seleccionar(id);
		this.entityManager.remove(ciu);
	}

	@Override
	public Empleado seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> myQuery = this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula =:cedula", Empleado.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	

	}

	@Override
	public Ciudadano seleccionarPorCedulaCiu(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula =:cedula", Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		return (Ciudadano) myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery("SELECT c FROM Ciudadano c WHERE c.nombre =:nombre", Ciudadano.class);
		myTypedQuery.setParameter("nombre", nombre);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery("SELECT c FROM Ciudadano c WHERE c.apellido =:apellido", Ciudadano.class);
		myTypedQuery.setParameter("apellido", apellido);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Ciudadano> seleccionarPorEdad(Integer edad) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery("SELECT c FROM Ciudadano c WHERE c.edad =:edad", Ciudadano.class);
		myTypedQuery.setParameter("edad", edad);
		return myTypedQuery.getResultList();
	}

	@Override
	public Ciudadano seleccionarPorGenero(String genero) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery("SELECT c FROM Ciudadano c WHERE c.genero =:genero", Ciudadano.class);
		myTypedQuery.setParameter("genero", genero);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorFechaNacimiento(LocalDate fechaNacimiento) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery("SELECT c FROM Ciudadano c WHERE c.fechaNacimiento =:fechaNacimiento", Ciudadano.class);
		myTypedQuery.setParameter("fechaNacimiento", fechaNacimiento);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Ciudadano> seleccionarPorFechaNaci(LocalDate fechaNacimiento) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_fecha_nacimiento <=:fechaNacimiento", Ciudadano.class);
		myQuery.setParameter("fechaNacimiento", fechaNacimiento);
		return myQuery.getResultList();
	}

	@Override
	public Ciudadano seleccionarPorNombreNative(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_nombre =:nombre", Ciudadano.class);
		myQuery.setParameter("nombre", nombre);
		return (Ciudadano) myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorApellidonative(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_apellidoo =:apellido", Ciudadano.class);
		myQuery.setParameter("apellido", apellido);
		return (Ciudadano) myQuery.getSingleResult();
	}

}
