package com.composite.impl;

import com.composite.interfaz.IPrecio;
import com.crud.pds.Productos;

public class ProductoPeso extends Productos implements IPrecio{
	
	
	public ProductoPeso(double peso, double precioPeso, String nombre, String categoria) {
		
		this.setCantidad((int) peso);
		this.setPrecio(precioPeso);
		this.setNombre(nombre);
		this.setDescripcion(categoria);
		
	}

	@Override
	public double getImporteTotal() {
		
		return this.getPrecio()*this.getCantidad();
	}

	
}
