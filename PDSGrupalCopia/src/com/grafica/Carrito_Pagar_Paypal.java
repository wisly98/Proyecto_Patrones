package com.grafica;

import org.eclipse.swt.widgets.Display; 
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.SQLException;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import com.composite.impl.CarritoCompuesto;
import com.crud.pds.Productos;
import com.proxy.impl.OperacionesProductosCrudProxy;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;

public class Carrito_Pagar_Paypal {
	private Text text_n;
	private Text text_a;
	private Text text_c;
	private CarritoCompuesto cc = CarritoCompuesto.getInstance();
	private OperacionesProductosCrudProxy pc = OperacionesProductosCrudProxy.getInstance();
	private List<Productos> prod;
	private Productos p;
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		try {
			prod = pc.LeerProductos();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Display display = Display.getDefault();
		Shell shlPaypal = new Shell();
		shlPaypal.setImage(SWTResourceManager.getImage(Carrito_Pagar_Paypal.class, "/com/imagenes/logo.jpeg"));
		shlPaypal.setSize(450, 299);
		shlPaypal.setText("Plaza la Merced");
		
		Composite composite = new Composite(shlPaypal, SWT.NONE);
		composite.setBounds(0, 0, 434, 260);
		
		Label lblIngreseLosSiguientes = new Label(composite, SWT.NONE);
		lblIngreseLosSiguientes.setBounds(124, 10, 181, 22);
		lblIngreseLosSiguientes.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblIngreseLosSiguientes.setText("Ingrese los siguientes datos");
		
		Label lblNombre = new Label(composite, SWT.NONE);
		lblNombre.setBounds(10, 46, 55, 15);
		lblNombre.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNombre.setText("Nombre:");
		
		Label lblApellido = new Label(composite, SWT.NONE);
		lblApellido.setBounds(10, 74, 55, 22);
		lblApellido.setText("Apellido:");
		lblApellido.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		
		Label lblCorreo = new Label(composite, SWT.NONE);
		lblCorreo.setBounds(10, 102, 55, 15);
		lblCorreo.setText("Correo:");
		lblCorreo.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		
		text_n = new Text(composite, SWT.BORDER);
		text_n.setBounds(71, 45, 330, 21);
		
		text_a = new Text(composite, SWT.BORDER);
		text_a.setBounds(71, 73, 330, 21);
		
		text_c = new Text(composite, SWT.BORDER);
		text_c.setBounds(71, 101, 330, 21);
		
		Label lblTotalAPagar = new Label(composite, SWT.NONE);
		lblTotalAPagar.setBounds(118, 144, 93, 22);
		lblTotalAPagar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblTotalAPagar.setText("Total a pagar");
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(278, 146, 55, 15);
		lblNewLabel.setText("$");
		
		Label label_msj = new Label(composite, SWT.NONE);
		label_msj.setBounds(124, 172, 212, 26);
		label_msj.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_msj.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		
		
		Label label_t = new Label(composite, SWT.NONE);
		label_t.setBounds(217, 144, 55, 15);
		label_t.setText(String.valueOf(String.format("%.2f",cc.getImporteTotal())));
				Button btnNewButton = new Button(composite, SWT.NONE);
				btnNewButton.setBounds(136, 208, 75, 25);
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						if(text_n.getText() == null || text_a.getText() == null || text_c.getText() == null) {
							text_n.setText("");
							text_a.setText("");
							text_c.setText("");
							
							label_msj.setText("Error al realizar el pago");
						}else {
							text_n.setText("");
							text_a.setText("");
							text_c.setText("");
							label_t.setText("0.0");
							
								try {
									for(int i = 0; i < prod.size(); i++) {
										p = cc.getProducto(prod.get(i).getNombre());
										prod.get(i).setCantidad(prod.get(i).getCantidad() - p.getCantidad());
										pc.actualizar(prod.get(i), prod.get(i).getId());
									
								
									}
									label_msj.setText("Pago realizado con éxito");
									
									for(int i = 0; i< prod.size(); i++) {
										cc.removeProducto(prod.get(i));
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							
						}
						
					}
				});
				btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
				btnNewButton.setText("Pagar");
				
				Button btnNewButton_1 = new Button(composite, SWT.NONE);
				btnNewButton_1.setBounds(239, 209, 75, 25);
				btnNewButton_1.setText("Regresar");
				
				
	
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shlPaypal.close();
			}
		});
		
		shlPaypal.open();
		shlPaypal.layout();
		while (!shlPaypal.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
