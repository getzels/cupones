package com.cupones.eis;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Usuario;
@Remote
public interface UsuarioDao {

	
	public List<Usuario> findAllUser() throws Exception;
	
	public Usuario findUserById(Usuario usuario) throws Exception;
	
	public Usuario findUserByUserName(Usuario usuario) throws Exception;
	
	public void addUser(Usuario usuario) throws Exception;
	
	public void updateUser(Usuario usuario) throws Exception;
	
	public void deleteUser(Usuario usuario) throws Exception;
}
