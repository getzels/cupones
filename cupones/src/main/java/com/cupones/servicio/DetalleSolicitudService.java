package com.cupones.servicio;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.DetalleSolicitud;

@Remote
public interface DetalleSolicitudService {

	
	public List<DetalleSolicitud> findAllDetalleSolicitud();
	
	public DetalleSolicitud findDetalleSolicitudById(DetalleSolicitud detalleSolicitud);
	
	public void addDetalleSolicitud(DetalleSolicitud detalleSolicitud);
	
	public void updateDetalleSolicitud(DetalleSolicitud detalleSolicitud);
	
	public void deleteDetalleSolicitud(DetalleSolicitud detalleSolicitud);
}
