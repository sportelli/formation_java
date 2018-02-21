package com.tswe.formation3.entities;

import com.tswe.formation3.dao.IDAO;

public class PolymorphService {
	
	public void connect(IDAO dao){
		dao.connect();
	}

}
