package com.example.demo.repository.service;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {
	public void ingresar(Estudiante estudiante);

	public Estudiante buscarPorCedula(String cedula);
}
