package com.programacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.service.IEstudianteService;
import com.programacion.service.to.EstudianteTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin
public class EstudianteControllerRestful {

	@Autowired
	private IEstudianteService estudianteService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void insertar(@RequestBody EstudianteTO estudiante) {
		this.estudianteService.insertar(estudiante);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.buscarTodos());
	}

	@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteTO> buscarPorCedula(@PathVariable String cedula) {
		return ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.buscarPorCedula(cedula));
	}

}
