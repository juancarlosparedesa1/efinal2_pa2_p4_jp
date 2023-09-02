package com.example.demo.repository.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository matriculaRepository;
	@Autowired
	private IEstudianteRepository estudianteRepository;
	@Autowired
	private IMateriaRepository materiaRepository;

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void ingresar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRepository.insertar(matricula);

	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void matricular(String codigo, String cedula) {
		// TODO Auto-generated method stub
		// busco el estudiante por cedula y lo almaceno en una variable
		Estudiante estudianteBd = this.estudianteRepository.seleccionarPorCedula(cedula);
		// busco la materia por codigo y la alamaceno en una variable
		List<Materia> materias = this.materiaRepository.reporte();
//		for (int i = 0; i < 3; i++) {
//			Matricula matricula = new Matricula();
//			matricula.setEstudiante(estudianteBd);
//			matricula.setFecha(LocalDateTime.now());
//			matricula.setMateria(materia);
//			matricula.setNombreHilo("Thread:");
//			this.matriculaRepository.insertar(matricula);
//		}
		for (Materia materia : materias) {
			Matricula matricula = new Matricula();
			Materia materiaBd = this.materiaRepository.seleccionarPorCodigo(materia.getCodigo());
			matricula.setEstudiante(estudianteBd);
			matricula.setFecha(LocalDateTime.now());
			matricula.setMateria(materia);
			matricula.setNombreHilo("Thread:");
			this.matriculaRepository.insertar(matricula);
		}

	}

}
