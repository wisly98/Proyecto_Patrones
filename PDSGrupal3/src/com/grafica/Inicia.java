package com.grafica;

import org.eclipse.swt.widgets.Display;  
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.swt.widgets.Label;

public class Inicia {
	
	public static void open() { // método para mostrar los componentes en pantalla. 
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(0, 255, 255));
		shell.setImage(SWTResourceManager.getImage(Inicia.class, "/com/imagenes/WhatsApp Image 2022-02-19 at 10.30.59.jpeg"));
		shell.setSize(245, 279);
		shell.setText("FAW");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 229, 242);
		composite.setLayout(null);
		
		Button btn_admin = new Button(composite, SWT.NONE);
		btn_admin.setImage(SWTResourceManager.getImage(Inicia.class, "/com/imagenes/Admin.png"));
		btn_admin.setVisible(true);
		btn_admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {  // damos funcionalidad al botón al dar click.
				
				// Llama a la ventana para iniciar seción como Administrador.
				try {
					Admin_IniciarSesion window = new Admin_IniciarSesion();
					window.open();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btn_admin.setBounds(97, 173, 40, 40);
		
		Button btn_usuario = new Button(composite, SWT.NONE);
		btn_usuario.setImage(SWTResourceManager.getImage(Inicia.class, "/com/imagenes/Usuarios.png"));
		btn_usuario.setVisible(true);
		btn_usuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { // damos funcionalidad al botón al dar click.
		
					// Llama a la ventana para iniciar seción como usiario.
					try {
						Usuario_IniciaSesion window = new Usuario_IniciaSesion();
						window.open();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			
		}});
		btn_usuario.setBounds(97, 113, 40, 40);
		
		Label fondo_Faw = new Label(composite, SWT.NONE);
		
		fondo_Faw.setImage(SWTResourceManager.getImage(Inicia.class, "/com/imagenes/fondo_p.png"));
		fondo_Faw.setBounds(0, 0, 229, 242);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
