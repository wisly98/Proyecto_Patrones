package com.grafica;

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

import com.composite.impl.CarritoCompuesto;
import com.crud.pds.Productos;
import org.eclipse.swt.widgets.Label;

public class Carrito_Mirar {
	private Table table;
	private CarritoCompuesto pc = CarritoCompuesto.getInstance();
	
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		
		pc.getImporteTotal();
		
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(516, 420);
		shell.setText("SWT Application");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 500, 382);
		
		Button btnRegresar = new Button(composite, SWT.NONE);
		btnRegresar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
			}
		});
		btnRegresar.setBounds(203, 347, 75, 25);
		btnRegresar.setText("Regresar");
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 0, 500, 281);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
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
		tblclmnExpira.setText("ValorProductos");
		
		Label total = new Label(composite, SWT.NONE);
		total.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		total.setBounds(417, 302, 55, 15);
		
		Label lblTotalAPagar = new Label(composite, SWT.NONE);
		lblTotalAPagar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblTotalAPagar.setBounds(298, 302, 81, 25);
		lblTotalAPagar.setText("Total a pagar:");
		
		Label label = new Label(composite, SWT.NONE);
		label.setAlignment(SWT.RIGHT);
		label.setBounds(385, 302, 26, 15);
		label.setText("$");
		
		TableItem tableItem; 
		List<TableItem> filas = new ArrayList<TableItem>();
		List<Productos> a = pc.getProductos();
		
		if(a != null) {
			for(int i = 0; i < a.size(); i++) {
				if(a.get(i).getCantidad() != 0) {
					tableItem = new TableItem(table, SWT.NONE);
					for(int j = 0; j < table.getColumnCount(); j++) {
						
						if(j == 0) {
							tableItem.setText(j, a.get(i).getNombre());
						}
						if(j == 1) {
							tableItem.setText(j, a.get(i).getDescripcion());
						}
						if(j == 2) {
							tableItem.setText(j, Integer.toString(a.get(i).getCantidad()));
						}
						if(j == 3) {
							tableItem.setText(j, Double.toString(a.get(i).getPrecio()));
						}
						if(j == 4) {
							tableItem.setText(j, String.valueOf(String.format("%.2f", a.get(i).getTotalProducto())));
							
						}
						filas.add(tableItem);
						
					};
				}
				
				
			System.out.println(i + " " + a.get(i));
			}
			total.setText(String.valueOf(String.format("%.2f",pc.getImporteTotal())));
			
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
