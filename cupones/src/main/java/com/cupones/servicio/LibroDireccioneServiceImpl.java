package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.cupones.domain.LibroDireccione;
import com.cupones.domain.Usuario;
import com.cupones.eis.LibroDireccioneDao;

@Stateless
public class LibroDireccioneServiceImpl implements LibroDireccioneService {

	@EJB
	private LibroDireccioneDao libroDireccioneDao;
	
	
	
	public List<LibroDireccione> findAllLibroDireccione() {
		return libroDireccioneDao.findAllLibroDireccione();
	}

	
	public List<LibroDireccione> findLibroDireccioneById(Usuario usuario) {
		return libroDireccioneDao.findLibroDireccioneById(usuario);
	}

	
	public void addLibroDireccione(LibroDireccione libroDireccione) {
		libroDireccioneDao.addLibroDireccione(libroDireccione);

	}

	
	public void updateLibroDireccione(LibroDireccione libroDireccione) {
		libroDireccioneDao.updateLibroDireccione(libroDireccione);

	}

	
	public void deleteLibroDireccione(LibroDireccione libroDireccione) {
		libroDireccioneDao.deleteLibroDireccione(libroDireccione);
	}

}
