package com.cupones.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the solicitud database table.
 * 
 */
@Entity
@Table(name="solicitud")
@NamedQuery(name="Solicitud.findAll", query="SELECT s FROM Solicitud s")
public class Solicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SOLICITUD", unique=true, nullable=false)
	private int idSolicitud;

	@Column(name="DESCUENTO_SOLICITUD", nullable=false)
	private double descuentoSolicitud;

	@Column(name="ESTADO_SOLICITUD", nullable=false, length=1)
	private String estadoSolicitud;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_CREA")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_MODI")
	private Date fechaHoraModi;

	@Column(name="FECHA_IMPRESION", length=20)
	private String fechaImpresion;

	@Column(name="ITBIS_SOLICITUD", nullable=false)
	private double itbisSolicitud;

	@Column(name="MONTO_SOLICITUD", nullable=false)
	private double montoSolicitud;

	@Column(name="NETO_SOLICITUD", nullable=false)
	private double netoSolicitud;

	@Column(name="OBSERVACIONES_SOLICITUD", length=150)
	private String observacionesSolicitud;

	@Column(name="SOL_IND_TRANSPORTE", length=1)
	private String solIndTransporte;

	@Temporal(TemporalType.DATE)
	@Column(name="SOLICITUD_FECHA")
	private Date solicitudFecha;

	@Column(name="TASA_SOLICITUD")
	private int tasaSolicitud;

	@Column(name="USR_CODIGO_CREA", length=15)
	private String usrCodigoCrea;

	@Column(name="USR_CODIGO_MODI", length=15)
	private String usrCodigoModi;

	//bi-directional many-to-one association to DetalleSolicitud
	@OneToMany(mappedBy="solicitud",cascade = {CascadeType.PERSIST})
	private List<DetalleSolicitud> detalleSolicitudes;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="solicitud",cascade = {CascadeType.PERSIST})
	private List<Pedido> pedidos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="ID_CLIENTE", nullable=false)
	private Cliente cliente;

	public Solicitud() {
	}

	public int getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public double getDescuentoSolicitud() {
		return this.descuentoSolicitud;
	}

	public void setDescuentoSolicitud(double descuentoSolicitud) {
		this.descuentoSolicitud = descuentoSolicitud;
	}

	public String getEstadoSolicitud() {
		return this.estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
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

	public String getFechaImpresion() {
		return this.fechaImpresion;
	}

	public void setFechaImpresion(String fechaImpresion) {
		this.fechaImpresion = fechaImpresion;
	}

	public double getItbisSolicitud() {
		return this.itbisSolicitud;
	}

	public void setItbisSolicitud(double itbisSolicitud) {
		this.itbisSolicitud = itbisSolicitud;
	}

	public double getMontoSolicitud() {
		return this.montoSolicitud;
	}

	public void setMontoSolicitud(double montoSolicitud) {
		this.montoSolicitud = montoSolicitud;
	}

	public double getNetoSolicitud() {
		return this.netoSolicitud;
	}

	public void setNetoSolicitud(double netoSolicitud) {
		this.netoSolicitud = netoSolicitud;
	}

	public String getObservacionesSolicitud() {
		return this.observacionesSolicitud;
	}

	public void setObservacionesSolicitud(String observacionesSolicitud) {
		this.observacionesSolicitud = observacionesSolicitud;
	}

	public String getSolIndTransporte() {
		return this.solIndTransporte;
	}

	public void setSolIndTransporte(String solIndTransporte) {
		this.solIndTransporte = solIndTransporte;
	}

	public Date getSolicitudFecha() {
		return this.solicitudFecha;
	}

	public void setSolicitudFecha(Date solicitudFecha) {
		this.solicitudFecha = solicitudFecha;
	}

	public int getTasaSolicitud() {
		return this.tasaSolicitud;
	}

	public void setTasaSolicitud(int tasaSolicitud) {
		this.tasaSolicitud = tasaSolicitud;
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

	public List<DetalleSolicitud> getDetalleSolicitudes() {
		return this.detalleSolicitudes;
	}

	public void setDetalleSolicitudes(List<DetalleSolicitud> detalleSolicitudes) {
		this.detalleSolicitudes = detalleSolicitudes;
	}

	public DetalleSolicitud addDetalleSolicitude(DetalleSolicitud detalleSolicitude) {
		getDetalleSolicitudes().add(detalleSolicitude);
		detalleSolicitude.setSolicitud(this);

		return detalleSolicitude;
	}

	public DetalleSolicitud removeDetalleSolicitude(DetalleSolicitud detalleSolicitude) {
		getDetalleSolicitudes().remove(detalleSolicitude);
		detalleSolicitude.setSolicitud(null);

		return detalleSolicitude;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setSolicitud(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setSolicitud(null);

		return pedido;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}