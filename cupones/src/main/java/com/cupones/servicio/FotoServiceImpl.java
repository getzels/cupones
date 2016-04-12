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

	
	@Override
	public List<Foto> findAllFoto() {
		return fotoDao.findAllFoto();
	}

	@Override
	public List<Foto> findFotoById(Foto foto) {
		return fotoDao.findFotoById(foto);
	}

	@Override
	public void addFoto(Foto foto) {
		fotoDao.addFoto(foto);

	}

	@Override
	public void updateFoto(Foto foto) {
		fotoDao.updateFoto(foto);

	}

	@Override
	public void deleteFoto(Foto foto) {
		fotoDao.deleteFoto(foto);
	}

}

