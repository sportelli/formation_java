package com.tswe.formation3.dao;

import com.tswe.formation3.entities.User;

public class UserDAO implements IUserDAO {

	/* (non-Javadoc)
	 * @see com.tswe.formation3.dao.IUserDAO#findByEmail(java.lang.String)
	 */
	@Override
	public User findByEmail(String email){
		//TODO: Faire un appel en BDD
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
	
	
	/* (non-Javadoc)
	 * @see com.tswe.formation3.dao.IUserDAO#create(com.tswe.formation3.entities.User)
	 */
	@Override
	public User create(User x) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.tswe.formation3.dao.IUserDAO#delete(com.tswe.formation3.entities.User)
	 */
	@Override
	public void delete(User x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.tswe.formation3.dao.IUserDAO#update(com.tswe.formation3.entities.User)
	 */
	@Override
	public User update(User x) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.tswe.formation3.dao.IUserDAO#connect()
	 */
	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
	}

}
