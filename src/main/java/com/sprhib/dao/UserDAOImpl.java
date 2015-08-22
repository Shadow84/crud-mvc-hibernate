package com.sprhib.dao;

import java.util.Date;
import java.util.List;

import com.sprhib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addUser(User user) {
		getCurrentSession().save(user);
	}

	public void updateUser(User user) {
		User userToUpdate = getUser(user.getId());
		userToUpdate.setName(user.getName());
		userToUpdate.setAge(user.getAge());
		userToUpdate.setIsAdmin(user.getIsAdmin());
		getCurrentSession().update(userToUpdate);
		
	}

	public User getUser(int id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}

	public void deleteUser(int id) {
		User user = getUser(id);
		if (user != null)
			getCurrentSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getCurrentSession().createQuery("FROM User").list();
	}

	@Override
	public List<User> getUsers(String name) {
		return getCurrentSession().createQuery("FROM User AS u WHERE u.name = :name").setParameter("name", name).list();
	}

	@Override
	public List<User> getUsersByIdBetwen(Integer from, Integer to,String sort) {
		 return getCurrentSession().createQuery("FROM User AS u WHERE u.id BETWEEN :from AND :to order by :sort")
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("sort", sort).list();
	}

	@Override
	public List<User> getUsersByNameBetwen(String from, String to, String sort) {
		return getCurrentSession().createQuery("FROM User AS u WHERE u.name BETWEEN :from AND :to order by :sort")
				.setParameter("from", from)
				.setParameter("to",to)
				.setParameter("sort",sort)
				.list();
	}

	@Override
	public List<User> getUsersByAgeBetwen(Integer from, Integer to, String sort) {
		return getCurrentSession().createQuery("FROM User AS u WHERE u.age BETWEEN :from AND :to order by :sort")
				.setParameter("from", from)
				.setParameter("to",to)
				.setParameter("sort",sort).list();
	}

	@Override
	public List<User> getUsersByCreatedDateBetwen(Date from, Date to, String sort) {
		return getCurrentSession().createQuery("FROM User AS u WHERE u.createdDate BETWEEN :from AND :to order by :sort")
				.setParameter("from", from)
				.setParameter("to",to)
				.setParameter("sort",sort).list();
	}
}
