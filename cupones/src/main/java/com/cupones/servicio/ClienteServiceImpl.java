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

	
	@Override
	public List<Cliente> findAllCliente() {
		return clienteDao.findAllCliente();
	}

	@Override
	public Cliente findClienteById(Cliente cliente) {
		return clienteDao.findClienteById(cliente);
	}

	@Override
	public void addCliente(Cliente cliente) {
		cliente.setCltFechaHoraCrea(new Date());
		clienteDao.addCliente(cliente);
	}

	@Override
	public void updateCliente(Cliente cliente) {
		cliente.setCltFechaHoraModi(new Date());
		clienteDao.updateCliente(cliente);

	}

	@Override
	public void deleteCliente(Cliente cliente) {
		clienteDao.deleteCliente(cliente);
	}

	@Override
	public Cliente findClienteByUser(String usuarioNombre) throws Exception {
		System.out.println("Se inicio el medoto findClienteByUser de la clase ClienteServiceImpl.");
		return clienteDao.findClienteByUser(usuarioNombre);
	}

}

