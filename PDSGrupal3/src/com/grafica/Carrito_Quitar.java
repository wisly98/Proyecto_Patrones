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

import com.composite.impl.CarritoCompuesto;
import com.crud.pds.Productos;
import com.proxy.impl.OperacionesProductosCrudProxy;

public class Carrito_Quitar {
	private Text text_nombre;
	private CarritoCompuesto pp = CarritoCompuesto.getInstance();
	

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(Carrito_Quitar.class, "/com/imagenes/WhatsApp Image 2022-02-19 at 10.30.59.jpeg"));
		shell.setSize(450, 331);
		shell.setText("Plaza la Merced");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(255, 255, 224));
		composite.setBounds(0, 0, 435, 292);
		
		Label label_mensaje = new Label(composite, SWT.NONE);
		label_mensaje.setBackground(SWTResourceManager.getColor(255, 255, 224));
		label_mensaje.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_mensaje.setAlignment(SWT.CENTER);
		label_mensaje.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_mensaje.setBounds(99, 87, 234, 15);
		
		Label lblIngreseElId = new Label(composite, SWT.NONE);
		lblIngreseElId.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lblIngreseElId.setFont(SWTResourceManager.getFont("STIXNonUnicode", 7, SWT.NORMAL));
		lblIngreseElId.setBounds(10, 10, 323, 17);
		lblIngreseElId.setText("Ingrese el nombre del producto que desea eliminar:");
		
		text_nombre = new Text(composite, SWT.BORDER | SWT.CENTER);
		text_nombre.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_nombre.setBounds(10, 31, 415, 21);
		
		Label obten_nombre = new Label(composite, SWT.NONE);
		obten_nombre.setBackground(SWTResourceManager.getColor(255, 255, 224));
		obten_nombre.setFont(SWTResourceManager.getFont("STIXNonUnicode", 7, SWT.NORMAL));
		obten_nombre.setAlignment(SWT.CENTER);
		obten_nombre.setBounds(109, 129, 203, 15);
		
		Label obten_descr = new Label(composite, SWT.NONE);
		obten_descr.setBackground(SWTResourceManager.getColor(255, 255, 224));
		obten_descr.setFont(SWTResourceManager.getFont("STIXNonUnicode", 7, SWT.NORMAL));
		obten_descr.setAlignment(SWT.CENTER);
		obten_descr.setBounds(109, 150, 203, 15);
		
		Label obten_cantidad = new Label(composite, SWT.NONE);
		obten_cantidad.setBackground(SWTResourceManager.getColor(255, 255, 224));
		obten_cantidad.setFont(SWTResourceManager.getFont("STIXNonUnicode", 7, SWT.NORMAL));
		obten_cantidad.setAlignment(SWT.CENTER);
		obten_cantidad.setBounds(109, 170, 203, 15);
		
		Label obten_precio = new Label(composite, SWT.NONE);
		obten_precio.setBackground(SWTResourceManager.getColor(255, 255, 224));
		obten_precio.setFont(SWTResourceManager.getFont("STIXNonUnicode", 7, SWT.NORMAL));
		obten_precio.setAlignment(SWT.CENTER);
		obten_precio.setBounds(109, 191, 203, 15);
		
		Label obten_expira = new Label(composite, SWT.NONE);
		obten_expira.setBackground(SWTResourceManager.getColor(255, 255, 224));
		obten_expira.setFont(SWTResourceManager.getFont("STIXNonUnicode", 7, SWT.NORMAL));
		obten_expira.setAlignment(SWT.CENTER);
		obten_expira.setBounds(109, 212, 203, 15);
		
		Label eliminado = new Label(composite, SWT.NONE);
		eliminado.setBackground(SWTResourceManager.getColor(255, 255, 224));
		eliminado.setForeground(SWTResourceManager.getColor(255, 0, 0));
		eliminado.setBounds(165, 236, 135, 15);
									
		Button btnBuscar = new Button(composite, SWT.NONE);
		btnBuscar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				
				eliminado.setText("");
					 try {
						
						if(pp.getProducto(text_nombre.getText()) == null) {
							label_mensaje.setText("Producto no encontrado");
						}else {
							
							obten_nombre.setText(pp.getProducto(text_nombre.getText()).getNombre());
							obten_descr.setText(pp.getProducto(text_nombre.getText()).getDescripcion());
							obten_cantidad.setText(Integer.toString(pp.getProducto(text_nombre.getText()).getCantidad()));
							obten_precio.setText(Double.toString(pp.getProducto(text_nombre.getText()).getPrecio()));
							obten_expira.setText(pp.getProducto(text_nombre.getText()).getFecha_caduca());
							label_mensaje.setText("");
						}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
						label_mensaje.setText("Producto no encontrado");
					}
				
			}
		});
		btnBuscar.setBounds(177, 58, 75, 25);
		btnBuscar.setText("Buscar");
		
		Label lblNombre = new Label(composite, SWT.NONE);
		lblNombre.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lblNombre.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblNombre.setBounds(10, 129, 55, 15);
		lblNombre.setText("Nombre:");
		
		Label lblDescripcin = new Label(composite, SWT.NONE);
		lblDescripcin.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lblDescripcin.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblDescripcin.setBounds(10, 150, 93, 15);
		lblDescripcin.setText("Descripci\u00F3n:");
		
		Label lblCantidad = new Label(composite, SWT.NONE);
		lblCantidad.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lblCantidad.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblCantidad.setBounds(10, 170, 75, 15);
		lblCantidad.setText("Cantidad:");
		
		Label lblPrecio = new Label(composite, SWT.NONE);
		lblPrecio.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lblPrecio.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblPrecio.setBounds(10, 191, 55, 15);
		lblPrecio.setText("Precio:");
		

		Button btnBorrar = new Button(composite, SWT.NONE);
		btnBorrar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				
				try {
					;
					pp.removeProducto(pp.getProducto(text_nombre.getText()));
					obten_nombre.setText("");
					obten_descr.setText("");
					obten_cantidad.setText("");
					obten_precio.setText("");
					obten_expira.setText("");
					eliminado.setText("Producto Eliminado");
				} catch (NumberFormatException e1) {
					eliminado.setText("Error al eliminar");
					e1.printStackTrace();
				}
			}
		});
		btnBorrar.setBounds(140, 257, 75, 25);
		btnBorrar.setText("Borrar");
		
		Button btnCancelar = new Button(composite, SWT.NONE);
		btnCancelar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
			}
		});
		btnCancelar.setBounds(237, 257, 75, 25);
		btnCancelar.setText("Regresar");
		
		Label lblExpira = new Label(composite, SWT.NONE);
		lblExpira.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lblExpira.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblExpira.setText("Expira:");
		lblExpira.setBounds(10, 212, 55, 15);
		
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
