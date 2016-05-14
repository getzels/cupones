package com.cupones.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.cupones.domain.LibroDireccione;
import com.cupones.domain.Usuario;
import com.cupones.servicio.LibroDireccioneService;

@ManagedBean
@RequestScoped
public class LibroDireccioneBean {

	@EJB
	private LibroDireccioneService libroDireccioneService; 
	
	
	
	@SuppressWarnings("unused")
	private List<LibroDireccione> libroDirecciones;	
	private Usuario usuario;
	
	@PostConstruct
	public void init(){
	usuario = SessionBean.getUsurioSession();
	libroDirecciones = libroDireccioneService.findLibroDireccioneById(usuario);
	}
	
	
	
	
	
}
