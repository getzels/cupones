package com.cupones.servicio;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Cliente;

@Remote
public interface ClienteService {

	
	public List<Cliente> findAllCliente();
	
	public Cliente findClienteById(Cliente cliente);
	
	public Cliente findClienteByUser(String usuarioNombre) throws Exception;
	
	public void addCliente(Cliente cliente);
	
	public void updateCliente(Cliente cliente);
	
	public void deleteCliente(Cliente cliente);
}
