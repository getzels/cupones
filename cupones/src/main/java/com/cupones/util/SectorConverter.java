package com.cupones.util;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cupones.domain.Sector;
import com.cupones.servicio.SectorService;

@ManagedBean
@FacesConverter("com.cupones.util.SectorConverter")
public class SectorConverter implements Converter {
	
	private static final Logger logger = LogManager.getLogger(SectorConverter.class);

	@EJB
	private SectorService sectorService;

	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {
		logger.trace("getAsObject", facesContext, component, value);
		try {
			
			if (!value.isEmpty()) {
				logger.debug("Se esta buscando el sector "  + value);
				
				Sector sector = sectorService.findSectorById(new Sector(Integer.parseInt(value)));

				 logger.debug("****" + sector);
				if (sector != null) {
					logger.debug("Retorno un sector");
					return sector;
				}
			}

		} catch (Exception e) {
			logger.error("Error convirtiendo el sector. ", e);
			Messageutil.mensajeError("Error convirtiendo el sector.");
		}finally{
			logger.traceExit();
		}
		return value;
	}

	public String getAsString(FacesContext facesContext, UIComponent component,
			Object value) {

		if (value instanceof Sector) {
			return String.valueOf(((Sector) value).getIdSector());
		}
		logger.debug("Retorno nulo 2");
		return null;
	}
}