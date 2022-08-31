package com.strategy.impl;

import com.strategy.interfaz.IPago;

public class Transferencia implements IPago{
	
	private String nombre;
	private String numCuenta;
	
	public Transferencia(String nombre, String numCuenta) {
		this.nombre = nombre;
		this.numCuenta = numCuenta;
	}
	@Override
	public void pago(double monto) {
		System.out.println(this.nombre + " ha transferido " + monto +
				" desde la cuenta" + this.numCuenta);
	}

}
