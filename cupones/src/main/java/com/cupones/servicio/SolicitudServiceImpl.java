package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.cupones.domain.Solicitud;
import com.cupones.eis.SolicitudDao;

@Stateless
public class SolicitudServiceImpl implements SolicitudService {

	@EJB
	SolicitudDao solicitudDao;

	
	public List<Solicitud> findAllSolicitud() {
		return solicitudDao.findAllSolicitud();
	}

	
	public Solicitud findSolicitudById(Solicitud solicitud) {
		return solicitudDao.findSolicitudById(solicitud);
	}

	
	public List<Solicitud> findSolicitudByUserId(Solicitud solicitud) {
		return solicitudDao.findSolicitudByUserId(solicitud);
	}

	
	public void addSolicitud(Solicitud solicitud) {
		solicitudDao.addSolicitud(solicitud);

	}

	
	public void deleteSolicitud(Solicitud solicitud) {
		solicitudDao.deleteSolicitud(solicitud);

	}

	
	public void updateSolicitud(Solicitud solicitud) {
		solicitudDao.updateSolicitud(solicitud);

	}

}
