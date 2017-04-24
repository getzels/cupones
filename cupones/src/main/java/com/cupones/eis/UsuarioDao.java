package com.cupones.eis;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Usuario;

@Remote
public interface UsuarioDao extends Serializable{

	
	public List<Usuario> findAllUser() throws SQLException;
	
	public Usuario findUserById(Usuario usuario) throws SQLException;
	
	public Usuario findUserByUserName(Usuario usuario) throws SQLException;
	
	public void addUser(Usuario usuario) throws SQLException;
	
	public void updateUser(Usuario usuario) throws SQLException;
	
	public void deleteUser(Usuario usuario) throws SQLException;
}
