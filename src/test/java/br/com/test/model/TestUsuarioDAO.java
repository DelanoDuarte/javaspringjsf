package br.com.test.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.estudoweb.dao.UserDAO;
import br.com.estudoweb.dao.UserDAO;
import br.com.estudoweb.domain.User;
import junit.framework.Assert;

public class TestUsuarioDAO {

	EntityManager em;
	ClassPathXmlApplicationContext ctx;

	UserDAO dao;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
		em = emf.createEntityManager();
		dao = new UserDAO(em);
	}

	@After
	public void end() {
		ctx.close();
	}

	@Test
	public void testeSalvar() {

		User user = new User();
		user.setName("TTTTT");
		user.setLogin("TTTTT");
		user.setSenha("TTTTT");

		dao.cadastrar(user);

	}

	@SuppressWarnings("deprecation")
	public void testeBuscaPorId() {
		User user = new User();
		user.setName("Teste ");
		user.setLogin("LOGIN ");
		user.setSenha("SENHA ");

		User userSave = dao.cadastrar(user);
		Integer id = userSave.getId();

		User userFind = dao.buscaPorId(id);
		Assert.assertNotNull(userSave.getId());
	}
}
