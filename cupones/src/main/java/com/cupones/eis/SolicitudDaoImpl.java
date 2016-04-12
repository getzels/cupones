package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.Solicitud;

@Stateless
public class SolicitudDaoImpl implements SolicitudDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> findAllSolicitud() {
				return em.createNativeQuery("Solicitud.findAll").getResultList();
	}

	@Override
	public Solicitud findSolicitudById(Solicitud solicitud) {
	Query query = em.createQuery("from Solicitud s where s.idSolicitud = :idSolicitud");
	query.setParameter("idSolicitud",solicitud.getIdSolicitud());
	return (Solicitud) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> findSolicitudByUserId(Solicitud solicitud) {
		Query query = em.createQuery("from Solicitud s where s.cliente.idCliente = :idCliente");
		query.setParameter("idCliente",solicitud.getIdSolicitud());
		return  query.getResultList();
	}

	@Override
	public void addSolicitud(Solicitud solicitud) {
		em.persist(solicitud);

	}

	@Override
	public void deleteSolicitud(Solicitud solicitud) {
		solicitud = em.find(Solicitud.class, solicitud.getIdSolicitud());
		em.remove(solicitud);

	}

	@Override
	public void updateSolicitud(Solicitud solicitud) {
		em.merge(solicitud);

	}

}
