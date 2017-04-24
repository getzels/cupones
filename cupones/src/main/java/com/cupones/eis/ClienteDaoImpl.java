package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.Cliente;

@Stateless
public class ClienteDaoImpl implements ClienteDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Cliente> findAllCliente() {
		return em.createNamedQuery("Cliente.findAll").getResultList();
	}

	public Cliente findClienteById(Cliente cliente) {
		return em.find(Cliente.class, cliente.getIdCliente());
	}

	public void addCliente(Cliente cliente) {
		em.persist(cliente);

	}

	public void updateCliente(Cliente cliente) {
		em.merge(cliente);

	}

	public void deleteCliente(Cliente cliente) {
		cliente = em.find(Cliente.class, cliente.getIdCliente());
		em.remove(cliente);
	}

	public Cliente findClienteByUser(String usuarioNombre) throws Exception {
		System.out.println("Inicio del metodo findClienteByUser");
		Query query = em.createQuery(
				"select c from Cliente c where c.idCliente = (select u.cliente.idCliente from Usuario u where u.nombreUsuario = :usuario)");

		query.setParameter("usuario", usuarioNombre);

		Cliente cliente = (Cliente) query.getSingleResult();

		if (cliente != null) {
			System.out.println(cliente);
			return (Cliente) query.getSingleResult();
		} else {
			System.out.println("No se encontro el cliente.");
			return null;
		}
	}

}
