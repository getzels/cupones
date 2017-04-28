package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.LibroDireccione;
import com.cupones.domain.Usuario;

@Stateless
public class LibroDireccioneDaoImpl implements LibroDireccioneDao {
    
	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	
	public List<LibroDireccione> findAllLibroDireccione() {
		
		return em.createNamedQuery("LibroDireccione.findAll").getResultList();
	}
    
	
	@SuppressWarnings("unchecked")
	
	public List<LibroDireccione> findLibroDireccioneById(Usuario usuario) {
		Query query = em.createQuery("select l from LibroDireccione l where l.id.idUsuario = :id");
		query.setParameter(1, usuario.getIdUsuario());
		
		return query.getResultList();
	}

	
	public void addLibroDireccione(LibroDireccione libroDireccione) {
		em.persist(libroDireccione);

	}

	
	public void updateLibroDireccione(LibroDireccione libroDireccione) {
		em.merge(libroDireccione);

	}

	
	public void deleteLibroDireccione(LibroDireccione libroDireccione) {
		em.remove(libroDireccione);

	}

}
