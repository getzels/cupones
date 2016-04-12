package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllUser() throws Exception {
		return em.createNamedQuery("Usuario.findAll").getResultList();
	}

	@Override
	public Usuario findUserById(Usuario usuario) throws Exception {
		Query query = em.createQuery("select u from Usuario u where u.idUsuario = :userID");
		query.setParameter("userID", usuario.getIdUsuario());
		return (Usuario) query.getSingleResult();
	}

	@Override
	public Usuario findUserByUserName(Usuario usuario) throws Exception {
		Query query = em.createQuery("select u from Usuario u where u.nombreUsuario like :userName");
		query.setParameter("userName", usuario.getNombreUsuario());
		return (Usuario) query.getSingleResult();
	}

	@Override
	public void addUser(Usuario usuario)throws Exception {
		em.persist(usuario);

	}

	@Override
	public void updateUser(Usuario usuario)throws Exception {
		em.merge(usuario);

	}

	@Override
	public void deleteUser(Usuario usuario)throws Exception {
		Usuario usuario1 = em.find(Usuario.class, usuario.getIdUsuario());
		em.remove(usuario1);
	}

}
