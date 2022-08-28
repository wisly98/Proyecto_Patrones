package com.composite.impl;

import java.util.ArrayList; 
import java.util.stream.Stream;

import com.composite.interfaz.IPrecio;
import com.crud.pds.Productos;


public class Carrito implements IPrecio{
	
	private ArrayList<Productos> productos;
	
	public Carrito() {
		
		productos = new ArrayList<Productos>();
		
	}
	
	public void addProduct(Productos prod) {
		productos.add(prod);
	}
	
	public void removeProducto(Productos prod) {
		productos.remove(prod);
	}
	
	public ArrayList<Productos> getProductos(){
		return productos;
	}
	
	public Productos getProducto(String nombre) {
		Productos producto = null;
		for(int i = 0; i < productos.size(); i++) {
			if(productos.get(i).getNombre().equals(nombre)) {
				producto = productos.get(i);
			}
			
		}
		return producto;
	}

	@Override
	public double getImporteTotal() {
		Double importeTotal = 0.0;

		for(Productos it : productos) {
			
			importeTotal += ((IPrecio) it).getImporteTotal();
			
		}
		return importeTotal;
	}

}
