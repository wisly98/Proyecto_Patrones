package com.proxy.impl;

import java.sql.SQLException; 
import java.util.List;

import com.crud.pds.Productos;
import com.proxy.interfaz.OperacionesPoductosCrud;

public class OperacionesProductosCrudProxy implements OperacionesPoductosCrud{
	
	private static OperacionesProductosCrudProxy instancia;
	
	private OperacionesProductosCrudProxy() {

	       // Hacemos que el constructor sea privado.
	   }
	 
	    public static OperacionesProductosCrudProxy getInstance(){
	       if(instancia == null){
	   
	             instancia = new OperacionesProductosCrudProxy();
	       }
	        return instancia;
	   }
	
	private OperacionesProductosCrudimpl target = new OperacionesProductosCrudimpl();

	@Override
	public boolean crear(int id, String nombre, String descripcion, int cantidad, double precio, String fecha_v)
			throws SQLException {
		boolean crear =target.crear(id, nombre, descripcion, cantidad, precio, fecha_v);
		return crear;
	}

	@Override
	public Productos leerProducto(int idProducto) throws SQLException {
		Productos leerProducto = target.leerProducto(idProducto);
		return leerProducto;
	}

	@Override
	public boolean actualizar(Productos produc, int id) throws SQLException {
		boolean actualizar = target.actualizar(produc, id);
		return actualizar;
	}

	@Override
	public boolean eliminar(int id) throws SQLException {
		boolean eliminar = target.eliminar(id);
		return eliminar;
	}

	@Override
	public List<Productos> LeerProductos() throws SQLException {
		List<Productos> leerProductos = target.LeerProductos();
		return leerProductos;
	}

}
