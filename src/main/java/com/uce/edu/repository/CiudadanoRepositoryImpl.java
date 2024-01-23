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
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

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
		TypedQuery<Empleado> myQuery = this.entityManager
				.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula =:cedula", Empleado.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();

	}

	@Override
	public Ciudadano seleccionarPorCedulaCiu(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula =:cedula",
				Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		return (Ciudadano) myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c WHERE c.nombre =:nombre", Ciudadano.class);
		myTypedQuery.setParameter("nombre", nombre);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c WHERE c.apellido =:apellido", Ciudadano.class);
		myTypedQuery.setParameter("apellido", apellido);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Ciudadano> seleccionarPorEdad(Integer edad) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c WHERE c.edad =:edad", Ciudadano.class);
		myTypedQuery.setParameter("edad", edad);
		return myTypedQuery.getResultList();
	}

	@Override
	public Ciudadano seleccionarPorGenero(String genero) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c WHERE c.genero =:genero", Ciudadano.class);
		myTypedQuery.setParameter("genero", genero);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorFechaNacimiento(LocalDate fechaNacimiento) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c WHERE c.fechaNacimiento =:fechaNacimiento", Ciudadano.class);
		myTypedQuery.setParameter("fechaNacimiento", fechaNacimiento);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Ciudadano> seleccionarPorFechaNaci(LocalDate fechaNacimiento) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM ciudadano c WHERE c.ciud_fecha_nacimiento <=:fechaNacimiento", Ciudadano.class);
		myQuery.setParameter("fechaNacimiento", fechaNacimiento);
		return myQuery.getResultList();
	}

	@Override
	public Ciudadano seleccionarPorNombreNative(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_nombre =:nombre",
				Ciudadano.class);
		myQuery.setParameter("nombre", nombre);
		return (Ciudadano) myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorApellidonative(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_apellidoo =:apellido", Ciudadano.class);
		myQuery.setParameter("apellido", apellido);
		return (Ciudadano) myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorApelli(String apellido) {
		// TODO Auto-generated method stub
		// SELECT c FROM Ciudadano c WHERE c.apellido =: variable
		// 0. Creamos una instancia de la interfaz CriteriaBuilder a partir de un EM
		CriteriaBuilder myCBuilder = this.entityManager.getCriteriaBuilder();

		// 1. Determinamos el tipo de retorno que va ha tener mi Consulta.
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCBuilder.createQuery(Ciudadano.class);

		// 2. Construir el SQL
		// 2.1. Determinamos el from (root)
		// Nota: No necesariamente el FROM es igual al tipo de retorno.
		// SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre =:dato
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);// Es el (FROM) Ciudadano c
		// 2.2. Construir las condiciones(WHERE) DE sql
		// En CRITERIA API QUERY las condiciones se las conoces como PREDICADOS

		// c.apellido=:variable
		Predicate condicionApellido = myCBuilder.equal(myFrom.get("apellido"), apellido);

		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionApellido);
		// 4. Ejecutamos la consulta con un TypedQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		// 5.
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorNombreApellidoCedulaCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub

		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		// 1. Determinamos el tipo de retorno que va ha tener mi Consulta.
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		// 2. Construir SQL
		// 2.1 Determinamos el FROM
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);

		// 2.2 Construimos las condiones del WHERE
//		String digitosProvincia = cedula.substring(0, 2);
//		System.out.println(digitosProvincia);

		Predicate condicionGenerica = null;

		if (cedula.startsWith("17")) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		} else if (cedula.startsWith("05")) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);

		} else {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("cedula"), cedula);

		}

		// 3. SQL Final
		myCriteriaQuery.select(myFrom).where(condicionGenerica);

		// 4. Ejecutamos la consulta con un TypedQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		// 5.
		return myTypedQuery.getSingleResult();

	}

	@Override
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		// 1. Determinamos el tipo de retorno que va ha tener mi Consulta.
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		// 2. Construir SQL
		// 2.1 Determinamos el FROM
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);

		// 2.2 Construimos las condiones del WHERE
		Predicate condicionTotal = null;

		//c.nombre =:nombre
		Predicate condicionNombre = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		//c.apellido =:apellido
		Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
		
		if (cedula.startsWith("17")) {
			//c.nombre =:nombre or c.apellido=:apellido
			condicionTotal = myCriteriaBuilder.or(condicionNombre, condicionApellido);
		} else if (cedula.startsWith("05")) {
			//c.nombre =:nombre and c.apellido=:apellido
			condicionTotal = myCriteriaBuilder.and(condicionNombre,condicionApellido);

		} 

		// 3. SQL Final
		myCriteriaQuery.select(myFrom).where(condicionTotal);

		// 4. Ejecutamos la consulta con un TypedQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		// 5.
		return myTypedQuery.getSingleResult();
	}

}
