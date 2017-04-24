package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.cupones.domain.Pais;
import com.cupones.domain.Provincia;
import com.cupones.eis.ProvinciaDao;

@Stateless
public class ProvinciaServiceImpl implements ProvinciaService {

	@EJB
	ProvinciaDao provinciaDao;

	
	public List<Provincia> findALLProvincia() {
		return provinciaDao.findALLProvincia();
	}

	
	public Provincia findProvinciaById(Provincia provincia) {
		return provinciaDao.findProvinciaById(provincia);
	}

	
	public void addProvincia(Provincia provincia) {
		provinciaDao.addProvincia(provincia);
	}

	
	public List<Provincia> findProvinciaByPais(Pais pais) {
		return provinciaDao.findProvinciaByPais(pais);
	}

	
	public void updateProvincia(Provincia provincia) {
		provinciaDao.updateProvincia(provincia);
	}

	
	public void deleteProvincia(Provincia provincia) {
		provinciaDao.deleteProvincia(provincia);

	}

}
