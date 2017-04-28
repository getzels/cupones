package com.cupones.eis;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5076166002978772150L;
	
	@PersistenceContext(unitName = "CuponesPU")
	private EntityManager em;
	
	public UsuarioDaoImpl(EntityManager em) {
		this.em = em;
	}


	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUser() throws SQLException {
		return em.createNamedQuery("Usuario.findAll").getResultList();
	}

	
	public Usuario findUserById(Usuario usuario) throws SQLException {
		Query query = em.createQuery("select u from Usuario u where u.idUsuario = :userID");
		query.setParameter("userID", usuario.getIdUsuario());
		return (Usuario) query.getSingleResult();
	}

	
	public Usuario findUserByUserName(Usuario usuario) throws SQLException {
		Query query = em.createQuery("select u from Usuario u where u.nombreUsuario like :userName");
		query.setParameter("userName", usuario.getNombreUsuario());
		return (Usuario) query.getSingleResult();
	}

	
	public void addUser(Usuario usuario)throws SQLException {
		em.persist(usuario);

	}

	
	public void updateUser(Usuario usuario)throws SQLException {
		em.merge(usuario);

	}

	
	public void deleteUser(Usuario usuario)throws SQLException {
		Usuario usuario1 = em.find(Usuario.class, usuario.getIdUsuario());
		em.remove(usuario1);
	}

}
