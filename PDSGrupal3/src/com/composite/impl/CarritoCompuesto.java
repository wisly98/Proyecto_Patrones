package com.composite.impl;

import java.util.ArrayList;  
import com.composite.interfaz.IPrecio;
import com.crud.pds.Productos;



public class CarritoCompuesto implements IPrecio{

	private ArrayList<Productos> productos;
	private static CarritoCompuesto instancia;
	
	private CarritoCompuesto() {
		
	
		productos = new ArrayList<Productos>();
	   }
	 
	    public static CarritoCompuesto getInstance(){
	       if(instancia == null){
	   
	             instancia = new CarritoCompuesto();
	       }
	        return instancia;
	   }
	
	
	
	public void addProduct(Productos prod) {
		productos.add(prod);
		prod.setCantidad(0);
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
		
		for(int i = 0; i<productos.size();i++) {
			importeTotal = importeTotal + (productos.get(i).getCantidad()*productos.get(i).getPrecio());
			productos.get(i).setTotalProducto(productos.get(i).getCantidad()*productos.get(i).getPrecio());
		}
				
		return importeTotal ;
	}

}
