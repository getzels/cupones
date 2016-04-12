package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.Categoria;

@Stateless
public class CategoriaDaoImpl implements CategoriaDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findAllCategoria() {
		List<Categoria> categorias = em.createNamedQuery("Categoria.findAll").getResultList();
		categorias.size();
		return categorias;
	}

	@Override
	public Categoria findCategoriaById(Categoria categoria) {
		Query query = em.createQuery("select c from Categoria c where c.idCategoria = :id" );
		//Pasamos los parametros al objeto query.
		query.setParameter("id",categoria.getIdCategoria());
		Categoria categoriaReturn = (Categoria) query.getSingleResult();
		categoriaReturn.getOfertas().size();

		return categoriaReturn;
	}
	
	@Override
	public Categoria findCategoriaByName(Categoria categoria){
		Query query = em.createQuery("select c from Categoria c where c.nombreCategoria like :desc");
		
		query.setParameter("desc", categoria.getDescripcionCategoria().toUpperCase());
		
		Categoria categoriaReturn = (Categoria) query.getSingleResult();
		
		categoriaReturn.getOfertas().size();
		
		return categoriaReturn;
		
		
	}

	@Override
	public void addCategoria(Categoria categoria) {
		em.persist(categoria);

	}

	@Override
	public void updateCategoria(Categoria categoria) {
		em.merge(categoria);

	}

	@Override
	public void deleteCategoria(Categoria categoria) {
		categoria = this.findCategoriaById(categoria);
		em.remove(categoria);
	}

}

