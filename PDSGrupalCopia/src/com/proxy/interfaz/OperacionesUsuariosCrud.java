package com.proxy.interfaz;

import java.sql.SQLException;
import java.util.List;

import com.prototype.abs.UsuarioBasico;

public interface OperacionesUsuariosCrud {
	
	boolean crear(String usuario,String nombre, String apellido, int edad, String contrasenia )  throws SQLException;
	UsuarioBasico leerUsuario(String usuario) throws SQLException, CloneNotSupportedException;
	boolean actualizar(UsuarioBasico usuarios, String usuario) throws SQLException;
	boolean eliminar (String usuario) throws SQLException;
	List<UsuarioBasico> LeerUsuarios() throws SQLException, CloneNotSupportedException;
	
	

}
