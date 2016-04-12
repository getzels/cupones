package com.cupones.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the detalle_solicitud database table.
 * 
 */
@Entity
@Table(name="detalle_solicitud")
@NamedQuery(name="DetalleSolicitud.findAll", query="SELECT d FROM DetalleSolicitud d")
public class DetalleSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleSolicitudPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_CREA")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_MODI")
	private Date fechaHoraModi;

	@Column(name="SOD_DESCUENTO", nullable=false)
	private double sodDescuento;

	@Column(name="SOD_ITBIS", nullable=false)
	private double sodItbis;

	@Column(name="SOD_MONEDA", length=3)
	private String sodMoneda;

	@Column(name="SOD_MONTO", nullable=false)
	private double sodMonto;

	@Column(name="SOD_NETO")
	private double sodNeto;

	@Column(name="USR_CODIGO_CREA", length=15)
	private String usrCodigoCrea;

	@Column(name="USR_CODIGO_MODI", length=15)
	private String usrCodigoModi;

	//bi-directional many-to-one association to Oferta
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="ID_OFERTA", nullable=false, insertable=false, updatable=false)
	private Oferta oferta;

	//bi-directional many-to-one association to Solicitud
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="ID_SOLICITUD", nullable=false, insertable=false, updatable=false)
	private Solicitud solicitud;

	public DetalleSolicitud() {
	}

	public DetalleSolicitudPK getId() {
		return this.id;
	}

	public void setId(DetalleSolicitudPK id) {
		this.id = id;
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

	public double getSodDescuento() {
		return this.sodDescuento;
	}

	public void setSodDescuento(double sodDescuento) {
		this.sodDescuento = sodDescuento;
	}

	public double getSodItbis() {
		return this.sodItbis;
	}

	public void setSodItbis(double sodItbis) {
		this.sodItbis = sodItbis;
	}

	public String getSodMoneda() {
		return this.sodMoneda;
	}

	public void setSodMoneda(String sodMoneda) {
		this.sodMoneda = sodMoneda;
	}

	public double getSodMonto() {
		return this.sodMonto;
	}

	public void setSodMonto(double sodMonto) {
		this.sodMonto = sodMonto;
	}

	public double getSodNeto() {
		return this.sodNeto;
	}

	public void setSodNeto(double sodNeto) {
		this.sodNeto = sodNeto;
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

	public Solicitud getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

}