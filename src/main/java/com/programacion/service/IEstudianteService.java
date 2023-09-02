package com.programacion.service;

import java.util.List;

import com.programacion.service.to.EstudianteTO;

public interface IEstudianteService {

	public void insertar(EstudianteTO estudiante);

	public List<EstudianteTO> buscarTodos();
	
	public EstudianteTO buscarPorCedula(String cedula);

}
