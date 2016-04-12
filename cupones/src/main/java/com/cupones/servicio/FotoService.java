package com.cupones.servicio;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Foto;

@Remote
public interface FotoService {

	
	public List<Foto> findAllFoto();
	
	public List<Foto> findFotoById(Foto foto);
	
	public void addFoto(Foto foto);
	
	public void updateFoto(Foto foto);
	
	public void deleteFoto(Foto foto);
}