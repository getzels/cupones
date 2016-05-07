package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;

import com.cupones.domain.LibroDireccione;
import com.cupones.domain.Usuario;
import com.cupones.eis.LibroDireccioneDao;

public class LibroDireccioneServiceImpl implements LibroDireccioneService {

	@EJB
	private LibroDireccioneDao libroDireccioneDao;
	
	
	@Override
	public List<LibroDireccione> findAllLibroDireccione() {
		return libroDireccioneDao.findAllLibroDireccione();
	}

	@Override
	public List<LibroDireccione> findLibroDireccioneById(Usuario usuario) {
		return libroDireccioneDao.findLibroDireccioneById(usuario);
	}

	@Override
	public void addLibroDireccione(LibroDireccione libroDireccione) {
		libroDireccioneDao.addLibroDireccione(libroDireccione);

	}

	@Override
	public void updateLibroDireccione(LibroDireccione libroDireccione) {
		libroDireccioneDao.updateLibroDireccione(libroDireccione);

	}

	@Override
	public void deleteLibroDireccione(LibroDireccione libroDireccione) {
		libroDireccioneDao.deleteLibroDireccione(libroDireccione);
	}

}
