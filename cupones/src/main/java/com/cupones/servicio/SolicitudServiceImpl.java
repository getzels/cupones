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

	@Override
	public List<Solicitud> findAllSolicitud() {
		return solicitudDao.findAllSolicitud();
	}

	@Override
	public Solicitud findSolicitudById(Solicitud solicitud) {
		return solicitudDao.findSolicitudById(solicitud);
	}

	@Override
	public List<Solicitud> findSolicitudByUserId(Solicitud solicitud) {
		return solicitudDao.findSolicitudByUserId(solicitud);
	}

	@Override
	public void addSolicitud(Solicitud solicitud) {
		solicitudDao.addSolicitud(solicitud);

	}

	@Override
	public void deleteSolicitud(Solicitud solicitud) {
		solicitudDao.deleteSolicitud(solicitud);

	}

	@Override
	public void updateSolicitud(Solicitud solicitud) {
		solicitudDao.updateSolicitud(solicitud);

	}

}
