package com.tswe.formation3.dao;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tswe.formation3.entities.Client;
import com.tswe.formation3.entities.User;
import com.tswe.formation3.exceptions.ClientNotFoundException;

public class TestClientDAO {
	private ClientDAO clientDAO = null;
	

	
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
	
	@Test
	public void testFindAllListNotNull(){
		List<Client> clients = this.clientDAO.findAll();
		Assert.assertNotNull(clients);
		Assert.assertTrue(clients.size() > 0);
	}
	
	@Test
	public void testCreate(){
		Client c = new Client();
		c.setName("pascale");
		c.setCodeClient("612");
		c = this.clientDAO.create(c);
		Assert.assertNotNull(c.getId());
		Assert.assertTrue(c.getId() > 0);
	}
	
	@Test(expected=ClientNotFoundException.class)
	public void testDeleteClient() throws ClientNotFoundException {
		Client c = new Client();
		c.setName("pascale");
		c.setCodeClient("612");
		c = this.clientDAO.create(c);
		System.out.println("id " + c.getId() + " créé");
		this.clientDAO.delete(c);
		this.clientDAO.getById(c.getId());
	}
	
	@Test
	public void testUpdateClient() throws ClientNotFoundException{
		// Je créé un client
		Client c = new Client();
		c.setName("felix");
		c.setCodeClient("123");
		c= this.clientDAO.create(c); // je le persiste
		c.setName("pascale");
		c.setCodeClient("612");
		c = this.clientDAO.update(c); // je le mets à jour
		c = this.clientDAO.getById(c.getId()); // je le récupère
		Assert.assertNotNull(c); // je verifie qu'il a les bonnes infos
		Assert.assertEquals(c.getName(), "pascale");
		Assert.assertEquals(c.getCodeClient(), "612");
	}
	
	@Before
	public void initialisation() {
		this.clientDAO = new ClientDAO();
	}
	
	
	
}
