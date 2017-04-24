package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.Estado;

@Stateless
public class EstadoDaoImpl implements EstadoDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Estado> findAllEstado() {
		List<Estado> estados = em.createNamedQuery("Estado.findAll").getResultList();
		//estados.size();
		return estados;
	}

	public Estado findEstadoById(Estado estado) {
		Query query = em.createQuery("select e from Estado e where e.idEstado = :id");
		query.setParameter("id", estado.getIdEstado());
		
		Estado estadoReturn = (Estado) query.getSingleResult();
		System.out.println("**********************inicializando la relacion lazy***************");
		//estadoReturn.getOfertas().size();
		
		return estadoReturn;
	}
	
	public Estado findEstadoByName(Estado estado){
      Query query = em.createQuery("select e from Estado e where e.estadoDescripcion like :desc");
      
      query.setParameter("desc", estado.getEstadoDescripcion());
      
      Estado estadoReturn = (Estado) query.getSingleResult();
      
//      estadoReturn.getOfertas().size();
      
		
		return estadoReturn;
		
	}

	public void addEstado(Estado estado) {
		em.persist(estado);

	}

	public void updateEstado(Estado estado) {
		em.merge(estado);

	}

	public void deleteEstado(Estado estado) {
		estado = em.find(Estado.class, estado.getIdEstado());
		em.remove(estado);
	}

}

