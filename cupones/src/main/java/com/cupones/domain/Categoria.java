package com.cupones.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@Table(name = "categoria")
@NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CATEGORIA", unique = true, nullable = false)
	private int idCategoria;

	@Column(name = "CAT_ESTADO")
	private int catEstado;

	@Column(name = "DESCRIPCION_CATEGORIA", length = 20)
	private String descripcionCategoria;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_CREA")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_MODI")
	private Date fechaHoraModi;

	@Column(name = "NOMBRE_CATEGORIA", nullable = false, length = 30)
	private String nombreCategoria;

	@Column(name = "USR_CODIGO_CREA", length = 15)
	private String usrCodigoCrea;

	@Column(name = "USR_CODIGO_MODI", length = 20)
	private String usrCodigoModi;

	// bi-directional many-to-one association to Oferta
	@OneToMany(mappedBy = "categoria",cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
	private List<Oferta> ofertas;

	public Categoria() {
	}

	public Categoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public Categoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

	public Categoria(String nombreCategoria, String descripcionCategoria,
			int catEstado, Date fechaHoraCrea, String usrCodigoCrea,
			Date fechaHoraModi, String usrCodigoModi) {
		this.nombreCategoria = nombreCategoria;
		this.descripcionCategoria = descripcionCategoria;
		this.catEstado = catEstado;
		this.fechaHoraCrea = fechaHoraCrea;
		this.usrCodigoCrea = usrCodigoCrea;
		this.fechaHoraModi = fechaHoraModi;
		this.usrCodigoModi = usrCodigoModi;
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getCatEstado() {
		return this.catEstado;
	}

	public void setCatEstado(int catEstado) {
		this.catEstado = catEstado;
	}

	public String getDescripcionCategoria() {
		return this.descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

	public Date getFechaHoraCrea() {
		return this.fechaHoraCrea;
	}

	public void setFechaHoraCrea(Date fechaHoraCrea) {
		this.fechaHoraCrea = fechaHoraCrea;
	}

	public Date getFechaHoraModi() {
		return this.fechaHoraModi;
	}

	public void setFechaHoraModi(Date fechaHoraModi) {
		this.fechaHoraModi = fechaHoraModi;
	}

	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getUsrCodigoCrea() {
		return this.usrCodigoCrea;
	}

	public void setUsrCodigoCrea(String usrCodigoCrea) {
		this.usrCodigoCrea = usrCodigoCrea;
	}

	public String getUsrCodigoModi() {
		return this.usrCodigoModi;
	}

	public void setUsrCodigoModi(String usrCodigoModi) {
		this.usrCodigoModi = usrCodigoModi;
	}

	public List<Oferta> getOfertas() {
		return this.ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + catEstado;
		result = prime
				* result
				+ ((descripcionCategoria == null) ? 0 : descripcionCategoria
						.hashCode());
		result = prime * result
				+ ((fechaHoraCrea == null) ? 0 : fechaHoraCrea.hashCode());
		result = prime * result
				+ ((fechaHoraModi == null) ? 0 : fechaHoraModi.hashCode());
		result = prime * result + idCategoria;
		result = prime * result
				+ ((nombreCategoria == null) ? 0 : nombreCategoria.hashCode());
		result = prime * result
				+ ((usrCodigoCrea == null) ? 0 : usrCodigoCrea.hashCode());
		result = prime * result
				+ ((usrCodigoModi == null) ? 0 : usrCodigoModi.hashCode());
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
		Categoria other = (Categoria) obj;
		if (catEstado != other.catEstado)
			return false;
		if (descripcionCategoria == null) {
			if (other.descripcionCategoria != null)
				return false;
		} else if (!descripcionCategoria.equals(other.descripcionCategoria))
			return false;
		if (fechaHoraCrea == null) {
			if (other.fechaHoraCrea != null)
				return false;
		} else if (!fechaHoraCrea.equals(other.fechaHoraCrea))
			return false;
		if (fechaHoraModi == null) {
			if (other.fechaHoraModi != null)
				return false;
		} else if (!fechaHoraModi.equals(other.fechaHoraModi))
			return false;
		if (idCategoria != other.idCategoria)
			return false;
		if (nombreCategoria == null) {
			if (other.nombreCategoria != null)
				return false;
		} else if (!nombreCategoria.equals(other.nombreCategoria))
			return false;
		if (usrCodigoCrea == null) {
			if (other.usrCodigoCrea != null)
				return false;
		} else if (!usrCodigoCrea.equals(other.usrCodigoCrea))
			return false;
		if (usrCodigoModi == null) {
			if (other.usrCodigoModi != null)
				return false;
		} else if (!usrCodigoModi.equals(other.usrCodigoModi))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", catEstado="
				+ catEstado + ", descripcionCategoria=" + descripcionCategoria
				+ ", fechaHoraCrea=" + fechaHoraCrea + ", fechaHoraModi="
				+ fechaHoraModi + ", nombreCategoria=" + nombreCategoria
				+ ", usrCodigoCrea=" + usrCodigoCrea + ", usrCodigoModi="
				+ usrCodigoModi + "]";
	}

//	public Oferta addOferta(Oferta oferta) {
//		getOfertas().add(oferta);
//		oferta.setCategoria(this);
//
//		return oferta;
//	}
//
//	public Oferta removeOferta(Oferta oferta) {
//		getOfertas().remove(oferta);
//		oferta.setCategoria(null);
//
//		return oferta;
//	}

}