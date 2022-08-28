package com.proxy.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.conexion.Conexion;
import com.crud.pds.Productos;
import com.proxy.interfaz.OperacionesPoductosCrud;



public class OperacionesProductosCrudimpl implements OperacionesPoductosCrud{
	private Connection connection;
	private PreparedStatement sentencia;
	private boolean estadoOp;
	@Override
	public boolean crear(int id, String nombre, String descripcion, int cantidad, double precio, String fecha_v) throws SQLException {
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			
			connection.setAutoCommit(false);
			sql = "INSERT INTO productos(id,nombre,descripcion,cantidad,precio,fecha_caduca) VALUES(?,?,?,?,?,?)";
			sentencia= connection.prepareStatement(sql);
			
			sentencia.setInt(1, id);
			sentencia.setString(2, nombre);
			sentencia.setString(3, descripcion);
			sentencia.setInt(4, cantidad);
			sentencia.setDouble(5, precio);
			sentencia.setString(6,fecha_v);
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
	public Productos leerProducto(int idProducto) throws SQLException {
		String sql = null;
		ResultSet resultSet = null;
		Productos p = new Productos();
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			sql = "select * from productos where id = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, idProducto);
			estadoOp= true;
			resultSet = sentencia.executeQuery(); // select * from prodcutos where id = ?
			if(resultSet.next()) {//id nombre 3 1.4
				p.setId(resultSet.getInt(1));
				p.setNombre(resultSet.getString(2));
				p.setDescripcion(resultSet.getString(3));
				p.setCantidad(resultSet.getInt(4));
				p.setPrecio(resultSet.getDouble(5));
				p.setFecha_caduca(resultSet.getString(6));
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
	public boolean actualizar(Productos produc, int id)throws SQLException  {
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE productos SET nombre = ?, descripcion = ?, cantidad = ?, precio = ?, fecha_caduca = ?"
					+ "WHERE id = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setString(1, produc.getNombre());
			sentencia.setString(2, produc.getDescripcion());
			sentencia.setInt(3, produc.getCantidad());
			sentencia.setDouble(4, produc.getPrecio());
			sentencia.setInt(6, id);
			sentencia.setString(5,produc.getFecha_caduca());
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
	public boolean eliminar(int id)throws SQLException  {
		String sql = null;
		estadoOp = false;
		connection = obtenerConexion();
		
		try {
			
			connection.setAutoCommit(false);
			sql = "DELETE FROM productos WHERE id = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, id);
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
	public List<Productos> LeerProductos() throws SQLException {
		String sql = null;
        ResultSet resultSet = null;
        connection = obtenerConexion();
        List<Productos> listaProductos = new ArrayList<>();
        connection = obtenerConexion();

        try {
            sql = "SELECT * FROM productos";
            sentencia = connection.prepareStatement(sql);
            resultSet = sentencia.executeQuery();
            resultSet.next();
            do {
                Productos auxProd = new Productos();
                auxProd.setId(resultSet.getInt(1));
                auxProd.setCantidad(resultSet.getInt(4));
                auxProd.setDescripcion(resultSet.getString(3));
                auxProd.setPrecio(resultSet.getDouble(5));
                auxProd.setNombre(resultSet.getString(2));
                auxProd.setFecha_caduca(resultSet.getString(6));
                listaProductos.add(auxProd);
                //System.out.println(auxProd);
            } while (resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
            sentencia.close();
        }
        return listaProductos;
	}
	

	private Connection obtenerConexion() throws SQLException{
		
		return Conexion.getConnection();
	}

}
