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

	@Override
	public List<Provincia> findALLProvincia() {
		return provinciaDao.findALLProvincia();
	}

	@Override
	public Provincia findProvinciaById(Provincia provincia) {
		return provinciaDao.findProvinciaById(provincia);
	}

	@Override
	public void addProvincia(Provincia provincia) {
		provinciaDao.addProvincia(provincia);
	}

	@Override
	public List<Provincia> findProvinciaByPais(Pais pais) {
		return provinciaDao.findProvinciaByPais(pais);
	}

	@Override
	public void updateProvincia(Provincia provincia) {
		provinciaDao.updateProvincia(provincia);
	}

	@Override
	public void deleteProvincia(Provincia provincia) {
		provinciaDao.deleteProvincia(provincia);

	}

}
