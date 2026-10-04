package Clase.InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Repaso1 extends JFrame{
	private JComboBox<String> Opciones;
	private JTextField Contador;
	private JLabel ActionSelection;
	
	public Repaso1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(422, 526);
		getContentPane().setLayout(null);
		
		ActionSelection = new JLabel("ACTION SELECTION");
		ActionSelection.setOpaque(true);
		ActionSelection.setBounds(140, 23, 97, 29);
		getContentPane().add(ActionSelection);
		
		Opciones = new JComboBox<String>();
		Opciones.addItem("CHG_COLOR");
		Opciones.addItem("PROG_BAR");
		Opciones.addItem("NEW_FRAME");
		Opciones.setBounds(150, 63, 87, 22);
		getContentPane().add(Opciones);
		Opciones.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e) {
				String boton = Opciones.getItemAt(Opciones.getSelectedIndex());
				switch(boton) {
				case "PROG_BAR":
					ActionSelection.setBackground(new Color(aleatorio(), aleatorio(), aleatorio()));
					break;
				}
			}
		});
		
		Contador = new JTextField();
		Contador.setHorizontalAlignment(SwingConstants.LEFT);
		Contador.setText("¡TextField2");
		Contador.setBounds(151, 110, 86, 20);
		getContentPane().add(Contador);
		Contador.setColumns(10);
		
		JLabel Cargando = new JLabel("loading...");
		Cargando.setBounds(172, 164, 46, 14);
		getContentPane().add(Cargando);
		
		JScrollBar Barra = new JScrollBar();
		Barra.setValue(50);
		Barra.setOrientation(JScrollBar.HORIZONTAL);
		Barra.setBounds(33, 189, 349, 14);
		getContentPane().add(Barra);
		
		JButton Boton = new JButton("accion");
		Boton.setBounds(151, 255, 89, 23);
		getContentPane().add(Boton);
		
		JLabel Log = new JLabel("LOG");
		Log.setBounds(48, 307, 20, 14);
		getContentPane().add(Log);
		
		JTextArea AreaTexto2 = new JTextArea();
		AreaTexto2.setBounds(48, 332, 334, 144);
		getContentPane().add(AreaTexto2);
	}
	
	private int aleatorio() {
		return (int)(Math.random() * (254 - 1 + 1)) + 1;
	}
}