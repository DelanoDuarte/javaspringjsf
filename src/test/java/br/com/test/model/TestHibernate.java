package br.com.test.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.estudoweb.domain.User;

public class TestHibernate {

	public static void main(String[] args) {
		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("estudo_web");
		//
		// EntityManager em = emf.createEntityManager();

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"file:src/main/resources/META-INF/springbeans.xml");
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManagerFactory");

		EntityManager em = emf.createEntityManager();

		User user = new User();
		user.setName("Joao");
		user.setLogin("Joao");
		user.setSenha("151651");

		ctx.close();

	}

}
