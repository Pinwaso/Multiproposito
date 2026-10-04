package Clase.InterfazGrafica;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Ejercio1_1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton botonRadial;
	private JRadioButton botonRadial2;
	private JPanel panel;
	private ButtonGroup grupo;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Ejercio1_1 frame = new Ejercio1_1();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Ejercio1_1() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);

		grupo = new ButtonGroup();

		botonRadial = new JRadioButton("Rojo");
		botonRadial2 = new JRadioButton("Azul");

		// action command
		botonRadial.setActionCommand("ROJO");
		botonRadial2.setActionCommand("AZUL");

		grupo.add(botonRadial);
		grupo.add(botonRadial2);

		panel.add(botonRadial);
		panel.add(botonRadial2);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesarBoton();
			}
		};

		botonRadial.addActionListener(listener);
		botonRadial2.addActionListener(listener);

		JCheckBox botonCheck = new JCheckBox("Prueba");

		botonCheck.addActionListener(e -> {
			if (botonCheck.isSelected()) {
				System.out.println("Seleccion Prueba");
			} else {
				System.out.println("No seleccionado");
			}
		});

		panel.add(botonCheck);
	}

	public void procesarBoton() {

		String seleccion = grupo.getSelection().getActionCommand();

		if (seleccion.equals("ROJO")) {
			panel.setBackground(Color.RED);
		} 
		else if (seleccion.equals("AZUL")) {
			panel.setBackground(Color.BLUE);
		}
	}
}