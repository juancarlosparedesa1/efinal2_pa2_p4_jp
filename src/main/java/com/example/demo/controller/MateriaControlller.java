package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaControlller {

	@Autowired
	private IMateriaService materiaService;

	// capacidades
	@PostMapping("/ingresarMateria")
	public String ingresarMateria(Materia materia) {
		this.materiaService.ingresar(materia);
		return "redirect:/materias/nuevaMateria";
	}

	// metodos de redireccionamiento
	// url:http://localhost:8080/universidad/materias/nuevaMateria
	@GetMapping("/nuevaMateria")
	public String paginaNuevaMateria(Materia materia) {
		return "VistaNuevaMateria";
	}

}
