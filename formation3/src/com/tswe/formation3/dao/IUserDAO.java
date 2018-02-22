package com.tswe.formation3.dao;

import com.tswe.formation3.entities.User;

public interface IUserDAO extends IDAO<User>{

	User findByEmail(String email);

}