package com.tswe.formation3.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import com.tswe.formation3.entities.User;

public class TestUserDAO 
{
	private IUserDAO userDAO;
	
	@Test
	public void testFindByEmailVide(){
		User u = userDAO.findByEmail("");
		// Doit me renvoyer null !
		Assert.assertNotNull(u);
	}

	@Test
	public void testFindByEmailIncorrect(){
		User u = userDAO.findByEmail("jeofzjopeff@gmail.com");
		// Ne doit pas me renvoyer null !
		Assert.assertNotNull(u);
	}

	@Test
	public void testFindByEmailPasswordCorrect(){
		User u = userDAO.findByEmail("a@a.com");
		// Doit me renvoyer null !
		Assert.assertEquals("76876876786878GJGHJjgjkgk", u.getPassword());
	}
		
	@Before
	public void initialisation(){
		this.userDAO = new UserDAO();
	}
	
	
}
