package com.cupones.beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cupones.domain.Usuario;
import com.cupones.excepciones.InternalServicesException;
import com.cupones.servicio.OfertaServiceImpl;
import com.cupones.servicio.UsuarioService;
import com.cupones.util.Constantes;

@ManagedBean
@RequestScoped
public class UsuarioBean  {
 
	private static final Logger logger = LogManager.getLogger(OfertaServiceImpl.class);
	
	

	private String nombreUsuario;
	private String contrasena;
	
	@EJB
	private UsuarioService usuarioService;
	
	public UsuarioBean() {
		//Constructor por defecto.
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
		FacesMessage mensaje;
		
		if (nombreUsuario != null && contrasena != null){
			Usuario usuario = new Usuario();
			usuario.setNombreUsuario(nombreUsuario);
			usuario.setContrasena(contrasena);
			
			try {
				if(usuarioService.validate(usuario)){
					HttpSession session = SessionBean.getSession();			
					session.setAttribute(Constantes.USER_LABEL, usuario);				
					
					if (session.getAttribute(Constantes.USER_LABEL) != null){
						logger.debug(session.getAttribute("usuario").toString());	
					mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Welcome",nombreUsuario);
					FacesContext.getCurrentInstance().addMessage(null, mensaje);
					return "deals/cuponesdia?faces-redirect=true";
					
					}
					else{
						mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Inicio de seccion.","error " + nombreUsuario);
						FacesContext.getCurrentInstance().addMessage(null, mensaje);
					}
				}
			} catch (InternalServicesException e) {
				logger.trace("Error validando usuario " + e);
				mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Inicio de seccion.","error " + nombreUsuario);
			}
			 mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Login error","Invalid credentials");
			 FacesContext.getCurrentInstance().addMessage(null, mensaje);
			 return "login";
		}else{
			 mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Login error","User and password cannot be entyp");
			 FacesContext.getCurrentInstance().addMessage(null, mensaje);
			 return "login";
		}
		
		
		
		
	}
	
	
	
	

}
