package com.cupones.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Messageutil {
	
	private static FacesMessage facesMessage = null;
	
	
	public static void mensajeError(String mensaje){
		facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, mensaje);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);					
	}
	
	public static void mensajeInfo(String mensaje){
		facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, mensaje);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);	
		System.out.println(mensaje);
	}
	
	public static void mensajeFatal(String mensaje){
		facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL, mensaje, mensaje);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);					
	}
	
	public static void mensajeCuidado(String mensaje){
		facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje, mensaje);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);					
	}

}
