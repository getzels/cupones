package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name = "cliente")
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENTE", unique = true, nullable = false)
	private int idCliente;

	@Column(name = "CLT_DIRECCION1", nullable = false, length = 100)
	private String cltDireccion1;

	@Column(name = "CLT_DIRECCION2", length = 99)
	private String cltDireccion2;

	@Column(name = "CLT_EMAIL", length = 99)
	private String cltEmail;

	@Temporal(TemporalType.DATE)
	@Column(name = "CLT_FECHA_HORA_CREA", nullable = false)
	private Date cltFechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name = "CLT_FECHA_HORA_MODI")
	private Date cltFechaHoraModi;

	@Column(name = "CLT_RNC", nullable = false, length = 20)
	private String cltRnc;

	@Column(name = "CLT_TELEFONO1", length = 10)
	private String cltTelefono1;

	@Column(name = "CLT_TELEFONO2", length = 10)
	private String cltTelefono2;

	@Column(name = "NOMBRE_CLIENTE", nullable = false, length = 40)
	private String nombreCliente;

	@Column(name = "USR_CODIGO_CREA", nullable = false, length = 15)
	private String usrCodigoCrea;

	@Column(name = "USR_CODIGO_MODI", length = 15)
	private String usrCodigoModi;

	// bi-directional many-to-one association to Solicitud
	@OneToMany(mappedBy = "cliente",cascade = {CascadeType.PERSIST})
	private List<Solicitud> solicitudes;

	// bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy = "cliente")
	private List<Usuario> usuarios;

	public Cliente() {
	}

	public Cliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Cliente(String nombreCliente, String cltRnc, String cltDireccion1,
			String cltDireccion2, String cltEmail, String cltTelefono1,
			String cltTelefono2, Date cltFechaHoraCrea, String usrCodigoCrea,
			Date cltFechaHoraModi, String usrCodigoModi) {
		this.nombreCliente = nombreCliente;
		this.cltRnc = cltRnc;
		this.cltDireccion1 = cltDireccion1;
		this.cltDireccion2 = cltDireccion2;
		this.cltEmail = cltEmail;
		this.cltTelefono1 = cltTelefono1;
		this.cltTelefono2 = cltTelefono2;
		this.cltFechaHoraCrea = cltFechaHoraCrea;
		this.usrCodigoCrea = usrCodigoCrea;
		this.cltFechaHoraModi = cltFechaHoraModi;
		this.usrCodigoModi = usrCodigoModi;
		}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCltDireccion1() {
		return this.cltDireccion1;
	}

	public void setCltDireccion1(String cltDireccion1) {
		this.cltDireccion1 = cltDireccion1;
	}

	public String getCltDireccion2() {
		return this.cltDireccion2;
	}

	public void setCltDireccion2(String cltDireccion2) {
		this.cltDireccion2 = cltDireccion2;
	}

	public String getCltEmail() {
		return this.cltEmail;
	}

	public void setCltEmail(String cltEmail) {
		this.cltEmail = cltEmail;
	}

	public Date getCltFechaHoraCrea() {
		return this.cltFechaHoraCrea;
	}

	public void setCltFechaHoraCrea(Date cltFechaHoraCrea) {
		this.cltFechaHoraCrea = cltFechaHoraCrea;
	}

	public Date getCltFechaHoraModi() {
		return this.cltFechaHoraModi;
	}

	public void setCltFechaHoraModi(Date cltFechaHoraModi) {
		this.cltFechaHoraModi = cltFechaHoraModi;
	}

	public String getCltRnc() {
		return this.cltRnc;
	}

	public void setCltRnc(String cltRnc) {
		this.cltRnc = cltRnc;
	}

	public String getCltTelefono1() {
		return this.cltTelefono1;
	}

	public void setCltTelefono1(String cltTelefono1) {
		this.cltTelefono1 = cltTelefono1;
	}

	public String getCltTelefono2() {
		return this.cltTelefono2;
	}

	public void setCltTelefono2(String cltTelefono2) {
		this.cltTelefono2 = cltTelefono2;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
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

	public List<Solicitud> getSolicitudes() {
		return this.solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public Solicitud addSolicitude(Solicitud solicitude) {
		getSolicitudes().add(solicitude);
		solicitude.setCliente(this);

		return solicitude;
	}

	public Solicitud removeSolicitude(Solicitud solicitude) {
		getSolicitudes().remove(solicitude);
		solicitude.setCliente(null);

		return solicitude;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setCliente(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setCliente(null);

		return usuario;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", cltDireccion1=" + cltDireccion1 + ", cltDireccion2="
				+ cltDireccion2 + ", cltEmail=" + cltEmail + ", cltFechaHoraCrea=" + cltFechaHoraCrea
				+ ", cltFechaHoraModi=" + cltFechaHoraModi + ", cltRnc=" + cltRnc + ", cltTelefono1=" + cltTelefono1
				+ ", cltTelefono2=" + cltTelefono2 + ", nombreCliente=" + nombreCliente + ", usrCodigoCrea="
				+ usrCodigoCrea + ", usrCodigoModi=" + usrCodigoModi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cltDireccion1 == null) ? 0 : cltDireccion1.hashCode());
		result = prime * result + ((cltDireccion2 == null) ? 0 : cltDireccion2.hashCode());
		result = prime * result + ((cltEmail == null) ? 0 : cltEmail.hashCode());
		result = prime * result + ((cltFechaHoraCrea == null) ? 0 : cltFechaHoraCrea.hashCode());
		result = prime * result + ((cltFechaHoraModi == null) ? 0 : cltFechaHoraModi.hashCode());
		result = prime * result + ((cltRnc == null) ? 0 : cltRnc.hashCode());
		result = prime * result + ((cltTelefono1 == null) ? 0 : cltTelefono1.hashCode());
		result = prime * result + ((cltTelefono2 == null) ? 0 : cltTelefono2.hashCode());
		result = prime * result + idCliente;
		result = prime * result + ((nombreCliente == null) ? 0 : nombreCliente.hashCode());
		result = prime * result + ((usrCodigoCrea == null) ? 0 : usrCodigoCrea.hashCode());
		result = prime * result + ((usrCodigoModi == null) ? 0 : usrCodigoModi.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cltDireccion1 == null) {
			if (other.cltDireccion1 != null)
				return false;
		} else if (!cltDireccion1.equals(other.cltDireccion1))
			return false;
		if (cltDireccion2 == null) {
			if (other.cltDireccion2 != null)
				return false;
		} else if (!cltDireccion2.equals(other.cltDireccion2))
			return false;
		if (cltEmail == null) {
			if (other.cltEmail != null)
				return false;
		} else if (!cltEmail.equals(other.cltEmail))
			return false;
		if (cltFechaHoraCrea == null) {
			if (other.cltFechaHoraCrea != null)
				return false;
		} else if (!cltFechaHoraCrea.equals(other.cltFechaHoraCrea))
			return false;
		if (cltFechaHoraModi == null) {
			if (other.cltFechaHoraModi != null)
				return false;
		} else if (!cltFechaHoraModi.equals(other.cltFechaHoraModi))
			return false;
		if (cltRnc == null) {
			if (other.cltRnc != null)
				return false;
		} else if (!cltRnc.equals(other.cltRnc))
			return false;
		if (cltTelefono1 == null) {
			if (other.cltTelefono1 != null)
				return false;
		} else if (!cltTelefono1.equals(other.cltTelefono1))
			return false;
		if (cltTelefono2 == null) {
			if (other.cltTelefono2 != null)
				return false;
		} else if (!cltTelefono2.equals(other.cltTelefono2))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (nombreCliente == null) {
			if (other.nombreCliente != null)
				return false;
		} else if (!nombreCliente.equals(other.nombreCliente))
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

	

}