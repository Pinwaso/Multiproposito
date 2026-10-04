package Clase.InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pitido extends JFrame {
	JButton boton;

	public pitido() {
		boton = new JButton("Pulsa!");
		add(boton);
		boton.addActionListener(new OyenteBoton());
		setSize(100, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	class OyenteBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Toolkit.getDefaultToolkit().beep();
		}
	}

	public static void main(String[] args) {
		pitido ventana = new pitido();
	}
}