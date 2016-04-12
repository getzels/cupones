package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_pedido database table.
 * 
 */
@Embeddable
public class DetallePedidoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_PEDIDO", unique=true, nullable=false)
	private int idPedido;

	@Column(unique=true, nullable=false)
	private int linea;

	public DetallePedidoPK() {
	}
	public int getIdPedido() {
		return this.idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
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
		if (!(other instanceof DetallePedidoPK)) {
			return false;
		}
		DetallePedidoPK castOther = (DetallePedidoPK)other;
		return 
			(this.idPedido == castOther.idPedido)
			&& (this.linea == castOther.linea);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPedido;
		hash = hash * prime + this.linea;
		
		return hash;
	}
}