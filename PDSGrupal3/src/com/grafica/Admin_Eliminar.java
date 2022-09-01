package com.grafica;

import org.eclipse.swt.widgets.Display; 
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import com.crud.pds.Productos;
import com.proxy.impl.OperacionesProductosCrudProxy;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Admin_Eliminar {
	private Text text_id;
	private OperacionesProductosCrudProxy pc = OperacionesProductosCrudProxy.getInstance();
	Productos p ;

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() throws SQLException{
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 331);
		shell.setText("Plaza la Merced");
		shell.setImage(SWTResourceManager.getImage(Carrito_Quitar.class, "/com/imagenes/WhatsApp Image 2022-02-19 at 10.30.59.jpeg"));
		
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 435, 292);
		composite.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label label_mensaje = new Label(composite, SWT.NONE);
		label_mensaje.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_mensaje.setAlignment(SWT.CENTER);
		label_mensaje.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_mensaje.setBounds(99, 87, 234, 15);
		
		Label lblIngreseElId = new Label(composite, SWT.NONE);
		lblIngreseElId.setFont(SWTResourceManager.getFont("STIXNonUnicode", 7, SWT.NORMAL));
		lblIngreseElId.setBounds(10, 10, 290, 17);
		lblIngreseElId.setText("Ingrese el ID del producto que desea eliminar:");
		lblIngreseElId.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		text_id = new Text(composite, SWT.BORDER | SWT.CENTER);
		text_id.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_id.setBounds(10, 31, 415, 21);
		

		Label obten_id = new Label(composite, SWT.NONE);
		obten_id.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		obten_id.setAlignment(SWT.CENTER);
		obten_id.setBounds(109, 108, 203, 15);
		obten_id.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label obten_nombre = new Label(composite, SWT.NONE);
		obten_nombre.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		obten_nombre.setAlignment(SWT.CENTER);
		obten_nombre.setBounds(109, 129, 203, 15);
		obten_nombre.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label obten_descr = new Label(composite, SWT.NONE);
		obten_descr.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		obten_descr.setAlignment(SWT.CENTER);
		obten_descr.setBounds(109, 150, 203, 15);
		obten_descr.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label obten_cantidad = new Label(composite, SWT.NONE);
		obten_cantidad.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		obten_cantidad.setAlignment(SWT.CENTER);
		obten_cantidad.setBounds(109, 170, 203, 15);
		obten_cantidad.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label obten_precio = new Label(composite, SWT.NONE);
		obten_precio.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		obten_precio.setAlignment(SWT.CENTER);
		obten_precio.setBounds(109, 191, 203, 15);
		obten_precio.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label obten_expira = new Label(composite, SWT.NONE);
		obten_expira.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		obten_expira.setAlignment(SWT.CENTER);
		obten_expira.setBounds(109, 212, 203, 15);
		obten_expira.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label eliminado = new Label(composite, SWT.NONE);
		eliminado.setForeground(SWTResourceManager.getColor(255, 0, 0));
		eliminado.setBounds(165, 236, 135, 15);
		eliminado.setBackground(SWTResourceManager.getColor(255, 255, 224));
									
		Button btnBuscar = new Button(composite, SWT.NONE);
		btnBuscar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Productos p ;
				
				boolean aux = false;
				eliminado.setText("");
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
		btnBuscar.setBounds(177, 58, 75, 25);
		btnBuscar.setText("Buscar");
		
		Label lblId = new Label(composite, SWT.NONE);
		lblId.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblId.setBounds(10, 108, 55, 15);
		lblId.setText("Id:");
		lblId.setBackground(SWTResourceManager.getColor(255, 255, 224));
		lblId.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lblNombre = new Label(composite, SWT.NONE);
		lblNombre.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblNombre.setBounds(10, 129, 55, 15);
		lblNombre.setText("Nombre:");
		lblNombre.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lblDescripcin = new Label(composite, SWT.NONE);
		lblDescripcin.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblDescripcin.setBounds(10, 150, 93, 15);
		lblDescripcin.setText("Descripci\u00F3n:");
		lblDescripcin.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lblCantidad = new Label(composite, SWT.NONE);
		lblCantidad.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblCantidad.setBounds(10, 170, 55, 15);
		lblCantidad.setText("Cantidad:");
		lblCantidad.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Label lblPrecio = new Label(composite, SWT.NONE);
		lblPrecio.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblPrecio.setBounds(10, 191, 55, 15);
		lblPrecio.setText("Precio:");
		lblPrecio.setBackground(SWTResourceManager.getColor(255, 255, 224));

		Button btnBorrar = new Button(composite, SWT.NONE);
		btnBorrar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				
				try {
					pc.eliminar(Integer.parseInt(obten_id.getText()));
					obten_id.setText("");
					obten_nombre.setText("");
					obten_descr.setText("");
					obten_cantidad.setText("");
					obten_precio.setText("");
					obten_expira.setText("");
					eliminado.setText("Producto Eliminado");
				} catch (NumberFormatException | SQLException e1) {
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
		lblExpira.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		lblExpira.setText("Expira:");
		lblExpira.setBounds(10, 212, 55, 15);
		lblExpira.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
