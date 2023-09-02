package com.example.demo.repository.service;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaService {
	public void ingresar(Matricula matricula);

	public void matricular(String codigo, String cedula);
}
