package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteControlller {

	@Autowired
	private IEstudianteService estudianteService;

	// capacidades
	@PostMapping("/ingresarEstudiante")
	public String ingresarEstudiante(Estudiante estudiante) {
		this.estudianteService.ingresar(estudiante);
		return "redirect:/estudiantes/nuevoEstudiante";
	}

	// metodos de redireccionamiento
	// url:http://localhost:8080/universidad/estudiantes/nuevoEstudiante
	@GetMapping("/nuevoEstudiante")
	public String paginaNuevoEstudiante(Estudiante estudiante) {
		return "VistaNuevoEstudiante";
	}

}
