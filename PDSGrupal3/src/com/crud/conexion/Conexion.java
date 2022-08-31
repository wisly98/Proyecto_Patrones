package com.crud.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private static String url;
	private static String usuario ;
	private static String contrasenia ;
	private static boolean valid = false;
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
		if(connection == null) {
			try {
				try {
					
					Class.forName("org.postgresql.Driver");
					
				}catch(ClassNotFoundException ex) {
					System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
				}
				
				connection = DriverManager.getConnection(url, usuario, contrasenia);
				
				valid = connection.isValid(50000);
				System.out.println(valid ? "CONEXIÓN VÁLIDA" : "CONEXIÓN FALLIDA");
				
			}catch(java.sql.SQLException sqle){
				System.out.println("Error: " + sqle);
			}
		}
		
		return connection;
		
	}


	public Object getUsuario() {
		
		return usuario;
	}


	public Object getContrasenia() {
		
		return contrasenia;
	}


	public static void setUsuario(String usuario) {
		Conexion.usuario = usuario;
	}


	public static void setContrasenia(String contrasenia) {
		Conexion.contrasenia = contrasenia;
	}


	public static boolean isValid() {
		return valid;
	}


	public static void setValid(boolean valid) {
		Conexion.valid = valid;
	}


	public static String getUrl() {
		return url;
	}


	public static void setUrl(String url) {
		Conexion.url = url;
	}
	
	
	

}
