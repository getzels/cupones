package com.cupones.servicio;

import java.util.List;

import com.cupones.domain.Tarjeta;
import com.cupones.domain.Usuario;

public interface TarjetaService {

		public List<Tarjeta> findAllTarjeta();
		
		public List<Tarjeta> findTarjetaById(Usuario usuario);
		
		public void addTarjeta (Tarjeta tarjeta);
		
		public void updateTarjeta (Tarjeta tarjeta);
		
		public void deleteTarjeta (Tarjeta tarjeta);
	}

