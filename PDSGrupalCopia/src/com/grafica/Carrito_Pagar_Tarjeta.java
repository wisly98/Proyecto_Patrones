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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Carrito_Pagar_Tarjeta {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private CarritoCompuesto cc = CarritoCompuesto.getInstance();
	private OperacionesProductosCrudProxy pc = OperacionesProductosCrudProxy.getInstance();
	private List<Productos> prod;
	private Productos p;
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlTarjeta = new Shell();
		shlTarjeta.setImage(SWTResourceManager.getImage(Carrito_Pagar_Tarjeta.class, "/com/imagenes/logo.jpeg"));
		shlTarjeta.setSize(450, 324);
		shlTarjeta.setText("Plaza la Merced");
		
		Composite composite = new Composite(shlTarjeta, SWT.NONE);
		composite.setBounds(0, 0, 435, 285);
		
		Label lblNombre = new Label(composite, SWT.NONE);
		lblNombre.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNombre.setBounds(10, 40, 55, 15);
		lblNombre.setText("Nombre");
		
		Label lblApellido = new Label(composite, SWT.NONE);
		lblApellido.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblApellido.setBounds(10, 71, 55, 22);
		lblApellido.setText("Apellido");
		
		Label lblNmeroTarjeta = new Label(composite, SWT.NONE);
		lblNmeroTarjeta.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNmeroTarjeta.setBounds(10, 101, 98, 22);
		lblNmeroTarjeta.setText("N\u00FAmero tarjeta");
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNewLabel.setBounds(10, 129, 105, 22);
		lblNewLabel.setText("Fecha expiraci\u00F3n");
		
		Label lblClave = new Label(composite, SWT.NONE);
		lblClave.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblClave.setBounds(10, 157, 55, 15);
		lblClave.setText("Clave");
		
		text = new Text(composite, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text.setBounds(114, 101, 246, 21);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_1.setBounds(255, 126, 105, 21);
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_2.setBounds(114, 68, 246, 21);
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setBounds(114, 34, 246, 21);
		
		text_4 = new Text(composite, SWT.BORDER);
		text_4.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_4.setBounds(255, 151, 105, 21);
		
		Label lblTotalAPagar = new Label(composite, SWT.NONE);
		lblTotalAPagar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblTotalAPagar.setBounds(133, 185, 90, 22);
		lblTotalAPagar.setText("Total a pagar");
		
		Label label_t = new Label(composite, SWT.NONE);
		label_t.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_t.setBounds(255, 185, 55, 15);
		label_t.setText(String.valueOf(String.format("%.2f",cc.getImporteTotal())));
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setBounds(316, 185, 44, 15);
		label_1.setText("$");
		
		Label msj = new Label(composite, SWT.NONE);
		msj.setAlignment(SWT.CENTER);
		msj.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		msj.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		msj.setBounds(114, 211, 231, 22);
		
		Button btnPagar = new Button(composite, SWT.NONE);
		btnPagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(text.getText().equals(null) || text_1.getText().equals(null) || text_2.getText().equals(null) || text_3.getText().equals(null)
						|| text_4.getText().equals(null)) {
					msj.setText("Error al realizar el pago");
				}else {
					text.setText("");
					text_1.setText("");
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					try {
						for(int i = 0; i < prod.size(); i++) {
							p = cc.getProducto(prod.get(i).getNombre());
							prod.get(i).setCantidad(prod.get(i).getCantidad() - p.getCantidad());
							pc.actualizar(prod.get(i), prod.get(i).getId());
						
					
				}
						msj.setText("Pago realizado con éxito");
						label_t.setText("0.0");
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
		btnPagar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnPagar.setBounds(124, 239, 75, 25);
		btnPagar.setText("Pagar");
		
		Button btnRegresar = new Button(composite, SWT.NONE);
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shlTarjeta.close();
			}
		});
		btnRegresar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnRegresar.setBounds(227, 239, 75, 25);
		btnRegresar.setText("Regresar");
		
		Label lblIngreseLosDatos = new Label(composite, SWT.NONE);
		lblIngreseLosDatos.setLocation(107, 6);
		lblIngreseLosDatos.setSize(253, 22);
		lblIngreseLosDatos.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblIngreseLosDatos.setText("Ingrese los datos de su tarjeta de D\u00E9bito");

		shlTarjeta.open();
		shlTarjeta.layout();
		while (!shlTarjeta.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
