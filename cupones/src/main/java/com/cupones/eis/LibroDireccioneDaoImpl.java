package com.cupones.eis;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.LibroDireccione;
import com.cupones.domain.Usuario;

public class LibroDireccioneDaoImpl implements LibroDireccioneDao {
    
	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LibroDireccione> findAllLibroDireccione() {
		
		return em.createNamedQuery("LibroDireccione.findAll").getResultList();
	}
    
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LibroDireccione> findLibroDireccioneById(Usuario usuario) {
		Query query = em.createQuery("select l from LibroDireccione l where l.id.idUsuario = :id");
		query.setParameter(1, usuario.getIdUsuario());
		
		return query.getResultList();
	}

	@Override
	public void addLibroDireccione(LibroDireccione libroDireccione) {
		em.persist(libroDireccione);

	}

	@Override
	public void updateLibroDireccione(LibroDireccione libroDireccione) {
		em.merge(libroDireccione);

	}

	@Override
	public void deleteLibroDireccione(LibroDireccione libroDireccione) {
		em.remove(libroDireccione);

	}

}
