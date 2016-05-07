 package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.Cliente;
import com.cupones.domain.CarritoCompra;
import com.cupones.domain.CarritoCompraPK;

@Stateless
public class CarritoCompraDaoImp implements CarritoCompraDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<CarritoCompra> findAllCarritoCompra() {
		return em.createNamedQuery("CarritoCompra.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarritoCompra> findDatosCarritoById(Cliente cliente) {
		
		List<CarritoCompra> carritoCompras;
		
		Query query = em.createQuery(
				"SELECT c FROM CarritoCompra c where c.id.idCliente = :idCliente");
        
		query.setParameter("idCliente", cliente.getIdCliente());
		//query.setParameter(":idOferta", cli)
		carritoCompras = query.getResultList();
		
		return carritoCompras;
	}

	@Override
	public void addCarritoCompra(CarritoCompra carritoCompra) {
		em.persist(carritoCompra);
	}

	@Override
	public void updateCarritoCompra(CarritoCompra carritoCompra) {
		em.merge(carritoCompra);

	}

	@Override
	public void deleteCarritoCompra(CarritoCompra carritoCompra) {
		System.out.println("Se inicio el medoto deleteCarritoCompra de CarritoComprasDaoImp");
		System.out.println(carritoCompra);
		CarritoCompraPK carritoCompraPK = new CarritoCompraPK(carritoCompra.getId().getIdCliente(),carritoCompra.getId().getIdOferta());
		System.out.println("Primary Key" + carritoCompraPK);
		CarritoCompra carritoCompra1 = em.find(CarritoCompra.class,carritoCompraPK);
		System.out.println("Objecto 2 " + carritoCompra1);
		em.remove(em.merge(carritoCompra1));
		System.out.println("Removido!!!!!");
	}

}
