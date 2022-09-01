package com.crud.pds;

import java.sql.SQLException;    

import com.crud.conexion.Conexion;
import com.grafica.Admin;
import com.grafica.Inicia;
import com.proxy.factory.OperacionesFactory;
import com.proxy.impl.OperacionesProductosCrudProxy;
import com.proxy.interfaz.OperacionesPoductosCrud;

public class PrincipalCrud {

	public static void main(String[] args) throws SQLException {
		OperacionesProductosCrudProxy opPro = OperacionesProductosCrudProxy.getInstance();
		
		/*
		 * OperacionesNumeros, OperacionesNumerosImpl
		 * OperacionesNumeros, OperacionesLetrasImpl
		 * 
		 */
	/*	
		OperacionesNumeros op = new OperacionesNumerosimpl();
		OperacionesNumeros op2 = new OperacionesLetrasImpl();
		int suma = opPro.sumar(10, 5);
		System.out.println(suma); */
		
		OperacionesPoductosCrud op = OperacionesFactory.crearOperaciones(OperacionesPoductosCrud.class);
		
		//a.getConnection();
		
		/*
		Productos produc = new Productos(3,"CocaCola", 15,2.3);
		Productos produc3 = new Productos(3,"Azúcar", 3,1.3);
		
		ProductosCrud pc = new ProductosCrud();
		
		/*boolean cone = pc.actualizar(produc3, 2);
		System.out.println(cone);*/
		/*boolean cone = pc.crear(produc);
		produc = pc.leerProducto(1);
		System.out.println(produc);
		
		boolean cone = pc.eliminar(4);
		System.out.println(cone);
		*/
		//produc = pc.leerProducto(1);
		try {
			Inicia window = new Inicia();
			window.open();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
