package com.grafica;

public class principalPrueba {
private static int n1=0;
	public static void main(String[] args) {
		
		n1 +=1;
		try {
			Usuario_Datos window = new Usuario_Datos();
				//hola 	
			window.open();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
		// TODO Auto-generated method stub

	

}
