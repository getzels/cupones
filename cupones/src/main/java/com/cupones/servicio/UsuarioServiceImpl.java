package com.cupones.servicio;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cupones.domain.Usuario;
import com.cupones.eis.UsuarioDao;
import com.cupones.excepciones.InternalServicesException;

@Stateless
public class UsuarioServiceImpl implements UsuarioService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(UsuarioServiceImpl.class);

	
	@EJB
	private UsuarioDao usuarioDao;

	
	public List<Usuario> findAllUser() throws Exception {
		return usuarioDao.findAllUser();
	}

	
	public Usuario findUserById(Usuario usuario) throws Exception {
		return usuarioDao.findUserById(usuario);
	}

	
	public Usuario findUserByUserName(Usuario usuario) throws Exception {
		return usuarioDao.findUserByUserName(usuario);
	}

	
	public void addUser(Usuario usuario) throws Exception {
		if (usuario != null) {
			usuarioDao.addUser(usuario);
		} else {
			logger.debug("El objecto tipo usuario que desea agregar esta nulo");
		}
	}

	
	public void updateUser(Usuario usuario) throws Exception {
		if (usuario != null) {
			usuarioDao.updateUser(usuario);
		} else {
			logger.debug("El objecto tipo usuario que desea actualiza esta nulo");
		}
	}

	
	public void deleteUser(Usuario usuario) throws Exception {
		if (usuario != null) {
			usuarioDao.deleteUser(usuario);
		} else {
			logger.debug("El objecto tipo usuario que desea eliminar esta nulo");
		}

	}

	public boolean validate(Usuario usuario) throws InternalServicesException {
		logger.trace("validate ", usuario);
		
		Usuario user;
		boolean validacion = false; 
		
		try {
			user = findUserByUserName(usuario);
			
			if (user != null && usuario.getContrasena().equals(user.getContrasena())) {
				logger.debug("Contrasena valida para usuario: " +  user);
				validacion = true;
			}
			
			return validacion;
		} catch (Exception e) {
			logger.error("Error validando el usuario " + e);
			throw new InternalServicesException(new Exception("Error validando el usuario " + e.getMessage()));
		}finally{
			logger.traceExit();
		}
	}

}
