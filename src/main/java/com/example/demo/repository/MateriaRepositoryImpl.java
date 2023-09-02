package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(value = TxType.MANDATORY)
	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Transactional(value = TxType.NOT_SUPPORTED)
	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuery = this.entityManager
				.createQuery("SELECT m FROM Materia m WHERE m.codigo=:datoCodigo", Materia.class);
		myQuery.setParameter("datoCodigo", codigo);
		try {
			return myQuery.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Transactional(value = TxType.NOT_SUPPORTED)
	@Override
	public List<Materia> reporte() {
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FORM Materia m", Materia.class);

		try {
			return myQuery.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
