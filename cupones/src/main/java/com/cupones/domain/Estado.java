package com.cupones.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@Table(name = "estado")
@NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESTADO", unique = true, nullable = false)
	private int idEstado;

	@Column(name = "ESTADO_DESCRIPCION", length = 30)
	private String estadoDescripcion;

	// bi-directional many-to-one association to Oferta
//	@OneToMany(mappedBy = "estado")
//	private List<Oferta> ofertas;

	public Estado() {
	}

	public Estado(int idEstado) {
		this.idEstado = idEstado;
	}

	public Estado(String estadoDescripcion) {
		this.estadoDescripcion = estadoDescripcion;
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getEstadoDescripcion() {
		return this.estadoDescripcion;
	}

	public void setEstadoDescripcion(String estadoDescripcion) {
		this.estadoDescripcion = estadoDescripcion;
	}

//	public List<Oferta> getOfertas() {
//		return this.ofertas;
//	}
//
//	public void setOfertas(List<Oferta> ofertas) {
//		this.ofertas = ofertas;
//	}

//	public Oferta addOferta(Oferta oferta) {
//		getOfertas().add(oferta);
//		oferta.setEstado(this);
//
//		return oferta;
//	}
//
//	public Oferta removeOferta(Oferta oferta) {
//		getOfertas().remove(oferta);
//		oferta.setEstado(null);
//
//		return oferta;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((estadoDescripcion == null) ? 0 : estadoDescripcion
						.hashCode());
		result = prime * result + idEstado;
//		result = prime * result + ((ofertas == null) ? 0 : ofertas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (estadoDescripcion == null) {
			if (other.estadoDescripcion != null)
				return false;
		} else if (!estadoDescripcion.equals(other.estadoDescripcion))
			return false;
		if (idEstado != other.idEstado)
			return false;
//		if (ofertas == null) {
//			if (other.ofertas != null)
//				return false;
//		} 
//		else if (!ofertas.equals(other.ofertas))
//			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", estadoDescripcion="
				+ estadoDescripcion+ "]";
	}

}