package com.grafica;

import org.eclipse.swt.widgets.Display; 
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.sql.SQLException;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import com.composite.impl.CarritoCompuesto;
import com.crud.pds.Productos;
import com.proxy.impl.OperacionesProductosCrudProxy;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Carrito_Pagar_Transferencia {
	private CarritoCompuesto cc = CarritoCompuesto.getInstance();
	private OperacionesProductosCrudProxy pc = OperacionesProductosCrudProxy.getInstance();
	private List<Productos> prod;
	private Productos p;
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlTransferencia = new Shell();
		shlTransferencia.setImage(SWTResourceManager.getImage(Carrito_Pagar_Transferencia.class, "/com/imagenes/logo.jpeg"));
		shlTransferencia.setSize(450, 300);
		shlTransferencia.setText("Plaza la Merced");
		
		Composite composite = new Composite(shlTransferencia, SWT.NONE);
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
		
		Label label_t = new Label(composite, SWT.NONE);
		label_t.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_t.setBounds(197, 154, 55, 15);
		label_t.setText(String.valueOf(String.format("%.2f",cc.getImporteTotal())));
		
		Label label_msj = new Label(composite, SWT.NONE);
		label_msj.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_msj.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_msj.setBounds(92, 183, 253, 25);
		
		Button btnHecho = new Button(composite, SWT.NONE);
		btnHecho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					for(int i = 0; i < prod.size(); i++) {
						p = cc.getProducto(prod.get(i).getNombre());
						prod.get(i).setCantidad(prod.get(i).getCantidad() - p.getCantidad());
						pc.actualizar(prod.get(i), prod.get(i).getId());
					
				
					}
					label_t.setText("0.0");
					label_msj.setText("Transferencia realizada con éxito");
					for(int i = 0; i< prod.size(); i++) {
						cc.removeProducto(prod.get(i));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnHecho.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnHecho.setBounds(116, 214, 75, 25);
		btnHecho.setText("Hecho");
		
		Button btnRegresar = new Button(composite, SWT.NONE);
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shlTransferencia.close();
			}
		});
		btnRegresar.setText("Regresar");
		btnRegresar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnRegresar.setBounds(239, 214, 75, 25);
		
		Label lblTotal = new Label(composite, SWT.NONE);
		lblTotal.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblTotal.setBounds(103, 154, 88, 23);
		lblTotal.setText("Total a pagar");
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(270, 156, 55, 15);
		lblNewLabel.setText("$");	
	
		shlTransferencia.open();
		shlTransferencia.layout();
		while (!shlTransferencia.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
