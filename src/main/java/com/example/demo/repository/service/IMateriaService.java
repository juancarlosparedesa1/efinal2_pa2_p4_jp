package com.example.demo.repository.service;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaService {
	public void ingresar(Materia materia);

	public Materia buscarPorCodigo(String codigo);

	public List<Materia> reporte();
}
