package com.grafica;

import org.eclipse.swt.widgets.Display;  
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import com.proxy.impl.OperacionesUsuariosCrudProxy;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Usuario_Datos {

	protected Shell shell;
	private Text text_contrasenia;
	private Text text_edad;
	private Text text_apellido;
	private Text text_nombre;
	private Text text_usuario;

	public void open() { // método para mostrar los componentes en pantalla.
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		OperacionesUsuariosCrudProxy pc = OperacionesUsuariosCrudProxy.getInstance();
	
		shell = new Shell();
		shell.setSize(339, 323);
		shell.setText("SWT Application");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 324, 285);
		
		Label lblIngreseLosSiguientes = new Label(composite, SWT.NONE);
		lblIngreseLosSiguientes.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblIngreseLosSiguientes.setBounds(59, 10, 197, 26);
		lblIngreseLosSiguientes.setText("Ingrese los siguientes datos");
		
		Label lblUsuario = new Label(composite, SWT.NONE);
		lblUsuario.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblUsuario.setBounds(10, 54, 55, 15);
		lblUsuario.setText("Usuario");
		
		Label lblNomre = new Label(composite, SWT.NONE);
		lblNomre.setText("Nombre");
		lblNomre.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNomre.setBounds(10, 85, 55, 15);
		
		Label lblApellido = new Label(composite, SWT.NONE);
		lblApellido.setText("Apellido");
		lblApellido.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblApellido.setBounds(10, 113, 55, 15);
		
		Label lblEdad = new Label(composite, SWT.NONE);
		lblEdad.setText("Edad");
		lblEdad.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblEdad.setBounds(10, 142, 55, 15);
		
		Label lblContrasea = new Label(composite, SWT.NONE);
		lblContrasea.setText("Contrase\u00F1a");
		lblContrasea.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblContrasea.setBounds(10, 172, 72, 15);
		
		text_contrasenia = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		text_contrasenia.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_contrasenia.setBounds(91, 172, 165, 21);
		
		text_edad = new Text(composite, SWT.BORDER);
		text_edad.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_edad.setBounds(91, 142, 165, 21);
		
		text_apellido = new Text(composite, SWT.BORDER);
		text_apellido.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_apellido.setBounds(91, 113, 165, 21);
		
		text_nombre = new Text(composite, SWT.BORDER);
		text_nombre.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_nombre.setBounds(91, 85, 165, 21);
		
		text_usuario = new Text(composite, SWT.BORDER);
		text_usuario.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_usuario.setBounds(91, 54, 165, 21);
		
		Label mensaje = new Label(composite, SWT.NONE);
		mensaje.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		mensaje.setBounds(101, 199, 141, 15);
		
		Button btnCrear = new Button(composite, SWT.NONE);
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { // Método para crear el usuario al dar click
			
			if(text_usuario.getText().equals(null) && text_nombre.equals(null) && text_apellido.getText().equals(null) && text_edad.getText().equals(null) && text_contrasenia.getText().equals(null)) {
				mensaje.setText("Error al registrar");
				text_usuario.setText("");
				text_nombre.setText("");
				text_apellido.setText("");
				text_edad.setText("");
				text_contrasenia.setText("");
			}else {
				try {
					pc.crear(text_usuario.getText(), text_nombre.getText(), text_apellido.getText(), Integer.parseInt(text_edad.getText()), text_contrasenia.getText());
					mensaje.setText("Registro completo");
					text_usuario.setText("");
					text_nombre.setText("");
					text_apellido.setText("");
					text_edad.setText("");
					text_contrasenia.setText("");
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					mensaje.setText("Error al registrar");
				}
				
			}
			
				
			}
		});
		btnCrear.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnCrear.setBounds(91, 236, 75, 25);
		btnCrear.setText("Crear");
		
		Button btnRgresar = new Button(composite, SWT.NONE);
		btnRgresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { //Método para cerrar la ventana al dar click.
				shell.close();
			}
		});
				
		btnRgresar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnRgresar.setBounds(181, 236, 75, 25);
		btnRgresar.setText("Regresar");
		
		Button mostrar = new Button(composite, SWT.NONE);
		Button ocultar = new Button(composite, SWT.NONE);
		ocultar.setVisible(false);
		mostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { // Método para mostrar la contraseña.
				mostrar.setVisible(false);
				ocultar.setVisible(true);
				text_contrasenia.setEchoChar((char)0) ;// paso de (•) a texto.
			
			}
		});
		mostrar.setImage(SWTResourceManager.getImage("C:\\Users\\Usuario-PC\\Downloads\\Iconos swt\\6803345 (1).png"));
		mostrar.setBounds(262, 171, 33, 21);
		

		ocultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { // Método para ocultar la contraseña.
				mostrar.setVisible(true);
				ocultar.setVisible(false);
				text_contrasenia.setEchoChar((char)0);
				text_contrasenia.setEchoChar('•'); // paso de texto a (•).
				
			}
		});
		ocultar.setImage(SWTResourceManager.getImage("C:\\Users\\Usuario-PC\\Downloads\\Iconos swt\\6803345 (2).png"));
		ocultar.setBounds(262, 171, 33, 21);
		

	}
}
