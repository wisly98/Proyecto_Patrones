package com.builder.pds;

import java.util.ArrayList;

import com.crud.pds.Productos;

public class Producto{
	
	
	private ArrayList<Productos> productos;
	
	public Producto() {
		productos = new ArrayList<Productos>();
	}
	
	public void add(Productos prod) {
		productos.add(prod);
	
	}
	
	public void mostrar() {
		System.out.println("El auto está formado por: ");
		for(int i = 0; i < productos.size(); i++) {
			System.out.println(productos.get(i));
		}
	}
		

}
