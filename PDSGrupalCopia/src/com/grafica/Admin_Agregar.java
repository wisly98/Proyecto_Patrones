package com.grafica;

import org.eclipse.swt.widgets.Display;  
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.proxy.impl.OperacionesProductosCrudProxy;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Admin_Agregar {
	private Text text_nombre_p;
	private Text text_descrip_p;
	private Text text_cantidad_p;
	private Text text_precio_p;
	private Text text_fecha_caduca;
	private Text text_id;
	private OperacionesProductosCrudProxy pc = OperacionesProductosCrudProxy.getInstance();
	
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() throws SQLException {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(348, 300);
		shell.setText("Plaza la Merced");
		//shell.setImage(SWTResourceManager.getImage(Carrito_Quitar.class, "/com/imagenes/WhatsApp Image 2022-02-19 at 10.30.59.jpeg"));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 332, 260);
		composite.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lbl_pedirdatos = new Label(composite, SWT.NONE);
		lbl_pedirdatos.setFont(SWTResourceManager.getFont("STIXNonUnicode", 7, SWT.NORMAL));
		lbl_pedirdatos.setAlignment(SWT.CENTER);
		lbl_pedirdatos.setBounds(32, 6, 203, 18);
		lbl_pedirdatos.setText("Ingrese los siguientes datos");
		lbl_pedirdatos.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lblNombreProducto = new Label(composite, SWT.NONE);
		lblNombreProducto.setAlignment(SWT.RIGHT);
		lblNombreProducto.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblNombreProducto.setBounds(10, 58, 124, 15);
		lblNombreProducto.setText("Nombre producto:");
		lblNombreProducto.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lblDescripcinProducto = new Label(composite, SWT.NONE);
		lblDescripcinProducto.setAlignment(SWT.RIGHT);
		lblDescripcinProducto.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblDescripcinProducto.setBounds(10, 79, 135, 15);
		lblDescripcinProducto.setText("Descripci\u00F3n:");
		lblDescripcinProducto.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.RIGHT);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblNewLabel_1.setBounds(10, 103, 124, 15);
		lblNewLabel_1.setText("Cantidad producto:");
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.RIGHT);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblNewLabel_2.setBounds(10, 125, 124, 15);
		lblNewLabel_2.setText("Precio producto:");
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lblFechaVencimiento = new Label(composite, SWT.NONE);
		lblFechaVencimiento.setAlignment(SWT.RIGHT);
		lblFechaVencimiento.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblFechaVencimiento.setBounds(10, 148, 124, 15);
		lblFechaVencimiento.setText("Expira:");
		lblFechaVencimiento.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		text_nombre_p = new Text(composite, SWT.BORDER);
		text_nombre_p.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_nombre_p.setBounds(151, 54, 124, 21);
		
		text_descrip_p = new Text(composite, SWT.BORDER);
		text_descrip_p.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_descrip_p.setBounds(151, 77, 124, 21);
		
		text_cantidad_p = new Text(composite, SWT.BORDER);
		text_cantidad_p.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_cantidad_p.setBounds(151, 100, 124, 21);
		
		text_precio_p = new Text(composite, SWT.BORDER);
		text_precio_p.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_precio_p.setBounds(151, 123, 124, 21);
		
		text_fecha_caduca = new Text(composite, SWT.BORDER);
		text_fecha_caduca.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_fecha_caduca.setBounds(151, 146, 124, 21);
		
		text_id = new Text(composite, SWT.BORDER);
		text_id.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_id.setBounds(151, 30, 124, 21);
		
		Label message = new Label(composite, SWT.NONE);
		message.setForeground(SWTResourceManager.getColor(255, 0, 0));
		message.setBounds(10, 201, 184, 25);
		message.setBackground(SWTResourceManager.getColor(255, 255, 224));

		
		Button btnAgregar = new Button(composite, SWT.NONE);
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				
				
			if(text_id.getText().equals(null) && text_nombre_p.getText().equals(null) && text_cantidad_p.getText().equals(null) && text_precio_p.getText().equals(null) && text_fecha_caduca.getText().equals(null)) {
				message.setText("Error al ingresar");
				text_id.setText("");
				text_id.setText("");
				text_nombre_p.setText("");
				text_descrip_p.setText("");
				text_cantidad_p.setText("");
				text_precio_p.setText("");
				text_fecha_caduca.setText("");
				
			}else {
				
					try {
						pc.crear(Integer.parseInt(text_id.getText()),text_nombre_p.getText(),text_descrip_p.getText(),Integer.parseInt(text_cantidad_p.getText()),Double.parseDouble(text_precio_p.getText()),text_fecha_caduca.getText());
						message.setText("Producto ingresado correctamente");
						text_id.setText("");
						text_nombre_p.setText("");
						text_descrip_p.setText("");
						text_cantidad_p.setText("");
						text_precio_p.setText("");
						text_fecha_caduca.setText("");
					} catch (NumberFormatException | SQLException e1) {
						
						e1.printStackTrace();
						message.setText("Error al ingresar");
					}
				
				}
			}
		});
		btnAgregar.setBounds(227, 196, 75, 25);
		btnAgregar.setText("Agregar");
		
		Button btnCancelar = new Button(composite, SWT.NONE);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
				
			}
		});
		btnCancelar.setBounds(227, 227, 75, 25);
		btnCancelar.setText("Regresar");
		
		Label lblIdProducto = new Label(composite, SWT.NONE);
		lblIdProducto.setAlignment(SWT.RIGHT);
		lblIdProducto.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblIdProducto.setText("ID producto:");
		lblIdProducto.setBounds(10, 37, 124, 15);
		lblIdProducto.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
