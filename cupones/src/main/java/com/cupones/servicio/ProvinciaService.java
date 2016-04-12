package com.cupones.servicio;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Pais;
import com.cupones.domain.Provincia;

@Remote
public interface ProvinciaService {
	
	public List<Provincia> findALLProvincia();
	
	public Provincia findProvinciaById(Provincia provincia);
	
	public List<Provincia> findProvinciaByPais(Pais pais);
	
	public void addProvincia(Provincia provincia);
	
	public void updateProvincia(Provincia provincia);
	
	public void deleteProvincia(Provincia provincia);

}
