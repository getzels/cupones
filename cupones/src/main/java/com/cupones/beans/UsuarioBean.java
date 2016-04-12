package com.cupones.beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.cupones.domain.Usuario;
import com.cupones.servicio.UsuarioService;

@ManagedBean
@RequestScoped
public class UsuarioBean  {
 
	private String nombreUsuario;
	private String contrasena;
	
	@EJB
	private UsuarioService usuarioService;
	
	
	public UsuarioBean() {
	
	}
	
	@PostConstruct
	public void inicializar(){
		
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	public String loginUsuario(){
		//RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage mensaje = null;
	//	boolean loggedIn  = false;

		
		if (nombreUsuario != null && contrasena != null){
			Usuario usuario = new Usuario();
			usuario.setNombreUsuario(nombreUsuario);
			usuario.setContrasena(contrasena);
			
			if(usuarioService.validate(usuario)){
				//SessionBean.getSession().invalidate();				
				HttpSession session = SessionBean.getSession();			
				session.setAttribute("usuario", usuario);				
				
				if (session.getAttribute("usuario") != null){
				System.out.println(session.getAttribute("usuario").toString());	
				mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Welcome",nombreUsuario);
				FacesContext.getCurrentInstance().addMessage(null, mensaje);
				return "deals/cuponesdia?faces-redirect=true";
				
				}
				else{
					mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Inicio de seccion.","error " + nombreUsuario);
					FacesContext.getCurrentInstance().addMessage(null, mensaje);
				}
			}else{}
			// loggedIn = false;
			
			 mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Login error","Invalid credentials");
			 FacesContext.getCurrentInstance().addMessage(null, mensaje);
			 return "login";
		}else{
			//loggedIn = false;
			
			 mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Login error","User and password cannot be entyp");
			 FacesContext.getCurrentInstance().addMessage(null, mensaje);
			 return "login";
		}
		
		
		
		
	}
	
	
	
	

}
