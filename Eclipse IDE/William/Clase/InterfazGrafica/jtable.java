package Clase.InterfazGrafica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jtable extends JFrame{
	
	private JTable tabla;
	private JButton agregar, eliminar;
	DefaultTableModel modelo;
	
	public jtable(){
		super("Jtabla");
		setLayout(new BorderLayout());
		
		//Columnas de la tabla
		String[] columnas = {"ID", "NOMBRE", "PRECIO"};
		
		//Modelo de datos
		modelo = new DefaultTableModel(columnas, 0);
		
		//JTable
		tabla = new JTable(modelo);
		tabla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		//Scroll
		JScrollPane scroll = new JScrollPane(tabla);
		
		//Añadir datos
		Object[] fila = {1, "Pan", 1};
		modelo.addRow(fila);
		modelo.addRow(new Object[] {2, "Serranito", 4});
		
		//Boton de agregar
		agregar = new JButton("Agregar");
		agregar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.addRow(new Object[] {3, "Torilla", 3});
			}
		});
		
		//Boton de eliminar
		eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] filas = tabla.getSelectedRows();
				for (int i = filas.length -1; i >= 0; i--) {
					modelo.removeRow(filas[i]);
				}
			}
		});
		
		add(scroll, BorderLayout.CENTER);
		add(agregar, BorderLayout.SOUTH);
		add(eliminar, BorderLayout.WEST);
		setSize(600, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		jtable tabla = new jtable();
	}
}