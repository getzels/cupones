package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cupones.domain.DetalleSolicitud;

@Stateless
public class DetalleSolicitudDaoImpl implements DetalleSolicitudDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleSolicitud> findAllDetalleSolicitud() {
		return em.createNamedQuery("DetalleSolicitud.findAll").getResultList();
	}

	@Override
	public DetalleSolicitud findDetalleSolicitudById(DetalleSolicitud detalleSolicitud) {
		return em.find(DetalleSolicitud.class, detalleSolicitud.getId());
	}

	@Override
	public void addDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		em.persist(detalleSolicitud);

	}

	@Override
	public void updateDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		em.merge(detalleSolicitud);

	}

	@Override
	public void deleteDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		detalleSolicitud = em.find(DetalleSolicitud.class, detalleSolicitud.getId());
		em.remove(detalleSolicitud);
	}

}

