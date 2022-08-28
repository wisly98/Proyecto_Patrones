package com.builder.pds;

import com.builder.abs.ProductoBuilder;

public class ProductoDirector {
	private ProductoBuilder carritoB;
	
	public void constructCarrito() {
		
		carritoB.buildProductoUnitario();
		carritoB.buildProductoPeso();		
		
	}

	public ProductoBuilder getAutoB() {
		return carritoB;
	}

	public void setAutoB(ProductoBuilder carritoB) {
		this.carritoB = carritoB;
	}
	
	

}
