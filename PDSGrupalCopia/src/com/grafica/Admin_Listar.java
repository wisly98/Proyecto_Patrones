package com.grafica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.crud.pds.Productos;
import com.proxy.impl.OperacionesProductosCrudProxy;

public class Admin_Listar {
	
	private Table table;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		
		OperacionesProductosCrudProxy pc = OperacionesProductosCrudProxy.getInstance();
		Productos p ;
		
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(617, 362);
		shell.setText("Plaza la Merced");
		//shell.setImage(SWTResourceManager.getImage(Carrito_Quitar.class, "/com/imagenes/WhatsApp Image 2022-02-19 at 10.30.59.jpeg"));

		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 601, 324);
		composite.setBackground(SWTResourceManager.getColor(255, 255, 224));
		
		Button btnRegresar = new Button(composite, SWT.NONE);
		btnRegresar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
			}
		});
		btnRegresar.setBounds(253, 289, 75, 25);
		btnRegresar.setText("Regresar");
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 0, 601, 281);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setWidth(100);
		tblclmnId.setText("ID");
		
		TableColumn tblclmnNombre = new TableColumn(table, SWT.NONE);
		tblclmnNombre.setWidth(100);
		tblclmnNombre.setText("Nombre");
		
		TableColumn tblclmnDescripcin = new TableColumn(table, SWT.NONE);
		tblclmnDescripcin.setWidth(100);
		tblclmnDescripcin.setText("Descripci\u00F3n");
		
		TableColumn tblclmnCantidad = new TableColumn(table, SWT.NONE);
		tblclmnCantidad.setWidth(100);
		tblclmnCantidad.setText("Cantidad");
		
		TableColumn tblclmnPrecio = new TableColumn(table, SWT.NONE);
		tblclmnPrecio.setWidth(100);
		tblclmnPrecio.setText("Precio");
		
		TableColumn tblclmnExpira = new TableColumn(table, SWT.NONE);
		tblclmnExpira.setWidth(100);
		tblclmnExpira.setText("Expira");
		
		TableItem tableItem; 
		List<TableItem> filas = new ArrayList<TableItem>();
		try {
			
			List<Productos> a = pc.LeerProductos();
			
			for(int i = 0; i < a.size(); i++) {
				p = a.get(i);
				tableItem = new TableItem(table, SWT.NONE);
				for(int j = 0; j < table.getColumnCount(); j++) {
					
					if(j == 0) {
						tableItem.setText(j, Integer.toString(p.getId()));
					}
					if(j == 1) {
						tableItem.setText(j, p.getNombre());
					}
					if(j == 2) {
						tableItem.setText(j, p.getDescripcion());
					}
					if(j == 3) {
						tableItem.setText(j, Integer.toString(p.getCantidad()));
					}
					if(j == 4) {
						tableItem.setText(j, Double.toString(p.getPrecio()));
					}
					if(j == 5) {
						tableItem.setText(j, p.getFecha_caduca());
					}
					filas.add(tableItem);
				};
				
			System.out.println(i + " " + p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
