package com.tswe.formation3.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tswe.formation3.dao.IUserDAO;
import com.tswe.formation3.dao.mocks.UserDAOMock;
import com.tswe.formation3.entities.User;
import com.tswe.formation3.exceptions.InvalidPasswordException;
import com.tswe.formation3.exceptions.UserNotFoundException;

public class TestUserServices {
	
	private UserService userService;
	
	@Before
	public void init(){
			
		this.userService = new UserService();
		IUserDAO userDAO = new UserDAOMock();
		this.userService.setuDAO(userDAO);
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testAuthEmailEtPasswordVide() throws UserNotFoundException, InvalidPasswordException{
		User u = this.userService.auth("", "");
	}

	@Test
	public void testAuthEmailPassOK() throws UserNotFoundException, InvalidPasswordException{
		User u = this.userService.auth("a@a.com", "76876876786878GJGHJjgjkgk");
		Assert.assertNull(u);
	}
	
	@Test(expected = InvalidPasswordException.class)
	public void testAuthMdpFaux() throws UserNotFoundException, InvalidPasswordException{
		User u = this.userService.auth("a@a.com", "xx");
	}
	
}
