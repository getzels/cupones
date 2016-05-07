package com.cupones.servicio;

import java.util.List;

import com.cupones.domain.LibroDireccione;
import com.cupones.domain.Usuario;
import com.cupones.eis.LibroDireccioneDao;

public class LibroDireccionServiceImpl implements LibroDireccioneService, LibroDireccioneDao {

	
	@EJB
	private LibroDireccioneService libroDireccionService;
	
	@Override
	public List<LibroDireccione> findAllLibroDireccione() {
		
		return libroDireccionService.findAllLibroDireccione();
	}

	@Override
	public List<LibroDireccione> findLibroDireccioneById(Usuario usuario) {
		return libroDireccionService.findLibroDireccioneById(usuario);
	}

	@Override
	public void addLibroDireccione(LibroDireccione libroDireccione) {
		libroDireccionService.addLibroDireccione(libroDireccione);

	}

	@Override
	public void updateLibroDireccione(LibroDireccione libroDireccione) {
		libroDireccionService.updateLibroDireccione(libroDireccione);

	}

	@Override
	public void deleteLibroDireccione(LibroDireccione libroDireccione) {
		libroDireccionService.deleteLibroDireccione(libroDireccione);

	}

}
