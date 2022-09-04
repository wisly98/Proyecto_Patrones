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

	protected Shell shlRegistro;
	private Text text_contrasenia;
	private Text text_edad;
	private Text text_apellido;
	private Text text_nombre;
	private Text text_usuario;

	public void open() { // método para mostrar los componentes en pantalla.
		Display display = Display.getDefault();
		createContents();
		shlRegistro.open();
		shlRegistro.layout();
		while (!shlRegistro.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		OperacionesUsuariosCrudProxy pc = OperacionesUsuariosCrudProxy.getInstance();
	
		shlRegistro = new Shell();
		shlRegistro.setImage(SWTResourceManager.getImage(Usuario_Datos.class, "/com/imagenes/logo.jpeg"));
		shlRegistro.setSize(339, 323);
		shlRegistro.setText("Registro");
		
		Composite composite = new Composite(shlRegistro, SWT.NONE);
		composite.setBounds(0, 0, 324, 285);
		
		Label lblIngreseLosSiguientes = new Label(composite, SWT.NONE);
		//lblIngreseLosSiguientes.setBackground(SWTResourceManager.getColor(25, 25, 112));
		//lblIngreseLosSiguientes.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblIngreseLosSiguientes.setImage(SWTResourceManager.getImage(Usuario_Datos.class, "/com/imagenes/daa6550f1247a73508c5560300d9d697.jpg"));
		lblIngreseLosSiguientes.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblIngreseLosSiguientes.setBounds(26, 10, 263, 26);
		lblIngreseLosSiguientes.setText("INGRESE DATOS CORRESPONDIENTES");
		
		Label lblUsuario = new Label(composite, SWT.NONE);
		lblUsuario.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblUsuario.setBounds(10, 54, 55, 15);
		lblUsuario.setText("Usuario");
		
		Label lblNomre = new Label(composite, SWT.NONE);
		lblNomre.setText("Nombre");
		lblNomre.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblNomre.setBounds(10, 85, 55, 15);
		
		Label lblApellido = new Label(composite, SWT.NONE);
		lblApellido.setText("Apellido");
		lblApellido.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblApellido.setBounds(10, 113, 55, 15);
		
		Label lblEdad = new Label(composite, SWT.NONE);
		lblEdad.setText("Edad");
		lblEdad.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblEdad.setBounds(10, 147, 55, 15);
		
		Label lblContrasea = new Label(composite, SWT.NONE);
		lblContrasea.setText("Contrase\u00F1a");
		lblContrasea.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblContrasea.setBounds(10, 177, 72, 15);
		
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
		btnCrear.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		btnCrear.setBounds(126, 236, 75, 25);
		btnCrear.setText("Crear");
		
		Button btnRgresar = new Button(composite, SWT.NONE);
		btnRgresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { //Método para cerrar la ventana al dar click.
				shlRegistro.close();
			}
		});
				
		btnRgresar.setFont(SWTResourceManager.getFont("STIXNonUnicode", 6, SWT.BOLD));
		btnRgresar.setBounds(214, 236, 75, 25);
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
		mostrar.setImage(SWTResourceManager.getImage(Usuario_Datos.class, "/com/imagenes/mostrar.png"));
		mostrar.setBounds(262, 171, 27, 21);
		

		ocultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { // Método para ocultar la contraseña.
				mostrar.setVisible(true);
				ocultar.setVisible(false);
				text_contrasenia.setEchoChar((char)0);
				text_contrasenia.setEchoChar('•'); // paso de texto a (•).
				
			}
		});
		ocultar.setImage(SWTResourceManager.getImage(Usuario_Datos.class, "/com/imagenes/ocultar.png"));
		ocultar.setBounds(262, 171, 27, 21);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Usuario_Datos.class, "/com/imagenes/fondo.png"));
		lblNewLabel_1.setBounds(0, 220, 324, 65);
		

	}
}
