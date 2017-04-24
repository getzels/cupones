package com.cupones.servicio;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.cupones.domain.Cliente;
import com.cupones.eis.ClienteDao;

@Stateless
public class ClienteServiceImpl implements ClienteService {

	@EJB
	ClienteDao clienteDao;

	
	
	public List<Cliente> findAllCliente() {
		return clienteDao.findAllCliente();
	}

	
	public Cliente findClienteById(Cliente cliente) {
		return clienteDao.findClienteById(cliente);
	}

	
	public void addCliente(Cliente cliente) {
		cliente.setCltFechaHoraCrea(new Date());
		clienteDao.addCliente(cliente);
	}

	
	public void updateCliente(Cliente cliente) {
		cliente.setCltFechaHoraModi(new Date());
		clienteDao.updateCliente(cliente);

	}

	
	public void deleteCliente(Cliente cliente) {
		clienteDao.deleteCliente(cliente);
	}

	
	public Cliente findClienteByUser(String usuarioNombre) throws Exception {
		System.out.println("Se inicio el medoto findClienteByUser de la clase ClienteServiceImpl.");
		return clienteDao.findClienteByUser(usuarioNombre);
	}

}

