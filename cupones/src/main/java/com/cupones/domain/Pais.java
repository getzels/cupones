package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name = "pais")
@NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PAIS", unique = true, nullable = false)
	private int idPais;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_CREA")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_MODI")
	private Date fechaHoraModi;

	@Column(name = "PAIS_DESCRIPCION", length = 20)
	private String paisDescripcion;

	@Column(name = "PAIS_DESCRIPCION_CORTA", length = 20)
	private String paisDescripcionCorta;

	@Column(name = "USR_CODIGO_CREA", length = 15)
	private String usrCodigoCrea;

	@Column(name = "USR_CODIGO_MODI", length = 15)
	private String usrCodigoModi;

	// bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy = "pais",cascade = {CascadeType.PERSIST})
	private List<Provincia> provincias;

	public Pais() {
	}

	public Pais(int idPais) {
		this.idPais = idPais;
	}

	public Pais(String paisDescripcion, String paisDescripcionCorta,
			Date fechaHoraCrea, String usrCodigoCrea, Date fechaHoraModi,
			String usrCodigoModi) {
		super();
		this.paisDescripcion = paisDescripcion;
		this.paisDescripcionCorta = paisDescripcionCorta;
		this.fechaHoraCrea = fechaHoraCrea;
		this.usrCodigoCrea = usrCodigoCrea;
		this.fechaHoraModi = fechaHoraModi;
		this.usrCodigoModi = usrCodigoModi;
	}

	public int getIdPais() {
		return this.idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
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

	public String getPaisDescripcion() {
		return this.paisDescripcion;
	}

	public void setPaisDescripcion(String paisDescripcion) {
		this.paisDescripcion = paisDescripcion;
	}

	public String getPaisDescripcionCorta() {
		return this.paisDescripcionCorta;
	}

	public void setPaisDescripcionCorta(String paisDescripcionCorta) {
		this.paisDescripcionCorta = paisDescripcionCorta;
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

	public List<Provincia> getProvincias() {
		return this.provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}

	public Provincia addProvincia(Provincia provincia) {
		getProvincias().add(provincia);
		provincia.setPais(this);

		return provincia;
	}

	public Provincia removeProvincia(Provincia provincia) {
		getProvincias().remove(provincia);
		provincia.setPais(null);

		return provincia;
	}

}