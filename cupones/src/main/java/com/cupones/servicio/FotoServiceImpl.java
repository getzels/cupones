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
	private FotoDao fotoDao;

	
	
	public List<Foto> findAllFoto() {
		return fotoDao.findAllFoto();
	}

	
	public List<Foto> findFotoById(Foto foto) {
		Foto fotoReturn;
		if (foto != null){
		fotoReturn = fotoDao.findFotoById(foto);
		}
		return fotoReturn;
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

