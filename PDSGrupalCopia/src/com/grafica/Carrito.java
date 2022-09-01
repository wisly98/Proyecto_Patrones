package com.grafica;

import org.eclipse.swt.widgets.Display; 
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Carrito {

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(635, 433);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(255, 255, 224));
		composite.setBounds(0, 0, 618, 393);
		
		Button button = new Button(composite, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button.setForeground(SWTResourceManager.getColor(95, 158, 160));
		button.setImage(SWTResourceManager.getImage(Carrito.class, "/com/imagenes/MicrosoftTeams-image (10).png"));
		button.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					Carrito_Buscar window = new Carrito_Buscar();
					window.open();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		button.setBounds(78, 31, 97, 96);
		
		Button button_1 = new Button(composite, SWT.NONE);
		button_1.setBackground(SWTResourceManager.getColor(255, 255, 224));
		button_1.setImage(SWTResourceManager.getImage(Carrito.class, "/com/imagenes/MicrosoftTeams-image (9).png"));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					Carrito_Agregar window = new Carrito_Agregar();
					window.open();
				} catch (Exception e1) {
					e1.printStackTrace();
				}			
			}
		});
		button_1.setBounds(261, 31, 97, 96);
		
		Button button_2 = new Button(composite, SWT.NONE);
		button_2.setImage(SWTResourceManager.getImage(Carrito.class, "/com/imagenes/MicrosoftTeams-image (11).png"));
		button_2.setBackground(SWTResourceManager.getColor(255, 255, 224));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					Carrito_Mirar window = new Carrito_Mirar();
					window.open();
				} catch (Exception e2) {
					e2.printStackTrace();
				}			}
		});
		button_2.setBounds(78, 253, 97, 96);
		
		Button button_3 = new Button(composite, SWT.NONE);
		button_3.setImage(SWTResourceManager.getImage(Carrito.class, "/com/imagenes/MicrosoftTeams-image (12).png"));
		button_3.setBackground(SWTResourceManager.getColor(255, 255, 224));
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					Carrito_Quitar window = new Carrito_Quitar();
					window.open();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_3.setBounds(438, 31, 97, 96);
		
		Button button_4 = new Button(composite, SWT.NONE);
		button_4.setImage(SWTResourceManager.getImage(Carrito.class, "/com/imagenes/MicrosoftTeams-image (7).png"));
		button_4.setBackground(SWTResourceManager.getColor(255, 255, 224));
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				display.close();
			}
		});
		button_4.setBounds(438, 253, 97, 96);
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_1.setImage(SWTResourceManager.getImage(Carrito.class, "/com/imagenes/MicrosoftTeams-image (8).png"));
		btnNewButton_1.setBackground(SWTResourceManager.getColor(255, 255, 224));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					Carrito_Pagar window = new Carrito_Pagar();
					window.open();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(261, 253, 97, 96);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
