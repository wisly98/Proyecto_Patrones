package com.grafica;

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

public class Carrito_Buscar {
	private Text text_nombre;
	private CarritoCompuesto pc = CarritoCompuesto.getInstance();
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(Carrito_Buscar.class, "/com/imagenes/logo.jpeg"));
		shell.setSize(450, 300);
		shell.setText("Plaza la Merced");
		shell.setLayout(null);
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 435, 261);
		composite.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lbl_ingrese = new Label(composite, SWT.NONE);
		lbl_ingrese.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.NORMAL));
		lbl_ingrese.setBounds(10, 10, 203, 17);
		lbl_ingrese.setText("Ingrese el nombre del producto");
		lbl_ingrese.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label label_mensaje = new Label(composite, SWT.NONE);
		label_mensaje.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		label_mensaje.setAlignment(SWT.CENTER);
		label_mensaje.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_mensaje.setBounds(99, 87, 234, 15);
		label_mensaje.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		text_nombre = new Text(composite, SWT.BORDER | SWT.CENTER);
		text_nombre.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_nombre.setBounds(10, 31, 415, 21);
		
		Label lblNombre = new Label(composite, SWT.NONE);
		lblNombre.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblNombre.setBounds(10, 129, 55, 15);
		lblNombre.setText("Nombre:");
		lblNombre.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lblDescripcin = new Label(composite, SWT.NONE);
		lblDescripcin.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblDescripcin.setBounds(10, 150, 75, 15);
		lblDescripcin.setText("Descripci\u00F3n:");
		lblDescripcin.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lblCantidad = new Label(composite, SWT.NONE);
		lblCantidad.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblCantidad.setBounds(10, 170, 55, 15);
		lblCantidad.setText("Cantidad:");
		lblCantidad.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lblPrecio = new Label(composite, SWT.NONE);
		lblPrecio.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblPrecio.setBounds(10, 191, 55, 15);
		lblPrecio.setText("Precio:");
		lblPrecio.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lblExpira = new Label(composite, SWT.NONE);
		lblExpira.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblExpira.setText("Expira:");
		lblExpira.setBounds(10, 212, 55, 15);
		lblExpira.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
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
		btnBuscar.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				
				 ;
				label_mensaje.setText("");
					 try {
						
						if(pc.getProducto(text_nombre.getText())== null) {
							label_mensaje.setText("El producto no ha sido encontrado");
						}else {
							
							obten_nombre.setText(pc.getProducto(text_nombre.getText()).getNombre());
							obten_descr.setText(pc.getProducto(text_nombre.getText()).getDescripcion());
							obten_cantidad.setText(Integer.toString(pc.getProducto(text_nombre.getText()).getCantidad()));
							obten_precio.setText(Double.toString(pc.getProducto(text_nombre.getText()).getPrecio()));
							obten_expira.setText(pc.getProducto(text_nombre.getText()).getFecha_caduca());
							label_mensaje.setText("");
						}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
						label_mensaje.setText("El producto no ha sido encontrado");
					}
			}
		});
		btnBuscar.setBounds(174, 58, 75, 25);
		btnBuscar.setText("Buscar");
		
		Button btnRegresar = new Button(composite, SWT.NONE);
		btnRegresar.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
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
