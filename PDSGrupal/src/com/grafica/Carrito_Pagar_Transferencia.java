package com.grafica;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Carrito_Pagar_Transferencia {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Carrito_Pagar_Transferencia window = new Carrito_Pagar_Transferencia();
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

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}