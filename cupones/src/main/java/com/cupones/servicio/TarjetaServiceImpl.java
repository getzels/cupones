package com.cupones.servicio;

import java.util.List;

import javax.ejb.Stateless;

import com.cupones.domain.Tarjeta;
import com.cupones.domain.Usuario;
import com.cupones.eis.TarjetaDao;

@Stateless
public class TarjetaServiceImpl implements TarjetaService, TarjetaDao {

	
	public List<Tarjeta> findAllTarjeta() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Tarjeta> findTarjetaById(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void addTarjeta(Tarjeta tarjeta) {
		// TODO Auto-generated method stub

	}

	
	public void updateTarjeta(Tarjeta tarjeta) {
		// TODO Auto-generated method stub

	}

	
	public void deleteTarjeta(Tarjeta tarjeta) {
		// TODO Auto-generated method stub

	}

}
