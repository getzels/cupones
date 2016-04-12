package com.cupones.eis;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Pedido;
@Remote
public interface PedidoDao {

	
	public List<Pedido> findAllPedido();
	
	public Pedido findPedidoById(Pedido pedido);
	
	public void addPedido(Pedido pedido);
	
	public void updatePedido(Pedido pedido);
	
	public void deletePedido(Pedido pedido);
}
