package com.grafica;

import java.sql.SQLException; 

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.crud.conexion.Conexion;

import com.prototype.abs.UsuarioBasico;
import com.proxy.impl.OperacionesUsuariosCrudProxy;


public class Usuario_IniciaSesion {

	private Text txt_contrasenia;
	private Text text_usuario;
	private String url= "jdbc:postgresql://localhost:5432/SuperMercado";
	private String usuario = "postgres";
    private String contrasenia = "rc2ijxxz";
	private Display display = Display.getDefault();
	private Shell shell = new Shell();

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() throws SQLException{ // método para mostrar los componentes en pantalla.
		
		
		shell.setBackground(SWTResourceManager.getColor(0, 255, 255));
		shell.setImage(SWTResourceManager.getImage(Usuario_IniciaSesion.class, "/com/imagenes/logo.jpeg"));		
		shell.setSize(411, 244);
		shell.setText("Iniciar Sesión Usuario");
		
		Conexion.setUsuario(usuario);
		Conexion.setContrasenia(contrasenia);
		Conexion.setUrl(url);
		Conexion.getConnection();
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
		
		OperacionesUsuariosCrudProxy uc = OperacionesUsuariosCrudProxy.getInstance();
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 396, 207);
		composite.setLayout(null);
		
		Label Mensaje = new Label(composite, SWT.NONE);
		
		Mensaje.setBackground(SWTResourceManager.getColor(255, 255, 255));
		Mensaje.setForeground(SWTResourceManager.getColor(255, 0, 0));
		Mensaje.setBounds(41, 10, 304, 15);
		Mensaje.setVisible(false);
		
		text_usuario = new Text(composite, SWT.BORDER);
		text_usuario.setBounds(99, 56, 228, 21);
		txt_contrasenia = new Text(composite, SWT.SINGLE | SWT.BORDER  | SWT.PASSWORD);
		txt_contrasenia.setBounds(99, 107, 228, 21);
		txt_contrasenia.setEchoChar('•');
		
		Button btnConectarse = new Button(composite, SWT.NONE);
		btnConectarse.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.NORMAL));
		btnConectarse.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) { 
				
				try {
					UsuarioBasico ub = uc.leerUsuario(text_usuario.getText());
					if(text_usuario.getText().equals(ub.getUsuario())&& txt_contrasenia.getText().equals(ub.getContrasenia())) {
						display.close();
						
						try {
							Carrito window = new Carrito();
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
				} catch (SQLException | CloneNotSupportedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					Mensaje.setText("Datos erroneos, intentelo de nuevo");

				}
				
			}
		});
		btnConectarse.setBounds(191, 159, 75, 25);
		
		Button btnCancelar = new Button(composite, SWT.NONE);
		btnCancelar.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.NORMAL));
		btnCancelar.setBounds(99, 159, 75, 25);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { // Funcionalidad para cerrar la ventana al dar click.
				shell.close();
			}
		});
		btnCancelar.setText("Cancelar");
	

		btnConectarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { // Funcionalidad para conectar ala base de datos dando click.
				
				
				//Método para concectarse a la base de datos.
				
				try {
					UsuarioBasico ub = uc.leerUsuario(text_usuario.getText());
					
					// valida usuario y contraseña con los que se encuentran registrados en la base de datos.
					
					if(text_usuario.getText().equals(ub.getUsuario())&& txt_contrasenia.getText().equals(ub.getContrasenia())) {
						display.close(); // Cierra todo el programa.
						
						
						// Abre la ventana carrito.
						
						try {
							Carrito window = new Carrito();
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
				} catch (SQLException | CloneNotSupportedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					Mensaje.setText("Datos erroneos, intentelo de nuevo");

				}
				
			}
		});
		btnConectarse.setText("Conectarse");
		
		Button mostrar = new Button(composite, SWT.NONE);
		Button ocultar = new Button(composite, SWT.NONE);
		ocultar.setVisible(false);
		mostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { // Botón para mostar  Contraseña.
				mostrar.setVisible(false);
				ocultar.setVisible(true);
				txt_contrasenia.setEchoChar((char)0);// paso de (•) a texto.
			
			}
		});
		mostrar.setImage(SWTResourceManager.getImage(Usuario_IniciaSesion.class, "/com/imagenes/mostrar.png"));
		mostrar.setBounds(333, 107, 33, 21);
		

		ocultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { //Botón para ocultar la contraseña.
				mostrar.setVisible(true);
				ocultar.setVisible(false);
				txt_contrasenia.setEchoChar((char)0);
				txt_contrasenia.setEchoChar('•');// paso de texto a (•).
				
			}
		});
		ocultar.setImage(SWTResourceManager.getImage(Usuario_IniciaSesion.class, "/com/imagenes/ocultar.png"));
		ocultar.setBounds(333, 107, 33, 21);
		
		Button btnCrearCuenta = new Button(composite, SWT.NONE);
		btnCrearCuenta.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.NORMAL));
		btnCrearCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { //Método para iniciar registro de usuario al dar click.
				try {
					Usuario_Datos window = new Usuario_Datos();
					window.open();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnCrearCuenta.setBounds(284, 159, 91, 25);
		btnCrearCuenta.setText("Crear usuario");
		
		Label lblUsuario = new Label(composite, SWT.NONE);
		lblUsuario.setAlignment(SWT.CENTER);
		lblUsuario.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblUsuario.setBounds(20, 57, 55, 15);
		lblUsuario.setText("Usuario");
		
		Label lblContrasea = new Label(composite, SWT.NONE);
		lblContrasea.setAlignment(SWT.CENTER);
		lblContrasea.setFont(SWTResourceManager.getFont("STIXNonUnicode", 10, SWT.BOLD));
		lblContrasea.setBounds(10, 107, 83, 15);
		lblContrasea.setText("Contrase\u00F1a");
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(Usuario_IniciaSesion.class, "/com/imagenes/fondo.png"));
		lblNewLabel.setBounds(0, 0, 396, 50);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Usuario_IniciaSesion.class, "/com/imagenes/fondo.png"));
		lblNewLabel_1.setBounds(0, 148, 396, 59);
		
		
	}
}
