package com.grafica;

import org.eclipse.swt.widgets.Display;  
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import com.crud.conexion.Conexion;
import java.sql.SQLException;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class Admin_IniciarSesion {
	private Text txt_contrasenia;
	private Text text_usuario;
	private String url= "jdbc:postgresql://localhost:5432/SuperMercado";
	private Display display = Display.getDefault();
	private Shell shell = new Shell();

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() throws SQLException{
		shell.setBackground(SWTResourceManager.getColor(0, 255, 255));
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\Usuario-PC\\Downloads\\Iconos swt\\kisspng-india-login-computer-icons-emoticon-medicine-user-login-icon-5ab05c8bc2f8d1.4479395815215074677986.jpg"));
		
		shell.setSize(411, 244);
		shell.setText("Iniciar Sesión Admin");
		//shell.setImage(SWTResourceManager.getImage(Carrito_Quitar.class, "/com/imagenes/WhatsApp Image 2022-02-19 at 10.30.59.jpeg"));
		
		

		shell.open();
		shell.layout();
		components(shell);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public void components(Shell shell) throws SQLException{
		
		
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 396, 207);
		composite.setLayout(null);
		
		text_usuario = new Text(composite, SWT.BORDER);
		text_usuario.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_usuario.setBounds(99, 56, 228, 21);
		txt_contrasenia = new Text(composite, SWT.SINGLE | SWT.BORDER  | SWT.PASSWORD);
		txt_contrasenia.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txt_contrasenia.setBounds(99, 107, 228, 21);
		txt_contrasenia.setEchoChar('•');
				
		Label Mensaje = new Label(composite, SWT.NONE);
		Mensaje.setBackground(SWTResourceManager.getColor(255, 255, 255));
		Mensaje.setForeground(SWTResourceManager.getColor(255, 0, 0));
		Mensaje.setBounds(116, 10, 195, 15);
		Mensaje.setVisible(false);
		
		Button btnConectarse = new Button(composite, SWT.NONE);
		btnConectarse.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.NORMAL));
		btnConectarse.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				String usuario = text_usuario.getText();
				String contrasenia = txt_contrasenia.getText();
				
				Conexion.setUsuario(usuario);
				Conexion.setContrasenia(contrasenia);
				Conexion.setUrl(url);
				Conexion.getConnection();
				
				if(Conexion.isValid() == true) {
				
					display.close();
					
					try {
						Admin window = new Admin();
						window.open();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}else {
					Mensaje.setVisible(true);
					Mensaje.setText("Datos erroneos, intentelo de nuevo");
					txt_contrasenia.setText("");
					text_usuario.setText("");
					
				}
			}
		});
		btnConectarse.setBounds(149, 159, 75, 25);
		
		Button btnCancelar = new Button(composite, SWT.NONE);
		btnCancelar.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.NORMAL));
		btnCancelar.setBounds(252, 159, 75, 25);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
			}
		});
		btnCancelar.setText("Cancelar");
	

		btnConectarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				String usuario = text_usuario.getText();
				String contrasenia = txt_contrasenia.getText();
				Conexion.setUsuario(usuario);
				Conexion.setContrasenia(contrasenia);
				Conexion.setUrl(url);
				Conexion.getConnection();
				
				if(Conexion.isValid() == true) {
				
					display.close();
					
					try {
						Admin window = new Admin();
						window.open();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}else {
					Mensaje.setVisible(true);
					Mensaje.setText("Datos erroneos, intentelo de nuevo");
					txt_contrasenia.setText("");
					text_usuario.setText("");
					
				}
						
			}
		});
		btnConectarse.setText("Conectarse");
		
		Button mostrar = new Button(composite, SWT.NONE);
		Button ocultar = new Button(composite, SWT.NONE);
		ocultar.setVisible(false);
		mostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mostrar.setVisible(false);
				ocultar.setVisible(true);
				txt_contrasenia.setEchoChar((char)0);
			
			}
		});
		mostrar.setImage(SWTResourceManager.getImage(Admin_IniciarSesion.class, "/com/imagenes/mostrar.png"));
		mostrar.setBounds(333, 107, 33, 21);
		
		

		ocultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mostrar.setVisible(true);
				ocultar.setVisible(false);
				txt_contrasenia.setEchoChar((char)0);
				txt_contrasenia.setEchoChar('•');
				
			}
		});
		ocultar.setImage(SWTResourceManager.getImage(Admin_IniciarSesion.class, "/com/imagenes/ocultar.png"));
		ocultar.setBounds(333, 107, 33, 21);
		
		Label lblUsuario = new Label(composite, SWT.NONE);
		lblUsuario.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblUsuario.setBounds(10, 57, 55, 15);
		lblUsuario.setText("Usuario");
		
		Label lblContrasea = new Label(composite, SWT.NONE);
		lblContrasea.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblContrasea.setBounds(10, 107, 83, 15);
		lblContrasea.setText("Contrase\u00F1a");
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(Admin_IniciarSesion.class, "/com/imagenes/fondo.png"));
		lblNewLabel.setBounds(0, 0, 396, 50);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Admin_IniciarSesion.class, "/com/imagenes/fondo.png"));
		lblNewLabel_1.setBounds(0, 148, 396, 59);
		
		
		
	}
}
