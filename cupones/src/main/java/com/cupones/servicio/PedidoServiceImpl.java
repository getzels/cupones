package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.cupones.domain.Pedido;
import com.cupones.eis.PedidoDao;

@Stateless
public class PedidoServiceImpl implements PedidoService {

	@EJB
	PedidoDao pedidoDao;


	
	public List<Pedido> findAllPedido() {
		return pedidoDao.findAllPedido();
	}

	
	public Pedido findPedidoById(Pedido pedido) {
		return pedidoDao.findPedidoById(pedido);
	}

	
	public void addPedido(Pedido pedido) {
		pedidoDao.addPedido(pedido);

	}

	
	public void updatePedido(Pedido pedido) {
		pedidoDao.updatePedido(pedido);

	}

	
	public void deletePedido(Pedido pedido) {
		pedidoDao.deletePedido(pedido);
	}

}
