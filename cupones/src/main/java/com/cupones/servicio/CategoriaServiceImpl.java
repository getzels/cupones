package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.cupones.domain.Categoria;
import com.cupones.eis.CategoriaDao;

@Stateless
public class CategoriaServiceImpl implements CategoriaService {

    @EJB
    CategoriaDao categoriaDao;
	
	
	
	public List<Categoria> findAllCategoria() {
	return categoriaDao.findAllCategoria();	
	}

	
	public Categoria findCategoriaById(Categoria categoria) {
		return categoriaDao.findCategoriaById(categoria);
	}

	
	
	public Categoria findCategoriaByName(Categoria categoria){
		return categoriaDao.findCategoriaByName(categoria);
	}
	
	public void addCategoria(Categoria categoria) {
		categoriaDao.addCategoria(categoria);

	}

	
	public void updateCategoria(Categoria categoria) {
		categoriaDao.updateCategoria(categoria);

	}

	
	public void deleteCategoria(Categoria categoria) {
		categoriaDao.deleteCategoria(categoria);
	}

}

