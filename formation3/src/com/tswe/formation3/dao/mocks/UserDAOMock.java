package com.tswe.formation3.dao.mocks;

import com.tswe.formation3.dao.IUserDAO;
import com.tswe.formation3.entities.User;

public class UserDAOMock implements IUserDAO{

	@Override
	public User findByEmail(String email){
		User u = null;
		if( ( "".equals(email)) || ("admin@root.com".equals(email))){
			// On laisse u null
		} else {
			u = new User();
			u.setId(123);
			u.setEmail(email);
			u.setPassword("76876876786878GJGHJjgjkgk");			
		}
		return u;
	}

	@Override
	public User create(User x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User x) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public User update(User x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub

	}

}
