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
	
	
	@Override
	public List<Categoria> findAllCategoria() {
	return categoriaDao.findAllCategoria();	
	}

	@Override
	public Categoria findCategoriaById(Categoria categoria) {
		return categoriaDao.findCategoriaById(categoria);
	}

	
	@Override
	public Categoria findCategoriaByName(Categoria categoria){
		return categoriaDao.findCategoriaByName(categoria);
	}
	@Override
	public void addCategoria(Categoria categoria) {
		categoriaDao.addCategoria(categoria);

	}

	@Override
	public void updateCategoria(Categoria categoria) {
		categoriaDao.updateCategoria(categoria);

	}

	@Override
	public void deleteCategoria(Categoria categoria) {
		categoriaDao.deleteCategoria(categoria);
	}

}

