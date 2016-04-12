package com.cupones.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_CREA")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_MODI")
	private Date fechaHoraModi;

	@Column(name="ROLE_NOMBRE", length=20)
	private String roleNombre;

	@Column(name="USR_CODIGO_CREA", length=15)
	private String usrCodigoCrea;

	@Column(name="USR_CODIGO_MODI", length=15)
	private String usrCodigoModi;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="ID_USUARIO", nullable=false, insertable=false, updatable=false)
	private Usuario usuario;

	public Role() {
	}

	public RolePK getId() {
		return this.id;
	}

	public void setId(RolePK id) {
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

	public String getRoleNombre() {
		return this.roleNombre;
	}

	public void setRoleNombre(String roleNombre) {
		this.roleNombre = roleNombre;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}