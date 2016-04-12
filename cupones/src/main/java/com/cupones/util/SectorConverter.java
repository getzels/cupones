package com.cupones.util;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cupones.domain.Sector;
import com.cupones.servicio.SectorService;

@ManagedBean
@FacesConverter("com.cupones.util.SectorConverter")
public class SectorConverter implements Converter {

	@EJB
	SectorService sectorService;

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {

		try {
			
			if (!value.isEmpty()) {
				System.out.println("Se esta buscando el sector "  + value);
				
				Sector sector = sectorService.findSectorById(new Sector(Integer.parseInt(value)));

				 System.out.println("****" + sector);
				if (sector != null) {
					System.out.println("Retorno un sector");
					return sector;
				}

			}

		} catch (Exception e) {
			Messageutil.mensajeError("Error convirtiendo el sector.");
		}
		System.out.println("Retorno nulo");
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object value) {

		if (value instanceof Sector) {
			return String.valueOf(((Sector) value).getIdSector());
		}
		System.out.println("Retorno nulo 2");
		return null;
	}
}