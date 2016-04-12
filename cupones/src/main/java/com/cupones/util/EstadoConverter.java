package com.cupones.util;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cupones.domain.Estado;
import com.cupones.servicio.EstadoService;

@ManagedBean
@FacesConverter("com.cupones.util.EstadoConverter")
public class EstadoConverter implements Converter {

	@EJB
	EstadoService estadoService; 


	@Override 
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {

		try {
           
			if (!value.isEmpty()) {
             System.out.println("Se esta buscando el estado con el id " + value);
			
             Estado estado = estadoService.findEstadoById(new Estado(Integer.parseInt(value)));
             
            // System.out.println("****" + estado);

				if (estado != null) {
					//System.out.println("Retorno un estado" + estado);
					return estado;
				}else{
					System.out.println("El estado esta nulo");
				}

			}

		} catch (Exception e) {
			Messageutil.mensajeError("Error convirtiendo el estado. " + e.getMessage());
			e.printStackTrace();
			System.out.println(e.getStackTrace());
		}
		System.out.println("Retorno nulo");
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object value) {

		if (value instanceof Estado) {
			return String.valueOf(((Estado) value).getIdEstado());
		}
		System.out.println("Retorno nulo 2");
		return null;
	}
}