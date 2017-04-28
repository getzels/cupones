package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tarjetas database table.
 * 
 */
@Embeddable
public class TarjetaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private int idUsuario;

	@Column(name="NUM_TARJETA")
	private int numTarjeta;

	public TarjetaPK() {
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getNumTarjeta() {
		return this.numTarjeta;
	}
	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TarjetaPK)) {
			return false;
		}
		TarjetaPK castOther = (TarjetaPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.numTarjeta == castOther.numTarjeta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario;
		hash = hash * prime + this.numTarjeta;
		
		return hash;
	}
}