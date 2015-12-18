package br.com.estudoweb.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.estudoweb.dao.DAOException;
import br.com.estudoweb.domain.User;
import br.com.estudoweb.service.ServiceException;
import br.com.estudoweb.service.UserService;
import br.com.estudoweb.util.MessageUtil;

@Controller(value = "userController")
public class UserController {

	private User user = new User();
	private List<User> userList;

	@Autowired
	private UserService userservice;

	public UserController() {
	}

	@PostConstruct
	public void init() {
		setUserList(userservice.seachAllUsers());
	}

	public void saveUser() {
		try {
			User userSave = userservice.saveUser(user);
			if (user.getId() == null)
				userList.add(userSave);

			user = new User();

			MessageUtil.newMsg("Saved", FacesMessage.SEVERITY_INFO);
		} catch (ServiceException e) {
			e.printStackTrace();
			MessageUtil.newMsg("Error on Save", FacesMessage.SEVERITY_ERROR);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteUser(User user) {
		try {
			userservice.removeUser(user);
			userList.remove(user);

			MessageUtil.newMsg("Deleted", FacesMessage.SEVERITY_INFO);

		} catch (Exception e) {

		}

	}

	public void editUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
