package com.prototype.impl;

import com.prototype.abs.UsuarioBasico;

public class Usuario extends UsuarioBasico{
private static Usuario instancia;


		private Usuario(String usuario, String nombre, String apellido, int edad, String contrasenia) {
			this.usuario = usuario;
			this.nombre = nombre;
			this.apellido = apellido;
			this.edad = edad;
			this.contrasenia = contrasenia;
			}
	   
	 
	    public static Usuario getInstance(){
	       if(instancia == null){
	   
	             instancia = new Usuario("wadiaz","Willan", "Diaz",24,"wadiaz123");
	       }
	        return instancia;
	   }
	
	
	
	@Override
	public UsuarioBasico clone() throws CloneNotSupportedException{
		return (UsuarioBasico)super.clone();
		
	}

}
