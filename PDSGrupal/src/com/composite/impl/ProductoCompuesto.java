package com.composite.impl;

import java.util.ArrayList; 
import java.util.stream.Stream;

import com.composite.interfaz.IPrecio;


public class ProductoCompuesto implements IPrecio{
	
	private ArrayList<IPrecio> productos;
	
	public ProductoCompuesto() {
		
		productos = new ArrayList<IPrecio>();
		
	}
	
	public void addProducto(IPrecio prod) {
		productos.add(prod);
	}
	
	public void removeProducto(IPrecio prod) {
		productos.remove(prod);
	}
	
	public ArrayList<IPrecio> getProductos(){
		return productos;
	}

	@Override
	public double getImporteTotal() {
		Double importeTotal = productos.stream()
				.map(s -> s.getImporteTotal())
				.reduce((double)0, (x,y)-> x= x+y);
		/*
		for(IPrecio it : productos) {
			
			importeTotal += it.getImporteTotal();
			
		}*/
		return importeTotal;
	}

}
