package com.cupones.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the fotos database table.
 * 
 */
@Entity
@Table(name = "fotos")
@NamedQuery(name = "Foto.findAll", query = "SELECT f FROM Foto f")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FotoPK id;

	@Column(nullable = false, length = 50)
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_CREA")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_MODI")
	private Date fechaHoraModi;

	@Column(name = "FOTO_ESTADO", length = 20)
	private String fotoEstado;

	@Column(name = "RUTA_FOTO", nullable = false, length = 255)
	private String rutaFoto;

	@Column(name = "USR_CODIGO_CREA", length = 15)
	private String usrCodigoCrea;

	@Column(name = "USR_CODIGO_MODI", length = 15)
	private String usrCodigoModi;
	
	@Column(name = "RUTA_FOTO_P", length = 200)
	private String rutaFotoP;

	// bi-directional many-to-one association to Oferta
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "ID_OFERTA", nullable = false)
	private Oferta oferta;

	public Foto() {
	}

	public Foto(FotoPK id) {
		this.id = id;
	}

	public Foto(String descripcion, String fotoNombre, String rutaFoto,
			String fotoEstado, Date fechaHoraCrea, String usrCodigoCrea,
			Date fechaHoraModi, String usrCodigoModi) {
		this.descripcion = descripcion;
		this.id = new FotoPK(fotoNombre);
		this.rutaFoto = rutaFoto;
		this.fotoEstado = fotoEstado;
		this.fechaHoraCrea = fechaHoraCrea;
		this.usrCodigoCrea = usrCodigoCrea;
		this.fechaHoraModi = fechaHoraModi;
		this.usrCodigoModi = usrCodigoModi;
	}

	public Foto(String descripcion, String fotoNombre, String rutaFoto,String rutaFotoP,
			String fotoEstado, Date fechaHoraCrea, String usrCodigoCrea,
			Date fechaHoraModi, String usrCodigoModi,Oferta oferta) {
		this.descripcion = descripcion;
		this.id = new FotoPK(fotoNombre);
		this.rutaFoto = rutaFoto;
		this.rutaFotoP = rutaFotoP;
		this.fotoEstado = fotoEstado;
		this.fechaHoraCrea = fechaHoraCrea;
		this.usrCodigoCrea = usrCodigoCrea;
		this.fechaHoraModi = fechaHoraModi;
		this.usrCodigoModi = usrCodigoModi;
		this.oferta = oferta;
	}

	public FotoPK getId() {
		return this.id;
	}

	public void setId(FotoPK id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getFotoEstado() {
		return this.fotoEstado;
	}

	public void setFotoEstado(String fotoEstado) {
		this.fotoEstado = fotoEstado;
	}

	public String getRutaFoto() {
		return this.rutaFoto;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
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

	public Oferta getOferta() {
		return this.oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result
				+ ((fechaHoraCrea == null) ? 0 : fechaHoraCrea.hashCode());
		result = prime * result
				+ ((fechaHoraModi == null) ? 0 : fechaHoraModi.hashCode());
		result = prime * result
				+ ((fotoEstado == null) ? 0 : fotoEstado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		
		result = prime * result
				+ ((rutaFoto == null) ? 0 : rutaFoto.hashCode());
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
		Foto other = (Foto) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
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
		if (fotoEstado == null) {
			if (other.fotoEstado != null)
				return false;
		} else if (!fotoEstado.equals(other.fotoEstado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
				if (rutaFoto == null) {
			if (other.rutaFoto != null)
				return false;
		} else if (!rutaFoto.equals(other.rutaFoto))
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
		return "Foto [id=" + id + ", descripcion=" + descripcion
				+ ", fechaHoraCrea=" + fechaHoraCrea + ", fechaHoraModi="
				+ fechaHoraModi + ", fotoEstado=" + fotoEstado + ", rutaFoto="
				+ rutaFoto + ", usrCodigoCrea=" + usrCodigoCrea
				+ ", usrCodigoModi=" + usrCodigoModi + ", rutaFotoP="
				+ rutaFotoP + "]";
	}

	public String getRutaFotoP() {
		return rutaFotoP;
	}

	public void setRutaFotoP(String rutaFotoP) {
		this.rutaFotoP = rutaFotoP;
	}

}