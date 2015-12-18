package br.com.test.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.estudoweb.dao.PerfilDAO;
import br.com.estudoweb.domain.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager")
public class TestRoleDao {

	@Autowired
	PerfilDAO dao = new PerfilDAO();

	@Test
	public void testSaveRole() {

		Role role = new Role();
		role.setType("USER");

		dao.cadastrar(role);

		Assert.assertNotNull(role.getId());

	}

}
