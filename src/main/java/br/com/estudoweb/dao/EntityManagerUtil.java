package br.com.estudoweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	static EntityManager em = null;

	public static EntityManager criarEntityManager() {
		if (em == null) {
			// Se não Existir ele Criar, se não usa um criado, "Sigleton"
			em = Persistence.createEntityManagerFactory("estudo_web").createEntityManager();
		} else {
			return em;
		}
		return em;
	}

}
