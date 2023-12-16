package com.uce.edu.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "agente")
public class Agente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_agente")
	@SequenceGenerator(name = "seq_agente", sequenceName = "seq_agente", allocationSize = 1)
	@Column(name = "agen_id")
	private Integer id;

	@Column(name = "agen_nombre")
	private String nombre;

	@Column(name = "agen_apellido")
	private String apellido;

	@Column(name = "agen_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;

	@Column(name = "agen_genero")
	private String genero;

	// set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
