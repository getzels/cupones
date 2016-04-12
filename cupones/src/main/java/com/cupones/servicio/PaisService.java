package com.cupones.servicio;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Pais;

@Remote
public interface PaisService {

	
	public List<Pais> findAllPais();
	
	public Pais findPaisById(Pais pais);
	
	public void addPais(Pais pais);
	
	public void updatePais(Pais pais);
	
	public void deletePais(Pais pais);
}