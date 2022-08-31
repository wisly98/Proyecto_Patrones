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
	private OperacionesProductosCrudProxy pc = OperacionesProductosCrudProxy.getInstance();
	Productos p ;

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 331);
		shell.setText("SWT Application");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 435, 292);
		
		Label label_mensaje = new Label(composite, SWT.NONE);
		label_mensaje.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_mensaje.setAlignment(SWT.CENTER);
		label_mensaje.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_mensaje.setBounds(99, 87, 234, 15);
		
		Label lblIngreseElId = new Label(composite, SWT.NONE);
		lblIngreseElId.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblIngreseElId.setBounds(10, 10, 323, 17);
		lblIngreseElId.setText("Ingrese el nombre del producto que desea eliminar:");
		
		text_nombre = new Text(composite, SWT.BORDER | SWT.CENTER);
		text_nombre.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_nombre.setBounds(10, 31, 415, 21);
		
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
		
		Label eliminado = new Label(composite, SWT.NONE);
		eliminado.setForeground(SWTResourceManager.getColor(255, 0, 0));
		eliminado.setBounds(165, 236, 135, 15);
									
		Button btnBuscar = new Button(composite, SWT.NONE);
		btnBuscar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Productos p ;
				
				eliminado.setText("");
					 try {
						p = pp.getProducto(text_nombre.getText());
						if(p == null) {
							label_mensaje.setText("Producto no encontrado");
						}else {
							
							obten_nombre.setText(p.getNombre());
							obten_descr.setText(p.getDescripcion());
							obten_cantidad.setText(Integer.toString(p.getCantidad()));
							obten_precio.setText(Double.toString(p.getPrecio()));
							obten_expira.setText(p.getFecha_caduca());
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
		

		Button btnBorrar = new Button(composite, SWT.NONE);
		btnBorrar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				
				try {
					p = pp.getProducto(text_nombre.getText());
					Productos p1 = pc.leerProducto(p.getId());
					
					p.setCantidad(p1.getCantidad() + p.getCantidad());
					pp.removeProducto(p);
					pc.actualizar(p, p.getId());
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
		lblExpira.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
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
