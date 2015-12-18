package br.com.estudoweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudoweb.dao.DAOException;
import br.com.estudoweb.dao.PerfilDAO;
import br.com.estudoweb.domain.Role;

@Service
public class RoleService {

	@Autowired
	PerfilDAO roledao;

	public Role saveRole(Role role) throws ServiceException, DAOException {
		return roledao.cadastrar(role);

	}

	public void removeRole(Role role) throws ServiceException {
		try {
			roledao.remove(role);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public Role seachWithId(int id) {

		return roledao.buscaPorId(id);

	}

	public List<Role> seachAllRoles() {

		return roledao.buscarTodos();
	}

}
