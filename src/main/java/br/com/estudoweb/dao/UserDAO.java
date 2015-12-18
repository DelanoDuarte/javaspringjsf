package br.com.estudoweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.estudoweb.domain.User;

@Repository
public class UserDAO {

	@PersistenceContext
	private EntityManager em;

	public UserDAO(EntityManager em) {
		this.em = em;
	}

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}

	// Insert
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.estudoweb.dao.UserDAO#cadastrar(br.com.estudoweb.domain.User)
	 */
	@Transactional
	public User cadastrar(User user) {
		em.merge(user);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.estudoweb.dao.UserDAO#remove(br.com.estudoweb.domain.User)
	 */
	@Transactional
	public void remove(User user) throws DAOException {

		try {
			User userManaged = em.getReference(User.class, user.getId());
			em.remove(userManaged);
		} catch (IllegalArgumentException e) {
			throw new DAOException("", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.estudoweb.dao.UserDAO#buscaPorId(int)
	 */
	public User buscaPorId(int id) {

		return em.find(User.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.estudoweb.dao.UserDAO#buscarTodos()
	 */
	@SuppressWarnings("unchecked")
	public List<User> buscarTodos() {

		Query q = em.createQuery("select u from User u");

		return q.getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public User buscarLogin(String login) throws DAOException {

		try {
			Query q = em
					.createQuery("select u from User u where u.login=:login");
			q.setParameter("login", login);
			q.setMaxResults(1);
			return (User) q.getSingleResult();
		} catch (Exception e) {

			return null;
			// throw new DAOException("Registo não encontrador", e);
		}

	}

}
