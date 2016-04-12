package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.Pais;
import com.cupones.domain.Provincia;


@Stateless
public class ProvinciaDaoImpl implements ProvinciaDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> findALLProvincia() {
		return em.createNamedQuery("Provincia.findAll").getResultList();
	}

	@Override
	public Provincia findProvinciaById(Provincia provincia) {
		return em.find(Provincia.class, provincia.getIdProvincia());
	}

	@Override
	public void addProvincia(Provincia provincia) {
	    em.persist(provincia);
	}

	@Override
	public void updateProvincia(Provincia provincia) {
       em.merge(provincia);
	}

	@Override
	public void deleteProvincia(Provincia provincia) {
      provincia = em.find(Provincia.class, provincia.getIdProvincia());
      em.remove(provincia);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> findProvinciaByPais(Pais pais) {
		Query query = em.createQuery("select p from Provincia p where p.pais.idPais = :idPais");
		query.setParameter("idPais", pais.getIdPais());
		
		return query.getResultList();
	}

}
