package com.yash.training.springMVC.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.yash.training.springMVC.model.User;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Integer addUser(User user) {

		entityManager.persist(user);

		return user.getUserId();
	}

	public User validateUser(String userName, String password) {

		System.out.println(userName + password);

		Query query = entityManager.createQuery("from User where username = '" + userName + "' and password = '" + password + "' ");

		List<User> users = query.getResultList();

		return users.size() > 0 ? users.get(0) : null;
	}
}
