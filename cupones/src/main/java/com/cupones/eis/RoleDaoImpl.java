package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cupones.domain.Role;

@Stateless
public class RoleDaoImpl implements RoleDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAllRole() {
		return em.createNamedQuery("Role.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findRoleByUser(Role role) {
	  Query query = em.createQuery("from Role r where r.usuario.idUsuario = :idUser ");
	  query.setParameter("idUser",role.getUsuario().getIdUsuario());
	  
	  return query.getResultList();
	}

	@Override
	public void addRole(Role role) {
	em.persist(role);
	}

	@Override
	public void updateRole(Role role) {
		em.merge(role);
	}

	@Override
	public void deleteRole(Role role) {
	role = em.find(Role.class, role.getId());
	em.remove(role);
	}

}
