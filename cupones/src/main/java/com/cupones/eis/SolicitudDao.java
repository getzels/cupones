package com.cupones.eis;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Solicitud;
@Remote
public interface SolicitudDao {

	public List<Solicitud> findAllSolicitud();
	
	public Solicitud findSolicitudById(Solicitud solicitud);
	
	public List<Solicitud> findSolicitudByUserId(Solicitud solicitud);
	
	public void addSolicitud(Solicitud solicitud);
	
	public void deleteSolicitud(Solicitud solicitud);
	
	public void updateSolicitud(Solicitud solicitud);
}
