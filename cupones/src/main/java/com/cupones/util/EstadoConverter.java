package com.cupones.util;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cupones.domain.Estado;
import com.cupones.servicio.EstadoService;

@ManagedBean
@FacesConverter("com.cupones.util.EstadoConverter")
public class EstadoConverter implements Converter {

	private static final Logger logger = LogManager.getLogger(EstadoConverter.class);

	@EJB
	private EstadoService estadoService;

	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {

		try {

			if (!value.isEmpty()) {
				logger.debug("Se esta buscando el estado con el id " + value);

				Estado estado = estadoService.findEstadoById(new Estado(Integer.parseInt(value)));

				logger.debug("estado " + estado);

				if (estado != null) {
					logger.debug("Retorno un estado s" + estado);
					return estado;
				}

			}
		} catch (Exception e) {
			Messageutil.mensajeError("Error convirtiendo el estado. " + e.getMessage());
			logger.error("Error convirtiendo el estado. ", e);
		} finally {
			logger.traceExit();
		}
		logger.debug("Retorno nulo");
		return null;
	}

	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {

		if (value instanceof Estado) {
			return String.valueOf(((Estado) value).getIdEstado());
		}
		logger.debug("Retorno nulo 2");
		return null;
	}
}