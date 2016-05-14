package com.cupones.servicio;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.LibroDireccione;
import com.cupones.domain.Usuario;

@Remote
public interface LibroDireccioneService {
	public List<LibroDireccione> findAllLibroDireccione();
	
	public List<LibroDireccione> findLibroDireccioneById(Usuario usuario);
	
	public void addLibroDireccione (LibroDireccione libroDireccione);
	
	public void updateLibroDireccione (LibroDireccione libroDireccione);
	
	public void deleteLibroDireccione (LibroDireccione libroDireccione);
}
