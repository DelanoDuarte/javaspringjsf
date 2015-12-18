package br.com.test.model;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.estudoweb.dao.DAOException;
import br.com.estudoweb.dao.UserDAO;
import br.com.estudoweb.domain.User;
import br.com.estudoweb.service.ServiceException;
import br.com.estudoweb.service.UserService;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/META-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestUserService {

	@Autowired
	UserService service;

	@Autowired
	UserDAO dao;

	@Test
	public void testSave() throws ServiceException, DAOException {
		User user = new User();
		user.setLogin("novoUser12323");
		user.setSenha("68464");
		user.setName("JJ");

		service.saveUser(user);

	}

	@Test
	public void testNotSave() throws ServiceException, DAOException {
		User user = new User();
		user.setLogin("Pedro");
		user.setSenha("64651651");
		user.setName("PP");

		dao.cadastrar(user);

		User userSave = service.saveUser(user);
		Assert.assertNull(userSave);
	}
}
