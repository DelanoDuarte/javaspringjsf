package br.com.estudoweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudoweb.dao.DAOException;
import br.com.estudoweb.dao.UserDAO;
import br.com.estudoweb.domain.User;

@Service
public class UserService {

	@Autowired
	UserDAO userdao;

	public User saveUser(User user) throws ServiceException, DAOException {

		User userExist = userdao.buscarLogin(user.getLogin());
		if (userExist != null) {
			throw new ServiceException("Usuário ja Existe !");
		}

		return userdao.cadastrar(user);

	}

	public void removeUser(User user) throws ServiceException {
		try {
			userdao.remove(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public User seachWithId(int id) {

		return userdao.buscaPorId(id);

	}

	public List<User> seachAllUsers() {

		return userdao.buscarTodos();
	}

	public User seachWithLogin(String login) throws DAOException {

		return userdao.buscarLogin(login);
	}
}
