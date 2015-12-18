package br.com.estudoweb.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.estudoweb.dao.DAOException;
import br.com.estudoweb.domain.Role;
import br.com.estudoweb.service.ServiceException;
import br.com.estudoweb.service.RoleService;
import br.com.estudoweb.util.MessageUtil;

@Controller(value = "roleController")
public class RoleController {

	private Role role = new Role();
	private List<Role> roleList;

	@Autowired
	private RoleService roleservice;

	public RoleController() {
	}

	@PostConstruct
	public void init() {
		setRoleList(roleservice.seachAllRoles());
	}

	public void saveRole() {
		try {
			Role roleSave = roleservice.saveRole(role);
			if (role.getId() == null)
				roleList.add(roleSave);

			role = new Role();

			MessageUtil.newMsg("Saved", FacesMessage.SEVERITY_INFO);
		} catch (ServiceException e) {
			e.printStackTrace();
			MessageUtil.newMsg("Error on Save", FacesMessage.SEVERITY_ERROR);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteRole(Role role) {
		try {
			roleservice.removeRole(role);
			roleList.remove(role);

			MessageUtil.newMsg("Deleted", FacesMessage.SEVERITY_INFO);

		} catch (Exception e) {

		}

	}

	public void editRole(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
