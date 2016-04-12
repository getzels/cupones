package com.cupones.eis;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Estado;
@Remote
public interface EstadoDao {

	
	public List<Estado> findAllEstado();
	
	public Estado findEstadoById(Estado estado);
	
	public Estado findEstadoByName(Estado estado);
	
	public void addEstado(Estado estado);
	
	public void updateEstado(Estado estado);
	
	public void deleteEstado(Estado estado);
}
