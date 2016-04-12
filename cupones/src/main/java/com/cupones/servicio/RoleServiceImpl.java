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
	
	@Override
	public List<Role> findAllRole() {
		return roleDao.findAllRole();
	}

	@Override
	public List<Role> findRoleByUser(Role role) {
	  return roleDao.findRoleByUser(role);
	  
	}

	@Override
	public void addRole(Role role) {
		roleDao.addRole(role);
	}

	@Override
	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

	@Override
	public void deleteRole(Role role) {
		roleDao.deleteRole(role);
	}

}
