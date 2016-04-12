package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.cupones.domain.DetalleSolicitud;
import com.cupones.eis.DetalleSolicitudDao;

@Stateless
public class DetalleSolicitudServiceImpl implements DetalleSolicitudService {

	@EJB
	DetalleSolicitudDao detalleSolicitudDao;

	
	@Override
	public List<DetalleSolicitud> findAllDetalleSolicitud() {
		return detalleSolicitudDao.findAllDetalleSolicitud();
	}

	@Override
	public DetalleSolicitud findDetalleSolicitudById(DetalleSolicitud detalleSolicitud) {
		return detalleSolicitudDao.findDetalleSolicitudById(detalleSolicitud);
	}

	@Override
	public void addDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		detalleSolicitudDao.addDetalleSolicitud(detalleSolicitud);

	}

	@Override
	public void updateDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		detalleSolicitudDao.updateDetalleSolicitud(detalleSolicitud);

	}

	@Override
	public void deleteDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		detalleSolicitudDao.deleteDetalleSolicitud(detalleSolicitud);
	}

}

