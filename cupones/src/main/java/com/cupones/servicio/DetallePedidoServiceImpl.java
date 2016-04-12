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

	@Override
	public List<DetallePedido> findAllDetallePedido() {
		return detallePedidoDao.findAllDetallePedido();
	}

	@Override
	public DetallePedido findDetallePedidoById(DetallePedido detallePedido) {
		return detallePedidoDao.findDetallePedidoById(detallePedido);
	}

	@Override
	public void addDetallePedido(DetallePedido detallePedido) {
		detallePedidoDao.addDetallePedido(detallePedido);

	}

	@Override
	public void updateDetallePedido(DetallePedido detallePedido) {
		detallePedidoDao.updateDetallePedido(detallePedido);

	}

	@Override
	public void deleteDetallePedido(DetallePedido detallePedido) {
		detallePedidoDao.deleteDetallePedido(detallePedido);
		}

}

