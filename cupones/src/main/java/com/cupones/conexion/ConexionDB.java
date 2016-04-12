package com.cupones.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * 
 * @author Getzels N
 */
public class ConexionDB {

	public static Connection GetConnection() {
		Connection conexion = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String servidor = "jdbc:mysql://localhost/desa_cupones";
			String usuarioDB = "root";
			String passwordDB = "admin";
			conexion = DriverManager.getConnection(servidor, usuarioDB,
					passwordDB);
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex,
					"Error1 en la Conexi�n con la BD " + ex.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex,
					"Error2 en la Conexi�n con la BD " + ex.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex,
					"Error3 en la Conexi�n con la BD " + ex.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		}
		return conexion;
	}
}
