package com.cupones.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the provincia database table.
 * 
 */
@Entity
@Table(name = "provincia")
@NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROVINCIA", unique = true, nullable = false)
	private int idProvincia;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_CREA")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_MODI")
	private Date fechaHoraModi;

	@Column(name = "PRO_DESCRIPCION", nullable = false, length = 30)
	private String proDescripcion;

	@Column(name = "PRO_DESCRIPCION_CORTA", length = 10)
	private String proDescripcionCorta;

	@Column(name = "USR_CODIGO_CREA", length = 15)
	private String usrCodigoCrea;

	@Column(name = "USR_CODIGO_MODI", length = 15)
	private String usrCodigoModi;

	// bi-directional many-to-one association to Pais
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "ID_PAIS", nullable = false)
	private Pais pais;

	// bi-directional many-to-one association to Sector
	@OneToMany(mappedBy = "provincia",cascade = {CascadeType.PERSIST})
	private List<Sector> sectors;

	public Provincia() {
	}

	public Provincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public Provincia(String proDescripcion, String proDescripcionCorta,
			Date fechaHoraCrea, String usrCodigoCrea, Date fechaHoraModi,
			String usrCodigoModi, Pais pais) {
		super();
		this.proDescripcion = proDescripcion;
		this.proDescripcionCorta = proDescripcionCorta;
		this.fechaHoraCrea = fechaHoraCrea;
		this.usrCodigoCrea = usrCodigoCrea;
		this.fechaHoraModi = fechaHoraModi;
		this.usrCodigoModi = usrCodigoModi;
		this.pais = pais;
	}

	public int getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
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

	public String getProDescripcion() {
		return this.proDescripcion;
	}

	public void setProDescripcion(String proDescripcion) {
		this.proDescripcion = proDescripcion;
	}

	public String getProDescripcionCorta() {
		return this.proDescripcionCorta;
	}

	public void setProDescripcionCorta(String proDescripcionCorta) {
		this.proDescripcionCorta = proDescripcionCorta;
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

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Sector> getSectors() {
		return this.sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fechaHoraCrea == null) ? 0 : fechaHoraCrea.hashCode());
		result = prime * result
				+ ((fechaHoraModi == null) ? 0 : fechaHoraModi.hashCode());
		result = prime * result + idProvincia;
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result
				+ ((proDescripcion == null) ? 0 : proDescripcion.hashCode());
		result = prime
				* result
				+ ((proDescripcionCorta == null) ? 0 : proDescripcionCorta
						.hashCode());
		result = prime * result + ((sectors == null) ? 0 : sectors.hashCode());
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
		Provincia other = (Provincia) obj;
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
		if (idProvincia != other.idProvincia)
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (proDescripcion == null) {
			if (other.proDescripcion != null)
				return false;
		} else if (!proDescripcion.equals(other.proDescripcion))
			return false;
		if (proDescripcionCorta == null) {
			if (other.proDescripcionCorta != null)
				return false;
		} else if (!proDescripcionCorta.equals(other.proDescripcionCorta))
			return false;
		if (sectors == null) {
			if (other.sectors != null)
				return false;
		} else if (!sectors.equals(other.sectors))
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
		return "Provincia [idProvincia=" + idProvincia + ", fechaHoraCrea="
				+ fechaHoraCrea + ", fechaHoraModi=" + fechaHoraModi
				+ ", proDescripcion=" + proDescripcion
				+ ", proDescripcionCorta=" + proDescripcionCorta
				+ ", usrCodigoCrea=" + usrCodigoCrea + ", usrCodigoModi="
				+ usrCodigoModi + ", pais=" + pais + ", sectors=" + sectors
				+ "]";
	}



}