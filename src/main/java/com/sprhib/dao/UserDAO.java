package com.sprhib.dao;

import java.util.Date;
import java.util.List;

import com.sprhib.model.User;

public interface UserDAO {
	
	public void addUser(User user);
	public void updateUser(User user);
	public User getUser(int id);
	public void deleteUser(int id);
	public List<User> getUsers();
	public List<User> getUsers(String name);

	public List<User> getUsersByIdBetwen(Integer from, Integer to,String sort);
	public List<User> getUsersByNameBetwen(String from, String to, String sort);
	public List<User> getUsersByAgeBetwen(Integer from, Integer to, String sort);
	public List<User> getUsersByCreatedDateBetwen(Date from, Date to, String sort);


}
