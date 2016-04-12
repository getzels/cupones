package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.Foto;
import com.cupones.domain.Oferta;

@Stateless
public class OfertaDaoImpl implements OfertaDao {

	@PersistenceContext(unitName = "CuponesPU")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Oferta> findAllOferta() {
		return em.createNamedQuery("Oferta.findAll").getResultList();
	}

	@Override
	public Oferta findOfertaById(Oferta oferta) {
		try{
		Query query = em
				.createQuery("select o from Oferta o where o.idOferta = :id");
       System.out.println(oferta.getIdOferta());
		query.setParameter("id", oferta.getIdOferta());
		System.out.println("se ejecuto el query");
		
		Oferta ofertaReturn = (Oferta) query.getSingleResult();
		
//		oferta.getFotos().size();
		
		return ofertaReturn;
		}catch (Exception e){
			System.out.println("Error consultado la oferta" + e.getMessage());
		}

		 return new Oferta(1);
	}
  
	@Override
	public void addOferta(Oferta oferta) {
		// System.out.println("**************addOferta**************");

		em.persist(oferta);

		// System.out.println("***********Persistio exitosamente*************");
	}

	@Override
	public void updateOferta(Oferta oferta) {
		em.merge(oferta);

	}

	@Override
	public void deleteOferta(Oferta oferta) {
		oferta = em.find(Oferta.class, oferta.getIdOferta());
		em.remove(oferta);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Foto> findFotosOferta(Oferta oferta) {
		String consulta = "select f from Oferta o, Foto f where o.idOferta = :id and o.idOferta = f.oferta.idOferta";
		
		Query query = em.createQuery(consulta);
		query.setParameter("id", oferta.getIdOferta());
		
		return query.getResultList();
	}

}
