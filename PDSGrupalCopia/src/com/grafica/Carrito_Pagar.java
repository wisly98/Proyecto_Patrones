package com.grafica;

import org.eclipse.swt.widgets.Display; 
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Carrito_Pagar {

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
		shell.setImage(SWTResourceManager.getImage(Carrito_Pagar.class, "/com/imagenes/logo.jpeg"));
		shell.setSize(450, 300);
		//shell.setImage(SWTResourceManager.getImage(Carrito_Quitar.class, "/com/imagenes/WhatsApp Image 2022-02-19 at 10.30.59.jpeg"));
		shell.setText("Plaza la Merced");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(255, 255, 224));
		composite.setBounds(0, 0, 435, 261);
		
		Button btnRegresar = new Button(composite, SWT.NONE);
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
			}
		});
		btnRegresar.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		btnRegresar.setBounds(173, 214, 75, 25);
		btnRegresar.setText("Regresar");
		
		Button button = new Button(composite, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					Carrito_Pagar_Paypal window = new Carrito_Pagar_Paypal();
					window.open();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button.setImage(SWTResourceManager.getImage(Carrito_Pagar.class, "/com/imagenes/paypal.jpg"));
		button.setBounds(34, 63, 85, 78);
		
		Button button_1 = new Button(composite, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					Carrito_Pagar_Transferencia window = new Carrito_Pagar_Transferencia();
					window.open();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		button_1.setImage(SWTResourceManager.getImage(Carrito_Pagar.class, "/com/imagenes/transferencia.png"));
		button_1.setBounds(163, 63, 85, 78);
		
		Button button_1_1 = new Button(composite, SWT.NONE);
		button_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					Carrito_Pagar_Tarjeta window = new Carrito_Pagar_Tarjeta();
					window.open();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_1_1.setImage(SWTResourceManager.getImage(Carrito_Pagar.class, "/com/imagenes/tarjeta.png"));
		button_1_1.setBounds(302, 63, 85, 78);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
