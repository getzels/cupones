package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.cupones.domain.Foto;
import com.cupones.domain.Oferta;
import com.cupones.eis.OfertaDao;

@Stateless
public class OfertaServiceImpl implements OfertaService {

	@EJB
	OfertaDao ofertaDao;

	@Override
	public List<Oferta> findAllOferta() {
		return ofertaDao.findAllOferta();
	}

	@Override
	public Oferta findOfertaById(Oferta oferta) {
		System.out.println("Inicio de service");
		System.out.println("Oferta ? " + oferta);
		if (oferta != null){
			System.out.println("Hola mundo");
		return ofertaDao.findOfertaById(oferta);}else{
			System.out.println("oferta esta nula en ofertaService");
		}
		return oferta;
		
	}

	@Override
	public void addOferta(Oferta oferta) {
		ofertaDao.addOferta(oferta);

	}

	@Override
	public void updateOferta(Oferta oferta) {
		ofertaDao.updateOferta(oferta);

	}

	@Override
	public void deleteOferta(Oferta oferta) {
		ofertaDao.deleteOferta(oferta);
	}

	@Override
	public boolean validaOfertaExistente(Oferta oferta) {
		Oferta ofertaReturn = null;
		ofertaReturn = findOfertaById(oferta);

		if (ofertaReturn != null){
			return true;
		}else{
			return false;
		}

	}

	@Override
	public List<Foto> findFotosOferta(Oferta oferta) {
		return  ofertaDao.findFotosOferta(oferta);
	}

}
