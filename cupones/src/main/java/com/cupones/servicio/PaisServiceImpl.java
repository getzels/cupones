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

	
	
	public List<Pais> findAllPais() {
		return paisDao.findAllPais();
	}

	
	public Pais findPaisById(Pais pais) {
		return paisDao.findPaisById(pais);
	}

	
	public void addPais(Pais pais) {
		paisDao.addPais(pais);
	}

	
	public void updatePais(Pais pais) {
		paisDao.updatePais(pais);
	}

	
	public void deletePais(Pais pais) {
		paisDao.deletePais(pais);
	}

}
