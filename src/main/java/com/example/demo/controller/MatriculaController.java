package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private IMatriculaService matriculaService;

	// capacidades
	@PostMapping("/ingresarMatricula")
	public String ingresarMatricula(Matricula matricula) {
		this.matriculaService.matricular(matricula.getMateria().getCodigo(), matricula.getEstudiante().getCedula());
		return "redirect:/matriculas/nuevaMatricula";
	}

	// metodos de redireccionamiento
	// url:http://localhost:8080/universidad/matriculas/nuevaMatricula
	@GetMapping("/nuevaMatricula")
	public String paginaNuevaMatricula(Matricula matricula) {
		return "VistaNuevaMatricula";
	}

	@GetMapping("/reportes")
	public String paginaReporte(Model modelo) {

		return "VistaReporte";
	}

}
