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
		
	
		
		OperacionesPoductosCrud op = OperacionesFactory.crearOperaciones(OperacionesPoductosCrud.class);
		
	
		try {
			Inicia window = new Inicia();
			window.open();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
