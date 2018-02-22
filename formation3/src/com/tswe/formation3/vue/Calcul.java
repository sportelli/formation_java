package com.tswe.formation3.vue;

import com.tswe.formation3.exceptions.ANegatifException;

public class Calcul {
	
	public Integer sommePositive(Integer a, Integer b) 
			throws Exception {
		Integer somme = 0;
		if ( a > 0) {
			if (b < 0) {
				throw new Exception();
			}
			somme = a+b;
		}
		else {
			// JETER L'EXCEPTION
			//throw new Exception("A NEGATIF");
			throw new ANegatifException();
		}
		System.out.println("somme OK");
		return somme;	
	}

}
