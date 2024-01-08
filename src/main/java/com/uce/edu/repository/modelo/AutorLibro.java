package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor2_libro2")
public class AutorLibro {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_autor2_libro2")
	@SequenceGenerator(name = "seq_autor2_libro2", sequenceName = "seq_autor2_libro2", allocationSize = 1)
	@Column(name = "auli2_id")
	private Integer id;
	
	//private Autor2 autor2;
	//private Libro2 libro2;

}
