package com.programacion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.repository.IEstudianteRepository;
import com.programacion.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void insertar(EstudianteTO estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante.convertir());
	}

	@Override
	public List<EstudianteTO> buscarTodos() {
		// TODO Auto-generated method stub
		return this.estudianteRepository.buscarTodos().stream().map(e -> e.convertir()).collect(Collectors.toList());
	}

	@Override
	public EstudianteTO buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.buscarPorCedula(cedula).convertir();
	}

}
