package com.cupones.servicio;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Foto;
import com.cupones.domain.Oferta;

@Remote
public interface OfertaService {

	
	public List<Oferta> findAllOferta();
	
	public Oferta findOfertaById(Oferta oferta);
	
	public List<Foto> findFotosOferta(Oferta oferta);
	
	public void addOferta(Oferta oferta);
	
	public void updateOferta(Oferta oferta);
	
	public void deleteOferta(Oferta oferta);
	
	public boolean validaOfertaExistente(Oferta oferta);
	
}
