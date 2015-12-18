package br.com.test.springbeans;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TesteSpringBeans {

	@Test
	public void testContextSpring() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"file:src/main/resources/META-INF/springbeans.xml");

		BasicDataSource bds = (BasicDataSource) ctx.getBean("dataSource");
		System.out.println(bds.getPassword());
		System.out.println(bds.getUrl());

		ctx.close();
	}

}
