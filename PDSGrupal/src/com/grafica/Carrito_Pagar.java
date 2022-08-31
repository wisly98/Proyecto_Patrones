package com.grafica;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Carrito_Pagar {
	private Label paypal;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Carrito_Pagar window = new Carrito_Pagar();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 435, 261);
		
		paypal = new Label(composite, SWT.NONE);
		paypal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
			}
		});
		paypal.setImage(SWTResourceManager.getImage(Carrito_Pagar.class, "/com/imagenes/paypal.jpg"));
		paypal.setBounds(29, 83, 85, 78);
		
		Label transferencia = new Label(composite, SWT.NONE);
		transferencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		transferencia.setImage(SWTResourceManager.getImage(Carrito_Pagar.class, "/com/imagenes/transferencia.png"));
		transferencia.setBounds(173, 83, 85, 78);
		
		Label tarjeta_debito = new Label(composite, SWT.NONE);
		tarjeta_debito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
			}
		});
		tarjeta_debito.setImage(SWTResourceManager.getImage(Carrito_Pagar.class, "/com/imagenes/tarjeta.png"));
		tarjeta_debito.setBounds(316, 83, 85, 78);
		
		Button btnRegresar = new Button(composite, SWT.NONE);
		btnRegresar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnRegresar.setBounds(173, 214, 75, 25);
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
