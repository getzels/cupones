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
	
	
	public List<CarritoCompra> findAllCarritoCompra() {
		return carritoCompraDao.findAllCarritoCompra();
	}

	
	public List<CarritoCompra> findDatosCarritoById(Cliente cliente) {
		return carritoCompraDao.findDatosCarritoById(cliente);
	}

	
	public void addCarritoCompra(CarritoCompra carritoCompra) {
		carritoCompraDao.addCarritoCompra(carritoCompra);
	}

	
	public void updateCarritoCompra(CarritoCompra carritoCompra) {
		carritoCompraDao.updateCarritoCompra(carritoCompra);

	}

	
	public void deleteCarritoCompra(CarritoCompra carritoCompra) {
		System.out.println("Se inicio el medoto deleteCarritoCompra de CarritoComprasServiceImp");
		carritoCompraDao.deleteCarritoCompra(carritoCompra);

	}

}
