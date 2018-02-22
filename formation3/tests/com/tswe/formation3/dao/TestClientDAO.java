package com.tswe.formation3.dao;

import org.junit.Assert;
import org.junit.Test;

import com.tswe.formation3.exceptions.ClientNotFoundException;

public class TestClientDAO {

	@Test (expected=ClientNotFoundException.class )
	public void testGetByIdNull() throws ClientNotFoundException{
		new ClientDAO().getById(0);
	}
	
	@Test (expected=ClientNotFoundException.class )
	public void testGetByIdInconnu() throws ClientNotFoundException{
		new ClientDAO().getById(9999999);
	}

	@Test
	public void testGetByIdValide() throws ClientNotFoundException {
		Assert.assertNotNull(new ClientDAO().getById(1));
	}
	
}
