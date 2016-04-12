package com.cupones.servicio;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Pedido;

@Remote
public interface PedidoService {

	
	public List<Pedido> findAllPedido();
	
	public Pedido findPedidoById(Pedido pedido);
	
	public void addPedido(Pedido pedido);
	
	public void updatePedido(Pedido pedido);
	
	public void deletePedido(Pedido pedido);
}
