package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cupones.domain.DetallePedido;

@Stateless
public class DetallePedidoDaoImpl implements DetallePedidoDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<DetallePedido> findAllDetallePedido() {
		return em.createNamedQuery("DetallePedido.findAll").getResultList();
	}

	public DetallePedido findDetallePedidoById(DetallePedido detallePedido) {
		return em.find(DetallePedido.class, detallePedido.getId());
	}

	public void addDetallePedido(DetallePedido detallePedido) {
		em.persist(detallePedido);

	}

	public void updateDetallePedido(DetallePedido detallePedido) {
		em.merge(detallePedido);

	}

	public void deleteDetallePedido(DetallePedido detallePedido) {
		detallePedido = em.find(DetallePedido.class, detallePedido.getId());
		em.remove(detallePedido);
	}

}

