package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cupones.domain.Pais;

@Stateless
public class PaisDaoImpl implements PaisDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> findAllPais() {
		return em.createNamedQuery("Pais.findAll").getResultList();
	}

	@Override
	public Pais findPaisById(Pais pais) {
		return em.find(Pais.class, pais.getIdPais());
	}

	@Override
	public void addPais(Pais pais) {
		em.persist(pais);

	}

	@Override
	public void updatePais(Pais pais) {
		em.merge(pais);

	}

	@Override
	public void deletePais(Pais pais) {
		pais = em.find(Pais.class, pais.getIdPais());
		em.remove(pais);
	}

}
