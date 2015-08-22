package com.sprhib.service;

import java.util.Date;
import java.util.List;

import com.sprhib.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.UserDAO;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	public void addUser(User user) {
		userDAO.addUser(user);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	public List<User> getUsers(String name) {
		return userDAO.getUsers(name);
	}

	@Override
	public List<User> getUsersByIdBetwen(Integer from, Integer to,String sort) {
		return userDAO.getUsersByIdBetwen(from, to, sort);
	}

	@Override
	public List<User> getUsersByNameBetwen(String from, String to, String sort) {
		return userDAO.getUsersByNameBetwen(from, to, sort);
	}

	@Override
	public List<User> getUsersByAgeBetwen(Integer from, Integer to, String sort) {
		return userDAO.getUsersByAgeBetwen(from, to, sort);
	}

	@Override
	public List<User> getUsersByCreatedDateBetwen(Date from, Date to, String sort) {
		return userDAO.getUsersByCreatedDateBetwen(from, to, sort);
	}
}
