package com.prototype.abs;

public abstract class UsuarioBasico implements Cloneable{
	protected String usuario;
	protected String nombre;
	protected String apellido;
	protected int edad;
	public String contrasenia;
	
		
	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public UsuarioBasico clone() throws CloneNotSupportedException{
		return (UsuarioBasico)super.clone();
	}

}
