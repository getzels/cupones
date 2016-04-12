package com.cupones.servicio;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import com.cupones.domain.Estado;

@Remote
public interface EstadoService {

	
	public List<Estado> findAllEstado();
	
	public Map<String, Integer> findAllEstado2();
	
	public Estado findEstadoById(Estado estado);
	
	public Estado findEstadoByName(Estado estado);
	
	public void addEstado(Estado estado);
	
	public void updateEstado(Estado estado);
	
	public void deleteEstado(Estado estado);

}
