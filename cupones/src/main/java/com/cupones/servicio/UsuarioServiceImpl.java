package com.cupones.servicio;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.cupones.domain.Usuario;
import com.cupones.eis.UsuarioDao;

@Stateless
public class UsuarioServiceImpl implements UsuarioService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	UsuarioDao usuarioDao;

	@Override
	public List<Usuario> findAllUser() throws Exception {
		return usuarioDao.findAllUser();
	}

	@Override
	public Usuario findUserById(Usuario usuario) throws Exception {
		return usuarioDao.findUserById(usuario);
	}

	@Override
	public Usuario findUserByUserName(Usuario usuario) throws Exception {
		return usuarioDao.findUserByUserName(usuario);
	}

	@Override
	public void addUser(Usuario usuario) throws Exception {
		if (usuario != null) {
			usuarioDao.addUser(usuario);
		} else {
			System.out
					.println("El objecto tipo usuario que desea agregar esta nulo");
		}
	}

	@Override
	public void updateUser(Usuario usuario) throws Exception {
		if (usuario != null) {
			usuarioDao.updateUser(usuario);
		} else {
			System.out
					.println("El objecto tipo usuario que desea actualiza esta nulo");
		}
	}

	@Override
	public void deleteUser(Usuario usuario) throws Exception {
		if (usuario != null) {
			usuarioDao.deleteUser(usuario);
		} else {
			System.out
					.println("El objecto tipo usuario que desea eliminar esta nulo");
		}

	}

	public boolean validate(Usuario usuario) {
		Usuario user;
		try {
			user = this.findUserByUserName(usuario);
		} catch (Exception e) {
			// Si se presenta alguna excepcion devuelve falso para denegar el
			// acceso.
			e.printStackTrace();
			return false;
		}
		//
		if (user != null) {
			if (usuario.getContrasena().equals(user.getContrasena())) {

				return true;
			} else {

				return false;

			}
		} else {

			return false;
		}

	}

}
