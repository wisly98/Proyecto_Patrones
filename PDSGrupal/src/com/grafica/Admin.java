package com.grafica;

import org.eclipse.swt.widgets.Display;  
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Admin {

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {

		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(634, 431);
		shell.setText("SWT Application");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(255, 255, 255));
		composite.setBounds(0, 0, 618, 393);
		composite.setLayout(null);
		
		Button buscar = new Button(composite, SWT.NONE);
		buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
		
				try {
					Admin_Buscar window = new Admin_Buscar();
					window.open();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
				
			}
		});
		buscar.setImage(SWTResourceManager.getImage("C:\\Users\\Usuario-PC\\Downloads\\Iconos swt\\2622200.png"));
		buscar.setBounds(78, 31, 97, 96);
		
		Button crear = new Button(composite, SWT.NONE);
		crear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					Admin_Agregar window = new Admin_Agregar();
					window.open();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		crear.setImage(SWTResourceManager.getImage("C:\\Users\\Usuario-PC\\Downloads\\Iconos swt\\3658756.png"));
		crear.setBounds(261, 31, 97, 96);
		
		Button actualizar = new Button(composite, SWT.NONE);
		actualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					Admin_Actualizar window = new Admin_Actualizar();
					window.open();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		actualizar.setImage(SWTResourceManager.getImage("C:\\Users\\Usuario-PC\\Downloads\\Iconos swt\\kisspng-cloud-computing-computer-icons-amazon-s3-service-update-button-5ac457835ba728.2678378615228168993754.png"));
		actualizar.setBounds(438, 31, 97, 96);
		
		Button lista = new Button(composite, SWT.NONE);
		lista.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Admin_Listar window = new Admin_Listar();
					window.open();
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		});
		lista.setImage(SWTResourceManager.getImage("C:\\Users\\Usuario-PC\\Downloads\\Iconos swt\\767ca771755f4675d4063c03e17c8595-icono-de-lista-de-verificacion-medica.png"));
		lista.setBounds(78, 253, 97, 96);
		
		Button eliminar = new Button(composite, SWT.NONE);
		eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					Admin_Eliminar window = new Admin_Eliminar();
					window.open();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		eliminar.setImage(SWTResourceManager.getImage("C:\\Users\\Usuario-PC\\Downloads\\Iconos swt\\MicrosoftTeams-image (1).png"));
		eliminar.setBounds(261, 253, 97, 96);
		
		Button salir = new Button(composite, SWT.NONE);
		salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				display.close();
			
			}
		});
		salir.setImage(SWTResourceManager.getImage("C:\\Users\\Usuario-PC\\Downloads\\Iconos swt\\logout-png-2.png"));
		salir.setBounds(438, 253, 97, 96);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
