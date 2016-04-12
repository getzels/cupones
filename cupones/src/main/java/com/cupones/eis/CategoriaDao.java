package com.cupones.eis;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Categoria;
@Remote
public interface CategoriaDao {

	
	public List<Categoria> findAllCategoria();
	
	public Categoria findCategoriaById(Categoria categoria);
	
	public Categoria findCategoriaByName(Categoria categoria);
	
	public void addCategoria(Categoria categoria);
	
	public void updateCategoria(Categoria categoria);
	
	public void deleteCategoria(Categoria categoria);
}
