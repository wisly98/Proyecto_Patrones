package com.composite.impl;

import com.composite.interfaz.IPrecio;
import com.crud.pds.Productos;

public class ProductoUnitario extends Productos implements IPrecio{

	
	public ProductoUnitario(int cantidad, double precio, String nombre, String categoria) {
		this.setCantidad(cantidad);
		this.setPrecio(precio);
		this.setNombre(nombre);
		this.setDescripcion(categoria);
		
		
	}

	@Override
	public double getImporteTotal() {
		
		return this.getCantidad()*this.getPrecio();
	}

		
}
