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
	
	public List<Pais> findAllPais() {
		return em.createNamedQuery("Pais.findAll").getResultList();
	}

	
	public Pais findPaisById(Pais pais) {
		return em.find(Pais.class, pais.getIdPais());
	}

	
	public void addPais(Pais pais) {
		em.persist(pais);

	}

	
	public void updatePais(Pais pais) {
		em.merge(pais);

	}

	
	public void deletePais(Pais pais) {
		pais = em.find(Pais.class, pais.getIdPais());
		em.remove(pais);
	}

}
