package br.com.estudoweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.estudoweb.domain.Role;

@Repository
public class PerfilDAO {

	@PersistenceContext
	private EntityManager em;

	public PerfilDAO(EntityManager em) {
		this.em = em;
	}

	public PerfilDAO() {
		// TODO Auto-generated constructor stub
	}

	// Insert
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.estudoweb.dao.RoleDAO#cadastrar(br.com.estudoweb.domain.Role)
	 */
	@Transactional
	public Role cadastrar(Role role) {
		em.merge(role);
		return role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.estudoweb.dao.RoleDAO#remove(br.com.estudoweb.domain.Role)
	 */
	@Transactional
	public void remove(Role role) throws DAOException {

		try {
			Role roleManaged = em.getReference(Role.class, role.getId());
			em.remove(roleManaged);
		} catch (IllegalArgumentException e) {
			throw new DAOException("", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.estudoweb.dao.RoleDAO#buscaPorId(int)
	 */
	public Role buscaPorId(int id) {

		return em.find(Role.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.estudoweb.dao.RoleDAO#buscarTodos()
	 */
	@SuppressWarnings("unchecked")
	public List<Role> buscarTodos() {

		Query q = em.createQuery("select u from Role u");

		return q.getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
