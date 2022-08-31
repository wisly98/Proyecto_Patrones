package com.proxy.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.conexion.Conexion;
import com.prototype.abs.UsuarioBasico;
import com.prototype.impl.Usuario;
import com.proxy.interfaz.OperacionesUsuariosCrud;

public class OperacionesUsuariosCrudimpl implements OperacionesUsuariosCrud {
	private UsuarioBasico p = Usuario.getInstance();
	private Connection connection;
	private PreparedStatement sentencia;
	private boolean estadoOp;

	@Override
	public boolean crear(String usuario, String nombre, String apellido, int edad, String contrasenia)
			throws SQLException {
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			
			connection.setAutoCommit(false);
			sql = "INSERT INTO usuarios(usuario,nombre,apellido,edad,contraseña) VALUES(?,?,?,?,?)";
			sentencia= connection.prepareStatement(sql);
			
			sentencia.setString(1, usuario);
			sentencia.setString(2, nombre);
			sentencia.setString(3, apellido);
			sentencia.setInt(4, edad);
			sentencia.setString(5, contrasenia);
			estadoOp =  sentencia.executeUpdate() > 0;
			
			connection.commit();
			sentencia.close();
	
		}catch(SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}finally {
			connection.close();
		}
		
		return estadoOp;
	}

	@Override
	public UsuarioBasico leerUsuario(String usuario) throws SQLException, CloneNotSupportedException {
		String sql = null;
		ResultSet resultSet = null;
		UsuarioBasico usuarioClon0;
		usuarioClon0 = p.clone();
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			sql = "select * from usuarios where usuario = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setString(1, usuario);
			estadoOp= true;
			resultSet = sentencia.executeQuery(); // select * from prodcutos where id = ?
			if(resultSet.next()) {//id nombre 3 1.4
				p.setUsuario(resultSet.getString(1));
				p.setNombre(resultSet.getString(2));
				p.setApellido(resultSet.getString(3));
				p.setEdad(resultSet.getInt(4));
				p.setContrasenia(resultSet.getString(5));
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
			sentencia.close();
		}
		
		return p;
	}

	@Override
	public boolean actualizar(UsuarioBasico usuarios, String usuario) throws SQLException {
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE usuarios SET nombre = ?, apellido = ?, edad = ?, contraseña = ?"
					+ "WHERE usuario = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setString(1, usuarios.getNombre());
			sentencia.setString(2, usuarios.getApellido());
			sentencia.setInt(3, usuarios.getEdad());
			sentencia.setString(4, usuarios.getContrasenia());
			sentencia.setString(5, usuario);
		
			estadoOp = sentencia.executeUpdate() > 0;
			
			connection.commit();
			
		}catch(SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}finally {
			sentencia.close();
			connection.close();
		}
		return estadoOp;
	}

	@Override
	public boolean eliminar(String usuario) throws SQLException {
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			
			connection.setAutoCommit(false);
			sql = "DELETE FROM usuarios WHERE usuario = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setString(1, usuario);
			estadoOp = sentencia.executeUpdate() > 0;
			connection.commit();
			
		}catch(SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}finally {
			sentencia.close();
			connection.close();
		}
		
		return estadoOp;
	}

	@Override
	public List<UsuarioBasico> LeerUsuarios() throws SQLException, CloneNotSupportedException {
		 String sql = null;
	        ResultSet resultSet = null;
	        connection = obtenerConexion();
	        
	        List<UsuarioBasico> listaUsuarios = new ArrayList<>();
	        connection = obtenerConexion();

	        try {
	            sql = "SELECT * FROM usuarios";
	            sentencia = connection.prepareStatement(sql);
	            resultSet = sentencia.executeQuery();
	            resultSet.next();
	            do {
	                UsuarioBasico usuarioClon = p.clone();
	                usuarioClon.setUsuario(resultSet.getString(1));
	                usuarioClon.setNombre(resultSet.getString(2));
	                usuarioClon.setApellido(resultSet.getString(3));
	                usuarioClon.setEdad(resultSet.getInt(4));
	                usuarioClon.setContrasenia(resultSet.getString(5));
	               
	                listaUsuarios.add(usuarioClon);
	                //System.out.println(auxProd);
	            } while (resultSet.next());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            connection.close();
	            sentencia.close();
	        }
	        return listaUsuarios;
	}


	private Connection obtenerConexion() throws SQLException{
		
		return Conexion.getConnection();
	}
}
