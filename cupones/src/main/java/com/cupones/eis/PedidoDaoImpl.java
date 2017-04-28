package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cupones.domain.Pedido;

@Stateless
public class PedidoDaoImpl implements PedidoDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	
	public List<Pedido> findAllPedido() {
		return em.createNamedQuery("Pedido.findAll").getResultList();
	}

	
	public Pedido findPedidoById(Pedido pedido) {
		return em.find(Pedido.class, pedido.getIdPedido());
	}

	
	public void addPedido(Pedido pedido) {
		em.persist(pedido);

	}

	
	public void updatePedido(Pedido pedido) {
		em.merge(pedido);

	}

	
	public void deletePedido(Pedido pedido) {
		pedido = em.find(Pedido.class, pedido.getIdPedido());
		em.remove(pedido);
	}

}
