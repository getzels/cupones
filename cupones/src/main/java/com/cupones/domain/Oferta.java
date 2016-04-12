package com.cupones.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the oferta database table.
 * 
 */
@Entity
@Table(name = "oferta")
@NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o")
public class Oferta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_OFERTA", unique = true, nullable = false)
	private int idOferta;

	@Column(name = "AHORO_OFERTA", nullable = false)
	private double ahoroOferta;

	@Column(name = "AHORO_OFERTA_US")
	private double ahoroOfertaUs;

	@Column(name = "DESCUETO_OFERTA", nullable = false)
	private int descuetoOferta;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_CREA")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_MODI")
	private Date fechaHoraModi;

	@Column(name = "NOMBRE_OFERTA", nullable = false, length = 50)
	private String nombreOferta;

	@Column(name = "PRECIO_OFERTA", nullable = false)
	private double precioOferta;

	@Column(name = "PRECIO_OFERTA_US", nullable = false)
	private double precioOfertaUs;

	@Column(name = "TIEMPO_OFERTA")
	private int tiempoOferta;

	@Column(name = "USR_CODIGO_CREA", nullable = false, length = 15)
	private String usrCodigoCrea;

	@Column(name = "USR_CODIGO_MODI", length = 15)
	private String usrCodigoModi;

	@Column(name = "VALOR_OFERTA", nullable = false)
	private double valorOferta;

	@Column(name = "VALOR_OFERTA_US")
	private double valorOfertaUs;
	
	@Column(name = "DETALLE_OFERTA")
	private String detalleOferta;

	// bi-directional many-to-one association to DetalleSolicitud
	@OneToMany(mappedBy = "oferta", cascade = { CascadeType.PERSIST },fetch=FetchType.EAGER)
	private List<DetalleSolicitud> detalleSolicituds;
	
	@OneToMany(mappedBy = "oferta", cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	private List<CarritoCompra> carritoCompras;

	// bi-directional many-to-one association to Foto
	@OneToMany(mappedBy = "oferta", cascade = { CascadeType.PERSIST }, fetch=FetchType.EAGER)
	private List<Foto> fotos;

	// bi-directional many-to-one association to Categoria
	@ManyToOne//(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "ID_CATEGORIA", nullable = false)
	private Categoria categoria;

	// bi-directional many-to-one association to Estado
	@ManyToOne//(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "ID_ESTADO", nullable = false)
	private Estado estado;
  
	public Oferta() {
	}

	public Oferta(int idOferta) {
		this.idOferta = idOferta;
	}
//Se agrego el detalle oferta 22/06/2014
	public Oferta(String nombreOferta, int tiempoOferta, float valorOferta,
			float valorOfertaUs, float precioOferta, float precioOfertaUs,
			float ahoroOferta, float ahoroOfertaUs, int descuetoOferta,
			Estado estado, Date fechaHoraCrea, String usrCodigoCrea,
			Date fechaHoraModi, String usrCodigoModi, Categoria categoria,String detalleOferta) {
		this.nombreOferta = nombreOferta;
		this.tiempoOferta = tiempoOferta;
		this.valorOferta = valorOferta;
		this.valorOfertaUs = valorOfertaUs;
		this.precioOferta = precioOferta;
		this.precioOfertaUs = precioOfertaUs;
		this.ahoroOferta = ahoroOferta;
		this.ahoroOfertaUs = ahoroOfertaUs;
		this.descuetoOferta = descuetoOferta;
		this.estado = estado;
		this.fechaHoraCrea = fechaHoraCrea;
		this.usrCodigoCrea = usrCodigoCrea;
		this.fechaHoraModi = fechaHoraModi;
		this.usrCodigoModi = usrCodigoModi;
		this.categoria = categoria;
		this.detalleOferta = detalleOferta;
	}

	public Oferta(String nombreOferta, int tiempoOferta, float valorOferta,
			float valorOfertaUs, float precioOferta, float precioOfertaUs,
			float ahoroOferta, float ahoroOfertaUs, int descuetoOferta,
			Estado estado, Categoria categoria, Date fechaHoraCrea,
			String usrCodigoCrea, Date fechaHoraModi, String usrCodigoModi) {
		this.nombreOferta = nombreOferta;
		this.tiempoOferta = tiempoOferta;
		this.valorOferta = valorOferta;
		this.valorOfertaUs = valorOfertaUs;
		this.precioOferta = precioOferta;
		this.precioOfertaUs = precioOfertaUs;
		this.ahoroOferta = ahoroOferta;
		this.ahoroOfertaUs = ahoroOfertaUs;
		this.descuetoOferta = descuetoOferta;
		this.estado = estado;
		this.categoria = categoria;
		this.fechaHoraCrea = fechaHoraCrea;
		this.usrCodigoCrea = usrCodigoCrea;
		this.fechaHoraModi = fechaHoraModi;
		this.usrCodigoModi = usrCodigoModi;
	}

	public int getIdOferta() {
		return this.idOferta;
	}

	public void setIdOferta(int idOferta) {
		this.idOferta = idOferta;
	}

	public double getAhoroOferta() {
		return this.ahoroOferta;
	}

	public void setAhoroOferta(float ahoroOferta) {
		this.ahoroOferta = ahoroOferta;
	}

	public double getAhoroOfertaUs() {
		return this.ahoroOfertaUs;
	}

	public void setAhoroOfertaUs(float ahoroOfertaUs) {
		this.ahoroOfertaUs = ahoroOfertaUs;
	}

	public int getDescuetoOferta() {
		return this.descuetoOferta;
	}

	public void setDescuetoOferta(int descuetoOferta) {
		this.descuetoOferta = descuetoOferta;
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

	public String getNombreOferta() {
		return this.nombreOferta;
	}

	public void setNombreOferta(String nombreOferta) {
		this.nombreOferta = nombreOferta;
	}

	public double getPrecioOferta() {
		return this.precioOferta;
	}

	public void setPrecioOferta(float precioOferta) {
		this.precioOferta = precioOferta;
	}

	public double getPrecioOfertaUs() {
		return this.precioOfertaUs;
	}

	public void setPrecioOfertaUs(float precioOfertaUs) {
		this.precioOfertaUs = precioOfertaUs;
	}

	public int getTiempoOferta() {
		return this.tiempoOferta;
	}

	public void setTiempoOferta(int tiempoOferta) {
		this.tiempoOferta = tiempoOferta;
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

	public double getValorOfertaUs() {
		return this.valorOfertaUs;
	}

	public void setValorOfertaUs(float valorOfertaUs) {
		this.valorOfertaUs = valorOfertaUs;
	}

	public List<DetalleSolicitud> getDetalleSolicituds() {
		return this.detalleSolicituds;
	}

	public void setDetalleSolicituds(List<DetalleSolicitud> detalleSolicituds) {
		this.detalleSolicituds = detalleSolicituds;
	}

	public DetalleSolicitud addDetalleSolicitud(
			DetalleSolicitud detalleSolicitud) {
		getDetalleSolicituds().add(detalleSolicitud);
		detalleSolicitud.setOferta(this);

		return detalleSolicitud;
	}

	public DetalleSolicitud removeDetalleSolicitud(
			DetalleSolicitud detalleSolicitud) {
		getDetalleSolicituds().remove(detalleSolicitud);
		detalleSolicitud.setOferta(null);

		return detalleSolicitud;
	}

	public List<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Foto addFoto(Foto foto) {
		getFotos().add(foto);
		foto.setOferta(this);

		return foto;
	}

	public Foto removeFoto(Foto foto) {
		getFotos().remove(foto);
		foto.setOferta(null);

		return foto;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(ahoroOferta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ahoroOfertaUs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((carritoCompras == null) ? 0 : carritoCompras.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + descuetoOferta;
		result = prime * result + ((detalleOferta == null) ? 0 : detalleOferta.hashCode());
		result = prime * result + ((detalleSolicituds == null) ? 0 : detalleSolicituds.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaHoraCrea == null) ? 0 : fechaHoraCrea.hashCode());
		result = prime * result + ((fechaHoraModi == null) ? 0 : fechaHoraModi.hashCode());
		result = prime * result + ((fotos == null) ? 0 : fotos.hashCode());
		result = prime * result + idOferta;
		result = prime * result + ((nombreOferta == null) ? 0 : nombreOferta.hashCode());
		temp = Double.doubleToLongBits(precioOferta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(precioOfertaUs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + tiempoOferta;
		result = prime * result + ((usrCodigoCrea == null) ? 0 : usrCodigoCrea.hashCode());
		result = prime * result + ((usrCodigoModi == null) ? 0 : usrCodigoModi.hashCode());
		temp = Double.doubleToLongBits(valorOferta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorOfertaUs);
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
		Oferta other = (Oferta) obj;
		if (Double.doubleToLongBits(ahoroOferta) != Double.doubleToLongBits(other.ahoroOferta))
			return false;
		if (Double.doubleToLongBits(ahoroOfertaUs) != Double.doubleToLongBits(other.ahoroOfertaUs))
			return false;
		if (carritoCompras == null) {
			if (other.carritoCompras != null)
				return false;
		} else if (!carritoCompras.equals(other.carritoCompras))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (descuetoOferta != other.descuetoOferta)
			return false;
		if (detalleOferta == null) {
			if (other.detalleOferta != null)
				return false;
		} else if (!detalleOferta.equals(other.detalleOferta))
			return false;
		if (detalleSolicituds == null) {
			if (other.detalleSolicituds != null)
				return false;
		} else if (!detalleSolicituds.equals(other.detalleSolicituds))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
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
		if (fotos == null) {
			if (other.fotos != null)
				return false;
		} else if (!fotos.equals(other.fotos))
			return false;
		if (idOferta != other.idOferta)
			return false;
		if (nombreOferta == null) {
			if (other.nombreOferta != null)
				return false;
		} else if (!nombreOferta.equals(other.nombreOferta))
			return false;
		if (Double.doubleToLongBits(precioOferta) != Double.doubleToLongBits(other.precioOferta))
			return false;
		if (Double.doubleToLongBits(precioOfertaUs) != Double.doubleToLongBits(other.precioOfertaUs))
			return false;
		if (tiempoOferta != other.tiempoOferta)
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
		if (Double.doubleToLongBits(valorOfertaUs) != Double.doubleToLongBits(other.valorOfertaUs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Oferta [idOferta=" + idOferta + ", ahoroOferta=" + ahoroOferta
				+ ", ahoroOfertaUs=" + ahoroOfertaUs + ", descuetoOferta="
				+ descuetoOferta + ", fechaHoraCrea=" + fechaHoraCrea
				+ ", fechaHoraModi=" + fechaHoraModi + ", nombreOferta="
				+ nombreOferta + ", precioOferta=" + precioOferta
				+ ", precioOfertaUs=" + precioOfertaUs + ", tiempoOferta="
				+ tiempoOferta + ", usrCodigoCrea=" + usrCodigoCrea
				+ ", usrCodigoModi=" + usrCodigoModi + ", valorOferta="
				+ valorOferta + ", valorOfertaUs=" + valorOfertaUs
				+ ", detalleSolicituds=" + detalleSolicituds + ", fotos="
				+ fotos + ", categoria=" + categoria + ", estado=" + estado
				+ "]";
	}

	public String getDetalleOferta() {
		return detalleOferta;
	}

	public void setDetalleOferta(String detalleOferta) {
		this.detalleOferta = detalleOferta;
	}

}