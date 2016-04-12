package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_solicitud database table.
 * 
 */
@Embeddable
public class DetalleSolicitudPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_OFERTA", unique=true, nullable=false)
	private int idOferta;

	@Column(name="ID_SOLICITUD",unique=true, nullable=false)
	private int idSolicitud;

	@Column(unique=true, nullable=false)
	private int linea;

	public DetalleSolicitudPK() {
	}
	public int getIdOferta() {
		return this.idOferta;
	}
	public void setIdOferta(int idOferta) {
		this.idOferta = idOferta;
	}
	public int getIdSolicitud() {
		return this.idSolicitud;
	}
	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public int getLinea() {
		return this.linea;
	}
	public void setLinea(int linea) {
		this.linea = linea;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleSolicitudPK)) {
			return false;
		}
		DetalleSolicitudPK castOther = (DetalleSolicitudPK)other;
		return 
			(this.idOferta == castOther.idOferta)
			&& (this.idSolicitud == castOther.idSolicitud)
			&& (this.linea == castOther.linea);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOferta;
		hash = hash * prime + this.idSolicitud;
		hash = hash * prime + this.linea;
		
		return hash;
	}
}