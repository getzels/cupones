package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the roles database table.
 * 
 */
@Embeddable
public class RolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ROLE_ID", unique=true, nullable=false)
	private int roleId;

	@Column(name="ID_USUARIO", unique=true, nullable=false)
	private int idUsuario;

	public RolePK() {
	}
	public int getRoleId() {
		return this.roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
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
		if (!(other instanceof RolePK)) {
			return false;
		}
		RolePK castOther = (RolePK)other;
		return 
			(this.roleId == castOther.roleId)
			&& (this.idUsuario == castOther.idUsuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.roleId;
		hash = hash * prime + this.idUsuario;
		
		return hash;
	}
}