package com.grafica;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class Carrito_Pagar_Transferencia {
	private Text text_t;
	
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
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 434, 262);
		
		Label lblDatosParaRealizar = new Label(composite, SWT.NONE);
		lblDatosParaRealizar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblDatosParaRealizar.setBounds(103, 10, 211, 23);
		lblDatosParaRealizar.setText("Datos para realizar la transferencia");
		
		Label lblNmeroDeCuenta = new Label(composite, SWT.NONE);
		lblNmeroDeCuenta.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNmeroDeCuenta.setBounds(27, 46, 112, 15);
		lblNmeroDeCuenta.setText("N\u00FAmero de cuenta:");
		
		Label lblTipoDeCuenta = new Label(composite, SWT.NONE);
		lblTipoDeCuenta.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblTipoDeCuenta.setBounds(27, 80, 112, 15);
		lblTipoDeCuenta.setText("Tipo de cuenta:");
		
		Label lblUsuario = new Label(composite, SWT.NONE);
		lblUsuario.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblUsuario.setBounds(27, 116, 55, 15);
		lblUsuario.setText("Usuario:");
		
		Label label = new Label(composite, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label.setAlignment(SWT.CENTER);
		label.setBounds(145, 46, 125, 15);
		label.setText("125781358");
		
		Label lblAhorros = new Label(composite, SWT.NONE);
		lblAhorros.setText("Ahorros");
		lblAhorros.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblAhorros.setAlignment(SWT.CENTER);
		lblAhorros.setBounds(145, 80, 125, 15);
		
		Label lblFranciscoJosChanataxi = new Label(composite, SWT.NONE);
		lblFranciscoJosChanataxi.setText("Francisco Jos\u00E9 Chanataxi Mancheno");
		lblFranciscoJosChanataxi.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblFranciscoJosChanataxi.setAlignment(SWT.CENTER);
		lblFranciscoJosChanataxi.setBounds(145, 116, 279, 15);
		
		Button btnHecho = new Button(composite, SWT.NONE);
		btnHecho.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnHecho.setBounds(116, 204, 75, 25);
		btnHecho.setText("Hecho");
		
		Button btnRegresar = new Button(composite, SWT.NONE);
		btnRegresar.setText("Regresar");
		btnRegresar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnRegresar.setBounds(239, 204, 75, 25);
		
		Label lblTotal = new Label(composite, SWT.NONE);
		lblTotal.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblTotal.setBounds(103, 154, 88, 23);
		lblTotal.setText("Total a pagar");
		
		text_t = new Text(composite, SWT.BORDER);
		text_t.setBounds(197, 154, 76, 21);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(279, 158, 55, 15);
		lblNewLabel.setText("$");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
