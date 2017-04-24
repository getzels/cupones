package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.cupones.domain.DetallePedido;
import com.cupones.eis.DetallePedidoDao;

@Stateless
public class DetallePedidoServiceImpl implements DetallePedidoService {

	@EJB
	DetallePedidoDao detallePedidoDao;

	
	public List<DetallePedido> findAllDetallePedido() {
		return detallePedidoDao.findAllDetallePedido();
	}

	
	public DetallePedido findDetallePedidoById(DetallePedido detallePedido) {
		return detallePedidoDao.findDetallePedidoById(detallePedido);
	}

	
	public void addDetallePedido(DetallePedido detallePedido) {
		detallePedidoDao.addDetallePedido(detallePedido);

	}

	
	public void updateDetallePedido(DetallePedido detallePedido) {
		detallePedidoDao.updateDetallePedido(detallePedido);

	}

	
	public void deleteDetallePedido(DetallePedido detallePedido) {
		detallePedidoDao.deleteDetallePedido(detallePedido);
		}

}

