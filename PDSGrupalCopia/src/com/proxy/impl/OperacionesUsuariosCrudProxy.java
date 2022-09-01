package com.proxy.impl;

import java.sql.SQLException;   
import java.util.List;

import com.prototype.abs.UsuarioBasico;

import com.proxy.interfaz.OperacionesUsuariosCrud;

public class OperacionesUsuariosCrudProxy implements OperacionesUsuariosCrud{
	
	private static OperacionesUsuariosCrudProxy instancia;
	
	private OperacionesUsuariosCrudProxy() {

	       // Hacemos que el constructor sea privado.
	   }
	 
	    public static OperacionesUsuariosCrudProxy getInstance(){
	       if(instancia == null){
	   
	             instancia = new OperacionesUsuariosCrudProxy();
	       }
	        return instancia;
	   }
	
	private OperacionesUsuariosCrudimpl target = new OperacionesUsuariosCrudimpl();

	@Override
	public boolean crear(String usuario, String nombre, String apellido, int edad, String contrasenia)
			throws SQLException {
		boolean crear = target.crear(usuario, nombre, apellido, edad, contrasenia);
		return crear;
	}

	@Override
	public UsuarioBasico leerUsuario(String usuario) throws SQLException, CloneNotSupportedException {
		UsuarioBasico leerUsuario = target.leerUsuario(usuario);
		return leerUsuario;
	}

	@Override
	public boolean actualizar(UsuarioBasico usuarios, String usuario) throws SQLException {
		boolean actualizar = target.actualizar(usuarios, usuario);
		return actualizar;
	}

	@Override
	public boolean eliminar(String usuario) throws SQLException {
		boolean eliminar = target.eliminar(usuario);
		return eliminar;
	}

	@Override
	public List<UsuarioBasico> LeerUsuarios() throws SQLException, CloneNotSupportedException {
		List<UsuarioBasico> leerUsuarios = target.LeerUsuarios();
		return leerUsuarios;
	}

	

	

}
