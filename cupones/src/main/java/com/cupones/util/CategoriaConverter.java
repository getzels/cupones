package com.cupones.util;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cupones.domain.Categoria;
import com.cupones.servicio.CategoriaService;

@ManagedBean
@FacesConverter("com.cupones.util.CategoriaConverter")
public class CategoriaConverter implements Converter {

	@EJB
	CategoriaService categoriaService;

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {

		try {
			
			if (!value.isEmpty()) {
				System.out.println("Se esta buscando la categoria "  + value);
				
				Categoria categotia = categoriaService.findCategoriaById(new Categoria(Integer.parseInt(value)));

				 System.out.println("****" + categotia);
				if (categotia != null) {
					System.out.println("Retorno una categoria");
					return categotia;
				}

			}

		} catch (Exception e) {
			Messageutil.mensajeError("Error convirtiendo el estado.");
		}
		System.out.println("Retorno nulo");
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object value) {

		if (value instanceof Categoria) {
			return String.valueOf(((Categoria) value).getIdCategoria());
		}
		System.out.println("Retorno nulo 2");
		return null;
	}
}