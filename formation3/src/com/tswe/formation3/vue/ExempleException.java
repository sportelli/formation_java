package com.tswe.formation3.vue;

import com.tswe.formation3.exceptions.ANegatifException;

public class ExempleException {
	
	public static void main (String[] args){
		
		Calcul tc = new Calcul();
		
		try {
		Integer somme1= tc.sommePositive(2 , 3);
		System.out.println("fin de somme 1");
		
//		Integer somme2= tc.sommePositive(-2 , 3);
		System.out.println("fin de somme 2");

		Integer somme3= tc.sommePositive(2 , -3);
		System.out.println("fin de somme 3");
		
		} catch (ANegatifException e ){
			System.out.println("ANegatifException levée");
		}
		catch (Exception e ){
			System.out.println("Exception levée");
		}
		
		System.out.println("fin des sommes");
		
	}

}
