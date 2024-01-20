package com.uce.edu.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoService {

	public void guardar(Empleado empleado);
	public Empleado buscar(Integer id);
	public void actualizar(Empleado empleado);
	public void eliminar(Integer id);
	
	public List<Empleado> buscarPorSalario(BigDecimal salario);

}
