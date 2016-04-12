package com.cupones.beans;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import com.cupones.domain.Cliente;
import com.cupones.domain.Sector;
import com.cupones.domain.Usuario;
import com.cupones.servicio.ClienteService;
import com.cupones.servicio.SectorService;
import com.cupones.servicio.UsuarioService;
import com.cupones.util.Messageutil;

@ManagedBean
@RequestScoped
public class ClienteBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private Usuario usuario;
	private List<Sector> sectores;
	

	@EJB
	private ClienteService clienteService;
	@EJB
	private UsuarioService usuarioService;
	@EJB
	private SectorService sectorService;

	

	public ClienteBean() {
		cliente = new Cliente();
		usuario = new Usuario();
	}

	@PostConstruct
	public void init() {
		try {
			//setSectores(sectorService.findAllSector());
			sectores = sectorService.findAllSector();
			if (SessionBean.getUsurioSession() != null) {
				cliente = clienteService.findClienteByUser(SessionBean.getUsurioSession().getNombreUsuario());
				usuario = SessionBean.getUsurioSession();
				if (usuario == null){
					usuario = new Usuario();
				}
			}
		} catch (Exception e) {
			Messageutil.mensajeError(e.getMessage());
			e.printStackTrace();
		}
	}

	public String addUpdateCliente() {
		System.out.println("Inicio de metodo addUpdateaCliente");
		try {
			if (SessionBean.getUsurioSession() != null) {
				clienteService.updateCliente(this.cliente);
				Messageutil.mensajeInfo("Se actualizo de manera exitosa los datos personales.");
				return "cuponesdia" + "faces-redirect=true";

			} else {
				this.usuario.setSector(sectorService.findSectorById(new Sector(1)));
				this.cliente.setCltFechaHoraCrea(new Date());
				this.cliente.setUsrCodigoCrea(usuario.getNombreUsuario());
				this.usuario.setFechaHoraCrea(new Date());
				this.usuario.setCliente(cliente);
				this.usuario.setUsrCodigoCrea(usuario.getNombreUsuario());
				
				System.out.println("Estatus del cliente " + cliente);
			
				usuarioService.addUser(usuario);	
				Messageutil.mensajeInfo("Se actualizo de manera exitosa los datos personales.");
				
				return "/deals/cuponesdia" + "?faces-redirect=true";
			}
		} catch (Exception e) {
			Messageutil.mensajeError(e.getMessage());
			e.printStackTrace();
		}
		return "error";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}

}
