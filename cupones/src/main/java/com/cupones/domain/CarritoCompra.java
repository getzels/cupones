package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the carrito_compras database table.
 * 
 */
@Entity
@Table(name="carrito_compras")
@NamedQuery(name="CarritoCompra.findAll", query="SELECT c FROM CarritoCompra c")
public class CarritoCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CarritoCompraPK id;

	private int cantidad;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_CREA")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_MODI")
	private Date fechaHoraModi;

	private double impuesto;

	private double total;

	@Column(name="USR_CODIGO_CREA")
	private String usrCodigoCrea;

	@Column(name="USR_CODIGO_MODI")
	private String usrCodigoModi;

	@Column(name="VALOR_OFERTA")
	private double valorOferta;
	
	@JoinColumn(name="ID_CLIENTE",nullable=false,insertable=false,updatable=false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Oferta oferta;

	public CarritoCompra() {
	}

	public CarritoCompra(CarritoCompraPK id) {
		super();
		this.id = id;
	}

	public CarritoCompra(int cantidad, Date fechaHoraCrea, Date fechaHoraModi, double impuesto, double total,
			String usrCodigoCrea, String usrCodigoModi, double valorOferta, Oferta oferta,Cliente cliente) {
		super();
		
		this.id = new CarritoCompraPK(cliente.getIdCliente(), oferta.getIdOferta());
		
		this.cantidad = cantidad;
		this.fechaHoraCrea = fechaHoraCrea;
		this.fechaHoraModi = fechaHoraModi;
		this.impuesto = impuesto;
		this.total = total;
		this.usrCodigoCrea = usrCodigoCrea;
		this.usrCodigoModi = usrCodigoModi;
		this.valorOferta = valorOferta;
		this.oferta = oferta;
	}
	
	public CarritoCompraPK getId() {
		return this.id;
	}

	public void setId(CarritoCompraPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

	public double getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(float total) {
		this.total = total;
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

	public double getValorOferta() {
		return this.valorOferta;
	}

	public void setValorOferta(float valorOferta) {
		this.valorOferta = valorOferta;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((fechaHoraCrea == null) ? 0 : fechaHoraCrea.hashCode());
		result = prime * result + ((fechaHoraModi == null) ? 0 : fechaHoraModi.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(impuesto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((oferta == null) ? 0 : oferta.hashCode());
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((usrCodigoCrea == null) ? 0 : usrCodigoCrea.hashCode());
		result = prime * result + ((usrCodigoModi == null) ? 0 : usrCodigoModi.hashCode());
		temp = Double.doubleToLongBits(valorOferta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		CarritoCompra other = (CarritoCompra) obj;
		if (cantidad != other.cantidad)
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(impuesto) != Double.doubleToLongBits(other.impuesto))
			return false;
		if (oferta == null) {
			if (other.oferta != null)
				return false;
		} else if (!oferta.equals(other.oferta))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
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
		if (Double.doubleToLongBits(valorOferta) != Double.doubleToLongBits(other.valorOferta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarritoCompra [id=" + id + ", cantidad=" + cantidad + ", fechaHoraCrea=" + fechaHoraCrea
				+ ", fechaHoraModi=" + fechaHoraModi + ", impuesto=" + impuesto + ", total=" + total
				+ ", usrCodigoCrea=" + usrCodigoCrea + ", usrCodigoModi=" + usrCodigoModi + ", valorOferta="
				+ valorOferta + ", oferta=" + oferta + "]";
	}
	
	

}