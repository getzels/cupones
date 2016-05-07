package com.cupones.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the libro_direcciones database table.
 * 
 */
@Entity
@Table(name="libro_direcciones")
@NamedQuery(name="LibroDireccione.findAll", query="SELECT l FROM LibroDireccione l")
public class LibroDireccione implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LibroDireccionePK id;

	@Column(name="CIUDAD")
	private String ciudad;

	@Column(name="CODIGO_POSTAL")
	private String codigoPostal;

	@Column(name="DIRECCION1")
	private String direccion1;

	@Column(name="DIRECCION2")
	private String direccion2;

	@Column(name="ID_ESTADO")
	private int idEstado;

	@Column(name="ID_PAIS")
	private int idPais;

	@Column(name="ID_PROVINCIA")
	private int idProvincia;

	@Column(name="ID_SECTOR")
	private int idSector;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="TELEFONO")
	private String telefono;

	public LibroDireccione() {
	}

	public LibroDireccionePK getId() {
		return this.id;
	}

	public void setId(LibroDireccionePK id) {
		this.id = id;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDireccion1() {
		return this.direccion1;
	}

	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}

	public String getDireccion2() {
		return this.direccion2;
	}

	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public int getIdPais() {
		return this.idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public int getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public int getIdSector() {
		return this.idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}