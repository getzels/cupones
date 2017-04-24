package com.cupones.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cupones.domain.Usuario;

@ManagedBean
@RequestScoped
public class SessionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(SessionBean.class);
	private Usuario usuario;

	public SessionBean() {
		/*
		 * this.usuario = SessionBean.getUsuario(); logger.debug(
		 * "Constructor SessionBean(1)"); if (this.usuario != null) {
		 * logger.debug("Se instacion el objecto usuario " + usuario); }
		 * else { logger.debug("No se inicio el objecto en el costructor."
		 * ); }
		 */
	}

	@PostConstruct
	public void init() {
		this.usuario = getUsurioSession();
		logger.debug("Se ejecuto el metodo init SessionBean " + this.usuario);
	}

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public static Usuario getUsurioSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		logger.debug("Se obtuvo el usuario " + session.getAttribute("usuario"));
		return (Usuario) session.getAttribute("usuario");
	}

	public String logout() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		if (session != null) {
			session.invalidate(); // Cierre de sesion
		}
		return "login";// indicas a donde quieres direccionar después de cerrar
						// sesión
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
