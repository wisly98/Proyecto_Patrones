package com.grafica;

import org.eclipse.swt.widgets.Display; 
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.crud.pds.Productos;
import com.proxy.impl.OperacionesProductosCrudProxy;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Admin_Buscar {
	private Text text_id;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(Admin_Buscar.class, "/com/imagenes/logo.jpeg"));
		shell.setSize(450, 300);
		shell.setText("Plaza la Merced");
		shell.setLayout(null);
		//shell.setImage(SWTResourceManager.getImage(Carrito_Quitar.class, "/com/imagenes/WhatsApp Image 2022-02-19 at 10.30.59.jpeg"));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 435, 261);
		
		Label lbl_ingrese = new Label(composite, SWT.NONE);
		lbl_ingrese.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lbl_ingrese.setBounds(10, 10, 170, 17);
		lbl_ingrese.setText("Ingrese el ID del producto");
		
		Label label_mensaje = new Label(composite, SWT.NONE);
		label_mensaje.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_mensaje.setAlignment(SWT.CENTER);
		label_mensaje.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_mensaje.setBounds(99, 87, 234, 15);
		
		text_id = new Text(composite, SWT.BORDER | SWT.CENTER);
		text_id.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_id.setBounds(10, 31, 415, 21);
		
		Label lblId = new Label(composite, SWT.NONE);
		lblId.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblId.setBounds(10, 108, 55, 15);
		lblId.setText("Id:");
		
		Label lblNombre = new Label(composite, SWT.NONE);
		lblNombre.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNombre.setBounds(10, 129, 55, 15);
		lblNombre.setText("Nombre:");
		
		Label lblDescripcin = new Label(composite, SWT.NONE);
		lblDescripcin.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblDescripcin.setBounds(10, 150, 75, 15);
		lblDescripcin.setText("Descripci\u00F3n:");
		
		Label lblCantidad = new Label(composite, SWT.NONE);
		lblCantidad.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblCantidad.setBounds(10, 170, 55, 15);
		lblCantidad.setText("Cantidad:");
		
		Label lblPrecio = new Label(composite, SWT.NONE);
		lblPrecio.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblPrecio.setBounds(10, 191, 55, 15);
		lblPrecio.setText("Precio:");
		
		Label lblExpira = new Label(composite, SWT.NONE);
		lblExpira.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblExpira.setText("Expira:");
		lblExpira.setBounds(10, 212, 55, 15);
		
		Label obten_id = new Label(composite, SWT.NONE);
		obten_id.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		obten_id.setAlignment(SWT.CENTER);
		obten_id.setBounds(109, 108, 203, 15);
		
		Label obten_nombre = new Label(composite, SWT.NONE);
		obten_nombre.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		obten_nombre.setAlignment(SWT.CENTER);
		obten_nombre.setBounds(109, 129, 203, 15);
		
		Label obten_descr = new Label(composite, SWT.NONE);
		obten_descr.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		obten_descr.setAlignment(SWT.CENTER);
		obten_descr.setBounds(109, 150, 203, 15);
		
		Label obten_cantidad = new Label(composite, SWT.NONE);
		obten_cantidad.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		obten_cantidad.setAlignment(SWT.CENTER);
		obten_cantidad.setBounds(109, 170, 203, 15);
		
		Label obten_precio = new Label(composite, SWT.NONE);
		obten_precio.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		obten_precio.setAlignment(SWT.CENTER);
		obten_precio.setBounds(109, 191, 203, 15);
		
		Label obten_expira = new Label(composite, SWT.NONE);
		obten_expira.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		obten_expira.setAlignment(SWT.CENTER);
		obten_expira.setBounds(109, 212, 203, 15);
		
		Button btnBuscar = new Button(composite, SWT.NONE);
		btnBuscar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				OperacionesProductosCrudProxy pc = OperacionesProductosCrudProxy.getInstance();
				Productos p ;
				label_mensaje.setText("");
					 try {
						p = pc.leerProducto(Integer.parseInt(text_id.getText()));
						if(p.getId() == 0) {
							label_mensaje.setText("ID ingresado no corresponde a ningún producto");
						}else {
							obten_id.setText(Integer.toString(p.getId()));
							obten_nombre.setText(p.getNombre());
							obten_descr.setText(p.getDescripcion());
							obten_cantidad.setText(Integer.toString(p.getCantidad()));
							obten_precio.setText(Double.toString(p.getPrecio()));
							obten_expira.setText(p.getFecha_caduca());
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
		
		Button btnRegresar = new Button(composite, SWT.NONE);
		btnRegresar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
			}
		});
		btnRegresar.setBounds(174, 233, 75, 25);
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
