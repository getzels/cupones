package com.cupones.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the sector database table.
 * 
 */
@Entity
@Table(name = "sector")
@NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s")
public class Sector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SECTOR", unique = true, nullable = false)
	private int idSector;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_CREA")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_MODI")
	private Date fechaHoraModi;

	@Column(name = "SECTOR_DESCRIPCION", nullable = false, length = 40)
	private String sectorDescripcion;

	@Column(name = "USR_CODIGO_CREA", length = 20)
	private String usrCodigoCrea;

	@Column(name = "USR_CODIGO_MODI", length = 15)
	private String usrCodigoModi;

	// bi-directional many-to-one association to Provincia
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "ID_PROVINCIA", nullable = false)
	private Provincia provincia;

	// bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy = "sector",cascade = {CascadeType.PERSIST})
	private List<Usuario> usuarios;

	public Sector() {
	}

	public Sector(int idSector) {
		this.idSector = idSector;
	}

	public Sector(String sectorDescripcion, Date fechaHoraCrea,
			String usrCodigoCrea, Date fechaHoraModi, String usrCodigoModi,
			Provincia provincia) {
		this.sectorDescripcion = sectorDescripcion;
		this.fechaHoraCrea = fechaHoraCrea;
		this.usrCodigoCrea = usrCodigoCrea;
		this.fechaHoraModi = fechaHoraModi;
		this.usrCodigoModi = usrCodigoModi;
		this.provincia = provincia;
	}

	public int getIdSector() {
		return this.idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
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

	public String getSectorDescripcion() {
		return this.sectorDescripcion;
	}

	public void setSectorDescripcion(String sectorDescripcion) {
		this.sectorDescripcion = sectorDescripcion;
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

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setSector(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setSector(null);

		return usuario;
	}

}