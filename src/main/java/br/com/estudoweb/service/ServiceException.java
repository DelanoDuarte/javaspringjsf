package br.com.estudoweb.service;

import br.com.estudoweb.dao.DAOException;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(DAOException E) {
		super(E);
	}
}
