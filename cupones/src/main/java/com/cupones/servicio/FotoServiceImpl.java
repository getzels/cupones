package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.cupones.domain.Foto;
import com.cupones.eis.FotoDao;

@Stateless
public class FotoServiceImpl implements FotoService {

	@EJB
	FotoDao fotoDao;

	
	
	public List<Foto> findAllFoto() {
		return fotoDao.findAllFoto();
	}

	
	public List<Foto> findFotoById(Foto foto) {
		return fotoDao.findFotoById(foto);
	}

	
	public void addFoto(Foto foto) {
		fotoDao.addFoto(foto);

	}

	
	public void updateFoto(Foto foto) {
		fotoDao.updateFoto(foto);

	}

	
	public void deleteFoto(Foto foto) {
		fotoDao.deleteFoto(foto);
	}

}

