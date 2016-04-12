package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.cupones.domain.Pais;
import com.cupones.eis.PaisDao;

@Stateless
public class PaisServiceImpl implements PaisService {

	@EJB
	PaisDao paisDao;

	
	@Override
	public List<Pais> findAllPais() {
		return paisDao.findAllPais();
	}

	@Override
	public Pais findPaisById(Pais pais) {
		return paisDao.findPaisById(pais);
	}

	@Override
	public void addPais(Pais pais) {
		paisDao.addPais(pais);
	}

	@Override
	public void updatePais(Pais pais) {
		paisDao.updatePais(pais);
	}

	@Override
	public void deletePais(Pais pais) {
		paisDao.deletePais(pais);
	}

}
