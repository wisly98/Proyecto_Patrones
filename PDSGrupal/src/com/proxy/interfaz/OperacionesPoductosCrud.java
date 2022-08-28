package com.proxy.interfaz;

import java.sql.SQLException;
import java.util.List;

import com.crud.pds.Productos;

public interface OperacionesPoductosCrud {
	
	boolean crear(int id,String nombre, String descripcion, int cantidad, double precio, String fecha_v )throws SQLException ;
	Productos leerProducto(int idProducto)throws SQLException ;
	boolean actualizar(Productos produc, int id)throws SQLException ;
	boolean eliminar (int id)throws SQLException ;
	List<Productos> LeerProductos()throws SQLException ;


}
