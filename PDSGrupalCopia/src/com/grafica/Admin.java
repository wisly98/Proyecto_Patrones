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
		shell.setText("Plaza la Merced");
		//shell.setImage(SWTResourceManager.getImage(Carrito_Quitar.class, "/com/imagenes/WhatsApp Image 2022-02-19 at 10.30.59.jpeg"));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(255, 255, 255));
		composite.setBackground(SWTResourceManager.getColor(255, 255, 224));
		composite.setBounds(0, 0, 618, 393);
		composite.setLayout(null);
		
		Button buscar = new Button(composite, SWT.NONE);
		buscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
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
		buscar.setImage(SWTResourceManager.getImage(Admin.class, "/com/imagenes/MicrosoftTeams-image (6).png"));
		buscar.setBounds(78, 31, 97, 96);
		buscar.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
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
		crear.setImage(SWTResourceManager.getImage(Admin.class, "/com/imagenes/MicrosoftTeams-image (5).png"));
		crear.setBounds(261, 31, 97, 96);
		crear.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
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
		actualizar.setImage(SWTResourceManager.getImage(Admin.class, "/com/imagenes/MicrosoftTeams-image (3).png"));
		actualizar.setBounds(438, 31, 97, 96);
		actualizar.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
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
		lista.setImage(SWTResourceManager.getImage(Admin.class, "/com/imagenes/listar.png"));
		lista.setBounds(78, 253, 97, 96);
		lista.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
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
		eliminar.setImage(SWTResourceManager.getImage(Admin.class, "/com/imagenes/MicrosoftTeams-image (4).png"));
		eliminar.setBounds(261, 253, 97, 96);
		eliminar.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Button salir = new Button(composite, SWT.NONE);
		salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				display.close();
			
			}
		});
		salir.setImage(SWTResourceManager.getImage(Admin.class, "/com/imagenes/MicrosoftTeams-image (7).png"));
		salir.setBounds(438, 253, 97, 96);
		salir.setBackground(SWTResourceManager.getColor(255, 255, 224));

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
