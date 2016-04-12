package com.cupones.servicio;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Role;

@Remote
public interface RoleService {
	
	public List<Role> findAllRole();
	
	public List<Role> findRoleByUser(Role role);
	
	public void addRole(Role role);
	
	public void updateRole(Role role);
	
	public void deleteRole(Role role);

}
