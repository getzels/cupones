package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.Tarjeta;
import com.cupones.domain.Usuario;
@Stateless
public class TarjetaDaoImpl implements TarjetaDao {
	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarjeta> findAllTarjeta() {
		return em.createNamedQuery("Tarjeta.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarjeta> findTarjetaById(Usuario usuario) {
		Query query = em.createQuery("select l from Tarjeta l where l.id.idUsuario = :id");
		query.setParameter("id", usuario.getIdUsuario());
		return query.getResultList();
	}

	@Override
	public void addTarjeta(Tarjeta tarjeta) {
		em.persist(tarjeta);

	}

	@Override
	public void updateTarjeta(Tarjeta tarjeta) {
	em.merge(tarjeta);

	}

	@Override
	public void deleteTarjeta(Tarjeta tarjeta) {
		em.remove(tarjeta);

	}

}
