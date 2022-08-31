package com.strategy.impl;

import com.strategy.interfaz.IPago;

public class Paypal implements IPago{
	
	private String mail;
	private String contrasenia;
	
	public Paypal(String mail, String contrasenia) {
		this.mail = mail;
		this.contrasenia = contrasenia;
	}

	@Override
	public void pago(double monto) {
		System.out.println("Comunicando al mail: " + this.mail);
		System.out.println("Esperando confirmación....");
		System.out.println(monto + " ha sido transferido por Paypal");
	}

}
