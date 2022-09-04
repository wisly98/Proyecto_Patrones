package com.grafica;

import java.sql.SQLException;  

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.crud.pds.Productos;
import com.proxy.impl.OperacionesProductosCrudProxy;


import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Admin_Actualizar {
	private Text text_nombre;
	private Text text_descr;
	private Text text_cantidad;
	private Text text_precio;
	private Text text_expira;
	
	private OperacionesProductosCrudProxy pc = OperacionesProductosCrudProxy.getInstance();	
	private Productos p ;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(Admin_Actualizar.class, "/com/imagenes/logo.jpeg"));
		shell.setSize(450, 329);
		shell.setText("Plaza la Merced");
		//shell.setImage(SWTResourceManager.getImage(Carrito_Quitar.class, "/com/imagenes/WhatsApp Image 2022-02-19 at 10.30.59.jpeg"));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 435, 290);
		composite.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		
		Label lbl_ingrese = new Label(composite, SWT.NONE);
		lbl_ingrese.setBounds(10, 10, 149, 15);
		lbl_ingrese.setText("Ingrese el ID del producto");
		lbl_ingrese.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lbl_ingrese.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.NORMAL));
		
		Label label_mensaje = new Label(composite, SWT.NONE);
		label_mensaje.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_mensaje.setAlignment(SWT.CENTER);
		label_mensaje.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_mensaje.setBounds(99, 87, 234, 15);
		
		
		Text text_id = new Text(composite, SWT.BORDER | SWT.CENTER);
		text_id.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_id.setBounds(10, 31, 415, 21);
		text_id.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		
		Label lblNombre = new Label(composite, SWT.NONE);
		lblNombre.setBounds(10, 129, 55, 15);
		lblNombre.setText("Nombre:");
		lblNombre.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lblNombre.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		
		Label lblDescripcin = new Label(composite, SWT.NONE);
		lblDescripcin.setBounds(10, 150, 75, 15);
		lblDescripcin.setText("Descripci\u00F3n:");
		lblDescripcin.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lblDescripcin.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		
		Label lblCantidad = new Label(composite, SWT.NONE);
		lblCantidad.setBounds(10, 170, 55, 15);
		lblCantidad.setText("Cantidad:");
		lblCantidad.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lblCantidad.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		
		
		Label lblPrecio = new Label(composite, SWT.NONE);
		lblPrecio.setBounds(10, 191, 55, 15);
		lblPrecio.setText("Precio:");
		lblPrecio.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lblPrecio.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		
		Label lblExpira = new Label(composite, SWT.NONE);
		lblExpira.setText("Expira:");
		lblExpira.setBounds(10, 212, 55, 15);
		lblExpira.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lblExpira.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		
		text_nombre = new Text(composite, SWT.BORDER);
		text_nombre.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_nombre.setBounds(105, 123, 211, 21);
		
		text_descr = new Text(composite, SWT.BORDER);
		text_descr.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_descr.setBounds(105, 144, 211, 21);
		
		text_cantidad = new Text(composite, SWT.BORDER);
		text_cantidad.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_cantidad.setBounds(105, 164, 211, 21);
		
		text_precio = new Text(composite, SWT.BORDER);
		text_precio.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_precio.setBounds(105, 185, 211, 21);
		
		text_expira = new Text(composite, SWT.BORDER);
		text_expira.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_expira.setBounds(105, 206, 211, 21);
		
		Label obten_id = new Label(composite, SWT.NONE);
		obten_id.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		obten_id.setBounds(106, 108, 210, 15);
		obten_id.setBackground(SWTResourceManager.getColor(255, 255, 224));

		Label label_actualizado = new Label(composite, SWT.NONE);
		label_actualizado.setForeground(SWTResourceManager.getColor(255, 0, 0));
		label_actualizado.setBounds(124, 233, 167, 15);
		label_actualizado.setBackground(SWTResourceManager.getColor(255, 255, 224));
				
		Button btnBuscar = new Button(composite, SWT.NONE);
		btnBuscar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

			
				label_mensaje.setText("");
				label_actualizado.setText("");
					 try {
						p = pc.leerProducto(Integer.parseInt(text_id.getText()));
						if(p.getId() == 0) {
							label_mensaje.setText("ID ingresado no corresponde a ningún producto");
						}else {
							obten_id.setText(Integer.toString(p.getId()));
							text_nombre.setText(p.getNombre());
							text_descr.setText(p.getDescripcion());
							text_cantidad.setText(Integer.toString(p.getCantidad()));
							text_precio.setText(Double.toString(p.getPrecio()));
							text_expira.setText(p.getFecha_caduca());
							label_mensaje.setText("");
						}
					} catch (NumberFormatException | SQLException e1) {
						e1.printStackTrace();
						label_mensaje.setText("ID ingresado no corresponde a ningún producto");
					}
			}
		});
		btnBuscar.setBounds(174, 58, 75, 25);
		btnBuscar.setText("Buscar");
		
		
		
		Button btnActualizar = new Button(composite, SWT.NONE);
		btnActualizar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnActualizar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
					p.setNombre(text_nombre.getText());
					p.setDescripcion(text_descr.getText());
					p.setCantidad(Integer.parseInt(text_cantidad.getText()));
					p.setPrecio(Double.parseDouble(text_precio.getText()));
					p.setFecha_caduca(text_expira.getText());
				try {
					
					if(text_nombre.getText() == null || text_cantidad.getText() == null || text_precio.getText() == null || text_expira.getText() == null) {
						label_actualizado.setText("Error al actualizar");
					}else {
						
						
						if(pc.actualizar(p,p.getId())) {
							pc.actualizar(p,p.getId());
							label_actualizado.setText("Actualizado correctamente");
							
							obten_id.setText("");
							text_nombre.setText("");
							text_descr.setText("");
							text_cantidad.setText("");
							text_precio.setText("");
							text_expira.setText("");
						}else {
							label_actualizado.setText("Error al actualizar");
						}
						
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					label_actualizado.setText("Error al actualizar");
				}
			}
		});
		btnActualizar.setBounds(124, 255, 75, 25);
		btnActualizar.setText("Actualizar");
		
		Button btnRegresar = new Button(composite, SWT.NONE);
		btnRegresar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
			}
		});
		btnRegresar.setBounds(216, 255, 75, 25);
		btnRegresar.setText("Regresar");
		
		Label lblId = new Label(composite, SWT.NONE);
		lblId.setBounds(10, 108, 55, 15);
		lblId.setText("ID:");
		lblId.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lblId.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
