package com.crud.pds;

public class Productos {
	
	private int id;
	private String nombre;
	private String descripcion;
	private int cantidad;
	private double precio;
	private String fecha_caduca;
	
	public Productos() {
		
		
	}
	
	public Productos(int id, String nombre, int cantidad, double precio) {
		
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("ID: " )
		.append(id)
		.append(" Nombre: ")
		.append(nombre)
		.append(" Cantidad: ")
		.append(cantidad)
		.append(" precio: ")
		.append(precio)
		.append(" Fecha caduca: ")
		.append(fecha_caduca)
		.append("\n");
		return sb.toString();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha_caduca() {
		return fecha_caduca;
	}

	public void setFecha_caduca(String fecha_caduca) {
		this.fecha_caduca = fecha_caduca;
	}
	
	
	
}
