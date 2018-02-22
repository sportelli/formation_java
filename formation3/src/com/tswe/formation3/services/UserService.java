package com.tswe.formation3.services;

import com.tswe.formation3.dao.IUserDAO;
import com.tswe.formation3.dao.UserDAO;
import com.tswe.formation3.entities.User;
import com.tswe.formation3.exceptions.InvalidPasswordException;
import com.tswe.formation3.exceptions.UserNotFoundException;

public class UserService {
	
	private IUserDAO uDAO = null;
	
	public UserService(){
		this.uDAO = new UserDAO();
	}
	
	public User auth (String login, String password) throws UserNotFoundException, InvalidPasswordException{
		
		User u = this.uDAO.findByEmail(login);
		
		if (u == null) {
			throw new UserNotFoundException(login + " non trouvé");
		} else {
			if (!password.equals(u.getPassword())){
				throw new InvalidPasswordException(login + " a un mot de passe erroné");
			}
		}
		return u;
	}

	public IUserDAO getuDAO() {
		return uDAO;
	}

	public void setuDAO(IUserDAO uDAO) {
		this.uDAO = uDAO;
	}

}
