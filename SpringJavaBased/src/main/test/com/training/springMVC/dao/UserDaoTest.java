package com.training.springMVC.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.training.springMVC.dao.UserDao;
import com.yash.training.springMVC.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

	@InjectMocks
	private UserDao userDao;

	@Mock
	private EntityManager entityManager;

	@Mock
	private Query query;

	@Test
	public void shouldReturnUserIdAfterRegistration(){

		User user = new User();
		user.setFirstname("nitish");
		user.setLastname("aggarwal");
		user.setUsername("ntsh");
		user.setPhone("112342");

		user.setUserId(1);

		doNothing().when(entityManager).persist(user);

		Integer actualUserId = userDao.addUser(user);

		verify(entityManager).persist(user);

		Assert.assertEquals((Integer)1, actualUserId);

	}

	@Test
	public void shouldReturnUserDetailsForValidUser(){

		User user = new User();
		user.setFirstname("nitish");
		user.setLastname("aggarwal");
		user.setUsername("ntsh");
		user.setPhone("112342");
		user.setPassword("1234");

		List<User> userList = new ArrayList<>();
		userList.add(user);

		when(entityManager.createQuery(anyString())).thenReturn(query);
		when(entityManager.createQuery(anyString()).getResultList()).thenReturn(userList);

		User actualUser = userDao.validateUser("ww", "ew");

		verify(entityManager,atLeast(1)).createQuery(anyString());

		Assert.assertEquals("ntsh", actualUser.getUsername());
		Assert.assertEquals("1234", actualUser.getPassword());

	}

	@Test
	public void shouldReturnNullForInValidUser(){

		User user = new User();
		user.setFirstname("nitish");
		user.setLastname("aggarwal");
		user.setUsername("ntsh");
		user.setPhone("112342");
		user.setPassword("ew");

		List<User> userList = new ArrayList<>();

		when(entityManager.createQuery(anyString())).thenReturn(query);
		when(entityManager.createQuery(anyString()).getResultList()).thenReturn(userList);

		User actualUser = userDao.validateUser("ww", "ew");

		verify(entityManager,atLeast(1)).createQuery(anyString());

		Assert.assertNull(actualUser);
	}
}
