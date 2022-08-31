package com.strategy.impl;

import com.strategy.interfaz.IPago;

public class CreditCard implements IPago{
	
	private String nombre;
	private int numCard;
	private int cvv;
	private String fechaExpira;
	
	public CreditCard(String nombre, int numCard, int cvv, String fechaExpira) {
		this.nombre = nombre;
		this.numCard =  numCard;
		this.cvv = cvv;
		this.fechaExpira = fechaExpira;
	}

	@Override
	public void pago(double monto) {
		System.out.println("El pago de la tarjeta del cliente: " + this.nombre +
				" con un monto: " + monto + " ha sido realizado con éxito");
	}

}
