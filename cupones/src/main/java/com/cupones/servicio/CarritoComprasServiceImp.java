package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.cupones.domain.CarritoCompra;
import com.cupones.domain.Cliente;
import com.cupones.eis.CarritoCompraDao;

@Stateless
public class CarritoComprasServiceImp implements CarritoCompraService {

	@EJB
	private CarritoCompraDao carritoCompraDao;
	
	@Override
	public List<CarritoCompra> findAllCarritoCompra() {
		// TODO Auto-generated method stub
		return carritoCompraDao.findAllCarritoCompra();
	}

	@Override
	public List<CarritoCompra> findDatosCarritoById(Cliente cliente) {
		// TODO Auto-generated method stub
		return carritoCompraDao.findDatosCarritoById(cliente);
	}

	@Override
	public void addCarritoCompra(CarritoCompra carritoCompra) {
		carritoCompraDao.addCarritoCompra(carritoCompra);
	}

	@Override
	public void updateCarritoCompra(CarritoCompra carritoCompra) {
		carritoCompraDao.updateCarritoCompra(carritoCompra);

	}

	@Override
	public void deleteCarritoCompra(CarritoCompra carritoCompra) {
		System.out.println("Se inicio el medoto deleteCarritoCompra de CarritoComprasServiceImp");
		carritoCompraDao.deleteCarritoCompra(carritoCompra);

	}

}
