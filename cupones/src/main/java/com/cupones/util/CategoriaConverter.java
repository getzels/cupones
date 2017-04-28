package com.cupones.util;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cupones.domain.Categoria;
import com.cupones.servicio.CategoriaService;

@ManagedBean
@FacesConverter("com.cupones.util.CategoriaConverter")
public class CategoriaConverter implements Converter {

	private static final Logger logger = LogManager.getLogger(SectorConverter.class);
	
	@EJB
	private CategoriaService categoriaService;

	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {
		
		logger.trace("getAsObject in CategoriaConverter");

		try {
			
			if (!value.isEmpty()) {
				logger.debug("Se esta buscando la categoria "  + value);
				
				Categoria categotia = categoriaService.findCategoriaById(new Categoria(Integer.parseInt(value)));

				 logger.debug("****" + categotia);
				if (categotia != null) {
					logger.debug("Retorno una categoria");
					return categotia;
				}

			}

		} catch (Exception e) {
			logger.error("Error convirtiendo la categoria. ", e);
			Messageutil.mensajeError("Error convirtiendo la categoria.");
		}finally{
			logger.traceExit();
		}
		logger.debug("Retorno nulo");
		return null;
	}
	
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object value) {

		if (value instanceof Categoria) {
			return String.valueOf(((Categoria) value).getIdCategoria());
		}
		logger.debug("Retorno nulo 2");
		return null;
	}
}