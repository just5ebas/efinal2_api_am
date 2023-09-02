package com.programacion.repository;

import java.util.List;

import com.programacion.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public void insertar(Estudiante estudiante);
	
	public Estudiante buscarPorCedula(String cedula);

	public List<Estudiante> buscarTodos();

}
