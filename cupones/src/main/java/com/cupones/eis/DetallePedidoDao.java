package com.cupones.eis;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.DetallePedido;
@Remote
public interface DetallePedidoDao {

	
	public List<DetallePedido> findAllDetallePedido();
	
	public DetallePedido findDetallePedidoById(DetallePedido detallePedido);
	
	public void addDetallePedido(DetallePedido detallePedido);
	
	public void updateDetallePedido(DetallePedido detallePedido);
	
	public void deleteDetallePedido(DetallePedido detallePedido);
}
