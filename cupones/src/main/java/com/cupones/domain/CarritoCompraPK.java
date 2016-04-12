package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the carrito_compras database table.
 * 
 */
@Embeddable
public class CarritoCompraPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	public CarritoCompraPK(int idCliente, int idOferta) {
		super();
		this.idCliente = idCliente;
		this.idOferta = idOferta;
	}

	@Column(name="ID_CLIENTE")
	private int idCliente;

	@Column(name="ID_OFERTA")
	private int idOferta;

	public CarritoCompraPK() {
	}
	public int getIdCliente() {
		return this.idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdOferta() {
		return this.idOferta;
	}
	public void setIdOferta(int idOferta) {
		this.idOferta = idOferta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CarritoCompraPK)) {
			return false;
		}
		CarritoCompraPK castOther = (CarritoCompraPK)other;
		return 
			(this.idCliente == castOther.idCliente)
			&& (this.idOferta == castOther.idOferta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCliente;
		hash = hash * prime + this.idOferta;
		
		return hash;
	}
}