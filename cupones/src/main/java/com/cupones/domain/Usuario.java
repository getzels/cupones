package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name = "usuario")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO", unique = true, nullable = false)
	private int idUsuario;

	@Column(length = 40)
	private String calle;

	@Column(nullable = false, length = 200)
	private String contrasena;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_CREA", nullable = false)
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_MODI")
	private Date fechaHoraModi;

	@Column(name = "NOMBRE_USUARIO", nullable = false, length = 15)
	private String nombreUsuario;

	@Column(name = "NUMERO_CASO_LOCAL")
	private Integer numeroCasoLocal;

	@Column(name = "PREGUNTA_SECRETA", length = 40)
	private String preguntaSecreta;

	@Column(name = "RESPUESTA_PREGUNTA", length = 88)
	private String respuestaPregunta;

	@Column(name = "USR_CODIGO_CREA", nullable = false, length = 15)
	private String usrCodigoCrea;

	@Column(name = "USR_CODIGO_MODI", length = 15)
	private String usrCodigoModi;

	// bi-directional many-to-one association to Role
	@OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST})
	private List<Role> roles;

	// bi-directional many-to-one association to Cliente
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "ID_CLIENTE", nullable = false)
	private Cliente cliente;

	// bi-directional many-to-one association to Sector
	@ManyToOne()
	@JoinColumn(name = "ID_SECTOR", nullable = false)
	private Sector sector;

	public Usuario() {
	}

	public Usuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario(String nombreUsuario, String contrasena, String calle,
			int numeroCasoLocal, Sector sector, String preguntaSecreta,
			String respuestaPregunta, Date fechaHoraCrea, String usrCodigoCrea,
			Date fechaHoraModi, String usrCodigoModi) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.calle = calle;
//		this.numeroCasoLocal = numeroCasoLocal;
		this.sector = sector;
		this.preguntaSecreta = preguntaSecreta;
		this.respuestaPregunta = respuestaPregunta;
		this.fechaHoraCrea = fechaHoraCrea;
		this.fechaHoraModi = fechaHoraModi;
		this.usrCodigoCrea = usrCodigoCrea;
		this.usrCodigoModi = usrCodigoModi;
	}
	
	public Usuario(String nombreUsuario, String contrasena, String calle,
			int numeroCasoLocal, Sector sector, String preguntaSecreta,
			String respuestaPregunta, Date fechaHoraCrea, String usrCodigoCrea,
			Date fechaHoraModi, String usrCodigoModi,Cliente cliente) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.calle = calle;
	//	this.numeroCasoLocal = numeroCasoLocal;
		this.sector = sector;
		this.preguntaSecreta = preguntaSecreta;
		this.respuestaPregunta = respuestaPregunta;
		this.fechaHoraCrea = fechaHoraCrea;
		this.fechaHoraModi = fechaHoraModi;
		this.usrCodigoCrea = usrCodigoCrea;
		this.usrCodigoModi = usrCodigoModi;
		this.cliente = cliente;
	}

	public Usuario(String usuario) {
		// TODO Auto-generated constructor stub
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public int getNumeroCasoLocal() {
		return this.numeroCasoLocal;
	}

	public void setNumeroCasoLocal(int numeroCasoLocal) {
		this.numeroCasoLocal = numeroCasoLocal;
	}

	public String getPreguntaSecreta() {
		return this.preguntaSecreta;
	}

	public void setPreguntaSecreta(String preguntaSecreta) {
		this.preguntaSecreta = preguntaSecreta;
	}

	public String getRespuestaPregunta() {
		return this.respuestaPregunta;
	}

	public void setRespuestaPregunta(String respuestaPregunta) {
		this.respuestaPregunta = respuestaPregunta;
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

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setUsuario(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setUsuario(null);

		return role;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Sector getSector() {
		return this.sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", calle=" + calle + ", contrasena=" + contrasena
				+ ", fechaHoraCrea=" + fechaHoraCrea + ", fechaHoraModi=" + fechaHoraModi + ", nombreUsuario="
				+ nombreUsuario + ", numeroCasoLocal=" + numeroCasoLocal + ", preguntaSecreta=" + preguntaSecreta
				+ ", respuestaPregunta=" + respuestaPregunta + ", usrCodigoCrea=" + usrCodigoCrea + ", usrCodigoModi="
				+ usrCodigoModi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((contrasena == null) ? 0 : contrasena.hashCode());
		result = prime * result + ((fechaHoraCrea == null) ? 0 : fechaHoraCrea.hashCode());
		result = prime * result + ((fechaHoraModi == null) ? 0 : fechaHoraModi.hashCode());
		result = prime * result + idUsuario;
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		result = prime * result + ((numeroCasoLocal == null) ? 0 : numeroCasoLocal.hashCode());
		result = prime * result + ((preguntaSecreta == null) ? 0 : preguntaSecreta.hashCode());
		result = prime * result + ((respuestaPregunta == null) ? 0 : respuestaPregunta.hashCode());
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
		Usuario other = (Usuario) obj;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (contrasena == null) {
			if (other.contrasena != null)
				return false;
		} else if (!contrasena.equals(other.contrasena))
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
		if (idUsuario != other.idUsuario)
			return false;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		if (numeroCasoLocal == null) {
			if (other.numeroCasoLocal != null)
				return false;
		} else if (!numeroCasoLocal.equals(other.numeroCasoLocal))
			return false;
		if (preguntaSecreta == null) {
			if (other.preguntaSecreta != null)
				return false;
		} else if (!preguntaSecreta.equals(other.preguntaSecreta))
			return false;
		if (respuestaPregunta == null) {
			if (other.respuestaPregunta != null)
				return false;
		} else if (!respuestaPregunta.equals(other.respuestaPregunta))
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