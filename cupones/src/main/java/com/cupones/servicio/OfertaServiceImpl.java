package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.cupones.domain.Foto;
import com.cupones.domain.Oferta;
import com.cupones.eis.OfertaDao;

@Stateless
public class OfertaServiceImpl implements OfertaService {

	private static final Logger logger = LogManager.getLogger(OfertaServiceImpl.class);
	
	@EJB
	OfertaDao ofertaDao;

	
	public List<Oferta> findAllOferta() {
		return ofertaDao.findAllOferta();
	}

	
	public Oferta findOfertaById(Oferta oferta) {
		
		if (oferta != null){
			return ofertaDao.findOfertaById(oferta);
		}
		
		return oferta;
		
	}

	
	public void addOferta(Oferta oferta) {
		ofertaDao.addOferta(oferta);

	}

	
	public void updateOferta(Oferta oferta) {
		ofertaDao.updateOferta(oferta);
	}

	
	public void deleteOferta(Oferta oferta) {
		ofertaDao.deleteOferta(oferta);
	}

	
	public boolean validaOfertaExistente(Oferta oferta) {
		logger.trace("Entrada al metodo validaOfertaExistente");
		logger.trace("oferta",oferta);
		Oferta ofertaReturn = findOfertaById(oferta);

			return ofertaReturn != null ? true : false;

	}

	
	public List<Foto> findFotosOferta(Oferta oferta) {
		return  ofertaDao.findFotosOferta(oferta);
	}

}
