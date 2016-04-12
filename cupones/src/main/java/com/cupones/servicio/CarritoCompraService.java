package com.cupones.servicio;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.CarritoCompra;
import com.cupones.domain.Cliente;

@Remote
public interface CarritoCompraService {

public List<CarritoCompra> findAllCarritoCompra();
	
	public List<CarritoCompra> findDatosCarritoById(Cliente cliente);
	
	public void addCarritoCompra (CarritoCompra carritoCompra);
	
	public void updateCarritoCompra (CarritoCompra carritoCompra);
	
	public void deleteCarritoCompra (CarritoCompra carritoCompra);
}
