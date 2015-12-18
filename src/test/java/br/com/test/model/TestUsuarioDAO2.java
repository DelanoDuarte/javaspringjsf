package br.com.test.model;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.estudoweb.dao.UserDAO;
import br.com.estudoweb.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/META-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager")
public class TestUsuarioDAO2 {

	EntityManager em;

	@Autowired
	UserDAO dao;

	@Before
	public void init() {
	}

	@After
	public void end() {
	}

	@Test
	public void testeSalvar() {

		User user = new User();
		user.setName("DelanoJunior");
		user.setLogin("Junior");
		user.setSenha("1234564");

		dao.cadastrar(user);

	}

}
