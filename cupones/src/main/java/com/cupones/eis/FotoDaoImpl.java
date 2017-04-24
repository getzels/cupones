package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.Foto;

@Stateless
public class FotoDaoImpl implements FotoDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Foto> findAllFoto() {
		return em.createNamedQuery("Foto.findAll").getResultList();
	}

	public List<Foto> findFotoById(Foto foto) {
		Query query = em.createQuery("select f from Foto f where f.id.idFotos = :id");
		query.setParameter("id", foto.getId().getIdFotos());
		@SuppressWarnings("unchecked")
		List<Foto> fotos = query.getResultList();
		fotos.size();
		return fotos;
	}

	public Foto findFotoByIdAndName(Foto foto) {
		Query query = em
				.createQuery("select p from Foto p where p.id = :id and p.descripcion = :desc");
		query.setParameter("id", foto.getId());
		query.setParameter("desc", foto.getDescripcion());

		return (Foto) query.getSingleResult();
	}

	public void addFoto(Foto foto) {
		em.persist(foto);

	}

	public void updateFoto(Foto foto) {
		em.merge(foto);

	}

	public void deleteFoto(Foto foto) {
		foto = em.find(Foto.class, foto.getId());
		em.remove(foto);
	}

}
