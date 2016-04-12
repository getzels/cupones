package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detalle_pedido database table.
 * 
 */
@Entity
@Table(name="detalle_pedido")
@NamedQuery(name="DetallePedido.findAll", query="SELECT d FROM DetallePedido d")
public class DetallePedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetallePedidoPK id;

	@Column(name="descuento_pedido", nullable=false)
	private double descuentoPedido;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_CREA")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_MODI")
	private Date fechaHoraModi;

	@Column(name="ITBIS_PEDIDO", nullable=false)
	private double itbisPedido;

	@Column(name="MONEDA_MONEDA", length=3)
	private String monedaMoneda;

	@Column(name="MONTO_PEDIDO", nullable=false)
	private double montoPedido;

	@Column(name="NETO_PEDIDO")
	private double netoPedido;

	@Column(name="USR_CODIGO_CREA", length=15)
	private String usrCodigoCrea;

	@Column(name="USR_CODIGO_MODI", length=15)
	private String usrCodigoModi;

	//bi-directional many-to-one association to Pedido
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="ID_PEDIDO", nullable=false, insertable=false, updatable=false)
	private Pedido pedido;

	public DetallePedido() {
	}

	public DetallePedidoPK getId() {
		return this.id;
	}

	public void setId(DetallePedidoPK id) {
		this.id = id;
	}

	public double getDescuentoPedido() {
		return this.descuentoPedido;
	}

	public void setDescuentoPedido(double descuentoPedido) {
		this.descuentoPedido = descuentoPedido;
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

	public double getItbisPedido() {
		return this.itbisPedido;
	}

	public void setItbisPedido(double itbisPedido) {
		this.itbisPedido = itbisPedido;
	}

	public String getMonedaMoneda() {
		return this.monedaMoneda;
	}

	public void setMonedaMoneda(String monedaMoneda) {
		this.monedaMoneda = monedaMoneda;
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

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}