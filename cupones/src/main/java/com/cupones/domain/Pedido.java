package com.cupones.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name="pedido")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PEDIDO", unique=true, nullable=false)
	private int idPedido;

	@Column(name="DESCUENTO_PEDIDO", nullable=false)
	private double descuentoPedido;

	@Column(name="ESTADO_PEDIDO", nullable=false, length=1)
	private String estadoPedido;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_CREA")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_MODI")
	private Date fechaHoraModi;

	@Column(name="FECHA_IMPRESION", length=20)
	private String fechaImpresion;

	@Column(name="ITBIS_PEDIDO", nullable=false)
	private double itbisPedido;

	@Column(name="MONTO_PEDIDO", nullable=false)
	private double montoPedido;

	@Column(name="NETO_PEDIDO", nullable=false)
	private double netoPedido;

	@Column(name="OBSERVACIONES_PEDIDO", length=150)
	private String observacionesPedido;

	@Temporal(TemporalType.DATE)
	@Column(name="SOLICITUD_FECHA")
	private Date solicitudFecha;

	@Column(name="TASA_PEDIDO")
	private int tasaPedido;

	@Column(name="USR_CODIGO_CREA", length=15)
	private String usrCodigoCrea;

	@Column(name="USR_CODIGO_MODI", length=15)
	private String usrCodigoModi;

	//bi-directional many-to-one association to DetallePedido
	@OneToMany(mappedBy="pedido", cascade={CascadeType.PERSIST})
	private List<DetallePedido> detallePedidos;

	//bi-directional many-to-one association to Solicitud
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="ID_SOLICITUD", nullable=false)
	private Solicitud solicitud;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public double getDescuentoPedido() {
		return this.descuentoPedido;
	}

	public void setDescuentoPedido(double descuentoPedido) {
		this.descuentoPedido = descuentoPedido;
	}

	public String getEstadoPedido() {
		return this.estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
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

	public double getItbisPedido() {
		return this.itbisPedido;
	}

	public void setItbisPedido(double itbisPedido) {
		this.itbisPedido = itbisPedido;
	}

	public double getMontoPedido() {
		return this.montoPedido;
	}

	public void setMontoPedido(double montoPedido) {
		this.montoPedido = montoPedido;
	}

	public double getNetoPedido() {
		return this.netoPedido;
	}

	public void setNetoPedido(double netoPedido) {
		this.netoPedido = netoPedido;
	}

	public String getObservacionesPedido() {
		return this.observacionesPedido;
	}

	public void setObservacionesPedido(String observacionesPedido) {
		this.observacionesPedido = observacionesPedido;
	}

	public Date getSolicitudFecha() {
		return this.solicitudFecha;
	}

	public void setSolicitudFecha(Date solicitudFecha) {
		this.solicitudFecha = solicitudFecha;
	}

	public int getTasaPedido() {
		return this.tasaPedido;
	}

	public void setTasaPedido(int tasaPedido) {
		this.tasaPedido = tasaPedido;
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

	public List<DetallePedido> getDetallePedidos() {
		return this.detallePedidos;
	}

	public void setDetallePedidos(List<DetallePedido> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}

	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().add(detallePedido);
		detallePedido.setPedido(this);

		return detallePedido;
	}

	public DetallePedido removeDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().remove(detallePedido);
		detallePedido.setPedido(null);

		return detallePedido;
	}

	public Solicitud getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

}