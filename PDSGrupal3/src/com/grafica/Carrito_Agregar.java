package com.grafica;

import org.eclipse.swt.widgets.Display;  
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import com.composite.impl.CarritoCompuesto;
import com.crud.pds.Productos;
import com.proxy.impl.OperacionesProductosCrudProxy;

import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Carrito_Agregar {
	private List<Productos> aux = new ArrayList<Productos>();
	private List<Productos> productos = new ArrayList<Productos>();
	private OperacionesProductosCrudProxy pc = OperacionesProductosCrudProxy.getInstance();
	private CarritoCompuesto pro = CarritoCompuesto.getInstance();

	public void open() {
		try {
			aux = pc.LeerProductos();
			productos = pc.LeerProductos();
			for(var i : aux) {
				pro.addProduct(i);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(615, 442);
		shell.setText("SWT Application");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 598, 403);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNewLabel.setBounds(243, 0, 124, 25);
		lblNewLabel.setText("Agregar Productos");
		
		Label img_arroz = new Label(composite, SWT.NONE);
		img_arroz.setImage(SWTResourceManager.getImage(Carrito_Agregar.class, "/com/imagenes/arroz.jpg"));
		img_arroz.setBounds(10, 33, 111, 97);
		
		Label img_ = new Label(composite, SWT.NONE);
		img_.setImage(SWTResourceManager.getImage(Carrito_Agregar.class, "/com/imagenes/atun.jpg"));
		img_.setBounds(162, 31, 111, 97);
		
		Label img_jamon = new Label(composite, SWT.NONE);
		img_jamon.setImage(SWTResourceManager.getImage(Carrito_Agregar.class, "/com/imagenes/jamon.jpg"));
		img_jamon.setBounds(312, 31, 111, 97);
		
		Label img_cocacola = new Label(composite, SWT.NONE);
		img_cocacola.setImage(SWTResourceManager.getImage(Carrito_Agregar.class, "/com/imagenes/cocacola.jpg"));
		img_cocacola.setBounds(471, 33, 111, 97);
		
		Label img_pepsi = new Label(composite, SWT.NONE);
		img_pepsi.setImage(SWTResourceManager.getImage(Carrito_Agregar.class, "/com/imagenes/pepsi.jpg"));
		img_pepsi.setBounds(10, 200, 111, 97);
		
		Label img_salchicha = new Label(composite, SWT.NONE);
		img_salchicha.setImage(SWTResourceManager.getImage(Carrito_Agregar.class, "/com/imagenes/salchicha.jpg"));
		img_salchicha.setBounds(162, 200, 111, 97);
		
		Label img_yogurt = new Label(composite, SWT.NONE);
		img_yogurt.setImage(SWTResourceManager.getImage(Carrito_Agregar.class, "/com/imagenes/yogurt.jpg"));
		img_yogurt.setBounds(312, 200, 111, 97);
		
		Label img_pollo = new Label(composite, SWT.NONE);
		img_pollo.setImage(SWTResourceManager.getImage(Carrito_Agregar.class, "/com/imagenes/pollo.jpg"));
		img_pollo.setBounds(471, 200, 111, 97);
		
		Spinner libras_arroz = new Spinner(composite, SWT.BORDER);
		libras_arroz.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		libras_arroz.setBounds(74, 140, 47, 22);
		
		Label arroz = new Label(composite, SWT.NONE);
		arroz.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		arroz.setBounds(10, 143, 55, 15);
		arroz.setText("Arroz");
		
		Label atun = new Label(composite, SWT.NONE);
		atun.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		atun.setBounds(162, 143, 55, 15);
		atun.setText("At\u00FAn");
		
		Spinner cantidad_atun = new Spinner(composite, SWT.BORDER);
		cantidad_atun.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		cantidad_atun.setBounds(223, 140, 47, 22);
		
		Label jamon = new Label(composite, SWT.NONE);
		jamon.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		jamon.setBounds(312, 143, 55, 15);
		jamon.setText("Jam\u00F3n");
		
		Spinner libras_jamon = new Spinner(composite, SWT.BORDER);
		libras_jamon.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		libras_jamon.setBounds(373, 140, 47, 22);
		
		Label cocacola = new Label(composite, SWT.NONE);
		cocacola.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		cocacola.setBounds(471, 143, 58, 15);
		cocacola.setText("Coca Cola");
		
		Spinner cantidad_cocacola = new Spinner(composite, SWT.BORDER);
		cantidad_cocacola.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		cantidad_cocacola.setBounds(535, 140, 47, 22);
		
		Label lblLb = new Label(composite, SWT.NONE);
		lblLb.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblLb.setBounds(127, 143, 21, 15);
		lblLb.setText("lb");
		
		Label lblLb_1 = new Label(composite, SWT.NONE);
		lblLb_1.setText("lb");
		lblLb_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblLb_1.setBounds(428, 143, 21, 15);
		
		Label lblPepsi = new Label(composite, SWT.NONE);
		lblPepsi.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblPepsi.setBounds(10, 303, 55, 15);
		lblPepsi.setText("Pepsi");
		
		Spinner cantidad_pepsi = new Spinner(composite, SWT.BORDER);
		cantidad_pepsi.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		cantidad_pepsi.setBounds(74, 300, 47, 22);
		
		Label salchicha = new Label(composite, SWT.NONE);
		salchicha.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		salchicha.setBounds(162, 303, 55, 15);
		salchicha.setText("Salchicha");
		
		Spinner libras_salchicha = new Spinner(composite, SWT.BORDER);
		libras_salchicha.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		libras_salchicha.setBounds(226, 300, 47, 22);
		
		Label lblLb_2 = new Label(composite, SWT.NONE);
		lblLb_2.setText("lb");
		lblLb_2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblLb_2.setBounds(279, 303, 21, 15);
		
		Label yogurt = new Label(composite, SWT.NONE);
		yogurt.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		yogurt.setBounds(312, 303, 55, 17);
		yogurt.setText("Yogurt");
		
		Spinner cantidad_yogurt = new Spinner(composite, SWT.BORDER);
		cantidad_yogurt.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		cantidad_yogurt.setBounds(373, 300, 47, 22);
		
		Label pollo = new Label(composite, SWT.NONE);
		pollo.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		pollo.setBounds(471, 303, 40, 15);
		pollo.setText("Pollo");
		
		Spinner libras_pollo = new Spinner(composite, SWT.BORDER);
		libras_pollo.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		libras_pollo.setBounds(517, 300, 47, 22);
		
		Label lblLb_2_1 = new Label(composite, SWT.NONE);
		lblLb_2_1.setText("lb");
		lblLb_2_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblLb_2_1.setBounds(567, 303, 21, 15);
		
		Label msj_ar = new Label(composite, SWT.NONE);
		msj_ar.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		msj_ar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		msj_ar.setBounds(10, 164, 111, 15);
		
		Label msj_a = new Label(composite, SWT.NONE);
		msj_a.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		msj_a.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		msj_a.setBounds(162, 164, 111, 15);
		
		Label msj_j = new Label(composite, SWT.NONE);
		msj_j.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		msj_j.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		msj_j.setBounds(312, 164, 111, 15);
		
		Label msj_c = new Label(composite, SWT.NONE);
		msj_c.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		msj_c.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		msj_c.setBounds(471, 164, 111, 15);
		
		Label msj_p = new Label(composite, SWT.NONE);
		msj_p.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		msj_p.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		msj_p.setBounds(10, 324, 111, 15);
		
		Label msj_s = new Label(composite, SWT.NONE);
		msj_s.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		msj_s.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		msj_s.setBounds(162, 324, 111, 15);
		
		Label msj_y = new Label(composite, SWT.NONE);
		msj_y.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		msj_y.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		msj_y.setBounds(312, 326, 111, 15);
		
		Label msj_pl = new Label(composite, SWT.NONE);
		msj_pl.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		msj_pl.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		msj_pl.setBounds(471, 324, 111, 15);
		
		Label label_msj = new Label(composite, SWT.NONE);
		label_msj.setAlignment(SWT.CENTER);
		label_msj.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_msj.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_msj.setBounds(187, 345, 213, 22);
		
		Button btnAgregar = new Button(composite, SWT.NONE);
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//Compara la cantidad querida, con la canitdad de la base de datos para agregar y saber si hay disponible esa cantidad
				//Arroz
				if(Integer.parseInt(libras_arroz.getText()) > productos.get(0).getCantidad()){
					msj_ar.setText("No disponible");
				}else {
					pro.getProductos().get(0).setCantidad(pro.getProductos().get(0).getCantidad() + Integer.parseInt(libras_arroz.getText()));
					msj_ar.setText("");
				}
				//Atun
				if(Integer.parseInt(cantidad_atun.getText())> productos.get(1).getCantidad()) {
					msj_a.setText("No disponible");
				}else {
					pro.getProductos().get(1).setCantidad(pro.getProductos().get(1).getCantidad() + Integer.parseInt(cantidad_atun.getText()));
					msj_a.setText("");
				}
				//Jamon
				if(Integer.parseInt(libras_jamon.getText())>productos.get(2).getCantidad()) {
					msj_j.setText("No disponible");
				}else {
					pro.getProductos().get(2).setCantidad(pro.getProductos().get(2).getCantidad() + Integer.parseInt(libras_jamon.getText()));
					msj_j.setText("");
				}
				//CocaCola
				if(Integer.parseInt(cantidad_cocacola.getText())>productos.get(3).getCantidad()) {
					msj_c.setText("No disponible");
				}else {
					pro.getProductos().get(3).setCantidad(pro.getProductos().get(3).getCantidad() + Integer.parseInt(cantidad_cocacola.getText()));
					msj_c.setText("");
				}
				//Pepsi
				if(Integer.parseInt(cantidad_pepsi.getText())>productos.get(4).getCantidad()) {
					msj_p.setText("No disponible");
				}else {
					pro.getProductos().get(4).setCantidad(pro.getProductos().get(4).getCantidad() + Integer.parseInt(cantidad_pepsi.getText()));
					msj_p.setText("");
				}
				//Salchicha
				if(Integer.parseInt(libras_salchicha.getText())>productos.get(5).getCantidad()) {
					msj_s.setText("Nom disponible");
				}else {
					pro.getProductos().get(5).setCantidad(pro.getProductos().get(5).getCantidad() + Integer.parseInt(libras_salchicha.getText()));
					msj_s.setText("");
				}
				//Yogurt
				if(Integer.parseInt(cantidad_yogurt.getText())>productos.get(6).getCantidad()) {
					msj_y.setText("No disponible");
				}else {
					pro.getProductos().get(6).setCantidad(pro.getProductos().get(6).getCantidad() + Integer.parseInt(cantidad_yogurt.getText()));
					msj_y.setText("");
				}
				//Pollo
				if(Integer.parseInt(libras_pollo.getText())>productos.get(7).getCantidad()) {
					msj_pl.setText("No disponible");
				}else {
					pro.getProductos().get(7).setCantidad(pro.getProductos().get(7).getCantidad() + Integer.parseInt(libras_pollo.getText()));
					msj_pl.setText("");
				}
				
				label_msj.setText("Se agrego correctamente");
			}
		});
		btnAgregar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnAgregar.setBounds(198, 368, 75, 25);
		btnAgregar.setText("Agregar");
		
		Button btnRegresar = new Button(composite, SWT.NONE);
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
			}
		});
		btnRegresar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnRegresar.setBounds(312, 368, 75, 25);
		btnRegresar.setText("Regresar");
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
