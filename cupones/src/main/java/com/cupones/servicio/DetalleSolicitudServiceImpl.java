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

	
	
	public List<DetalleSolicitud> findAllDetalleSolicitud() {
		return detalleSolicitudDao.findAllDetalleSolicitud();
	}

	
	public DetalleSolicitud findDetalleSolicitudById(DetalleSolicitud detalleSolicitud) {
		return detalleSolicitudDao.findDetalleSolicitudById(detalleSolicitud);
	}

	
	public void addDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		detalleSolicitudDao.addDetalleSolicitud(detalleSolicitud);

	}

	
	public void updateDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		detalleSolicitudDao.updateDetalleSolicitud(detalleSolicitud);

	}

	
	public void deleteDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		detalleSolicitudDao.deleteDetalleSolicitud(detalleSolicitud);
	}

}

