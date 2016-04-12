package com.cupones.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.cupones.domain.Estado;
import com.cupones.eis.EstadoDao;

@Stateless
public class EstadoServiceImpl implements EstadoService {

	@EJB
	EstadoDao estadoDao;

	@Override
	public List<Estado> findAllEstado() {
		return estadoDao.findAllEstado();
	}

	@Override
	public Map<String, Integer> findAllEstado2() {
		Map<String, Integer> estados = new HashMap<String, Integer>();

		List<Estado> estados1 = this.findAllEstado();

		for (Estado estado : estados1) {
			estados.put(estado.getEstadoDescripcion(), estado.getIdEstado());
		}

		return estados;
	}

	@Override
	public Estado findEstadoById(Estado estado) {
		return estadoDao.findEstadoById(estado);
	}

	@Override
	public Estado findEstadoByName(Estado estado) {
		return estadoDao.findEstadoByName(estado);
	}

	@Override
	public void addEstado(Estado estado) {
		estadoDao.addEstado(estado);

	}

	@Override
	public void updateEstado(Estado estado) {
		estadoDao.updateEstado(estado);

	}

	@Override
	public void deleteEstado(Estado estado) {
		estadoDao.deleteEstado(estado);
	}

}
