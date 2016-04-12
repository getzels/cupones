package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the fotos database table.
 * 
 */
@Embeddable
public class FotoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_FOTOS", unique=true, nullable=false)
	private int idFotos;

	@Column(name="NOMBRE_FOTO", unique=true, nullable=false, length=30)
	private String nombreFoto;

	public FotoPK() {
	}

	public FotoPK(int id){
		this.idFotos = id;
	}
   
	public FotoPK(String nombreFoto){
		this.nombreFoto =  nombreFoto;
	}
	
	public int getIdFotos() {
		return this.idFotos;
	}
	public void setIdFotos(int idFotos) {
		this.idFotos = idFotos;
	}
	public String getNombreFoto() {
		return this.nombreFoto;
	}
	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FotoPK)) {
			return false;
		}
		FotoPK castOther = (FotoPK)other;
		return 
			(this.idFotos == castOther.idFotos)
			&& this.nombreFoto.equals(castOther.nombreFoto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idFotos;
		hash = hash * prime + this.nombreFoto.hashCode();
		
		return hash;
	}

	@Override
	public String toString() {
		return "FotoPK [idFotos=" + idFotos + ", nombreFoto=" + nombreFoto
				+ "]";
	}
}