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
@Table(name = "fiscal")
public class Fiscal {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fiscal")
	@SequenceGenerator(name = "seq_fiscal", sequenceName = "seq_fiscal", allocationSize = 1)
	@Column(name = "fisc_id")
	private Integer id;

	@Column(name = "fisc_nombre")
	private String nombre;

	@Column(name = "fisc_apellido")
	private String apellido;

	@Column(name = "fisc_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;

	@Column(name = "fisc_genero")
	private String genero;

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
