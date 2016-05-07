package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tarjetas database table.
 * 
 */
@Entity
@Table(name="tarjetas")
@NamedQuery(name="Tarjeta.findAll", query="SELECT t FROM Tarjeta t")
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TarjetaPK id;

	@Column(name="ANO_EXPIRA")
	private String anoExpira;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_CREA")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_MODI")
	private Date fechaHoraModi;

	@Column(name="ID_PREFERIDA")
	private String idPreferida;

	@Column(name="ID_TARJETA")
	private String idTarjeta;

	@Column(name="MES_EXPIRA")
	private String mesExpira;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="USR_CODIGO_CREA")
	private String usrCodigoCrea;

	@Column(name="USR_CODIGO_MODI")
	private String usrCodigoModi;

	public Tarjeta() {
	}

	public TarjetaPK getId() {
		return this.id;
	}

	public void setId(TarjetaPK id) {
		this.id = id;
	}

	public String getAnoExpira() {
		return this.anoExpira;
	}

	public void setAnoExpira(String anoExpira) {
		this.anoExpira = anoExpira;
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

	public String getIdPreferida() {
		return this.idPreferida;
	}

	public void setIdPreferida(String idPreferida) {
		this.idPreferida = idPreferida;
	}

	public String getIdTarjeta() {
		return this.idTarjeta;
	}

	public void setIdTarjeta(String idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getMesExpira() {
		return this.mesExpira;
	}

	public void setMesExpira(String mesExpira) {
		this.mesExpira = mesExpira;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

}