package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the libro_direcciones database table.
 * 
 */
@Embeddable
public class LibroDireccionePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_DIRECCIONES")
	private int idDirecciones;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private int idUsuario;

	public LibroDireccionePK() {
	}
	public int getIdDirecciones() {
		return this.idDirecciones;
	}
	public void setIdDirecciones(int idDirecciones) {
		this.idDirecciones = idDirecciones;
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LibroDireccionePK)) {
			return false;
		}
		LibroDireccionePK castOther = (LibroDireccionePK)other;
		return 
			(this.idDirecciones == castOther.idDirecciones)
			&& (this.idUsuario == castOther.idUsuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idDirecciones;
		hash = hash * prime + this.idUsuario;
		
		return hash;
	}
}