package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.cupones.domain.Role;
import com.cupones.eis.RoleDao;

@Stateless
public class RoleServiceImpl implements RoleService {

	@EJB
	RoleDao roleDao;
	
	
	public List<Role> findAllRole() {
		return roleDao.findAllRole();
	}

	
	public List<Role> findRoleByUser(Role role) {
	  return roleDao.findRoleByUser(role);
	  
	}

	
	public void addRole(Role role) {
		roleDao.addRole(role);
	}

	
	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

	
	public void deleteRole(Role role) {
		roleDao.deleteRole(role);
	}

}
