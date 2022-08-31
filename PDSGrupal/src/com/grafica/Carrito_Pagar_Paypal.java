package com.grafica;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import com.composite.impl.CarritoCompuesto;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;

public class Carrito_Pagar_Paypal {
	private Text text_n;
	private Text text_a;
	private Text text_c;
	private Text text_total;
	private CarritoCompuesto cp;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Carrito_Pagar_Paypal window = new Carrito_Pagar_Paypal();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		cp = CarritoCompuesto.getInstance();
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 299);
		shell.setText("SWT Application");
		
		Composite composite = new Composite(shell, SWT.NONE);
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
		
		text_total = new Text(composite, SWT.BORDER);
		text_total.setBounds(218, 143, 76, 21);
		text_total.setText(Double.toString(cp.getImporteTotal()));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(300, 146, 55, 15);
		lblNewLabel.setText("$");
		
		Label label_msj = new Label(composite, SWT.NONE);
		label_msj.setBounds(124, 172, 212, 26);
		label_msj.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_msj.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		
				
				Button btnNewButton = new Button(composite, SWT.NONE);
				btnNewButton.setBounds(136, 208, 75, 25);
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						if(text_n.getText() == null || text_a.getText() == null || text_c.getText() == null) {
							text_n.setText("");
							text_a.setText("");
							text_c.setText("");
							text_total.setText("");
							label_msj.setText("Error al realizar el pago");
						}
						text_n.setText("");
						text_a.setText("");
						text_c.setText("");
						text_total.setText("");
						label_msj.setText("Pago realizado con éxito");
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
				shell.close();
			}
		});
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
