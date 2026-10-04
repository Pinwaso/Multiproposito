package Clase.InterfazGrafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ejercicio1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton botonRadial;
	private JRadioButton botonRadial2;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 frame = new Ejercicio1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio1() {
		setBackground(new Color(255, 255, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		ButtonGroup grupo = new ButtonGroup();
		botonRadial = new JRadioButton("Rojo");
		botonRadial2 = new JRadioButton("Azul");
		
		grupo.add(botonRadial);
		grupo.add(botonRadial2);
		
		panel.add(botonRadial);
		panel.add(botonRadial2);
		
		botonRadial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				procesarBoton();
				
			}
		});
		
		botonRadial2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				procesarBoton();
				
			}
		});
		
		JCheckBox botonCheck = new JCheckBox("Prueba");
		botonCheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (botonCheck.isSelected()) {
					System.out.println("Seleccion Prueba");
				}
				else {
					System.out.println("No seleccionado");
				}
				
			}
		});
		
		panel.add(botonCheck);
		

	}
	
	public void procesarBoton () {
		if (botonRadial.isSelected()) {
			panel.setBackground(Color.RED);
		} else if(botonRadial2.isSelected()) {
			panel.setBackground(Color.BLUE);
		}
	}

}

