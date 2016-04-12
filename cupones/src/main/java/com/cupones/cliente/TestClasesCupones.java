package com.cupones.cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

//import org.apache.commons.codec.digest.DigestUtils;
import com.cupones.conexion.ConexionDB;
import com.cupones.domain.Categoria;
import com.cupones.domain.Estado;
import com.cupones.domain.Oferta;
import com.cupones.servicio.CategoriaService;
import com.cupones.servicio.EstadoService;
import com.cupones.servicio.OfertaService;
import com.cupones.servicio.UsuarioService;

public class TestClasesCupones {

	public static void main(String[] args) {

		Context jndi;

		try {
			jndi = new InitialContext();

		/*	EstadoService estadoService = (EstadoService) jndi
					.lookup("java:global/cupones/EstadoServiceImpl!com.cupones.servicio.EstadoService");
			CategoriaService categoriaService = (CategoriaService) jndi
					.lookup("java:global/cupones/CategoriaServiceImpl!com.cupones.servicio.CategoriaService");
			OfertaService ofertaService = (OfertaService) jndi
					.lookup("java:global/cupones/OfertaServiceImpl!com.cupones.servicio.OfertaService");
*/
			UsuarioService usaurioService = (UsuarioService) jndi
					.lookup("java:global/cupones/UsuarioServiceImpl!com.cupones.servicio.UsuarioService");

			System.out.println("Inicio de prueba");

			// Estado estado = estadoService
			// .findEstadoByName(new Estado("ACTIVO"));

			// Estado estado = estadoService.findEstadoById(new Estado(1));

			// System.out.println(estado);

			//Categoria categoria = categoriaService.findCategoriaById(new Categoria(1));
			//
			//System.out.println(categoria);

			// consultaUsuarios();

			// System.out.println(oferta1);

			// Oferta oferta = ofertaService.findOfertaById(new Oferta());

			// List<Oferta> ofertas = ofertaService.findAllOferta();
			//
			// for(Oferta o : ofertas){
			// System.out.println(o);
			// }

			// System.out.println(oferta);

			System.out.println("Fin de la prueba");

		} catch (Exception e) {
			System.out.println("Error en la prueba " + e.getMessage());
		}
	}

	public static String consultaUsuarios() {
		Connection miConexion;
		miConexion = ConexionDB.GetConnection();
		String cadena = "";

		try {
			Statement statement = miConexion.createStatement();

			String sql = "SELECT NOMBRE_USUARIO,CONTRASENA FROM desa_cupones.usuario;";

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				cadena += resultSet.getString(1) + " |" + resultSet.getString(2) + "/n";
			}

			miConexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cadena;

	}

}
